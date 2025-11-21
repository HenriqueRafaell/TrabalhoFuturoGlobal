# 📌 Sistema de Cadastro de Profissionais  

Este projeto é uma API REST desenvolvida em **Java + Spring Boot**, cujo objetivo é realizar o cadastro de profissionais com cargo, tipo de deficiência e endereço recuperado automaticamente via **consumo externo da API ViaCEP**. Além da possibilidade do profissional conseguir avaliar o posto de trabalho

A aplicação segue boas práticas de arquitetura, validação, separação por camadas, DTOs, Entities, Services, Controllers e Repositories.

---

## 🚀 Funcionalidades

- Cadastro de profissionais  
- Associação com:
  - Tipo de deficiência  
  - Cargo  
- Busca de endereço automática pelo CEP via API ViaCEP  
- Camadas bem organizadas (Controller, Service, Repository, Domain)
- Validações de entrada  
- Tratamento de exceções  
- Conexão com banco de dados  
- Migrações versionadas com Flyway  
- Pronto para testes de carga (ex: JMeter)

---

## 🧱 Arquitetura

Padrão utilizado: **Clean layered architecture**

/src/main/java \
├─ controller -> Recebe as requisições HTTP \
├─ service -> Regras de negócio \
├─ repository -> Acesso ao banco (JPA) \
├─ domain/entity -> Entidades JPA \
├─ domain/dto -> Objetos de transferência de dados \
├─ exception -> Tratamento centralizado


---

## 📦 Dependências Principais

- Spring Web  
- Spring JPA  
- Flyway  
- Validation  
- H2 
- Java 21

---

## 🌎 Consumo de API Externa – ViaCEP

O sistema consome:

https://viacep.com.br/ws/{cep}/json/


Ao cadastrar um profissional, o CEP informado é enviado ao ViaCEP, e os campos de endereço retornados são armazenados no banco.

Exemplo de resposta:

```json
{
  "cep": "05338-900",
  "logradouro": "Rua Exemplo",
  "bairro": "Centro",
  "localidade": "São Paulo",
  "uf": "SP"
}
```

🧪 Banco de Dados & Migrações

Flyway é utilizado para criar tabelas e inserir valores iniciais automaticamente.

Inserts de exemplo:
```sql
INSERT INTO cargo (id, nome) VALUES (1, 'Analista'), (2, 'Desenvolvedor');
INSERT INTO tipo_deficiencia (id, nome) VALUES (1, 'Auditiva'), (2, 'Visual');
```

📌 Modelagem Simplificada

| Campo           | Tipo    | Descrição           |
| --------------- | ------- | ------------------- |
| nome            | String  | Nome completo       |
| idade           | Integer | Idade               |
| cargo           | FK      | Cargo               |
| tipoDeficiencia | FK      | Tipo de deficiência |
| cep             | String  | CEP informado       |
| logradouro      | String  | Obtido via ViaCEP   |
| bairro          | String  | Obtido via ViaCEP   |
| cidade          | String  | Obtido via ViaCEP   |
| uf              | String  | Obtido via ViaCEP   |

🧾 Exemplo de Requisição (cURL) \
➕ Criar profissional

```cURL
curl -X POST http://localhost:8080/profissionais \
-H "Content-Type: application/json" \
-d '{
  "nome": "João Silva",
  "idade": 30,
  "cargoId": 1,
  "tipoDeficienciaId": 2,
  "cep": "05338900"
}'
```

❌ Tratamento de erros

A aplicação apresenta tratamento adequado para:

- Cargo não encontrado

- Tipo de deficiência inexistente

- Erro ao consultar ViaCEP

- CEP inválido

- Validações Bean Validation

- Exceções transformadas em respostas HTTP claras

📚 Testes de Carga

A API está preparada para execução de testes usando ferramentas como:

- Apache JMeter


