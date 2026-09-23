package be.condorcet.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

//Singleton (instance seule) /thread (plusieurs instances)
@WebServlet(name = "PageServlet", value = "/visite")
public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //1. Récupérer mon context (de l'app) GetInitParam = GetAttribute
        ServletContext context = getServletContext();

        //2. Lire le compteur de visite actuelle du contexte
        Integer compteur = (Integer)context.getAttribute("visitCount");

        //3. S'il n'existe pas => 1. Sinon j'incrémente

        if(compteur == null)
            compteur=1;
        else
            compteur++;

        //4. Réenregistrer la nouvelle valeur dans le contexte de l'app
        context.setAttribute("visitCount", compteur);

        //5. Afficher
        out.println("<html><body>");
        out.println("<h1>Merci de votre visite</h1>");
        out.println("<p>La page a été chargée" + compteur + "fois </p>");
        out.println("</body></html>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
