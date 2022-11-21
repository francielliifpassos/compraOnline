package ifsuldeminas.compraOnline.controller.comercial;

import ifsuldeminas.compraOnline.model.entities.comercial.Produto;
import ifsuldeminas.compraOnline.model.repositories.comercial.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    /*
     * O metodo retorna um objeto do tipo Produto, ou seja, a
     * resposta HTTP ira conter os dados do produto recem cadastrado.
     * O metodo recebe como parametro um objeto do tipo Produto.
     * Dessa forma, antes de invocar tal metodo, o Spring Framework
     * ira instanciar um objeto do tipo produto e inicializar seus
     * atributos com os dados recebidas na requisicao. Para isso,
     * e´ necessario implementar na entidade Plano um construtor
     * padrao e getters e setters para todos os atributos.
     * @PostMapping - define que o metodo trata requisicoes POST.
     * @RequestBody - indica que os dados do objeto Produto serao
     * obtidos pelo corpo da requisicao (request body)
     */
    @PostMapping
    public Produto cadastra(@Valid @RequestBody Produto produto){
        //verificar os dados (implementaremos depois)

        //se os dados estiverem ok, cadastra o produto no BD
        //executando um metodo de produtoRepository.
        // O metodo save retorna o proprio produto.
        return produtoRepository.save(produto);
    }

    //operacoes read

    //lista produtos
    @GetMapping
    public List<Produto> listaProdutos(){
        return this.produtoRepository.findAll();
    }

    //lista dados de um produto
    @GetMapping("/{id}")
    public ResponseEntity<Produto> listaProduto(@PathVariable Long id){
        Optional<Produto> opt = this.produtoRepository.findById(id);
        if(opt.isPresent()){
            Produto produto = opt.get();
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        }else{
            return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
        }
    }

    //operacao update
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualiza(@Valid @RequestBody Produto produto, @PathVariable Long id){
        //buscando no BD
        Optional<Produto> opt = this.produtoRepository.findById(id);

        if(opt.isPresent()){
            Produto produtoBD = opt.get();
            //atualizando os dados do produto
            produtoBD.setNome(produto.getNome());
            produtoBD.setDescricao(produto.getDescricao());
            produtoBD.setPreco(produto.getPreco());
            //atualizando no BD e retornando os dados do produto
            this.produtoRepository.save(produtoBD);
            return new ResponseEntity<Produto>(produtoBD, HttpStatus.OK);
        }else{
            return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
        }
    }

    //operacao delete
    @DeleteMapping("/{id}")
    public ResponseEntity deleta(@PathVariable Long id){
        try {
            this.produtoRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch (RuntimeException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
