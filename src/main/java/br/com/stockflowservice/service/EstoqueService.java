package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Estoque;
import br.com.stockflowservice.domain.dto.EstoqueDTO;

import java.util.List;

public interface EstoqueService {

    Estoque criarEstoque(EstoqueDTO Estoque) throws Exception;

    List<Estoque> buscarTodasEstoque();

    Estoque buscarUmEstoque(Long id) throws Exception;

    Estoque alterarEstoque(EstoqueDTO Estoque) throws Exception;

    void deletarEstoque(Long id) throws Exception;

    void deletarEstoque(EstoqueDTO Estoque) throws Exception;
}
