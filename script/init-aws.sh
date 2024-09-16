#!/bin/bash

# cria o tópico
awslocal sns create-topic --name notification-topic
# cria a fila
awslocal sqs create-queue --queue-name NOTIFICATION-DEMOFILAS-QUEUE
# inscreve o a fila ao tópico
awslocal --endpoint-url=http://localhost:4566 sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:notification-topic --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:NOTIFICATION-DEMOFILAS-QUEUE