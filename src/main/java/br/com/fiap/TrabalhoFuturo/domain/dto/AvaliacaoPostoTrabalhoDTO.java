package br.com.fiap.TrabalhoFuturo.domain.dto;

import jakarta.validation.constraints.NotNull;

public class AvaliacaoPostoTrabalhoDTO {

    @NotNull(message = "O ID do profissional é obrigatório")
    private Long cadastroId;

    private Boolean acessoRampa;
    private Boolean softwareLeitorTela;
    private Boolean mesaErgonomicaAjustada;

    public Long getCadastroId() {
        return cadastroId;
    }

    public void setCadastroId(Long cadastroId) {
        this.cadastroId = cadastroId;
    }

    public Boolean getAcessoRampa() {
        return acessoRampa;
    }

    public void setAcessoRampa(Boolean acessoRampa) {
        this.acessoRampa = acessoRampa;
    }

    public Boolean getSoftwareLeitorTela() {
        return softwareLeitorTela;
    }

    public void setSoftwareLeitorTela(Boolean softwareLeitorTela) {
        this.softwareLeitorTela = softwareLeitorTela;
    }

    public Boolean getMesaErgonomicaAjustada() {
        return mesaErgonomicaAjustada;
    }

    public void setMesaErgonomicaAjustada(Boolean mesaErgonomicaAjustada) {
        this.mesaErgonomicaAjustada = mesaErgonomicaAjustada;
    }
}
