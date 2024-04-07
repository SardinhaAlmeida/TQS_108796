# Use uma imagem base que tenha o Java e o Maven instalados
FROM maven:latest AS build

# Copie o pom.xml para o contêiner
COPY pom.xml .

# Baixe as dependências do Maven
RUN mvn dependency:go-offline -B

# Copie o código-fonte para o contêiner
COPY src src

# Compile o projeto
RUN mvn package -DskipTests

# Use uma imagem base que tenha o Java instalado
FROM openjdk:latest

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR construído no estágio anterior para o contêiner
COPY --from=build target/HW1-0.0.1-SNAPSHOT.jar .

# Exponha a porta em que o servidor do Spring Boot será executado
EXPOSE 8080

# Comando para iniciar o servidor do Spring Boot
CMD ["java", "-jar", "HW1-0.0.1-SNAPSHOT.jar"]
