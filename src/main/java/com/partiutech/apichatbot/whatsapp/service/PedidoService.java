package com.partiutech.apichatbot.whatsapp.service;

import com.partiutech.apichatbot.whatsapp.dto.PedidoDTO;
import com.partiutech.apichatbot.whatsapp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    public PedidoDTO criar(PedidoDTO pedidoDTO) {
        return pedidoRepository.save(pedidoDTO);
    }


    public PedidoDTO atualizar(Long id, PedidoDTO pedidoDTO) {
        Optional<PedidoDTO> pedidoExistente = pedidoRepository.findById(id);

        if (pedidoExistente.isPresent()) {
            PedidoDTO pedidoAtualizado = pedidoExistente.get();
            pedidoAtualizado.setPessoa(pedidoDTO.getPessoa());
            pedidoAtualizado.setFormaPagamento(pedidoDTO.getFormaPagamento());
            pedidoAtualizado.setValorTotal(pedidoDTO.getValorTotal());
            pedidoAtualizado.setDataSolicitacao(pedidoDTO.getDataSolicitacao());
            pedidoAtualizado.setDataRetirada(pedidoDTO.getDataRetirada());
            pedidoAtualizado.setDataEntrega(pedidoDTO.getDataEntrega());
            return pedidoRepository.save(pedidoAtualizado);
        }

        throw new RuntimeException("Pedido com ID " + id + " não encontrado.");
    }


    public List<PedidoDTO> getAll() {
        return pedidoRepository.findAll();
    }


    public PedidoDTO getById(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido com ID " + id + " não encontrado.")); //metodo para retorno do valor null, cria a excessão
    }


    public void delete(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Pedido com ID " + id + " não encontrado.");
        }
    }
}
