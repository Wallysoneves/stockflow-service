package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.Estoque;

import java.util.List;

public interface EstoqueResource {

    Estoque criarEstoque(Estoque Estoque);

    List<Estoque> buscarTodasEstoque();

    Estoque buscarUmEstoque(Long id) throws Exception;

    Estoque alterarEstoque(Estoque Estoque) throws Exception;

    void deletarEstoque(Long id) throws Exception;

    void deletarEstoque(Estoque Estoque) throws Exception;
}
