package com.partiutech.apichatbot.whatsapp.repository;

import com.partiutech.apichatbot.whatsapp.dto.PessoaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaDTO, Long> { // metodo para buscar o cpf (utilizei pois eh um dado imutavel)
    Optional<PessoaDTO> findByCpf(String cpf);
}
