package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Categoria;
import br.com.stockflowservice.domain.dto.CategoriaDTO;

import java.util.List;

public interface CategoriaService {

    Categoria criarCategoria(CategoriaDTO categoria);

    List<Categoria> buscarTodasCategoria();

    Categoria buscarUmaCategoria(Long id);

    Categoria alterarCategoria(CategoriaDTO categoria);

    void deletarCategoria(Long id);

    void deletarCategoria(CategoriaDTO categoria);

    Categoria buscarCategoriaNome(String nomeCategoria);
}
