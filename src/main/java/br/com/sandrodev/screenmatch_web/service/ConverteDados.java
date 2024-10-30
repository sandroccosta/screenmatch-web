package br.com.sandrodev.screenmatch_web.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements interfaceConverteDados{
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <t> t obterDados(String json, Class<t> classe) {
       try {
        return  mapper.readValue(json, classe);
       }catch (JsonProcessingException e) {
           throw new RuntimeException(e);
       }
    }
}
