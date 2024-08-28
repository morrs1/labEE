# Используем официальный образ Maven для сборки приложения с JDK 21
FROM maven:3.9.0-openjdk-21 AS build

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файл pom.xml и загружаем зависимости
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Используем официальный образ OpenJDK 21 для запуска приложения
FROM openjdk:21-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем собранный .war файл из предыдущего этапа
COPY --from=build /app/target/your-app.war ./your-app.war

# Открываем порт, на котором будет работать приложение
EXPOSE 8080

# Команда для запуска приложения
CMD ["java", "-jar", "your-app.war"]