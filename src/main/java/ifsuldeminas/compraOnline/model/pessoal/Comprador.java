package ifsuldeminas.compraOnline.model.pessoal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Comprador")
public class Comprador extends Usuario{
    private long cpf;
}
