package br.com.sandrodev.screenmatch_web;

import br.com.sandrodev.screenmatch_web.model.DadosEpisodio;
import br.com.sandrodev.screenmatch_web.model.DadosSerie;
import br.com.sandrodev.screenmatch_web.model.DadosTemporada;
import br.com.sandrodev.screenmatch_web.service.ConsumoApi;
import br.com.sandrodev.screenmatch_web.service.ConverteDados;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchWebApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=d24567b9");

		System.out.println("json:" + json);
		System.out.println("------------------------------------");
		ConverteDados converso = new ConverteDados();

		DadosSerie dadosSeries = converso.obterDados(json, DadosSerie.class);
		System.out.println("Dados da série: " + dadosSeries);

		System.out.println("------------------------------------");

		json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=1&apikey=d24567b9");
		DadosEpisodio dadosEpisodio = converso.obterDados(json, DadosEpisodio.class);
		System.out.println("Dados do episódio: " + dadosEpisodio);

		System.out.println("------------------------------------");
		List<DadosTemporada> temporadas = new ArrayList<>();
		for (int i = 1; i <= dadosSeries.temporadas(); i++) {
			json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=d24567b9");
			DadosTemporada dadosTemporada = converso.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);



	}
}
