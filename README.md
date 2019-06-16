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
      
# API Contatos

### Instruções
	Para o correto funcionamento da aplicação, realize os seguintes passos:
	
	  1. No MySQL, crie o banco de dados "contatos_apirest" e, em seguida, execute o script "contatos_apirest.sql" para que sejam criadas e populadas as tabelas com dados iniciais;
      2. Verificar usuário e senha do banco de dados no arquivo "src/main/resources/application.properties" e alterar, caso necessário;
      3. Importe o projeto para o Eclipse, através do caminho File->Import->Existing Maven Projects e aguarde o Maven baixar as dependências;
      4. Abra o arquivo "ApiRestApplication.java" que está no package "com.contatos.apirest" em "src/main/java" e execute como JavaApplication (por padrão, aplicação irá rodar na porta 8080, caso já esteja ocupada, adicionar uma nova linha no arquivo "application.properties" com "server.port = xxxx", substituindo xxxx pelo número da porta disponível); 
      5. Acesse a documentação da api através da url: http://localhost:xxxx/swagger-ui.html (substituindo xxxx pelo número da porta na qual a aplicação está rodando).
      
### O que foi feito?
	Uma API de Contatos, utilizando o Framework Spring Boot e Banco de dados MySQL. O Maven foi utilizado como gerenciador de dependências e o Swagger para documentação da API.
