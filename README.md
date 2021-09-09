
<h3 align="center">
  BUDGET-API
</h3>

<blockquote align="center">“Não espere resultados brilhantes se suas metas não forem claras”!</blockquote>

<p align="center">
  <img alt="License" src="https://img.shields.io/badge/license-MIT-%2304D361">
</p>

<p align="center">
  <a href="#memo-licença">Licença</a>
</p>

## :rocket: Sobre a API
## A proposta do app é criar, calcular e armazenar orçamentos de serviços.

Um orçamento é composto por um ou mais serviços e deve não estar associado a um cliente. O valor total do orçamento é a soma dos valores dos serviços que o compõe.

O serviço deve possuir um nome, uma unidade padrão e um valor por unidade padrão, ou seja o valor unitário. (Ex: Serviço { Nome: pintura, Unidade: m², Valor_Unitário: 100}). Ao cadastrar um serviço deve ser possível selecionar unidade padrão que o representa, além de atribuir um nome, uma descrição (opcional) e o valor unitário, que é o valor de uma unidade da unidade padrão que o representa.

Ao criar um orçamento é deve ser possível adicionar serviços a ele. Para cada serviço adicionado, deve ser possível informar a quantidade de unidades - da unidade padrão do serviço - que serão necessárias à execução daquele serviço. O valor total de determinado serviço naquele orçamento deve ser determinado pela multiplicação da quantidade de unidades (das unidades padrão) daquele serviço no orçamento pelo valor da unidade padrão. Por exemplo, caso a unidade padrão seja m², e 1m² custe R$100,00, então um serviço em uma área de 10m² custaria R$1000,00. O valor total do orçamento deve ser atualizado a cada serviço adicionado a ele. Além disso um orçamento deve possuir status (criado, aprovado, rejeitado);

# :hammer:  Backend

- Java 1.8
- SpringBoot
- Spring Data
- Spring Security
- Spring Security - OAuth
- Spring Security - JWT
- Banco de dados MYSQL
- FlywayDB
- SWAGGER
- DOCKER

## :hammer: Tecnologias (Frontend)

EM CONSTRUÇÃO
 
## :key: Como rodar esse projeto.

Para executar este sistema, você precisará de  Java 1.8,  instalado em seu computador;

### :sheep: Clonando o repositório.
```
# Clone este repositório
$ git clone git@github.com:LuizSerra/budgets-api.git
```
### :computer: Rodando a aplicação - Backend

Antes de iniciar, lembre-se de ter uma configuração de banco de dados ativa. Verifique o arquivo application.properties e altere as informações para o banco criado em seu ambiente local. Nesta aplicação essas configurações são as seguintes:
```
spring.jpa.database=MYSQL
spring.jpa.show-sql=true
spring.datasource.url=jdbc:mysql://localhost:3306/budget_bd?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=net0326
```

**Opção 1**
No terminal:
$ Execute o comando "mvn clean package" na raiz do projeto.
$ Vá até a pasta target e execute o comando java -jar java -jar -DSpring.profiles.active=prod budget-api.jar


**Opção 2**
$ Importe o projeto Budgests-api na IDE de sua preferência
$Execute o maven a fim de atualizar as dependências
$ Rode a Aplicação

O servidor será executado em http://localhost:8080

 O mapeamento objeto-relacional foi feito utilizando Spring Data JPA e a implementação é Hibernate.

### Funcionalidades da aplicação

Toda a documentação referente aos endpoints foi realizada utilizando SWAGGER e pode ser encontrada no endereço http://localhost:8080/swagger-ui.html . O Endereço estará acessível após subir a aplicação. Inclusive é possível testar o endpoints através dessa interface gráfica.

#### Segurança

A Segurança da API REST é feita utilizando Spring Security.
OAUTH e JWT -> Para se autenticar na Aplicação é preciso realizar um request na rota localhost:8080/auth com um usuário (email) e senha válidos, conforme cadastrados no banco de dados. um deles é tony.stark@shield.com com a senha 123456.
Para acessara cada uma das demais rotas da aplicação é necessário informar um token válido, que pode ser obtido como resposta da requisição para /auth;
 Esse token deve ser enviado em cada requisição em um Header Authorization.

### :computer: Rodando a aplicação - Frontend

Em construção

## :computer: Quer contribuir com o Projeto? Saiba como:

-   Faça um  **fork**  do projeto;
-   Crie uma nova branch com as suas alterações:  `git checkout -b my-feature`
-   Salve as alterações e crie uma mensagem de commit contando o que você fez:`git commit -m "feature: My new feature"`
-   Envie as suas alterações:  `git push origin my-feature`

> Caso tenha alguma dúvida confira este [guia de como contribuir no GitHub](https://github.com/firstcontributions/first-contributions)


## :memo: Licença

Esse projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

Feito com dedicação por Luiz Serra 👋🏽 [Entre em contato](https://www.linkedin.com/in/luizserra)!
