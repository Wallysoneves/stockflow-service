package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.Categoria;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.util.List;

public interface CategoriaResource {

    @Operation(
            summary = "Criar uma categoria",
            description = "Método responsável por criar uma categoria no sistema",
            tags = { "categoria"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Categoria.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
    })
    Categoria criarCategoria(Categoria categoria);

    @Operation(
            summary = "Recupera varias categorias",
            description = "Método responsável para recuperar varias categorias no sistema",
            tags = { "categoria" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Categoria.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Categoria.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    List<Categoria> buscarTodasCategoria();

    @Operation(
            summary = "Recupera uma categoria",
            description = "Método responsável para recuperar uma categoria no sistema",
            tags = { "categoria" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Categoria.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Categoria.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    Categoria buscarUmaCategoria(Long id) throws Exception;

    @Operation(
            summary = "Alterar uma  categoria",
            description = "Método responsável para alterar uma categoria no sistema",
            tags = { "categoria" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Categoria.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Categoria.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    Categoria alterarCategoria(Categoria categoria) throws Exception;

    @Operation(
            summary = "Deletar uma categoria",
            description = "Método responsável por deletar uma categoria no sistema por id",
            tags = { "categoria" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema(implementation = Categoria.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Categoria.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    void deletarCategoria(Long id) throws Exception;

    @Operation(
            summary = "Deletar uma categoria",
            description = "Método responsável por deletar uma categoria no sistema",
            tags = { "categoria" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema(implementation = Categoria.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema(implementation = Categoria.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) }
    )
    void deletarCategoria(Categoria categoria) throws Exception;
}
