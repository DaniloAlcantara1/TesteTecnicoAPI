
# Teste Técnico de Automação de API
![Image](https://github.com/user-attachments/assets/37f07935-532c-478c-bc37-970b05d42d8a)

## Este Projeto tem como intuito a implementação de  testes automatizados para uma API de Raças de Cães e suas imagens.
![Image](https://github.com/user-attachments/assets/5da90a88-f422-407b-839a-d7e8412eff8b)

# Projeto Construído com:

<img width="2357" height="550" alt="Image" src="https://github.com/user-attachments/assets/73fa43f6-b0b8-4d08-8a66-8aba5c56c5de" />

Java 8 - https://www.oracle.com/br/java/technologies/javase/javase8u211-later-archive-downloads.html

Maven - https://maven.apache.org/download.cgi

Rest-Assured - https://rest-assured.io/

TestNG - https://testng.org/doc/

Allure - https://docs.qameta.io/allure/

IntelliJ Idea - https://www.jetbrains.com/pt-br/idea/

# Configurar o Ambiente Java:

# No Windows: 

## 1. Instalação do Java:
Download: Acesse o site oficial do Java (Oracle) e baixe a versão adequada do JDK ou JRE para o seu sistema (32 ou 64 bits). 

Instalação: Execute o arquivo baixado e siga as instruções do instalador. Se você precisar apenas executar aplicativos Java, o JRE é suficiente. Se você for desenvolver em Java, o JDK é recomendado. 

Local de instalação: Anote o local de instalação do Java, pois você precisará dele para configurar as variáveis de ambiente. Geralmente, a instalação padrão é em "C:\Program Files\Java\jdk-versão" para o JDK ou "C:\Program Files\Java\jre-versão" para o JRE. 

## 2. Configuração das variáveis de ambiente:

## JAVA_HOME:
Abra o Painel de Controle > Sistema e Segurança > Sistema > Configurações avançadas do sistema. 
Clique em "Variáveis de Ambiente". 
Em "Variáveis do sistema", clique em "Novo". 
Adicione uma nova variável chamada JAVA_HOME e defina o valor como o caminho da pasta "jdk" ou "jre" da instalação do Java. 

## PATH:
Edite a variável PATH nas variáveis do sistema. 
Adicione o caminho C:\Program Files\Java\jdk-versão\bin (ou C:\Program Files\Java\jre-versão\bin) ao final da variável PATH. 

## Testando a instalação:
Abra um novo prompt de comando (cmd). 
Digite java -version e verifique se a versão do Java instalada é exibida corretamente. Se sim a configuração foi bem sucedida

# No Linux

## Instalação via Gerenciador de Pacotes (ex: Ubuntu/Debian):

Atualize o índice de pacotes:
digite no terminal:

```
    sudo apt update

```

Instale o pacote Java desejado:
Para instalar o OpenJDK (versão padrão):

digite no terminal:

```
    sudo apt install default-jdk
```

Para instalar o JRE (Java Runtime Environment): 

digite no terminal:

```
        sudo apt install default-jre
```

Configure as variáveis de ambiente:
Edite o arquivo .bashrc ou .zshrc (dependendo do seu shell): 

digite no terminal:

```

        nano ~/.bashrc
```

Adicione as seguintes linhas (ajuste o caminho conforme a instalação):

Altere no Arquivo:

```
export JAVA_HOME=/opt/java
export PATH=$JAVA_HOME/bin:$PATH

```

Salve e aplique as alterações.
digite no terminal:
```
        source ~/.bashrc
```

Verifique a instalação:
digite no terminal:

```
    java -version
```

Este comando exibirá a versão do Java instalada se a versão for exibida tudo foi instalado corretamente 

# Maven

## 1. Baixe o Maven:
Acesse o site oficial do Apache Maven ([Link: Apache Maven https://maven.apache.org/download.cgi]) e baixe a versão binária mais recente. 

## 2. Descompacte o arquivo:
Localize o arquivo baixado e extraia-o para um diretório de sua escolha, por exemplo, C:\apache-maven ou /opt/maven. 

## 3. Configure as variáveis de ambiente:

## Windows:
Adicione a variável de ambiente MAVEN_HOME apontando para o diretório onde o Maven foi extraído, por exemplo, C:\apache-maven. 
Adicione o diretório bin do Maven ao PATH do sistema, por exemplo, C:\apache-maven\bin. 

## Linux/macOS:
Adicione a variável de ambiente MAVEN_HOME apontando para o diretório onde o Maven foi extraído, por exemplo, /opt/maven. 
Adicione o diretório bin do Maven ao PATH do sistema, por exemplo, /opt/maven/bin. 

## 4. Verifique a instalação:
Abra um novo terminal e execute o comando mvn -v. Uma saída detalhada com a versão do Maven e do Java instalados deve ser exibida, indicando que a instalação foi bem-sucedida. 

# Clonar o projeto

Abra a pasta em que deseja clonar o projeto execute o comando com git bash ou algum outro  terminal que possua git integrado:

```
git clone <url http ou ssh do projeto git>
```


# Executando o projeto

Acesse a  pasta do projeto no terminal execute os comandos abaixo para limpar, compilar e executar todos os tests. 
```sh
mvn clean - Limpa execuções anteriores e pasta target
mvn compile - criar a estrutura da pasta target
mvn test -  executa os tests
```


# Geração de relatório de execução 📃

Na geração de relatório foi utilizado o framework allure report, para geração do mesmo é necessário instalar seu commandline basta seguir os passo do link a seguir :  

https://allurereport.org/docs/install/
(adicione a pasta bin ao path do sistema)

## Localmente no PC 💻
Com o mesmo instalado e configurado, após uma execução dos tests basta acessar a raiz do projeto no terminal e rodar o comando:

```
allure serve allure-results
```

O servidor do allure será levantado, a pasta allure-results ser gerada e o relatório será aberto automaticamente como no exemplo abaixo.

## Usando o Github Actions 🚀

Para visualizar:
Vá até a aba Actions no seu repositório.

Clique na execução do workflow.

Na seção Artifacts, baixe o allure-results.

<img width="1516" height="679" alt="Image" src="https://github.com/user-attachments/assets/68536b08-d4fc-4d5e-aa94-044f8f783922" />

Realize a extração do allure-results.zip

Acesse o local onde a pasta foi extraida e rode o comando

```
allure serve allure-results
```

<img width="1252" height="659" alt="Image" src="https://github.com/user-attachments/assets/2810fe0e-066e-4d59-bd79-846e091aea58" />



