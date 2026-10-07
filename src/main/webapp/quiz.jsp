<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Quiz Manga</title>
</head>
<body>

<h1>Quiz Manga</h1>

<!-- Affichage du feedback après soumission -->
<c:if test="${not empty feedback}">
  <p style="color: ${isCorrect ? 'green' : 'red'}; font-weight: bold;">
    <c:out value="${feedback}" />
  </p>
</c:if>

<!-- Formulaire du Quiz -->
<form action="${pageContext.request.contextPath}/quiz" method="post">
  <fieldset>
    <legend>Question : <c:out value="${question.text}" /></legend>

    <c:forEach var="option" items="${question.options}">
      <div>
        <label>
          <input type="radio"
                 name="answer"
                 value="<c:out value='${option}' />"
                 <c:if test="${option eq selectedAnswer}">checked</c:if>
                 required />
          <c:out value="${option}" />
        </label>
      </div>
    </c:forEach>
  </fieldset>

  <br>
  <button type="submit">Soumettre</button>
</form>

</body>
</html>