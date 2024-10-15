package com.partiutech.apichatbot.whatsapp.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "item_pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id")
    private PedidoDTO pedido;

    @ManyToOne
    @JoinColumn(name = "id_item", referencedColumnName = "id")
    private ItemDTO item;

    @Column(name = "observacao", length = 100)
    private String observacao;
}

