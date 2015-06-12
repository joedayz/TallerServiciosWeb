# Servicios REST

## Requisitos

* JBoss Application Server 7.1.1.Final (Obtido em http://www.jboss.org/jbossas/downloads/)


## Como utilizar

* Inicialice el JBoss AS.
* Execute el comando mvn package jboss-as:deploy
* Observe los logs

## Diferencias entre con la versión (soa-04-jboss)

Se cuenta con un servicio de validación de CPF's. Para utilizar, basta inicializar la aplicación (conforme a lo descrito arriba) y apuntar a los siguientes URL's:

* http://localhost:8080/soa-05-0.0.1-SNAPSHOT/services/validador/cpf/12345678909?algoritmo=MODULO11 (debe retornar HTTP 200, o sea, una pagina en blanco)
* http://localhost:8080/soa-05-0.0.1-SNAPSHOT/services/validador/cpf/12345678909 (debe retornar HTTP 400, o sea, una Página de Error)
* http://localhost:8080/soa-05-0.0.1-SNAPSHOT/services/validador/cpf/53389399321 (HTTP 200)
* http://localhost:8080/soa-05-0.0.1-SNAPSHOT/services/validador/cpf/64573128530 (HTTP 200)
* http://localhost:8080/soa-05-0.0.1-SNAPSHOT/services/validador/cpf/53783947677 (HTTP 200)
* http://localhost:8080/soa-05-0.0.1-SNAPSHOT/services/validador/cpf/79780901671 (HTTP 200)
* http://localhost:8080/soa-05-0.0.1-SNAPSHOT/services/validador/cpf/75538117774 (HTTP 200) 
  
  

 
