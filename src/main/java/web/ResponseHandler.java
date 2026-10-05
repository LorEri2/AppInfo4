package web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //1.Lecture des paramètres (transmis via l'URL en GET)
        String username = request.getParameter("username");
        String responseType = request.getParameter("responseType");

        //2.Sécurité
        if (username == null || username.trim().isEmpty() || responseType == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("<html><body><h3>Erreur : Paramètres manquants ou invalides.</h3></body></html>");
            return;
        }
        //3.Choix de la réponse
        String title = "";
        String message = "";

        switch (responseType) {
            case "welcome" -> {
                title = "Bienvenue, " + username + " !";
                message = "Nous sommes ravis de vous voir.";
            }
            case "encourage" -> {
                title = "Continuez comme ça, " + username + " !";
                message = "Vous êtes sur la bonne voie !";
            }
            case "remerciement" -> {
                title = "Merci, " + username + " !";
                message = "D'avoir utilisé notre service !";
            }
            default -> {
                title = "Erreur";
                message = "Type de réponse inconnu.";
            }
        }

        //4.Affichage de la réponse HTML
        out.println("<html>");
        out.println("<head><meta charset='UTF-8'><title>Réponse</title></head>");
        out.println("<body>");
        out.println("<h1>" + title + "</h1>");
        out.println("<p>" + message + "</p>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}