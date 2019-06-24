# desafio-contatos

### Solução
  Foi utilizado para implementação:
    - Spring MVC
    - Oracle Database XE 11G

### Abordagem
  Foi utilizado o padrão JPA e a solução foi dividida em 3 partes:
    - Entidades
    - Repositórios
    - Controladores

### Características
  O projeto é composto de 5 APIs, onde uma para cada entidade: Contato (Gerenciar usuários), Telefone (CRUD dos telefones dos contatos), GrupoInfo (Gerenciamento de grupos), Grupos (Gerenciamento das relações de grupos com os usuários), Caixa (Gerenciamento de fluxo). 

  O DUMP com massa de dados está incluído na pasta resources/static em formato de PLSQL. Caso queira, pode executar os testes e essa massa de dados será incluída no banco, detalhe que no final da execução dos testes, os dados são removidos. Foram adicionadas restrições entre as tabelas para garantir consistência dos dados. Ex: Ao remover um contato, os dados de fluxo de caixa, grupos e telefones associados são removidos juntamente.

### Endpoints  
  O projeto seguiu o padrão REST para desenvolvimento dos endpoints tendo como principais endpoints: /contato, /grupo-info, /grupos, /telefone e /caixa. Caso haja curiosidade em testar, dentro desses endpoints existem outros como por exemplo /contato/find-by-param em que o usuário pode passar informações que serão utilizadas durante a busca. 

### Execução
  Recomenda-se utilizar o Intellij para execução do projeto.

### Troubleshooting
  Para o projeto foi utilizado o driver Oracle JDBC 6 compatível com JDK 8. Caso ocorra algum problema durante o build execução do projeto por falta desse driver, basta corrigir/adicionar o arquivo .jar localizado na pasta lib/ do projeto no classpath. Esse problema pode ocorrer durante a resolução de dependências do Maven caso ele não o encontre no repositório central.