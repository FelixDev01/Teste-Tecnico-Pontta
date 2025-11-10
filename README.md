# Teste-Tecnico-Pontta.

# Backend

Java 21
Spring Boot
Spring Web
Spring Data JPA
MySQL
Swagger
Maven

# Frontend

Angular 17+
TypeScript
HTML / CSS
Bootstrap

# Funcionalidades
- Backend (API REST)

Cadastrar novo cliente

Listar todos os clientes

Buscar cliente por ID

Atualizar dados do cliente

Excluir cliente

# Frontend (Interface Angular)
Formulário de cadastro e edição de clientes
Listagem de clientes com atualização automática
Botões de editar e excluir
Comunicação via HttpClient com a API REST

O backend foi construído com foco em boas práticas de arquitetura e manutenção, seguindo o padrão Controller → Service → Repository, além de utilizar DTOs para isolamento entre a camada de domínio e a camada de transporte.

Principais recursos:

Cadastro de novos clientes

Listagem de todos os clientes

Busca de cliente por ID

Atualização de dados de cliente existente

Exclusão de cliente

# Boas práticas implementadas:

DTOs (Data Transfer Objects): usados para garantir integridade e controle sobre os dados expostos pela API.

Validações com anotações Jakarta Validation (@NotBlank, @Email, @Size, etc.).

Tratamento de exceções personalizado, retornando respostas padronizadas ao frontend.

Uso de ModelMapper (ou conversão manual) para mapear entidades e DTOs de forma eficiente.
Spring JPA Repository para abstrair consultas SQL e facilitar a persistência.

Camadas desacopladas e limpas, facilitando testes e manutenção.

# Frontend (Angular)

O frontend foi desenvolvido para consumir a API REST do backend e exibir os dados de forma clara e interativa.
Principais recursos:
Tela de listagem de clientes
Formulário para cadastro e edição
Botões para excluir ou atualizar clientes
Comunicação com backend via HttpClient e Observables
Componentização e organização em services, models e components

#  Integração

O frontend se comunica com o backend através de requisições HTTP:

private apiUrl = 'http://localhost:8080/clientes';


As rotas seguem o padrão REST:

GET /clientes

GET /clientes/{id}

POST /clientes

PUT /clientes/{id}

DELETE /clientes/{id}

-Estrutura de Pastas
projeto/
├── Backend/
│   ├── src/main/java/com/seuprojeto/
│   ├── src/main/resources/
│   └── pom.xml
│
└── Frontend/
    ├── src/app/
    │   ├── components/
    │   ├── services/
    │   ├── models/
    │   └── app.module.ts
    └── angular.json

## Como Executar o Projeto
Backend

Clonar o repositório:

git clone https://github.com/FelixDev01/Teste-Tecnico-Pontta.git
 
Entre na classe GerenciamentoApplication e clicar em run ou Shift+ F10


# FrontEnd

Instalar as dependências:
npm install


Rodar o servidor de desenvolvimento:
ng serve

Acessar:
http://localhost:4200