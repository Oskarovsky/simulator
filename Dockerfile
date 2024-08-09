# Użyj obrazu JDK jako podstawy
FROM openjdk:17-jdk-slim

# Ustaw katalog roboczy wewnątrz kontenera
WORKDIR /app

# Skopiuj plik JAR do kontenera
COPY build/libs/simulator-all.jar app.jar

# Ustaw domyślny port aplikacji (jeśli używasz niestandardowego portu, np. 8081)
EXPOSE 8081

# Uruchom aplikację w tle
ENTRYPOINT ["java", "-jar", "app.jar"]