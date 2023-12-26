# Projeto de Exemplo com Spring Boot, Spring Security e JWT Tokens

Este é um projeto de exemplo que utiliza Spring Boot 3, Spring Security 6 e JWT Tokens para autenticação e autorização de endpoints. O projeto foi desenvolvido para trabalhar com um banco de dados MySQL e está configurado para funcionar na URL padrão localhost:8080.

## Endpoints Disponíveis

### Autenticação
- **POST /login**
  - Permite que os usuários façam login no sistema e recebam um token JWT para autenticação em outros endpoints.
```
{
    "login": "luisfelipe",
    "password": 12345
}
```
  
- **POST /register**
  - Permite o registro de novos usuários no sistema.

```
{
    "login": "luisfelipe",
    "password": 12345,
    "email": "luis@gmail.com",
    "role": "ADMIN"
}
```

### Produtos
- **GET /products**
  - Endpoint acessível para usuários com função USER e ADMIN.
  - Retorna a lista de produtos disponíveis.
  
- **POST /products**
  - Endpoint acessível apenas para usuários com função ADMIN.
  - Permite a criação de novos produtos no sistema.
    
```
{
    "name": "Computador",
    "value": 100
}
```

## Autorização por Função
- **USER**
  - Tem acesso apenas ao endpoint GET /products.
  
- **ADMIN**
  - Tem acesso aos endpoints GET /products e POST /products.

## Configuração do Banco de Dados
Este projeto utiliza MySQL como banco de dados. Certifique-se de ter o MySQL configurado e atualize as informações de configuração no arquivo `application.properties`.

## Inicialização do Projeto
1. Certifique-se de ter o MySQL configurado corretamente.
2. Clone este repositório.
3. Configure as propriedades do banco de dados no arquivo `application.properties`.
4. Execute a aplicação Spring Boot.

## Como Usar
1. Faça uma solicitação POST para `/register` com as informações necessárias para registrar um novo usuário no sistema.
2. Após o registro, faça uma solicitação POST para `/login` com as credenciais do usuário recém-registrado para receber um token JWT.
3. Use o token JWT recebido para acessar os endpoints conforme as permissões do usuário (USER ou ADMIN).
