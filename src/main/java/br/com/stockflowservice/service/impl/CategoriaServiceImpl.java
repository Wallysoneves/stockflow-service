package br.com.stockflowservice.service.impl;


import br.com.stockflowservice.domain.Categoria;
import br.com.stockflowservice.domain.dto.CategoriaDTO;
import br.com.stockflowservice.repository.CategoriaRepository;
import br.com.stockflowservice.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
    public Categoria buscarUmaCategoria(Long id) throws Exception {
        return categoriaRepository.findById(id).orElseThrow(() -> new Exception("Categoria não encontrada!"));
    }

    @Override
    public Categoria alterarCategoria(CategoriaDTO categoriaDTO) throws Exception {
        Categoria categoria = this.buscarUmaCategoria(categoriaDTO.id());
        categoria.setNome(categoriaDTO.nome());
        categoria.setObservacao(categoriaDTO.observacao());

        return categoriaRepository.save(categoria);
    }

    @Override
    public void deletarCategoria(Long id) throws Exception {
        Categoria categoria = this.buscarUmaCategoria(id);
        categoriaRepository.delete(categoria);
    }

    @Override
    public void deletarCategoria(CategoriaDTO categoriaDTO) throws Exception {
        Categoria categoria = new Categoria(categoriaDTO);

        Categoria categoriaBuscada = this.buscarUmaCategoria(categoria.getId());
        categoriaRepository.delete(categoriaBuscada);
    }

    @Override
    public Categoria buscarCategoriaNome(String nomeCategoria) throws Exception {
        return categoriaRepository.findByNome(nomeCategoria).orElseThrow(() -> new Exception("Categoria não encontrada!"));
    }
}
