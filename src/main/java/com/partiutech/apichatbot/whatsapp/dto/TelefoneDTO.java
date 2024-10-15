package com.partiutech.apichatbot.whatsapp.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "telefone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class TelefoneDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private PessoaDTO pessoa;

    @Column(name = "numero", length = 50, nullable = false)
    private String numero;
}