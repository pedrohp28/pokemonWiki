package br.com.pedrohp28.pokemonwiki.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pokemon")
public class Pokemon implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String type;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    @Column(name = "sp_Atk")
    private Integer spAttack;
    @Column(name = "sp_Def")
    private Integer spDefense;
    private Integer speed;

    public Pokemon() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(o instanceof Pokemon pokemon)) return false;
        return Objects.equals(id, pokemon.id) && Objects.equals(name, pokemon.name) && Objects.equals(description, pokemon.description) && Objects.equals(type, pokemon.type) && Objects.equals(hp, pokemon.hp) && Objects.equals(attack, pokemon.attack) && Objects.equals(defense, pokemon.defense) && Objects.equals(spAttack, pokemon.spAttack) && Objects.equals(spDefense, pokemon.spDefense) && Objects.equals(speed, pokemon.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, type, hp, attack, defense, spAttack, spDefense, speed);
    }
}
