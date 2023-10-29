package br.com.stockflowservice.service.impl;


import br.com.stockflowservice.domain.Categoria;
import br.com.stockflowservice.repository.CategoriaRepository;
import br.com.stockflowservice.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria criarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> buscarTodasCategoria() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarUmaCategoria(Long id) throws Exception {
        return categoriaRepository.findById(id).orElseThrow(() -> new Exception("Categoria não encontrada!"));
    }

    @Override
    public Categoria alterarCategoria(Categoria categoria) throws Exception {

        if (categoriaRepository.exists(Example.of(categoria))) {
            return categoriaRepository.save(categoria);
        } else {
            throw new Exception("Categoria não encontrada!");
        }
    }

    @Override
    public void deletarCategoria(Long id) throws Exception {
        Categoria categoria = this.buscarUmaCategoria(id);
        categoriaRepository.delete(categoria);
    }

    @Override
    public void deletarCategoria(Categoria categoria) throws Exception {
        Categoria categoriaBuscada = this.buscarUmaCategoria(categoria.getId());
        categoriaRepository.delete(categoriaBuscada);
    }
}
