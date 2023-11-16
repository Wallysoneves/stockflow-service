package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Categoria;
import br.com.stockflowservice.domain.dto.CategoriaDTO;

import java.util.List;

public interface CategoriaService {

    Categoria criarCategoria(CategoriaDTO categoria);

    List<Categoria> buscarTodasCategoria();

    Categoria buscarUmaCategoria(Long id) throws Exception;

    Categoria alterarCategoria(CategoriaDTO categoria) throws Exception;

    void deletarCategoria(Long id) throws Exception;

    void deletarCategoria(CategoriaDTO categoria) throws Exception;

    Categoria buscarCategoriaNome(String nomeCategoria) throws Exception;
}
