import jakarta.persistence.*;

@Entity
@Table(name = "telefone")
public class TelefoneDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private PessoaDTO pessoa;

    @Column(name = "numero", nullable = false)
    private String numero;

    // Getters e Setters
}