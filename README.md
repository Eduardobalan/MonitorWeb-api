
# Índice de conteúdo

* [Introdução MonitorWeb](#introdução "Introdução sobre o sistema MonitorWeb")
  * [Introdução MonitorWeb-Cli](#monitorweb-cli "Introdução sobre o sistema MonitorWeb-Cli")
  * [Introdução MonitorWeb-Api](#monitorweb-api "Introdução sobre o sistema MonitorWeb-Api")
* [Guia de instalação](#guia-de-instalação "Guia de instalação")
  * [Banco de dados](#banco-de-dados "Banco de dados")
   * [Aplicação](#aplicação "Aplicação")
   * [Teste Unitário](#teste-unitário "Teste Unitário")
   * [Docker](#docker "Docker")
   * [SonarQube](#sonarqube "SonarQube")
* [Notas de release](#notas-de-release "Notas de release do projeto")
* [Issues](#issues "Issues do projeto")


## Introdução

Sistema para monitoramento de servidores Linux, utilizando a arquitetura cliente-servidor. O sistema consiste em duas aplicações, um web service desenvolvido em Java para o qual foi dado o nome de MonitorWeb-Api(https://github.com/Eduardobalan/monitorWeb-api), e outra aplicação em C++(https://github.com/Eduardobalan/monitorWeb-Cli), executada nos servidores Linux como cliente, tendo o nome de MonitorWeb-Cli.

### MonitorWeb-Cli

O MonitorWeb-Cli realiza a leitura dos dados de seu hospedeiro, tais como CPU (Central Processing Unit), memória, banco de dados e swap. Esse procedimento é realizado de acordo com a configuração de tempo desejada pelo usuário. Para cada leitura realizada, o sistema realiza o envio dos dados para o MonitorWeb-Api. Ele também pode realizar rotinas de backups (cópia de segurança) e vaccum (processo de limpeza no banco de dados) do banco de dados PostgreSQL, tanto no hospedeiro quanto em outro computador a qual tenha acesso pela rede. Após efetuar esses procedimentos, o MonitorWeb-Cli envia mensagens para o MonitorWeb-Api que por sua vez armazena essas informações.

### MonitorWeb-Api

Um MonitorWeb-Api é responsável por receber os dados de diversos MonitorWeb-Cli e realizar a persistência no banco de dados. Também é responsável por armazenar as configurações dos clientes, tais como o intervalo de envio dos dados de monitoramento e as informações dos procedimentos de backup. Essas configurações são capturadas periodicamente conforme as configurações do usuário. A API também pode ser utilizada para disponibilizar os dados dos servidores para aplicações de front-end (aplicações responsáveis por coletar a entrada do usuário e processá-la para adequá-la a uma especificação em que o back-end possa utilizar).


## Guia de instalação

### Banco de dados

- Dependencias para esse passo: `PostgreSQL` e `pgAdmin` instalados.

No pgAdmin crie um banco de dados com nome de `monitorweb` e solicite um restore do banco de dados localizado no diretorio do projeto `/DB/Banco de dados PostgreSQL.backup` .

### Aplicação
- Dependencias para esse passo: `Maven`.

Com terminal de seu SO navegue até o mesmo diretorio do arquivo pom.xml e execute os seguintes comandos:

      `mvn clean install`


### Teste Unitário
- Dependencias para esse passo: `Maven`.

Com terminal de seu SO navegue até o mesmo diretorio do arquivo pom.xml e execute os seguintes comandos:

      `mvn test`

### Docker
- Dependencias para esse passo: possuir o `docker` instalado.

Com terminal de seu SO navegue até o mesmo diretorio do arquivo `docker-compose.yml` e execute o comandos:

      `docker-compose up -d`

Duas novas aplicações estarão a dispoição no seu navegador atraves do indreço:

- localhost:9001 ou 127.0.0.1:90001 -> portainer (Gerenciador do docker)
- localhost:9000 ou 127.0.0.1:90000 -> SonarQube (Visualizador dos resultados de testes unitários)


### SonarQube
- Dependencias para esse passo: `Maven` ter execuado o passo do `docker`.

Com terminal de seu SO navegue até o mesmo diretorio do arquivo pom.xml e execute os seguintes comandos:

      `mvn sonar:sonar`

Acesse a navegardor pela endereço 127.0.0.1:9000 ou localhost:9000 para visualizar as informações do sonar.

-----

## Notas de release

Para visualizar as notas de release acesse o _link_ abaixo:

[Notas de release](CHANGELOG.md)

-----

## Issues

Veja os issues do projeto: [aqui](../../issues)
