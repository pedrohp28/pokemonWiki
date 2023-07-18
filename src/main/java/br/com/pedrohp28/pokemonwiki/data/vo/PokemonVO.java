package br.com.pedrohp28.pokemonwiki.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id", "name", "description", "type", "hp", "attack", "defense", "spAtk", "spDef", "speed"})
public class PokemonVO extends RepresentationModel<PokemonVO> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Mapping("id")
    private Long key;
    private String name;
    private String description;
    private String type;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    @JsonProperty("spAtk")
    private Integer spAttack;
    @JsonProperty("spDef")
    private Integer spDefense;
    private Integer speed;

    public PokemonVO() {}

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getSpAttack() {
        return spAttack;
    }

    public void setSpAttack(Integer spAttack) {
        this.spAttack = spAttack;
    }

    public Integer getSpDefense() {
        return spDefense;
    }

    public void setSpDefense(Integer spDefense) {
        this.spDefense = spDefense;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PokemonVO pokemon)) return false;
        return Objects.equals(key, pokemon.key) && Objects.equals(name, pokemon.name) && Objects.equals(description, pokemon.description) && Objects.equals(type, pokemon.type) && Objects.equals(hp, pokemon.hp) && Objects.equals(attack, pokemon.attack) && Objects.equals(defense, pokemon.defense) && Objects.equals(spAttack, pokemon.spAttack) && Objects.equals(spDefense, pokemon.spDefense) && Objects.equals(speed, pokemon.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, description, type, hp, attack, defense, spAttack, spDefense, speed);
    }
}
