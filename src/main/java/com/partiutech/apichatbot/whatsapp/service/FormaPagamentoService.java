package com.partiutech.apichatbot.whatsapp.service;

import com.partiutech.apichatbot.whatsapp.dto.FormaPagamentoDTO;
import com.partiutech.apichatbot.whatsapp.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    public FormaPagamentoDTO criar(FormaPagamentoDTO formaPagamentoDTO){
        return formaPagamentoRepository.save(formaPagamentoDTO);
    }

    public FormaPagamentoDTO atualizar(Long id, FormaPagamentoDTO formaPagamentoDTO) {
        Optional<FormaPagamentoDTO> formaPagamentoExistente = formaPagamentoRepository.findById(id);

        if (formaPagamentoExistente.isPresent()) {
            FormaPagamentoDTO formaPagamentoAtualizada = formaPagamentoExistente.get();
            formaPagamentoAtualizada.setDescricao(formaPagamentoDTO.getDescricao());
            return formaPagamentoRepository.save(formaPagamentoAtualizada);
        }

        throw new RuntimeException("Forma de pagamento " + id + " não encontrada.");
    }


    public List<FormaPagamentoDTO> getAll() {
        return formaPagamentoRepository.findAll();
    }


    public FormaPagamentoDTO getById(Long id) {
        return formaPagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forma de pagamento " + id + " não encontrada."));
    }


    public void delete(Long id) {
        if (formaPagamentoRepository.existsById(id)) {
            formaPagamentoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Forma de pagamento " + id + " não encontrada.");
        }
    }
}


