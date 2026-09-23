package be.condorcet.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

//1. Configuration de l'url & paramètres d'initialisation via les annotations
@WebServlet(
        name = "ConnexionServlet",
        value = "/ConnexionServlet",
        initParams = {
                @WebInitParam(name="username", value="admin"),
                @WebInitParam(name="password", value="Secret123"),

        }
)
public class ConnexionServlet extends HttpServlet {
    private String username;
    private String password;

    @Override
    public void init() throws ServletException {
        super.init(); // Permet de charger la méthode init de la classe au dessus

        //2. Récupérer les init params
        username = getInitParameter("username");
        password = getInitParameter("password");


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //3. Simulation: récupération des données saisies (dans l'url)
        //Exemple: /ConnexionServlet?user=admin&pass=Secret123

        String typeduser = request.getParameter("user");
        String typedPassword= request.getParameter("pass");

        out.println("<html><body>");
        out.println("<h1> -- Vérification de la connexion -- </h1>");
        //4. Vérification

        if(typeduser != null && typedPassword != null){
            if(typeduser.equals(username) && typedPassword.equals(password)){
                out.println("<p>Succès</p>");
            }else {
                out.println("<p>Echec de connexion</p>");
            }
        }

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
