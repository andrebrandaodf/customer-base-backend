# Cadastro de clientes - GS3!

* Java 8
* [Spring Boot 2.3.4.RELEASE](https://start.spring.io/)
* Mysql Driver
* [IDE SpringTools](https://spring.io/tools)
* Spring Web
* Spring Data JPA
* Bean Validation
* Maven 4.0.0

# Add-ons
Este projeto foi criado para funcionar junto ao frontend 
[desafio-gs3-frontend](https://github.com/andrebrandaodf/desafio-gs3-frontend).
Informações sobre como rodar o projeto frontend se encontram [README.md](https://github.com/andrebrandaodf/desafio-gs3-frontend#readme). 

# Executando projeto

1. Entrar na pasta do projeto `desafio-gs3` 

	`cd desafio-gs3`
 
2. Executar o servidor spring 

	`./mvnw spring-boot:run`

# Métodos CRUD Client

** Registrando Usuário **

POST http://localhost:8080/register

```
{

	"username":"admin",
	"password":"123456",
	"role":"ROLE_ADMIN"
}
```
** Autenticando Usuário **

POST http://localhost:8080/authenticate

```
{

	"username":"admin",
	"password":"123456",
	
}
```

**Adicionando Client**

POST http://localhost:8080/client 



```
{
    "name": "Antônio José",
    "cpf": "232.364.928-05",
    "address": {
        "id": 8,
        "cep": "72.310-715",
        "logradouro": "Quadra 504 conjunto 09",
        "bairro": "Samambaia sul",
        "localidade": "Brasília",
        "uf": "DF",
        "complemento": "casa 5",
        "ddd": 61,
        "gia": "",
        "ibge": null,
        "siafi": null
    },
    "phone": "61 98502-8544",
    "email": "antonio@gmail.com"
}
```

**Para buscar cliente por id**

GET http://localhost:8080/client/{id}


**Para atualizar um cliente**

PUT http://localhost:8080/client/{id}

```
{
    "id": 1,
    "name": "Antônio José",
    "cpf": "232.364.928-05",
    "address": {
        "id": 8,
        "cep": "72.310-715",
        "logradouro": "Quadra 504 conjunto 09",
        "bairro": "Samambaia sul",
        "localidade": "Brasília",
        "uf": "DF",
        "complemento": "casa 5",
        "ddd": 61,
        "gia": "",
        "ibge": null,
        "siafi": null
    },
    "phone": "61 98502-8544",
    "email": "antonio@gmail.com"
}
```

**Para deletar um cliente**

DELETE http://localhost:8080/delete/{id}
