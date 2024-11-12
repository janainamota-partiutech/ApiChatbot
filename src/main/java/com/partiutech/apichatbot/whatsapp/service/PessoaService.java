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

        if (pessoaDTO.getTelefones() != null) { // verificando se n eh null
            pessoaDTO.getTelefones().forEach(telefone -> telefone.setPessoa(pessoaDTO));
        }

        if (pessoaDTO.getEnderecos() != null) {
            pessoaDTO.getEnderecos().forEach(endereco -> endereco.setPessoa(pessoaDTO));
        }


        return pessoaRepository.save(pessoaDTO);
    }


    public PessoaDTO atualizar(PessoaDTO pessoaDTO) {
        Optional<PessoaDTO> pessoaExistente = pessoaRepository.findByCpf(pessoaDTO.getCpf());

        if (pessoaExistente.isPresent()) {
            PessoaDTO pessoa = pessoaExistente.get();
            pessoa.setNome(pessoaDTO.getNome());
            pessoa.setDataNascimento(pessoaDTO.getDataNascimento());

            // Atualiza os telefones pessoa
            if (pessoaDTO.getTelefones() != null) {
                // Remove os telefones antigos e associa os novos
                pessoa.getTelefones().clear();
                pessoaDTO.getTelefones().forEach(telefone -> telefone.setPessoa(pessoa));
                pessoa.getTelefones().addAll(pessoaDTO.getTelefones());
            }

            // Atualiza os endereços pessoa
            if (pessoaDTO.getEnderecos() != null) {
                // Remove os endereços antigos e associa os novos
                pessoa.getEnderecos().clear();
                pessoaDTO.getEnderecos().forEach(endereco -> endereco.setPessoa(pessoa));
                pessoa.getEnderecos().addAll(pessoaDTO.getEnderecos());
            }

            // Atualiza a data de nascimento diretamente
            if (pessoaDTO.getDataNascimento() != null) {
                pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
            }

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
