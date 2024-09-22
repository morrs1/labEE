<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.labee.thirdLab.model.core.TicTacToeGame " %>

<%
  // Получаем текущее состояние игры из сессии
  TicTacToeGame game = (TicTacToeGame) session.getAttribute("game");

  // Если игра не начата, создаем новую игру
  if (game == null) {
    game = new TicTacToeGame();
    session.setAttribute("game", game);
  }

  // Обрабатываем ход пользователя, если он сделал ход
  String rowParam = request.getParameter("row");
  String colParam = request.getParameter("col");
  if (rowParam != null && colParam != null) {
    int row = Integer.parseInt(rowParam);
    int col = Integer.parseInt(colParam);
    game.makePlayerMove(row, col);
  }

  // Проверяем, завершена ли игра
  game.checkWinner('X');
  game.checkWinner('O');
  boolean gameOver = game.isGameOver();
  System.out.println(game.isGameOver());
  String message = "";
  if (gameOver) {
    if (game.isPlayerWinner()) {
      message = "Вы победили!";
    } else if (game.isComputerWinner()) {
      message = "Компьютер победил!";
    } else {
      message = "Ничья!";
    }
  }
%>

<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Игра в крестики-нолики</title>
  <style>
    table {
      border-collapse: collapse;
      margin: 20px auto;
    }
    td {
      width: 50px;
      height: 50px;
      border: 1px solid #000;
      text-align: center;
      font-size: 24px;
    }
    input[type="submit"] {
      margin-top: 10px;
    }
  </style>
</head>
<body>
<h1>Игра в крестики-нолики</h1>
<% if (!gameOver) { %>
<form action="tictactoe" method="get">
  <label for="row">Строка:</label>
  <input type="number" id="row" name="row" min="0" max="2" required>
  <label for="col">Столбец:</label>
  <input type="number" id="col" name="col" min="0" max="2" required>
  <input type="submit" value="Сделать ход">
</form>
<% } %>
<table>
  <% for (int i = 0; i < 3; i++) { %>
  <tr>
    <% for (int j = 0; j < 3; j++) { %>
    <td><%= game.getBoard()[i][j] %></td>
    <% } %>
  </tr>
  <% } %>
</table>
<% if (gameOver) { %>
<p><%= message %></p>
<% } %>
</body>
</html>

