package be.condorcet.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QueryStringReceiver", value = "/QueryStringReceiver")
public class QueryStringReceiver extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String firstname = request.getParameter("firstname");
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        if (firstname != null && name != null && age != null){
            out.println("Bonjour " + firstname + "    "+ name + ", vous avez " + age + " ans !");
        }
        else out.println("Champs manquants.");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
