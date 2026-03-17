# Sistema de Gerenciamento de Pedidos

Uma aplicação robusta e completa construída com **Spring Boot 4.0.3** para gerenciar pedidos, produtos, pessoas e usuários com autenticação segura.

## 📋 Descrição do Projeto

Este projeto é uma API REST que fornece funcionalidades completas para um sistema de e-commerce ou gestão de pedidos. A aplicação implementa autenticação de usuários, criptografia de senhas e operações CRUD para as principais entidades do negócio.

## 🎯 Funcionalidades Principais

### 👥 Gestão de Usuários
- ✅ Criar novos usuários
- ✅ Autenticação segura com login
- ✅ Recuperar informações do usuário autenticado
- ✅ Deletar usuários
- ✅ Senhas criptografadas com validação

### 📦 Gestão de Produtos
- ✅ Listar todos os produtos
- ✅ Criar novos produtos
- ✅ Atualizar informações de produtos
- ✅ Deletar produtos

### 📋 Gestão de Pedidos
- ✅ Listar pedidos
- ✅ Criar novos pedidos
- ✅ Deletar pedidos
- ✅ Associação com produtos e usuários

### 👤 Gestão de Pessoas
- ✅ Listar pessoas
- ✅ Criar novas pessoas
- ✅ Atualizar dados de pessoas
- ✅ Deletar pessoas

## 🛠️ Tecnologias Utilizadas

### Backend
- **Java 17** - Linguagem de programação
- **Spring Boot 4.0.3** - Framework web
- **Spring Data JPA** - ORM para persistência de dados
- **Spring Security** - Autenticação e autorização
- **MySQL 8.0** - Banco de dados relacional

### Ferramentas
- **Maven** - Gerenciador de dependências
- **Lombok** - Redução de código boilerplate
- **Docker** - Containerização do banco de dados

## 📁 Estrutura do Projeto

```
src/main/java/com11/
├── controller/           # Controllers REST (endpoints)
│   ├── ControllerLogin.java
│   ├── ControllerUsuario.java
│   ├── ControllerProduto.java
│   ├── ControllerPedido.java
│   └── ControllerPessoa.java
├── service/             # Serviços (lógica de negócio)
│   ├── ServiceUsuario.java
│   ├── ServiceProduto.java
│   ├── ServicePedido.java
│   ├── ServicePessoa.java
│   └── UsuarioDetailsService.java
├── model/              # Entidades JPA
│   ├── Usuario.java
│   ├── Produto.java
│   ├── Pedido.java
│   └── Pessoa.java
├── DTO/                # Data Transfer Objects
│   ├── DTOLoginRequest.java
│   ├── DTOUsuario.java
│   ├── DTOProduto.java
│   ├── DTOPedido.java
│   └── DTOPessoa.java
├── repository/         # Repositórios (acesso a dados)
│   ├── RepositoryUsuario.java
│   ├── RepositoryProduto.java
│   ├── RepositoryPedido.java
│   └── RepositoryPessoa.java
├── configurations/     # Configurações
│   └── SecurityConfig.java
└── Application.java    # Classe principal
```

## 🚀 Como Executar

### Pré-requisitos
- Java 17 ou superior instalado
- Maven instalado
- Docker e Docker Compose (opcional, para banco de dados)
- MySQL 8.0 (ou usar Docker)

### Instalação e Execução

1. **Clone o repositório**
   ```bash
   git clone <seu-repositorio>
   cd 01
   ```

2. **Inicie o banco de dados com Docker**
   ```bash
   docker-compose up -d
   ```

3. **Compile e execute o projeto**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

A aplicação estará disponível em `http://localhost:8080`

## 📡 Endpoints da API

### Autenticação
```
POST /auth/login
Content-Type: application/json
{
  "email": "usuario@example.com",
  "senha": "senha123"
}
```

### Usuários
```
POST /usuario/criar              - Criar novo usuário
GET /usuario                      - Obter usuário logado
DELETE /usuario/deletar/{id}      - Deletar usuário por ID
```

### Produtos
```
GET /produto                      - Listar todos os produtos
POST /produto/criar               - Criar novo produto
PUT /produto/atualizar            - Atualizar produto
DELETE /produto/deletar/{id}      - Deletar produto por ID
```

### Pedidos
```
GET /pedido                       - Listar todos os pedidos
POST /pedido/criar                - Criar novo pedido
DELETE /pedido/deletar/{id}       - Deletar pedido por ID
```

### Pessoas
```
GET /pessoa                       - Listar todas as pessoas
POST /pessoa/criar                - Criar nova pessoa
PUT /pessoa/atualizar             - Atualizar pessoa
DELETE /pessoa/deletar/{id}       - Deletar pessoa por ID
```

## 🔐 Segurança

- **Senhas Criptografadas**: Implementa criptografia segura de senhas
- **Spring Security**: Integração com framework de segurança do Spring
- **Validação de Login**: Descriptografa e valida credenciais no endpoint `/auth/login`
- **LDAP Integration**: Suporte para autenticação LDAP

## 🗄️ Configuração do Banco de Dados

O projeto utiliza MySQL com as seguintes configurações padrão:

```properties
URL: jdbc:mysql://localhost:3356/bancoteste01
Usuário: root
Senha: 1212
Driver: MySQL Connector/J
Dialeto: MySQL8Dialect
DDL-Auto: update (auto-cria/atualiza tabelas)
```

### Docker Compose

O arquivo `docker-compose.yml` fornece uma instância pronta de MySQL:

```yaml
services:
  db:
    image: mysql:8.0
    ports:
      - "3356:3306"
    environment:
      MYSQL_ROOT_PASSWORD: 1212
      MYSQL_DATABASE: bancoteste01
```

## 📝 Padrões de Desenvolvimento

- **DTO Pattern**: Separação entre objetos de transferência de dados e modelos
- **Service Layer**: Lógica de negócio centralizada
- **Repository Pattern**: Abstração do acesso a dados
- **Builder Pattern**: Construção fluente de objetos (Lombok)
- **REST API**: Endpoints seguindo convenções REST

## 🔧 Dependências Principais

```xml
- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- Spring Boot Starter WebMVC
- MySQL Connector/J
- Lombok
- Spring Data LDAP
```

## 📌 Notas Importantes

- A aplicação usa JPA/Hibernate com geração automática de tabelas
- Os logs SQL são exibidos no console para fins de debug
- O pool de conexões HikariCP é configurado para otimizar performance
- A aplicação segue as melhores práticas de segurança do Spring Framework

## 🤝 Contribuindo

Sinta-se à vontade para fazer fork do projeto e enviar pull requests com melhorias.

## 📄 Licença

Este projeto está disponível sem restrições específicas. Sinta-se livre para usar e modificar conforme necessário.

## 👨‍💻 Autor

Desenvolvido como um projeto de gerenciamento de pedidos com Spring Boot.

---

**Status**: Em desenvolvimento  
**Última atualização**: 2026  
**Versão**: 0.0.1-SNAPSHOT

