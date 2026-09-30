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
        String basePokemon = request.getParameter("pokemon");
        String levelStr = request.getParameter("level");
        boolean wantEvolution = "yes".equals(request.getParameter("evolve"));

        out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Résultat</title></head><body>");

        if (basePokemon != null && levelStr != null && !levelStr.isBlank()) {
            try {
                int level = Integer.parseInt(levelStr);

                if (level < 1 || level > 100) {
                    out.println("<p>Erreur : le niveau doit être compris entre 1 et 100.</p>");
                } else {
                    String finalPokemon = basePokemon;


                    if (wantEvolution) {
                        finalPokemon = computeEvolution(basePokemon, level);
                    }

                    out.println("<h2>Résultat</h2>");
                    out.println("<p>Pokémon de base : <strong>" + basePokemon + "</strong></p>");
                    out.println("<p>Niveau : <strong>" + level + "</strong></p>");
                    out.println("<p>Autoriser l'évolution : <strong>" + (wantEvolution ? "Oui" : "Non") + "</strong></p>");
                    out.println("<hr>");
                    out.println("<p>Pokémon final : <strong>" + finalPokemon + "</strong></p>");
                }
            } catch (NumberFormatException e) {
                out.println("<p>Erreur : format de niveau invalide.</p>");
            }
        } else {
            out.println("<p>Veuillez sélectionner un Pokémon et entrer un niveau.</p>");
        }

        out.println("<br><a href='PokemonEvolution.html'>Recommencer</a>");
        out.println("</body></html>");
    }

    private String computeEvolution(String pokemon, int level) {
        if (level >= 36) {
            return switch (pokemon) {
                case "Salamèche" -> "Dracaufeu";
                case "Carapuce" -> "Tortank";
                case "Bulbizarre" -> "Florizarre";
                default -> pokemon;
            };
        } else if (level >= 16) {
            return switch (pokemon) {
                case "Salamèche" -> "Reptincelle";
                case "Carapuce" -> "Carabaffe";
                case "Bulbizarre" -> "Herbizarre";
                default -> pokemon;
            };
        }
        return pokemon;
    }
}

