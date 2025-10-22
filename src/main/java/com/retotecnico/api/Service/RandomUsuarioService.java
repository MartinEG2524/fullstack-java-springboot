package com.retotecnico.api.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.retotecnico.api.Model.RandomUsuarioResponse;
import com.retotecnico.api.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

@Service
public class RandomUsuarioService {

    private final String API_URL = "https://randomuser.me/api/?results=10";

    public List<Usuario> obtenerUsuarios() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            RandomUsuarioResponse response = restTemplate.getForObject(API_URL, RandomUsuarioResponse.class);

            if (response != null && response.getResults() != null) {
                return response.getResults();
            } else {
                System.out.println("No se encontraron resultados en la respuesta.");
            }
        } catch (Exception e) {
            System.out.println("Error al obtener los usuarios: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
