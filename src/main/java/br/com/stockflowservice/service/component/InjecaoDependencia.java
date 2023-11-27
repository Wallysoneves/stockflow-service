package br.com.stockflowservice.service.component;

import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.EstoqueDTO;
import br.com.stockflowservice.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjecaoDependencia {

    @Autowired
    private EstoqueService estoqueService;

    public void criarEstoque(EstoqueDTO estoqueDTO, Produto produto) {
        estoqueService.criarEstoque(estoqueDTO, produto);
    }
}
