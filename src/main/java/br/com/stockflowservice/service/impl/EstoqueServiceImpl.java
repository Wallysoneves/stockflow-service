package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.Estoque;
import br.com.stockflowservice.repository.EstoqueRepository;
import br.com.stockflowservice.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueRepository EstoqueRepository;

    @Override
    public Estoque criarEstoque(Estoque estoque) {
        return EstoqueRepository.save(estoque);
    }

    @Override
    public List<Estoque> buscarTodasEstoque() {
        return EstoqueRepository.findAll();
    }

    @Override
    public Estoque buscarUmEstoque(Long id) throws Exception {
        return EstoqueRepository.findById(id).orElseThrow(() -> new Exception("Estoque não encontrada!"));
    }

    @Override
    public Estoque alterarEstoque(Estoque estoque) throws Exception {

        if (EstoqueRepository.exists(Example.of(estoque))) {
            return EstoqueRepository.save(estoque);
        } else {
            throw new Exception("Estoque não encontrada!");
        }
    }

    @Override
    public void deletarEstoque(Long id) throws Exception {
        Estoque estoque = this.buscarUmEstoque(id);
        EstoqueRepository.delete(estoque);
    }

    @Override
    public void deletarEstoque(Estoque estoque) throws Exception {
        Estoque estoqueEncontrado = this.buscarUmEstoque(estoque.getId());
        EstoqueRepository.delete(estoqueEncontrado);
    }
}
