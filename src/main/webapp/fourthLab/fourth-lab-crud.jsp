<%--
  Created by IntelliJ IDEA.
  User: grish
  Date: 19.09.2024
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.labee.fourthLab.database.dao.BaseDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.example.labee.fourthLab.database.entity.Displayable" %>
<%@ page import="com.example.labee.fourthLab.model.core.DAOFactory" %>
<%
    String typeOfTable = request.getParameter("typeOfTable");
    BaseDAO<Displayable> dao = DAOFactory.getDAO(typeOfTable);
    List<Displayable> itemsOfTable;

    try {
        itemsOfTable = dao.readAll();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRUD</title>
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

<h1>CRUD - <%=typeOfTable%>
</h1>


<!-- Таблица для отображения аудио файлов -->
<h2>Список</h2>
<table>
    <thead>
    <tr>
        <%
            // Получаем заголовки из первого элемента списка
            if (!itemsOfTable.isEmpty()) {
                Map<String, String> firstItemData = itemsOfTable.get(0).getDisplayInfo();
                for (String header : firstItemData.keySet()) {
        %>
        <th><%= header %></th>
        <%
                }
            }
        %>
    </tr>
    <tbody>
    <%
        for (Displayable item : itemsOfTable) {
            Map<String, String> data = item.getDisplayInfo();
    %>
    <tr>
        <%
            for (String key : data.keySet()) {
        %>
        <td><%= data.get(key) != null ? data.get(key) : "" %>
        </td>
        <%
            }
        %>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<!-- Форма для добавления нового аудио файла -->
<h2>Добавить новую запись</h2>
<form action="add" method="GET">
    <%
        // Получаем заголовки из первого элемента списка
        if (!itemsOfTable.isEmpty()) {
            Map<String, String> firstItemData = itemsOfTable.get(0).getDisplayInfo();
            for (String header : firstItemData.keySet()) {
    %>
    <input type="text" name=<%=header%> placeholder=<%=header%> required>
    <%
            }
        }
    %>
    <input type="submit" value="Добавить">
</form>

</body>
</html>
