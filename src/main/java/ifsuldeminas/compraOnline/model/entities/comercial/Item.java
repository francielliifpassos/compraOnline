package ifsuldeminas.compraOnline.model.entities.comercial;

import javax.persistence.*;

@Entity
public class Item {
    //definindo que o atributo id sera a chave primaria
    @Id
    //definindo que o id sera auto incremento
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private int quantidade;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    private OrdemDeCompra ordemDeCompra;
}
