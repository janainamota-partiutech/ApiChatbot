package com.partiutech.apichatbot.whatsapp.service;

import com.partiutech.apichatbot.whatsapp.dto.PessoaDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PessoaService {

    private static final Map<String, PessoaDTO> pessoas = new HashMap<>();


    public PessoaDTO criar(PessoaDTO pessoaDTO) {
        pessoas.put(pessoaDTO.getCpf(), pessoaDTO);
        return pessoaDTO;
    }

    public PessoaDTO atualizar(PessoaDTO pessoaDTO) {
        if (pessoas.containsKey(pessoaDTO.getCpf())) {
            PessoaDTO pessoaExistente = pessoas.get(pessoaDTO.getCpf());
            pessoaExistente.setNome(pessoaDTO.getNome());
            pessoaExistente.setDataNascimento(pessoaDTO.getDataNascimento());
            return pessoaExistente;
        }
        throw new RuntimeException("Pessoa com CPF " + pessoaDTO.getCpf() + " não encontrada."); // lançando excessão caso n seja encontrado
    }


    public List<PessoaDTO> getAll() {
        return new ArrayList<>(pessoas.values());
    }


    public void delete(String cpf) {
        if (pessoas.containsKey(cpf)) {
            pessoas.remove(cpf);
        } else {
            throw new RuntimeException("Pessoa com CPF " + cpf + " não encontrada.");
        }
    }
}
