![Image](https://github.com/user-attachments/assets/37f07935-532c-478c-bc37-970b05d42d8a)
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

## Localmente no PC
Com o mesmo instalado e configurado, após uma execução dos tests basta acessar a raiz do projeto no terminal e rodar o comando:

```
allure serve allure-results
```

O servidor do allure será levantado, a pasta allure-results ser gerada e o relatório será aberto automaticamente como no exemplo abaixo.

## Usando o Github Actions

Para visualizar:
Vá até a aba Actions no seu repositório.

Clique na execução do workflow.

Na seção Artifacts, baixe o allure-results.

<img width="1516" height="679" alt="Image" src="https://github.com/user-attachments/assets/68536b08-d4fc-4d5e-aa94-044f8f783922" />

Realize a extração do allure-results.zip

Acesse o local pasta extraida e rode o comando

```
allure serve allure-results
```

<img width="1252" height="659" alt="Image" src="https://github.com/user-attachments/assets/2810fe0e-066e-4d59-bd79-846e091aea58" />



