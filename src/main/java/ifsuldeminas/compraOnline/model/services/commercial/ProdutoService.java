package ifsuldeminas.compraOnline.model.services.commercial;

import ifsuldeminas.compraOnline.exceptions.commercial.ProdutoNotFoundException;
import ifsuldeminas.compraOnline.model.entities.comercial.Produto;
import ifsuldeminas.compraOnline.model.repositories.comercial.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastra(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    public Produto listaProduto(Long id) throws ProdutoNotFoundException{
        return getById(id);
    }

    public Produto atualiza(Long id, Produto produto) throws ProdutoNotFoundException{
        Produto produtoBD = getById(id);
        //atualizando os dados do produto
        produtoBD.setNome(produto.getNome());
        produtoBD.setDescricao(produto.getDescricao());
        produtoBD.setPreco(produto.getPreco());
        //atualizando no BD e retornando os dados do produto
        return this.produtoRepository.save(produtoBD);
    }

    public void deleta(Long id) throws ProdutoNotFoundException{
        try{
            produtoRepository.deleteById(id);
        }catch(RuntimeException e){
            throw new ProdutoNotFoundException(id);
        }
    }

    private Produto getById(Long id) throws ProdutoNotFoundException{
        Optional<Produto> opt = this.produtoRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }else{
            throw new ProdutoNotFoundException(id);
        }
    }
}
