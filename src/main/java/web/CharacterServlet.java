package web;

import model.Character;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CharacterServlet", value = "/CharacterServlet")
public class CharacterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Character garen = new Character(
                "Garen",
                "Tank",
                List.of(
                        "Coup de tonnerre",
                        "Charge décisive",
                        "Décimation"
                )
        );

        request.setAttribute("character", garen);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Character.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}