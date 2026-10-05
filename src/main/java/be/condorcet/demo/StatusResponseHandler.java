package be.condorcet.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StatusResponseHandler", value = "/StatusResponseHandler")
public class StatusResponseHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("userId");

        if (userId == null || userId.isEmpty())
        {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("<h1>Code de statut : 400 Bad Request</h1>");
            out.println("<p>Identifiant d'utilisateur requis.</p>");

        }
        else
        {
            int id = Integer.parseInt(userId);
            if (id > 0) {
                response.setStatus(HttpServletResponse.SC_OK);
                out.println("<h1>Code de statut : 200 OK</h1>");
                out.println("<p>Message : Identifiant valide : "+ userId +"</p>");

            }
            else
            {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.println("<h1>Code de statut : 404 Not Found</h1>");
                out.println("<p>Message : Identifiant d'utilisateur introuvable.</p>");
            }
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
