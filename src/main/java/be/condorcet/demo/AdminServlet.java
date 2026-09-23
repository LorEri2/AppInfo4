package be.condorcet.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminServlet", value = "/admin/stats")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();
        Integer compteur = (Integer) context.getAttribute("visitCount");

        //Si personne n'a visite la page alors = 0, sinon on affiche le compteur
        if(compteur==null)
            compteur=0;

        out.println("<html><body>");
        out.println("<h1>Stats globales</h1>");
        out.println("<p>" + compteur + "pages ont été consultées </p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
