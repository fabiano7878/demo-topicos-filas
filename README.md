# demo-topicos-filas
Projeto para prova de conceitos comunicação com SNS e SQS, via localstack, aws-sdk, awslocal, docker.
Testes foram locais com container criado no docker local.
A propósito da demo, é ser possivel disparar mensagens para o tópico e para fila, e conseguir visualiza-las no console 
pelo comando da awslocal de recuperar as mensagens, validando se a msg envia via payload do endpoint chegou ao destino,
na mensagem é apresentada somente o campo constnt, as demais informações não aparecem na mensagem.


#pré-requisitos
- python e pip e awslocal
- instalar localstack
- Estou usando o docker-desktop com o extensão do Localstack, para facilitar
- recomendo criar usuário na Localstack, para conhecer a ferramenta



#Docker-compose
Neste exemplo foi possível praticar comandos docker, criando um container da forma que eu precisei.
Configurei um docker-compose para facilitar nas informações, porém foi necessário navegar dentro da instância do docker
e criar manualmente o topico e a fila, assim como realizar os testes de envio de mensagem a fila e leitura da mesma.


- documentação para comandos de manipulação da sns
  https://docs.localstack.cloud/user-guide/aws/sqs/
- documentação para os comandos do sqs
  https://docs.localstack.cloud/user-guide/aws/sns/

**com base no docker-compose criado para este projeto o comando abaixo sobe a instância,
"docker-compose up --build -d" pelo terminal e no diretorio do arquivo executamos o comando.

navegar dentro do bash do container e executar os comandos para criar o tópico, fila e vincular a fila no tópico.
"docker container exec -it localstack-demo_topicos_filas bash"

# tópico
notification-topic
# fila
NOTIFICATION-DEMOFILAS-QUEUE


#Para criar o projeto, usei o site do Spring Starter, aplicação esta usando gradle
https://start.spring.io/

As dependência da aws são as atuais desta época.

