![java_rest](https://gitlab.com/DaniloAlcantara/Java_RestAssured/-/raw/master/java_rest.jpg)
# Teste Tecnico de Automação de API
## Este Projeto tem o intuito de implementar tests  automatizados para uma API de Raças de Cães e suas imagens.


# Projeto Construído com:

Java 8 - https://www.oracle.com/br/java/technologies/javase/javase8u211-later-archive-downloads.html

Maven - https://maven.apache.org/download.cgi

Rest-Assured - https://rest-assured.io/

TestNG - https://testng.org/doc/

Allure - https://docs.qameta.io/allure/

IntelliJ Idea - https://www.jetbrains.com/pt-br/idea/


## Clonar o projeto

Abra a pasta em que deseja clonar o projeto execute o comando com git bash ou algum outro  terminal que possua git integrado:

```
git clone <url http ou ssh do projeto git>
```


## Executando o projeto

Acesse a  pasta do projeto no terminal execute os comandos abaixo para limpar, compilar e executar todos os tests. 
```sh
mvn clean - Limpa execuções anteriores e pasta target
mvn compile - criar a estrutura da pasta target
mvn test -  executa os tests
```


## Geração de relatório de execução

Na geração de relatório foi utilizado o framework allure report, para geração do mesmo é necessário instalar seu commandline basta seguir os passo do link a seguir :  

https://allurereport.org/docs/install/
(adicione a pasta bin ao path do sistema)

Com o mesmo instalado e configurado, após uma execução dos tests basta acessar a raiz do projeto no terminal e rodar o comando:

```
allure serve allure-results
```

O servidor do allure será levantado, a pasta allure-results ser gerada e o relatório será aberto automaticamente como no exemplo abaixo.

![relatorio_example](https://gitlab.com/DaniloAlcantara/Java_RestAssured/-/raw/master/relatorio%20example.png)



