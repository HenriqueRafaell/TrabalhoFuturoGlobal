package br.com.fiap.TrabalhoFuturo.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CadastroProfissionalDTO {

    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    private String nome;

    @NotNull(message = "O cargoId não pode ser nulo.")
    private Long cargoId;

    @Min(value = 18, message = "A idade deve ser maior ou igual a 18 anos.")
    private Integer idade;

    @NotNull(message = "O tipoDeficienciaId não pode ser nulo.")
    private Long tipoDeficienciaId;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Long getTipoDeficienciaId() {
        return tipoDeficienciaId;
    }

    public void setTipoDeficienciaId(Long tipoDeficienciaId) {
        this.tipoDeficienciaId = tipoDeficienciaId;
    }
}
