# 🌱 aprendendo-spring

Projeto de estudos criado com o objetivo de **fixar conhecimentos em desenvolvimento Java com Spring Boot** e praticar a implementação de um **pipeline de CI/CD** com GitHub Actions.

Aqui, o foco não é entregar um produto final, mas sim **exercitar na prática** conceitos como camadas de aplicação, persistência de dados, autenticação/autorização com JWT e automação de build via integração contínua.

---

## 🎯 Objetivo do projeto

Este repositório faz parte da minha rotina de estudo contínuo em desenvolvimento back-end. A proposta é simular, em pequena escala, uma API real de gerenciamento de usuários, aplicando boas práticas de arquitetura em camadas e configurando um workflow de CI para validar o build a cada Pull Request.

Principais pontos praticados:

- Estruturação de um projeto Spring Boot em camadas (`controller`, `business`, `infrastructure`)
- Persistência de dados com **Spring Data JPA** e **PostgreSQL**
- Autenticação e autorização com **Spring Security + JWT**
- Tratamento de exceções customizadas
- Automação de build com **GitHub Actions (CI/CD)**

---

## 🛠️ Tecnologias utilizadas

- **Java 17**
- **Spring Boot** (Web, Data JPA, Security)
- **PostgreSQL**
- **JWT (JJWT)** para geração e validação de tokens
- **Lombok**
- **Maven**
- **GitHub Actions** para CI/CD

---

## 📁 Estrutura do projeto

```
src/main/java/com/jorge/aprendendo_spring
├── AprendendoSpringApplication.java
├── business
│   └── UsuarioService.java
├── controller
│   ├── UsuarioController.java
│   └── dtos/UsuarioDTO.java
└── infrastructure
    ├── entity
    │   ├── Usuario.java
    │   ├── Enderecos.java
    │   └── Telefone.java
    ├── exceptions
    │   ├── ConflictExecptions.java
    │   └── ResourceNotFoundException.java
    ├── repository
    │   ├── UsuarioRepository.java
    │   ├── EnderecoRepository.java
    │   └── TelefoneRepository.java
    └── security
        ├── JwtRequestFilter.java
        ├── JwtUtil.java
        ├── SecurityConfig.java
        └── UserDetailsServiceImpl.java
```

A organização segue uma separação por responsabilidade:

- **controller**: exposição dos endpoints REST e DTOs de entrada/saída
- **business**: regras de negócio da aplicação
- **infrastructure**: entidades JPA, repositórios, tratamento de exceções e configuração de segurança

---

## 🔗 Endpoints disponíveis

| Método | Endpoint              | Descrição                              |
|--------|------------------------|-----------------------------------------|
| POST   | `/usuario`             | Cadastra um novo usuário                |
| POST   | `/usuario/login`       | Autentica o usuário e retorna um token JWT |
| GET    | `/usuario?email=`      | Busca um usuário pelo e-mail            |
| DELETE | `/usuario/{email}`     | Remove um usuário pelo e-mail           |

---

## ⚙️ Como executar localmente

### Pré-requisitos

- Java 17+
- Maven
- PostgreSQL rodando localmente

### Passos

```bash
# Clone o repositório
git clone https://github.com/Jorge-Gabriel97/aprendendo-spring.git
cd aprendendo-spring

# Configure o banco de dados em src/main/resources/application.properties
# (url, usuário e senha do PostgreSQL)

# Execute a aplicação
./mvnw spring-boot:run
```

A aplicação sobe por padrão na porta **8081**.

> ⚠️ **Nota de segurança:** o `application.properties` deste projeto contém credenciais de banco de dados apenas para fins de estudo local. Em um cenário real, essas informações devem ser movidas para variáveis de ambiente ou um arquivo de configuração fora do versionamento (via `.gitignore`).

---

## 🔄 CI/CD

O projeto conta com um workflow de **integração contínua** configurado em `.github/workflows/maven.yml`, disparado automaticamente a cada Pull Request aberto, sincronizado ou reaberto na branch `main`.

O pipeline executa:

1. **Checkout** do código-fonte
2. **Setup** do JDK 17 (Temurin)
3. **Cache** de dependências Maven, para acelerar builds futuros
4. **Build** do projeto com `mvn package`

A ideia é evoluir esse pipeline gradualmente, incluindo execução automática de testes e, futuramente, etapas de deploy contínuo (CD).

---

## 📌 Status

Projeto em constante evolução, usado como campo de prática para novos conceitos de Spring e DevOps à medida que vou estudando.

---

## 👤 Autor

**Jorge Gabriel**
Desenvolvedor Full Stack

[LinkedIn](https://www.linkedin.com/in/jorge-gabriel-579605228) · [GitHub](https://github.com/Jorge-Gabriel97)
