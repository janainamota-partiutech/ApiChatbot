package com.partiutech.apichatbot.whatsapp.dto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class EnderecoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private PessoaDTO pessoa;

    @Column(name = "logradouro", length = 50, nullable = false)
    private String logradouro;

    @Column(name = "numero", length = 50, nullable = false)
    private String numero;

    @Column(name = "bairro", length = 50, nullable = false)
    private String bairro;

    @Column(name = "cidade", length = 50, nullable = false)
    private String cidade;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @Column(name = "pais", length = 50, nullable = false)
    private String pais;

    @Column(name = "cep", length = 50, nullable = false)
    private String cep;
}