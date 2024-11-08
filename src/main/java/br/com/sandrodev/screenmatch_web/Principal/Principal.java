package br.com.sandrodev.screenmatch_web.Principal;

import br.com.sandrodev.screenmatch_web.model.DadosEpisodio;
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

        List<DadosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i <= dadosSerie.temporadas(); i++) {
            json = consumoApi.obterDados(URL + nomeSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
            DadosTemporada dadosTemporada = converso.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);

        for (int i = 0; i < dadosSerie.temporadas(); i++) {
            // Obtém a lista de episódios para a temporada atual
            List<DadosEpisodio> episodios = temporadas.get(i).episodios();

            // Itera sobre cada episódio na temporada atual
            for (int j = 0; j < episodios.size(); j++) {
                // Imprime o título do episódio atual
                System.out.println(episodios.get(j).titulo());
            }
        }


    }
}
