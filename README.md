
# 🛍️ E-commerce API - Spring Boot & Spring Data JPA

Este projeto é uma API REST de um sistema de e-commerce desenvolvida com Spring Boot, Spring Data JPA e banco de dados MySQL. A aplicação implementa funcionalidades básicas de pedidos, clientes, produtos e relacionamentos entre as entidades, utilizando as boas práticas de modelagem com JPA.

## 🔧 Funcionalidades

- Cadastro e listagem de pedidos com paginação
- Detalhamento completo de pedidos
- Relacionamentos com:
    - `@OneToOne`
    - `@OneToMany`
    - `@ManyToOne`
    - `@ManyToMany`
- Uso de `@Embeddable` e `@EmbeddedId`
- Configuração de chaves estrangeiras com `@JoinColumn` e `@JoinTable`
- Restrições de unicidade com `@UniqueConstraint`
- Estratégias de `CascadeType`
- Controle de carregamento de dados com `FetchType.LAZY` e `FetchType.EAGER`

## 📁 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## ⚙️ Requisitos para rodar o projeto

1. Ter o MySQL instalado e rodando
2. Criar um banco de dados com o nome `ecommerce` ou alterar no `application.properties`
3. Alterar o arquivo `src/main/resources/application.properties` para conter as credenciais do seu banco:

```properties
spring.application.name=ecommerce

spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=${BANCOKEY}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

> 🔐 **Atenção**: Substitua `${BANCOKEY}` pela sua senha do banco local, ou configure uma variável de ambiente com esse nome.

## 🚀 Como rodar

Com o Maven instalado:

```bash
./mvnw spring-boot:run
```

Ou rode diretamente pela sua IDE (ex: IntelliJ IDEA).

---

Desenvolvido por Henrique Lindman ✨
