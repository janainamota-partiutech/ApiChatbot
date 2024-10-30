package com.partiutech.apichatbot.whatsapp.dto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class PedidoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private PessoaDTO pessoa;

    @ManyToOne
    @JoinColumn(name = "id_forma_pagamento", referencedColumnName = "id")
    private FormaPagamentoDTO formaPagamento;

    @Column(name = "valor_total",  nullable = false)
    private BigDecimal valorTotal;

    @Column(name = "data_solicitacao",  nullable = false)
    private LocalDate dataSolicitacao;

    @Column(name = "data_retirada")
    private LocalDate dataRetirada;

    @Column(name = "data_entrega")
    private LocalDate dataEntrega;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedidoDTO> itensPedido;
}
