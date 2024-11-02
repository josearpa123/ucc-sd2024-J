# Usa una imagen base de Java
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el JAR de la aplicación al contenedor
COPY target/Java_prueba-1.0-SNAPSHOT.jar /app/

# Crea un directorio 'lib' en el contenedor y copia el controlador PostgreSQL
RUN mkdir lib
COPY lib/postgresql-42.2.24.jar /app/lib/

# Comando para ejecutar la aplicación Java
CMD ["java", "-cp", "Java_prueba-1.0-SNAPSHOT.jar:lib/postgresql-42.2.24.jar", "org.example.Main"]

