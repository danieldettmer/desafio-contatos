# desafio-contatos

### Desafio Conductor de Seleção 
Olá, queremos convidá-lo a participar de nosso desafio de seleção.  Pronto para participar? Seu trabalho será visto por nosso time e você receberá ao final um feedback sobre o que achamos do seu trabalho. Não é legal?

### Sobre a oportunidade 
A vaga é para Desenvolvedor Java, temos vagas com diversos níveis de senioridade e para cada um deles utilizaremos critérios específicos considerando esse aspecto, combinado? 
Se você for aprovado nesta etapa, será convidado para uma entrevista final com nosso time técnico.

### Desafio Técnico
  Desenvolver um sistema de gerenciamento de despesas, para manter controle entre gastos e receita:
  - Pré-requisitos:
    ```
    * Utilização do SGBD Oracle ou MySQL.
    * JDK 1.8+
    * Maven 3+
    * JUnit 4+
    * Framework Web a critério (Servlets, JSF, Spring MVC ou afins)
    * Criação de um DUMP com massa de dados.
    ```

  - O que esperamos como escopo:
    ```
    * Adicionar e Manter contato;
    * Adicionar/Alterar/Remover: dados do contato;
    * Consultar Contatos, por filtros de dados;
    * API Rest para cadastro de telefone ao contato;
    * Possibilidade de categorizar e manter contatos em Grupos (Escopo Bônus);
    ```
    
  - O que vamos avaliar:
    ```
    * Seu código; 
    * Organização;
    * Boas práticas;
    ```

### Instruções
      1. Faça o fork do desafio e crie uma branch 'desafio_contatos_nome_candidato';
      2. Desenvolva. Você terá 2 (dois) dias a partir da data do envio do desafio; 
      3. Após concluir seu trabalho faça um push; 
      4. Crie um arquivo de texto com a nomenclatura README.MD com a explicação de como devemos executar o 
        projeto e com uma descrição do que foi feito; 
      5. Solicite o Merge request para o repositório original e que a força esteja com você.
---
---
---
# ContactsAPI
---
### Config DB
---
##### application.properties
É preciso criar um banco com o nome agenda, e configurar o arquivo "application.properties" com os dados do usuario do banco, em seguida é preciso executar a aplicação, para que as tabelas seja criadas, e por fim fazer uma requisição GET "http://localhost:8080/api/base" para popular o banco com alguns registros.
```
#banco_local
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/agenda?serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username=root
#spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=upd
```
##### GET http://localhost:8080/api/base
##### Return void
```
HTTP/1.1 200 Ok
```
---
## Contatos
---
### List
```
Lista todos os Contatos com e sem telefone.
```
---
##### GET http://localhost:8080/api/contatos

##### Return

```
[
    {
        "id": 1,
        "nome": "xd asd",
        "categoria": null,
        "telefones": [
            {
                "id": 2,
                "numero": "963",
                "contato": 1
            }
        ]
    },
    {
        "id": 4,
        "nome": "xddd",
        "categoria": "aaaa",
        "telefones": []
    },
    {
        "id": 5,
        "nome": "xddd dsajkdoalks",
        "categoria": "bbbb",
        "telefones": []
    }
]
```
---
### Read
```
Lista um contato específico através do id
```
---
##### GET http://localhost:8080/api/contato/1
##### Return
```
{
    "id": 1,
    "nome": "xd asd",
    "telefones": [
        {
            "id": 2,
            "numero": "963",
            "contato": 1
        }
    ]
}
```
---
### List
```
Lista todos os Contatos através do nome.
```
---
##### GET http://localhost:8080/api/contatos/xd
##### Return
```
[
    {
        "id": 1,
        "nome": "xd asd",
        "telefones": [
            {
                "id": 2,
                "numero": "963",
                "contato": 1
            }
        ]
    },
    {
        "id": 4,
        "nome": "xddd",
        "telefones": []
    },
    {
        "id": 5,
        "nome": "xddd dsajkdoalks",
        "telefones": []
    }
]
```
---
### Delete
```
Apaga um contato pelo id
```
##### DELETE http://localhost:8080/api/contato/telefone/4
##### Return Void
```
HTTP/1.1 200 Ok
```
---
### Create
```
Cria um contato sem telefone.
```
##### POST http://localhost:8080/api/contato
##### Headers  
```
KEY                 VALUE
Content-Type        application/json
```
##### Body
```
{
    "nome": "xddd dsajkdoalks",
    "telefones":[]
}
```
##### Return
```
{
    "id": 5,
    "nome": "xddd dsajkdoalks",
    "telefones": []
}
```
---
### Create
```
Cria um contato com telefone. 
// Os campos id e contatos, devem possuir o mesmo valor, para referenciar o telefone ao contato.
```
##### POST http://localhost:8080/api/contato
##### Headers  
```
KEY                 VALUE
Content-Type        application/json
```
##### Body
```
{
  "id":6,
    "nome": "xd",
    "telefones":[
      {
        "numero":"963",
        "contato":6
      }
    ]
        
}
```
##### Return
```
{
    "id": 6,
    "nome": "xd",
    "telefones": [
        {
            "id": 7,
            "numero": "963",
            "contato": 6
        }
    ]
}
```
---
### Update
```
Atualiza um contato, com ou sem telefone
```
##### PUT http://localhost:8080/api/contato/
##### Headers  
```
KEY                 VALUE
Content-Type        application/json
```
##### Body
```
{
  "id": 1,
    "nome": "xd asd",
    "telefones":[]
}
```
##### Return
```
{
    "id": 1,
    "nome": "xd asd qwe",
    "telefones": []
}
```
---
### Update
```
Atualiza um contato, com ou sem telefone, caso nao exista o telefone é criado.
```
##### PUT http://localhost:8080/api/contato/
##### Headers  
```
KEY                 VALUE
Content-Type        application/json
```
##### Body
```
{
  "id": 4,
    "nome": "xd",
    "telefones":[
      {
        "numero":"8888",
        "contato":4
      }
    ]
}
```
##### Return
```
{
    "id": 4,
    "nome": "xd",
    "telefones": [
        {
            "id": 9,
            "numero": "8888",
            "contato": 4
        }
    ]
}
```
## Telefone
---

### Delete
```
Apaga um telefone pelo id
```
##### DELETE http://localhost:8080/api/contato/telefone/9
##### Return Void
```
HTTP/1.1 200 Ok
```
---
### Create
```
Cria um telefone. 
// Os campos id e contatos, devem possuir o mesmo valor, para referenciar o telefone ao contato.
```
##### POST http://localhost:8080/api/contato/telefone
##### Headers  
```
KEY                 VALUE
Content-Type        application/json
```
##### Body
```
{
  "id":1,
    "nome": "xd",
    "telefones":[
      {
        "numero":"96399900",
        "contato":1
      }
    ]
        
}
```
##### Return
```
{
    "id": 1,
    "nome": "xd",
    "telefones": [
        {
            "id": 14,
            "numero": "96399900",
            "contato": 1
        }
    ]
}
```
---
### Update
```
Atualiza telefone
```
##### PUT http://localhost:8080/api/contato/
##### Headers  
```
KEY                 VALUE
Content-Type        application/json
```
##### Body
```
{
  "id": 1,
    "nome": "xd",
    "telefones":[
      {
        "id":14,
        "numero":"4567123",
        "contato":1
      }
    ]
}
```
##### Return
```
{
    "id": 1,
    "nome": "xd",
    "telefones": [
        {
            "id": 14,
            "numero": "4567123",
            "contato": 1
        }
    ]
}
```
---
## Categoria
---
### List
```
Lista os contatos de uma categoria, o paramentro order aceita os valores "asc" ou "desc"
```
##### GET http://localhost:8080/api/contatos/categoria/bb?order=desc
##### Headers  
```
KEY                 VALUE
order               asc||desc
```

##### Return
```
[
    {
        "id": 4,
        "nome": "xd",
        "categoria": "bbbb",
        "telefones": [
            {
                "id": 9,
                "numero": "8888",
                "contato": 4
            }
        ]
    },
    {
        "id": 6,
        "nome": "xd",
        "categoria": "aabb",
        "telefones": [
            {
                "id": 7,
                "numero": "963",
                "contato": 6
            },
            {
                "id": 8,
                "numero": "963999",
   ```
---
## Grupo
---
### List
```
Lista os grupo de usuario
```
##### GET http://localhost:8080/api/grupos
##### Return
```
[
    {
        "id": 8,
        "nome": "teste qweqw",
        "admnistrador": null,
        "contatos": []
    },
    {
        "id": 9,
        "nome": "teste qweqw",
        "admnistrador": null,
        "contatos": [
            {
                "id": 4,
                "nome": "xdd",
                "categoria": null,
                "telefones": []
            }
        ]
    }
]
```
---
### Read
```
Lista os grupo de usuario
```
##### GET http://localhost:8080/api/grupo/8
##### Return
```
[
    {
        "id": 8,
        "nome": "teste qweqw",
        "admnistrador": null,
        "contatos": []
    }
]
```
---
### Create
```
Cria um grupo
```
##### POST http://localhost:8080/api/grupo
##### Headers  
```
KEY                 VALUE
Content-Type        application/json
```
##### Body
```
{
    "nome": "teste qweqw",
    "admnistrador": null
}
```
##### Return
```
{
    "id": 12,
    "nome": "teste qweqw",
    "admnistrador": null,
    "contatos": null
}
```
---
---
### Update
```
Atualiza um grupo e pode adicionar um usuario ao grupo, se o campo contatos for vazio só vai editar o grupo, se tiver valor adiciona o usuario ao grupo.
```
##### PUT http://localhost:8080/api/grupo
##### Headers  
```
KEY                 VALUE
Content-Type        application/json
```
##### Body
```
{
    "id": 12,
        "nome": "testeqewqwe",
        "admnistrador": null,
        "contatos": [
      {
        "id": 4,
        "nome": "xdd",
          "telefones":[]
      } 
        ]
}
```
##### Return
```
{
    "id": 12,
    "nome": "testeqewqwe",
    "admnistrador": null,
    "contatos": [
        {
            "id": 4,
            "nome": "xdd",
            "categoria": null,
            "telefones": []
        }
    ]
}
```
---
### Delete
```
Apaga um grupo pelo id
```
##### DELETE http://localhost:8080/api/grupo/2
##### Return Void
```
HTTP/1.1 200 Ok
```
---