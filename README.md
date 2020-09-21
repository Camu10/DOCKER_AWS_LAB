# DOCKER_AWS_LAB
Se realizó la implementación de una arquitectura la cual consiste en un balancador de carga en donde se uso el método de RoundRobin este balanceador realiza peticiones a cada uno de los tres nodos disponibles dependiendo del turno,los cuales se encargan de realizar la conección con la tercera parte de la arquitectura, una base de datos mongo que almacena todos lo mensajes que entran. Cada una de las partes de esta arquitectura se encuentran en un contenedor de Docker diferente.

## Pre-requisitos
* [MAVEN](https://maven.apache.org/) - Administrador de dependencias.
* [GIT](https://git-scm.com/) - Control de versiones.
Para estar seguro de las versiónes que posee de maven, git y de java ejecute los siguientes comandos:
```
mvn -version  
git --version  
java -version  
```
## Instalación 
Para descargar el proyecto desde GitHub ejecute la siguiente linea:
```
git clone https://github.com/Camu10/DOCKER_AWS_LAB.git
```

## Ejecutar
Dentro de los directorios DOCKER_AWS_LAB/APP-LB-RoundRobin y DOCKER_AWS_LAB/LogService ejecutamos el siguiente comando para compilar:
```
mvn package
```
Para ejecutar el proyecto de manera local, dentro del directorio DOCKER_AWS_LAB ejecutamos la siguiente linea desde la consola de comandos y desde un navegador buscamos `http://192.168.99.100:8000/` :
```
docker-compose up -d --scale web=3
```

## Pruebas
Ingresar los mensajes que quieren ser guardados.  
![](https://github.com/Camu10/DOCKER_AWS_LAB/blob/master/img/Prueba1.jpg)  
Mensajes guardados en la base de datos mongo.  
![](https://github.com/Camu10/DOCKER_AWS_LAB/blob/master/img/BaseDatos.jpg)

## Construido con
* [MAVEN](https://maven.apache.org/) - Administrador de dependencias.
* [GIT](https://git-scm.com/) - Control de versiones.
* [JUNIT](https://junit.org/junit5/) - Framework para realizar y automatizar pruebas.
* [SPARK](http://sparkjava.com/) - Framework para el desarrollo de aplicaciones web.
* JAVA - Lenguaje de programación.

## Autor
* **Carlos Murillo** - [Camu10](https://github.com/Camu10)

## Licencia
Este proyecto está bajo la Licencia GNU(General Public License) - mira el archivo [LICENSE](LICENSE) para detalles.
