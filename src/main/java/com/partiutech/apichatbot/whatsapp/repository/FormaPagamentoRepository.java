package com.partiutech.apichatbot.whatsapp.repository;

import com.partiutech.apichatbot.whatsapp.dto.FormaPagamentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamentoDTO, Long> {

}
