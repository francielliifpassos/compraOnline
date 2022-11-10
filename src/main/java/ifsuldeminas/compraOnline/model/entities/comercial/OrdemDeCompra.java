package ifsuldeminas.compraOnline.model.entities.comercial;

import ifsuldeminas.compraOnline.model.entities.pessoal.Comprador;
import ifsuldeminas.compraOnline.model.entities.pessoal.Vendedor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class OrdemDeCompra {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDaCompra;
    @OneToMany(mappedBy="ordemDeCompra")
    private Set<Item> itens;
    @ManyToOne
    private Vendedor vendedor;
    @ManyToOne
    private Comprador comprador;
}
