package com.partiutech.apichatbot.whatsapp.service;

import com.partiutech.apichatbot.whatsapp.dto.FormaPagamentoDTO;
import com.partiutech.apichatbot.whatsapp.dto.PedidoDTO;
import com.partiutech.apichatbot.whatsapp.repository.FormaPagamentoRepository;
import com.partiutech.apichatbot.whatsapp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;



    public PedidoDTO criar(PedidoDTO pedidoDTO) {
        // Validar forma de pagamento
        if (pedidoDTO.getFormaPagamento() != null) {
            FormaPagamentoDTO formaPagamento = formaPagamentoRepository
                    .findById(pedidoDTO.getFormaPagamento().getId())
                    .orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada."));
            pedidoDTO.setFormaPagamento(formaPagamento);
        }

        // Associar cada item ao pedido antes de salvar
        if (pedidoDTO.getItensPedido() != null) {
            pedidoDTO.getItensPedido().forEach(item -> item.setPedido(pedidoDTO));
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
