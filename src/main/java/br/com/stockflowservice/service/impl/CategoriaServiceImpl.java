package br.com.stockflowservice.service.impl;


import br.com.stockflowservice.domain.Categoria;
import br.com.stockflowservice.domain.dto.CategoriaDTO;
import br.com.stockflowservice.exception.StockFlowException;
import br.com.stockflowservice.repository.CategoriaRepository;
import br.com.stockflowservice.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria criarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria(categoriaDTO);
        
        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public List<Categoria> buscarTodasCategoria() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarUmaCategoria(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new StockFlowException("Categoria não encontrada!", HttpStatus.NOT_FOUND));
    }

    @Override
    public Categoria alterarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = this.buscarUmaCategoria(categoriaDTO.getId());
        categoria.setNome(categoriaDTO.getNome());
        categoria.setObservacao(categoriaDTO.getObservacao());

        return categoriaRepository.save(categoria);
    }

    @Override
    public void deletarCategoria(Long id) {
        Categoria categoria = this.buscarUmaCategoria(id);
        categoriaRepository.delete(categoria);
    }

    @Override
    public void deletarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria(categoriaDTO);

        Categoria categoriaBuscada = this.buscarUmaCategoria(categoria.getId());
        categoriaRepository.delete(categoriaBuscada);
    }

    @Override
    public Categoria buscarCategoriaNome(String nomeCategoria) {
        return categoriaRepository.findByNome(nomeCategoria)
                .orElseThrow(() -> new StockFlowException("Categoria não encontrada!", HttpStatus.NOT_FOUND));
    }
}
