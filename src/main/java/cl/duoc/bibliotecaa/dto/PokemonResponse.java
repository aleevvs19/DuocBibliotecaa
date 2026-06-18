package cl.duoc.bibliotecaa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonResponse {

    private Long id;

    private String name;

    @JsonProperty("is_legendary")
    private Boolean isLegendary;

    public PokemonResponse() {
    }

    public PokemonResponse(Long id, String name, Boolean isLegendary) {
        this.id = id;
        this.name = name;
        this.isLegendary = isLegendary;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getIsLegendary() {
        return isLegendary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsLegendary(Boolean legendary) {
        isLegendary = legendary;
    }
}