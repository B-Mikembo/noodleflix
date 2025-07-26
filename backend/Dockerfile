# Dockerfile
FROM maven:3.9-openjdk-21-slim AS build
WORKDIR /app

# Copier les fichiers de configuration Maven
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .

# Télécharger les dépendances (optimise le cache Docker)
RUN mvn dependency:go-offline -B

# Copier le code source
COPY src ./src

# Build args pour recevoir les secrets
ARG SPRING_PROFILES_ACTIVE=dev
ARG TMDB_API_TOKEN
ARG TMDB_BASE_URL

# Variables d'environnement pour le build
ENV SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE}
ENV TMDB_API_TOKEN=${TMDB_API_TOKEN}
ENV TMDB_BASE_URL=${TMDB_BASE_URL}

# Build de l'application
RUN mvn clean package -DskipTests

# Image de runtime
FROM openjdk:21-jre-slim

# Arguments pour le runtime
ARG SPRING_PROFILES_ACTIVE=dev
ARG TMDB_API_TOKEN
ARG TMDB_BASE_URL

# Variables d'environnement pour l'application Spring Boot
ENV SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE}
ENV TMDB_API_TOKEN=${TMDB_API_TOKEN}
ENV TMDB_BASE_URL=${TMDB_BASE_URL}

# Créer un utilisateur non-root pour la sécurité
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

WORKDIR /app

# Copier le JAR depuis le stage de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Point d'entrée
ENTRYPOINT ["java", "-jar", "app.jar"]