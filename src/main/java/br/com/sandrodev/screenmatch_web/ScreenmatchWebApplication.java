package br.com.sandrodev.screenmatch_web;

import br.com.sandrodev.screenmatch_web.model.DadosSerie;
import br.com.sandrodev.screenmatch_web.service.ConsumoApi;
import br.com.sandrodev.screenmatch_web.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
	}
}
