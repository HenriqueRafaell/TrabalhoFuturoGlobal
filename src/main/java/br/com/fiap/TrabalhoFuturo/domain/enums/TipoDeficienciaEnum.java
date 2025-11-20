package br.com.fiap.TrabalhoFuturo.domain.enums;

public enum TipoDeficienciaEnum {
    MOTORAS("Motora"),
    AUDITIVA("Auditiva"),
    VISUAL("Visual"),
    COGNITIVA("Cognitiva");

    private final String descricao;

    TipoDeficienciaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
