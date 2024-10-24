package com.partiutech.apichatbot.whatsapp.service;

import com.partiutech.apichatbot.whatsapp.dto.PessoaDTO;
import com.partiutech.apichatbot.whatsapp.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDTO criar(PessoaDTO pessoaDTO) {
        return pessoaRepository.save(pessoaDTO);
    }


    public PessoaDTO atualizar(PessoaDTO pessoaDTO) {
        Optional<PessoaDTO> pessoaExistente = pessoaRepository.findByCpf(pessoaDTO.getCpf());

        if (pessoaExistente.isPresent()) {
            PessoaDTO pessoa = pessoaExistente.get();
            pessoa.setNome(pessoaDTO.getNome());
            pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
            return pessoaRepository.save(pessoa);
        }

        throw new RuntimeException("Pessoa com CPF " + pessoaDTO.getCpf() + " não encontrada.");
    }


    public List<PessoaDTO> getAll() {
        return pessoaRepository.findAll();
    }


    public void delete(String cpf) {
        Optional<PessoaDTO> pessoaExistente = pessoaRepository.findByCpf(cpf);

        if (pessoaExistente.isPresent()) {
            pessoaRepository.delete(pessoaExistente.get());
        } else {
            throw new RuntimeException("Pessoa com CPF " + cpf + " não encontrada.");
        }
    }
}
