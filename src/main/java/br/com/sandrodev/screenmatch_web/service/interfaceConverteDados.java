package br.com.sandrodev.screenmatch_web.service;

public interface interfaceConverteDados {
    <t> t obterDados(String json, Class<t> classe); //converte o json para a classe passada
}
