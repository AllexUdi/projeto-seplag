Projeto: Sistema de Gestão de Servidores Públicos - Processo seletivo -  SEPLAG MT

 📦 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.4**
- **Maven**
- **PostgreSQL (via Docker)**
- **MinIO (S3 Storage via Docker)**
- **Spring Security com JWT**
- **Spring Data JPA**
- **Spring Web**
- **Lombok**
- **ModelMapper (opcional)**
- **Docker / Docker Compose**


 ▶️ Como Executar o Projeto

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/AllexUdi/desafio-seplag.git
   cd seuprojeto


2. Configure variáveis de ambiente (caso necessário):

Crie um arquivo .env (opcional) ou edite application.yml para ajustar suas credenciais de banco de dados ou MinIO.

3.Suba os containers Docker:

docker-compose up --build

Isso irá subir:

PostgreSQL (última versão), MinIO Server, a aplicação Spring Boot

4.Acesse a aplicação:

Backend: http://localhost:8080

MinIO Console: http://localhost:9000

Default: minioadmin / minioadmin


5.Autenticação

A API usa autenticação baseada em JWT.

O token expira em 5 minutos.

É possível renovar o token usando o endpoint /auth/refresh.

6.Endpoints Principais

POST /servidor-efetivo

PUT /servidor-efetivo/{id}

GET /servidor-efetivo (com paginação)

Mesmos endpoints para:

/servidor-temporario

/unidade

/lotacao

*Consultas Especiais

GET /servidor-efetivo/unidade/{unid_id}

Retorna nome, idade, unidade de lotação e fotografia.

GET /servidor-efetivo/buscar-endereco?nome=João

Retorna o endereço funcional da unidade onde o servidor está lotado, a partir de parte do nome.


7.Testando a aplicação

Recomenda-se o uso do Postman ou Insomnia para testar os endpoints com autenticação JWT.

* Observações

O projeto está preparado para rodar totalmente via Docker Compose.

Evite alterar os arquivos após o prazo final de entrega.

Certifique-se de que todos os commits foram feitos antes do prazo.
