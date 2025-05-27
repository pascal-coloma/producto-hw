# Stage 1: Build
FROM openjdk:19-jdk AS build
WORKDIR /app

COPY pom.xml .
COPY src src
COPY mvnw .
COPY .mvn .mvn

RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:19-jdk-slim

# Crear directorio de trabajo
WORKDIR /app

# Copiar el JAR
COPY target/productos-0.0.1-SNAPSHOT.jar app.jar

# Copiar el archivo de propiedades y la carpeta wallet
COPY env.properties .
COPY wallet/ ./wallet/

# Exponer el puerto
EXPOSE 8082

# Ejecutar la aplicación con las propiedades externas
ENTRYPOINT ["java", "-Dspring.config.import=file:env.properties", "-jar", "app.jar"]
