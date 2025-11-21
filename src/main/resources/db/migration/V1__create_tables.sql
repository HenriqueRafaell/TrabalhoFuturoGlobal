-- ===============================
-- TABELA: cargo
-- ===============================
CREATE TABLE cargo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(80) NOT NULL
);

-- ===============================
-- TABELA: tipo_deficiencia
-- ===============================
CREATE TABLE tipo_deficiencia (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL
);

-- ===============================
-- TABELA: cadastro_profissional
-- ===============================
CREATE TABLE cadastro_profissional (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,    
    cargo_id BIGINT,
    tipo_deficiencia_id BIGINT,
    idade integer,
    data_criacao TIMESTAMP,
    cep VARCHAR(8) NOT NULL,
    logradouro VARCHAR(150),
    bairro VARCHAR(150),
    cidade VARCHAR(100),
    estado VARCHAR(2),
    
    CONSTRAINT fk_cadastro_cargo
        FOREIGN KEY (cargo_id)
        REFERENCES cargo(id),
    
    CONSTRAINT fk_cadastro_deficiencia
        FOREIGN KEY (tipo_deficiencia_id)
        REFERENCES tipo_deficiencia(id)
);

-- ===============================
-- TABELA: avaliacao_posto_trabalho
-- ===============================
CREATE TABLE avaliacao_posto_trabalho (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    cadastro_id BIGINT NOT NULL,
    
    acesso_rampa BOOLEAN DEFAULT FALSE,
    software_leitor_tela BOOLEAN DEFAULT FALSE,
    mesa_ergonomica_ajustada BOOLEAN DEFAULT FALSE,

    data_analise TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_avaliacao_cadastro
        FOREIGN KEY (cadastro_id)
        REFERENCES cadastro_profissional(id)
);
