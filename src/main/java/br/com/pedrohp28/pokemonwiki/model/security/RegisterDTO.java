package br.com.pedrohp28.pokemonwiki.model.security;

public record RegisterDTO(String login, String password, UserRole role) {
}
