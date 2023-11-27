package br.com.stockflowservice.service.component;

import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.EstoqueDTO;
import br.com.stockflowservice.service.EstoqueService;
import br.com.stockflowservice.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjecaoDependencia {

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private ProdutoService produtoService;

    public void criarEstoque(EstoqueDTO estoqueDTO, Produto produto) {
        estoqueService.criarEstoque(estoqueDTO, produto);
    }

    public Produto buscarProduto(Long id) {
        return produtoService.buscarUmProduto(id);
    }
}
