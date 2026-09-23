package be.condorcet.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ApiKeyServlet", value = "/ApiKeyServlet")
public class ApiKeyServlet extends HttpServlet {

    private String apiKey;
    private String dbUrl;


    public void init() throws ServletException {
        apiKey = getInitParameter("apiKey");
        dbUrl = getServletContext().getInitParameter("dbConnectionString");

        if (apiKey == null || apiKey.trim().isEmpty()){
            throw new ServletException("Erreur : le param apikey est absent ");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Hello
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "API KEY SERVLET" + "</h1>");
        out.println("<p>" + "La clé recupérée : " + apiKey + "</p>");
        out.println(dbUrl);
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}