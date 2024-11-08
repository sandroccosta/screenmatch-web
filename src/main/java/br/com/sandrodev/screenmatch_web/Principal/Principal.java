package br.com.sandrodev.screenmatch_web.Principal;

import br.com.sandrodev.screenmatch_web.model.DadosSerie;
import br.com.sandrodev.screenmatch_web.model.DadosTemporada;
import br.com.sandrodev.screenmatch_web.service.ConsumoApi;
import br.com.sandrodev.screenmatch_web.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private final String URL = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=d24567b9";

    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converso = new ConverteDados();

    private Scanner leitura = new Scanner(System.in);
    public void exibirMenu() {
        System.out.println("Digite o nome da serie que consultar: ");
        var nomeSerie = leitura.nextLine();
        var json = consumoApi.obterDados(URL + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dadosSerie = converso.obterDados(json, DadosSerie.class);
        System.out.println("Dados da série: " + dadosSerie);


		System.out.println("------------------------------------");
		List<DadosTemporada> temporadas = new ArrayList<>();
		for (int i = 1; i <= dadosSerie.temporadas(); i++) {
			json = consumoApi.obterDados(URL + nomeSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
			DadosTemporada dadosTemporada = converso.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);


    }
}
