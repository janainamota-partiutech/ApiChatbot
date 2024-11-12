package com.partiutech.apichatbot.whatsapp.service;

import com.partiutech.apichatbot.whatsapp.dto.*;
import com.partiutech.apichatbot.whatsapp.repository.FormaPagamentoRepository;
import com.partiutech.apichatbot.whatsapp.repository.ItemRepository;
import com.partiutech.apichatbot.whatsapp.repository.PedidoRepository;
import com.partiutech.apichatbot.whatsapp.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ItemRepository itemRepository;


    public PedidoDTO criar(PedidoDTO pedidoDTO) {
        // Validar e buscar a pessoa associada
        if (pedidoDTO.getPessoa() != null) {
            PessoaDTO pessoa = pessoaRepository.findById(pedidoDTO.getPessoa().getId())
                    .orElseThrow(() -> new RuntimeException("Pessoa não encontrada."));
            pedidoDTO.setPessoa(pessoa);
        }

        // Validar e buscar a forma de pagamento associada
        if (pedidoDTO.getFormaPagamento() != null) {
            FormaPagamentoDTO formaPagamento = formaPagamentoRepository
                    .findById(pedidoDTO.getFormaPagamento().getId())
                    .orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada."));
            pedidoDTO.setFormaPagamento(formaPagamento);
        }

        // Associar cada item ao pedido e validar se eles existem no banco
        if (pedidoDTO.getItensPedido() != null) {
            for (ItemPedidoDTO itemPedido : pedidoDTO.getItensPedido()) {
                ItemDTO itemExistente = itemRepository.findById(itemPedido.getItem().getId())
                        .orElseThrow(() -> new RuntimeException("Item não encontrado."));
                itemPedido.setItem(itemExistente);
                itemPedido.setPedido(pedidoDTO);
            }
        }

        return pedidoRepository.save(pedidoDTO);
    }


    public PedidoDTO atualizar(Long id, PedidoDTO pedidoDTO) {
        PedidoDTO pedidoAtualizado = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido com ID " + id + " não encontrado."));

        // Atualizar os dados do pedido
        pedidoAtualizado.setPessoa(pedidoDTO.getPessoa());
        pedidoAtualizado.setValorTotal(pedidoDTO.getValorTotal());
        pedidoAtualizado.setDataSolicitacao(pedidoDTO.getDataSolicitacao());
        pedidoAtualizado.setDataRetirada(pedidoDTO.getDataRetirada());
        pedidoAtualizado.setDataEntrega(pedidoDTO.getDataEntrega());

        // Atualizar a forma de pagamento
        if (pedidoDTO.getFormaPagamento() != null) {
            FormaPagamentoDTO formaPagamento = formaPagamentoRepository
                    .findById(pedidoDTO.getFormaPagamento().getId())
                    .orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada."));
            pedidoAtualizado.setFormaPagamento(formaPagamento);
        }

        // Atualizar os itens do pedido
        if (pedidoDTO.getItensPedido() != null) {
            pedidoAtualizado.getItensPedido().clear(); // Limpar itens antigos
            pedidoDTO.getItensPedido().forEach(item -> {
                item.setPedido(pedidoAtualizado);
                pedidoAtualizado.getItensPedido().add(item);
            });

        }

        return pedidoRepository.save(pedidoAtualizado);
    }

    public List<PedidoDTO> getAll() {
        return pedidoRepository.findAll();
    }


    public PedidoDTO getById(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido " + id + " não encontrado.")); //metodo para retorno do valor null, cria a excessão
    }


    public void delete(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Pedido " + id + " não encontrado.");
        }
    }
}
