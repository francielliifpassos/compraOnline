package ifsuldeminas.compraOnline.model.entities.pessoal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Comprador")
public class Comprador extends Usuario{
    private long cpf;
}
