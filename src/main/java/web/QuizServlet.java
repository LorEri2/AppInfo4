package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Question;

import java.io.IOException;
import java.util.List;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {

    private Question defaultQuestion;

    @Override
    public void init() {
        defaultQuestion = new Question(
                "Qui est le créateur de Naruto ?",
                List.of("Eiichiro Oda", "Masashi Kishimoto", "Akira Toriyama", "Tite Kubo"),
                "Masashi Kishimoto"
        );
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("question", defaultQuestion);
        request.getRequestDispatcher("/quiz.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String selectedAnswer = request.getParameter("answer");

        String feedback;
        boolean isCorrect = false;

        if (selectedAnswer == null || selectedAnswer.isBlank()) {
            feedback = "Veuillez sélectionner une réponse avant de valider.";
        } else if (selectedAnswer.equals(defaultQuestion.getCorrectAnswer())) {
            feedback = "Bonne réponse ! C'est bien " + defaultQuestion.getCorrectAnswer() + ".";
            isCorrect = true;
        } else {
            feedback = "Mauvaise réponse ! La bonne réponse était : " + defaultQuestion.getCorrectAnswer() + ".";
        }

        request.setAttribute("question", defaultQuestion);
        request.setAttribute("feedback", feedback);
        request.setAttribute("isCorrect", isCorrect);
        request.setAttribute("selectedAnswer", selectedAnswer);

        request.getRequestDispatcher("/quiz.jsp").forward(request, response);
    }
}