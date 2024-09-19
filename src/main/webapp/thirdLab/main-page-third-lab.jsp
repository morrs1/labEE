<%--
  Created by IntelliJ IDEA.
  User: grish
  Date: 19.09.2024
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Мультимедийная Библиотека</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        form {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<h1>Мультимедийная Библиотека - Аудио Файлы</h1>

<!-- Форма для фильтрации аудио файлов -->
<h2>Фильтр по жанру</h2>
<form action="filter" method="get">
    <input type="text" name="genre" placeholder="Введите жанр">
    <input type="submit" value="Фильтровать">
</form>

<!-- Таблица для отображения аудио файлов -->
<h2>Список Аудио Файлов</h2>
<table>
    <thead>
    <tr>
        <th>Название</th>
        <th>Исполнитель</th>
        <th>Жанр</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <!-- Здесь будет динамически генерироваться список аудио файлов -->
<%--    <tr>--%>
<%--        <td>Song Title 1</td>--%>
<%--        <td>Artist 1</td>--%>
<%--        <td>Genre 1</td>--%>
<%--        <td><a href="delete?id=1">Удалить</a></td>--%>
<%--    </tr>--%>
    <!-- Добавьте больше строк по мере необходимости -->
    </tbody>
</table>

<!-- Форма для добавления нового аудио файла -->
<h2>Добавить Новый Аудио Файл</h2>
<form action="addItem" method="post">
    <input type="text" name="title" placeholder="Название" required>
    <input type="text" name="artist" placeholder="Исполнитель" required>
    <input type="text" name="genre" placeholder="Жанр" required>
    <input type="submit" value="Добавить">
</form>

</body>
</html>

