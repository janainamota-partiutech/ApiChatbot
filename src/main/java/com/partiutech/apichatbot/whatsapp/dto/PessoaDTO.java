package com.partiutech.apichatbot.whatsapp.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Getter
    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

}
