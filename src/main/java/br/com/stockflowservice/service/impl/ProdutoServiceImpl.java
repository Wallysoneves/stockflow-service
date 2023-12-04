package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.Categoria;
import br.com.stockflowservice.domain.Estoque;
import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.EstoqueDTO;
import br.com.stockflowservice.domain.dto.ProdutoDTO;
import br.com.stockflowservice.exception.StockFlowException;
import br.com.stockflowservice.repository.ProdutoRepository;
import br.com.stockflowservice.service.CategoriaService;
import br.com.stockflowservice.service.EstoqueService;
import br.com.stockflowservice.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    @Lazy
    private EstoqueService estoqueService;

    @Override
    public Produto criarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);

        Categoria categoria = categoriaService.buscarUmaCategoria(produtoDTO.getCategoriaDTO().getId());
        produto.setCategoria(categoria);

        Produto produtoNovo = produtoRepository.save(produto);

        EstoqueDTO estoqueDTO = EstoqueDTO.builder()
                                            .dataEntrada(produtoNovo.getDataCadastro())
                                            .situacao("I")
                                            .precoCompra(produtoNovo.getPreco())
                                            .precoVenda(produtoNovo.getPreco())
                                            .quantidade(0)
                                            .build();

        estoqueService.criarEstoque(estoqueDTO, produto);

        return produtoNovo;

    }

    @Override
    public List<Produto> buscarTodasProduto() {
        return produtoRepository.findAll();
    }

    @Override
    public List<Produto> buscarCampoPesquisa (String texto) {
        List<Produto> produtos = new ArrayList<>();

        produtos.addAll(produtoRepository.buscarCampoPesquisa(texto).orElse(new ArrayList<>()));

        String textSemLetra = texto.replaceAll("\\D", "");

        if (!textSemLetra.trim().isBlank()) {
            Long codbarra = Long.valueOf(textSemLetra);

            produtos.addAll(produtoRepository.findByCodigoBarra(codbarra).orElse(new ArrayList<>()));
        }

        return produtos;
    }

    @Override
    public Produto buscarUmProduto(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new StockFlowException("Produto não encontrada!", HttpStatus.BAD_REQUEST));
    }

    @Override
    public Produto alterarProduto(ProdutoDTO produtoDTO) {
        Produto produto = buscarUmProduto(produtoDTO.getId());

        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setObservacao(produtoDTO.getObservacao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setCodigoBarra(produtoDTO.getCodigoBarra());
        produto.setDataAlteracao(Objects.nonNull(produtoDTO.getDataAlteracao()) ? produtoDTO.getDataAlteracao() : LocalDateTime.now());

        return produtoRepository.save(produto);

    }

    @Override
    public void deletarProduto(Long id) {
        Produto produto = this.buscarUmProduto(id);
        Estoque estoque = estoqueService.buscarUmEstoque(produto);

        if (estoque.getQuantidade() > 0) {
            throw new StockFlowException("Esse produto possui estoque, é preciso dar baixa no estoque para excluir o produto!", HttpStatus.BAD_REQUEST);
        }
        estoqueService.deletarEstoque(estoque.getId());
        produtoRepository.delete(produto);
    }

    @Override
    public void deletarProduto(ProdutoDTO produto) {
        Produto produtoEncontrado = this.buscarUmProduto(produto.getId());

        Estoque estoque = estoqueService.buscarUmEstoque(produtoEncontrado);

        if (estoque.getQuantidade() > 0) {
            throw new StockFlowException("Esse produto possui estoque, é preciso dar baixa no estoque para excluir o produto!", HttpStatus.BAD_REQUEST);
        }
        estoqueService.deletarEstoque(estoque.getId());
        produtoRepository.delete(produtoEncontrado);
    }
}
