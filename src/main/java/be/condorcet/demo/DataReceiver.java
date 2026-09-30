package be.condorcet.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DataReceiver", value = "/DataReceiver")
public class DataReceiver extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstname = request.getParameter("firstname");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String age = request.getParameter("age");

        if (firstname != null && name != null && age != null){
            out.println("Bonjour " + firstname + "    "+ name + ", vous avez " + age + " ans !");
            out.println("Voici la description fournie : ");
            out.println(description);
        }
        else out.println("Champs manquants.");
    }
}
