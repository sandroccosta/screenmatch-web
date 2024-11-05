package br.com.sandrodev.screenmatch_web.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)//ignora campos desconhecidos
public record DadosEpisodio(@JsonAlias("Title") String titulo,
                             @JsonAlias("Episode") Integer numero,
                             @JsonAlias("Released") String lancamento,
                             @JsonAlias("imdbRating") String avaliacao) {
}
