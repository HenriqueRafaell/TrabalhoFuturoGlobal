package br.com.fiap.TrabalhoFuturo.domain.enums;

public enum CargoEnum {
    ANALISTA_TI("Analista de TI"),
    DESENVOLVEDOR("Desenvolvedor"),
    GERENTE("Gerente"),
    AUXILIAR_ADMINISTRATIVO("Auxiliar Administrativo");

    private final String descricao;

    CargoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
