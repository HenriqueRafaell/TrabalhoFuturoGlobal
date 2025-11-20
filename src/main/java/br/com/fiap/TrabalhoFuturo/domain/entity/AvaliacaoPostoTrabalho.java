package br.com.fiap.TrabalhoFuturo.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "avaliacao_posto_trabalho")
public class AvaliacaoPostoTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cadastro_id", nullable = false)
    private CadastroProfissional cadastroProfissional;

    @Column(name = "acesso_rampa", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean acessoRampa;

    @Column(name = "software_leitor_tela", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean softwareLeitorTela;

    @Column(name = "mesa_ergonomica_ajustada", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean mesaErgonomicaAjustada;

    @Column(name = "data_analise", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataAnalise;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CadastroProfissional getCadastroProfissional() {
        return cadastroProfissional;
    }

    public void setCadastroProfissional(CadastroProfissional cadastroProfissional) {
        this.cadastroProfissional = cadastroProfissional;
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

    public LocalDateTime getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(LocalDateTime dataAnalise) {
        this.dataAnalise = dataAnalise;
    }
}
