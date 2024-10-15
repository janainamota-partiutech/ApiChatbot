package com.partiutech.apichatbot.whatsapp.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "forma_pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormaPagamentoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
}
