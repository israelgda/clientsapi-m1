# API de Clients - CRUD Completo
Projeto de prática e conclusão do Módulo 1 - CRUD do Bootcamp Spring React. Webservice criado com Java, Springboot, em arquitetura REST.

## Sobre o projeto

### Objetivo
O projeto é um webservice Rest simples de CRUD completo de clientes. Os dados utilizados na entidade a ser administrada são: Nome, CPF, renda, data de aniversário, número de dependentes. Projeto criado com os conceitos compreendidos no primeiro módulo do Bootcamp. Criado com arquitetura de camadas Rest, padrão DTO na entidade principal, mapeamento realizado com JPA e seeding do Banco de testes H2 através do arquivo data.sql, incluso no projeto. 

### Funcinalidades
####  - Das cadastros dos clientes - 
* Cadastro e edição clientes;
* Endpoint centralizado para consulta de clientes por: id;
* Visualização de todos os clientes com paginação;

####  - Do seeding do banco - 
* O seeding é realizado através do arquivo "data.sql" localizado na pasta src/main/resources. Foi utilizado o banco H2 para realização dos testes, com auxílio do Postman nos testes das requests;

## Tecnologias utilizadas
#### - Framework - 
* Backend desenvolvido com Spring Framework;
* Banco em memória H2 para testes;

#### - Linguagens - 
* JAVA

