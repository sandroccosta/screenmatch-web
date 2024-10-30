
//classe para mapear os dados da api

package br.com.sandrodev.screenmatch_web.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)//ignora campos desconhecidos
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") String temporadas,
                         @JsonAlias("imdbRating") String avaliacao) {
}
