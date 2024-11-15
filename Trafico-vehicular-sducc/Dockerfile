# Usa una imagen base de Java
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia los archivos compilados al contenedor
COPY out/production/Trafico-vehicular-sducc /app

# Especifica el comando para ejecutar la aplicación
CMD ["java", "Main"]
