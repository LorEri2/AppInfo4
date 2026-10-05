package web;
import  model.Character;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CharacterServlet ", value = "/CharacterServlet")
public class CharacterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.Préparer mon modèle
        Character garen = new Character("Garen", "Tank", List.of("Coup de tonerre", "Charge décisive", "Décimation"));
        request.setAttribute("character", garen);
        request.getRequestDispatcher("/WEB-INF/character.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
