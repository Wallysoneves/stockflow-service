package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Estoque;
import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.EstoqueDTO;

import java.util.List;

public interface EstoqueService {

    Estoque criarEstoque(EstoqueDTO Estoque);

    Estoque criarEstoque(EstoqueDTO estoque, Produto produto);

    List<Estoque> buscarTodasEstoque();

    Estoque buscarUmEstoque(Long id);

    Estoque buscarEstoqueCodigoBarra(Long codigoBarra);

    Estoque alterarEstoque(EstoqueDTO Estoque);

    void deletarEstoque(Long id);

    void deletarEstoque(EstoqueDTO Estoque);
}
