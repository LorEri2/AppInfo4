package be.condorcet.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PokemonReceiver", value = "/PokemonReceiver")
public class PokemonReceiver extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String[] selectedPokemons = request.getParameterValues("pokemon");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><meta charset='UTF-8'><title>Vos Pokémon</title></head>");
        out.println("<body>");

        if (selectedPokemons != null && selectedPokemons.length > 0) {
            out.println("<h2>Vous avez choisi :</h2>");
            out.println("<ul>");
            for (String poke : selectedPokemons) {
                out.println("<li>" + poke + "</li>");
            }
            out.println("</ul>");
            out.println("<p>Merci pour votre choix !</p>");
            out.println("<p>Amusez-vous bien avec vos Pokémon !</p>");
        } else {
            out.println("<h2>Vous n'avez sélectionné aucun Pokémon !</h2>");
            out.println("<p><a href='PokemonSelector.html'>Retourner au choix</a></p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}

