package br.com.fiap.TrabalhoFuturo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.TrabalhoFuturo.domain.dto.ViaCepResponseDTO;

@Service
public class ViaCepService {

    private final RestTemplate restTemplate = new RestTemplate();

    public ViaCepResponseDTO consultarCep(String cep) {

        try {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";

            ViaCepResponseDTO response =
                    restTemplate.getForObject(url, ViaCepResponseDTO.class);

            if (response == null || response.getLogradouro() == null) {
                throw new IllegalArgumentException("CEP não encontrado.");
            }

            return response;

        } catch (RestClientException e) {
            throw new RuntimeException("Erro ao consultar ViaCEP.");
        }
    }
}
