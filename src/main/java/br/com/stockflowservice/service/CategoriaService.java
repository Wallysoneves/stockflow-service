package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria criarCategoria(Categoria categoria);

    List<Categoria> buscarTodasCategoria();

    Categoria buscarUmaCategoria(Long id) throws Exception;

    Categoria alterarCategoria(Categoria categoria) throws Exception;

    void deletarCategoria(Long id) throws Exception;

    void deletarCategoria(Categoria categoria) throws Exception;
}
