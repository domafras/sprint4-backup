# sprint4-backup
API REST capaz de:
- autenticar
- monitorar
- documentar
- listar
- cadastrar
- detalhar
- atualizar
- deletar
- filtrar
- ordenar

Projeto desenvolvido durante a Sprint 4 do Programa de Bolsa da [Compasso UOL](https://compassouol.com/)

### Tecnologias
- [Spring Boot API REST](https://start.spring.io/)
- [H2 Database](http://www.h2database.com/html/quickstart.html)
- [Swagger](https://editor.swagger.io/)
- [SpringFox](https://springfox.github.io/springfox/)
- [Postman](https://www.postman.com/downloads/)
- [Spring Boot Admin](https://codecentric.github.io/spring-boot-admin/current/)

### Pré-requisitos

Antes de começar, você vai precisar ter em sua máquina os arquivos disponibilizados nesse repositório. 

Além do Java e uma IDE como [Eclipse](https://www.eclipse.org/eclipseide/) em que você pode seguir esses passos:
```bash
1. 'Import existing Maven Project'
2. Run 'Sprint4Application.java'
3. Acessar 'localhost:8080' em seu navegador
4. Guide com Endpoints possíveis
5. Somente '../pessoa/**' está livre de autenticação
6. Utilizar Postman ou Swagger UI para explorar todos os métodos
```
### Autenticação
Neste projeto, foram implementados os recursos do Spring Security.
Caso necessário, para se autenticar:
```bash
Acesse: 'http://localhost:8080/auth'
# Execute através do método (POST)
```
Utilizando o Postman, nos Headers adicione:
```bash
KEY: Content-Type
VALUE: application/json
```
Em seguida, no Body digite:
```bash
{
    "email":"auth@email.com",
    "senha":"123456"
}
# Cadastrado na base de dados
```
E com isso, terá acesso ao Token e seu tipo:
```bash
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgU3ByaW50IDQiLCJzdWIiOiIxIiwiaWF0IjoxNjI2NTYxMDE5LCJleHAiOjE2MjY2NDc0MTl9.-2AwnK8IiAXWz3IbgkOto3NIzEO3nOsuXqCFrPPVQiI",
    "tipo": "Bearer"
}
# Que será utilizado no campo Authorization (Postman)
```
Ou, no Swagger UI:
```bash
{
     "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgU3ByaW50IDQiLCJzdWIiOiIxIiwiaWF0IjoxNjI2NTYxMDE5LCJleHAiOjE2MjY2NDc0MTl9.-2AwnK8IiAXWz3IbgkOto3NIzEO3nOsuXqCFrPPVQiI"
}
# Para utilizar os campos '/protected'
```

### Postman 
É no Postman que se torna possível utilizar a API de maneira à utilizar todos os métodos HTTP.
Ou seja, de fato criar, listar, detalhar, atualizar, deletar, filtrar e ordenar de acordo com o domínio explorado.


```bash
Utilizando (POST), (GET), (GET/{id}), (PUT/{ID}), (DELETE/{id}) # Respectivamente
```

### Endpoints:
```bash
(GET) /pessoa
# Apresenta a lista de pessoas cadastradas
Acesse: localhost:8080/pessoa
```
```bash
(GET) /pessoa/1
# Apresenta a pessoa de ID 1 de forma detalhada
Acesse: localhost:8080/pessoa/1
```
```bash
(POST) /pessoa
# Cadastra nova pessoa
Acesse: localhost:8080/pessoa

# No Body, adicione e execute:
{
        "nome": "Gaules",
        "cpf": "77777777777",
        "salario": 7777.00,
        "sexo": "F",
        "enderecos":[
            {
                "pais": "Brasil",
                "estado":"Bahia",
                "cidade": "Salvador",
                "cep":"77777777",
                "rua":"Rua 777"
            }
        ]
    }
```
```bash
(PUT) /pessoa/1
# Atualiza cadastro da pessoa de ID 1
Acesse: localhost:8080/pessoa/1

# No Body, adicione e execute:
{
        "nome": "Elize Matsunaga",
        "cpf": "66666666666",
        "salario": 6666.00,
        "sexo": "F",
        "enderecos":[
            {
                "pais": "Brasil",
                "estado":"Paraná",
                "cidade": "Curitiba",
                "cep":"66666666",
                "rua":"Rua 666"
            }
        ]
    }
```
```bash
(DELETE) /pessoa/1
# Deleta cadastro da pessoa de ID 1
Acesse: localhost:8080/pessoa/1
```
```bash
Gerenciar ordenação com 'asc' ou 'desc'

    # Apresenta pessoas por ordem alfabética crescente:
    Acesse: localhost:8080/pessoa?sort=nome,asc
```
```bash
Gerenciar ordenação com 'desc'

    # Apresenta pessoas por ordem de salário decrescente:
    Acesse: localhost:8080/pessoa?sort=salario,desc
```
```bash
Realizar filtro:

    # Apresenta somente pessoa do sexo feminino:
    Acesse: localhost:8080/pessoa?sexo=F
```
### Swagger UI
Existem várias funcionalidades para o Swagger, sendo capaz de nos auxiliar no desenvolvimento e também no entendimento de uma API. 
Para esse projeto, foi adicionado e configurado o SpringFox, tendo dessa forma a criação da documentação facilitada.

```bash
Run 'Sprint4Application.java'
```
Com a aplicação Java sendo executada, acessar:

```bash
Endereço: localhost:8080/swagger-ui.html
```
Nesta interface, faça a autenticação:
```bash
# Utilizando email e senha
{
  "email": "auth@email.com",
  "senha": "123456"
}
```
```bash
# Recupere o Token e seu tipo
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgU3ByaW50IDQiLCJzdWIiOiIxIiwiaWF0IjoxNjI2NTY1NDUwLCJleHAiOjE2MjY2NTE4NTB9.bdMHWDKgFmVmZ8kSSWOUJQZp-R0OWXo177afrubF1_8",
  "tipo": "Bearer"
}
```
Ao acessar os campos '/protected':
```bash
# Preencha o 'Header para token JWT' da seguinte maneira:
{
     "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgU3ByaW50IDQiLCJzdWIiOiIxIiwiaWF0IjoxNjI2NTYxMDE5LCJleHAiOjE2MjY2NDc0MTl9.-2AwnK8IiAXWz3IbgkOto3NIzEO3nOsuXqCFrPPVQiI"
}
# *Sem as aspas
```
Dessa forma, você terá acesso total ao:
```bash
pedidos-controller
# Expanda a aba e clique em "Try it out"

    Altere os valores dos atributos e execute.
  
    # Requisições:
        (GET)       -> '/protected/pedido'
        (POST)      -> '/protected/pedido'
        (GET)       -> '/protected/pedido/{id}'
        (PUT)       -> '/protected/pedido/{id}'
        (DELETE)    -> '/protected/pedido/{id}'
```
E também:
```bash
produtos-controller
# Expanda a aba e clique em "Try it out"

    Altere os valores dos atributos e execute.
  
    # Requisições:
        (GET)       -> '/protected/produto'
        (POST)      -> '/protected/produto'
        (GET)       -> '/protected/produto/{id}'
        (PUT)       -> '/protected/produto/{id}'
        (DELETE)    -> '/protected/produto/{id}'
```

### Spring Boot Admin
O monitoramento é parte importante de uma API, facilitando o acompanhamento e assim otimizando a resolução de eventual problema. 
Para esse projeto, foi adicionado e configurado o Spring Boot Admin, tendo dessa forma uma interface amigável para monitorar.

```bash
Run 'Sprint4AdminApplication.java'
```
Com ambas aplicações Java sendo executadas, acessar:

```bash
Endereço: http://localhost:8081/
# Vale ressaltar que este endereço só está com livre acesso por fins didáticos
```
---
### Contato e licença
Sem restrições ao uso, modificações e distribuição do código fonte.
Feito com ❤️ por [Leonardo Mafra](https://www.linkedin.com/in/leomafra/).
