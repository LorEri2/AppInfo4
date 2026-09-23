package be.condorcet.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "LimiteurServlet",
        value = "/LimiteurServlet",
        initParams = {
                @WebInitParam(name="maxRequests", value="5"),
                @WebInitParam(name="apiStatus", value="ACTIVE"),
        }
)
public class LimiteurServlet extends HttpServlet {
    private String maxRequests;
    private String apiStatus;
    @Override
    public void init() throws ServletException {
        super.init();

        maxRequests = getInitParameter("maxRequests");
        apiStatus = getInitParameter("apiStatus");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        ServletContext context = getServletContext();
        Integer compteur = (Integer)context.getAttribute("maxRequest");

        if(compteur == null)
            compteur=0;
        else
            compteur++;

        context.setAttribute("maxRequest", compteur);

        if(compteur >= 5 )
            out.println("Limite atteinte");
        else if(!"ACTIVE".equals(apiStatus))
            out.println("API indisponible");
        else
            out.println("<p>données de l'API envoyées avec succès. Requête numéro " + compteur + " /5</p>");

        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
