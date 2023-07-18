package br.com.pedrohp28.pokemonwiki.repositories;

import br.com.pedrohp28.pokemonwiki.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}