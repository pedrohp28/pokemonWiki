package br.com.pedrohp28.pokemonwiki.controller;

import br.com.pedrohp28.pokemonwiki.data.vo.PokemonVO;
import br.com.pedrohp28.pokemonwiki.model.Pokemon;
import br.com.pedrohp28.pokemonwiki.service.PokemonService;
import br.com.pedrohp28.pokemonwiki.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort.*;

@RestController
@RequestMapping("/api/pokemon/v1")
@Tag(name = "Pekemon", description = "Endpoints para gerenciar os Pokemon")
public class PokemonController {

    @Autowired
    private PokemonService service;

    @GetMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Procurar um Pokemon",description = "Informe o Id de pokemon e retornará suas informações",
            tags = {"Pokemon"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PokemonVO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public PokemonVO findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Encontre todos os pokemon",description = "Acesse todas as informações dos pokemons cadastrados",
            tags = {"Pokemon"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = PokemonVO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<PagedModel<EntityModel<PokemonVO>>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "12") Integer size,
            @RequestParam(value = "direction", defaultValue = "asc") String direction
    ){

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "name"));
        return ResponseEntity.ok(service.findAll(pageable));
    }
}
