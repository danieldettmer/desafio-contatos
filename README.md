# desafio-contatos

### Instruções

      1. Clone o repositório e rode "docker-compose up" na raiz do projeto;
      2. Após iniciar, os serviços estarão expostos nas portas 8080 (API) e 3306 (MySQL) do hospedeiro;

### Descrição

    Spring Boot foi utilizado como Framework para desenvolvimento. O sistema possui endpoints para 
    gerenciar Contatos, Grupos, Telefones e Categorias. A consulta de Contatos por filtro fornece a 
    possibilidade de se utilizar nome ou email, tendo o nome como prioridade. Após a construção das
    funcionalidades, um dump automatizado foi criado na inicialização do serviço. São excluídos os
    dados de todas as tabelas e preenchidos novamente com alguns dados aleatórios.