package ifsuldeminas.compraOnline.model.repositories.comercial;

import ifsuldeminas.compraOnline.model.entities.comercial.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
