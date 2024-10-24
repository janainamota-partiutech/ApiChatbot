package com.partiutech.apichatbot.whatsapp.repository;

import com.partiutech.apichatbot.whatsapp.dto.PedidoDTO;
import com.partiutech.apichatbot.whatsapp.dto.PessoaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoDTO, Long> {

    //buscar pedidos por clientes
    List<PedidoDTO> findByPessoa(PessoaDTO pessoa);
}
