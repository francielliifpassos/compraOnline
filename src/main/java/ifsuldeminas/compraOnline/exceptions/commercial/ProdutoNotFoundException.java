package ifsuldeminas.compraOnline.exceptions.commercial;

public class ProdutoNotFoundException extends RuntimeException{
    public ProdutoNotFoundException(Long id){
        super("Produto #" + id + " não encontrado.");
    }
}
