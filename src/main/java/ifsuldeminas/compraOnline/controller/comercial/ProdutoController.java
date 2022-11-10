package ifsuldeminas.compraOnline.controller.comercial;

import ifsuldeminas.compraOnline.model.entities.comercial.Produto;
import ifsuldeminas.compraOnline.model.repositories.comercial.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Produto cadastra(@RequestBody Produto produto){
        //verificar os dados (implementaremos depois)

        //se os dados estiverem ok, cadastra o produto no BD
        //executando um metodo de produtoRepository.
        // O metodo save retorna o proprio produto.
        return produtoRepository.save(produto);
    }
}
