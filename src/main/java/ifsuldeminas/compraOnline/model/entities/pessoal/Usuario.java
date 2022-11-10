package ifsuldeminas.compraOnline.model.entities.pessoal;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="classe")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String nome;
    private String email;
    private String senha;
    private String endereco;
}
