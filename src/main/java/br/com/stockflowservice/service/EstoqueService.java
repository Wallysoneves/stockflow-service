package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Estoque;

import java.util.List;

public interface EstoqueService {

    Estoque criarEstoque(Estoque Estoque);

    List<Estoque> buscarTodasEstoque();

    Estoque buscarUmaEstoque(Long id) throws Exception;

    Estoque alterarEstoque(Estoque Estoque) throws Exception;

    void deletarEstoque(Long id) throws Exception;

    void deletarEstoque(Estoque Estoque) throws Exception;
}
