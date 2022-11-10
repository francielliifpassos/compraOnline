package ifsuldeminas.compraOnline.model.pessoal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Vendedor")
public class Vendedor extends Usuario{
    private long cnpj;
    private String nomeFantasia;
}
