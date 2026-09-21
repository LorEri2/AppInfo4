package be.condorcet.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Exo1Servlet", value = "/Exo1Servlet")
public class Exo1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age1 = request.getParameter("age");

        int age = Integer.parseInt(age1);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.write("<!DOCTYPE html><html><head><title>Bienvenue</title></head><body>");
        out.write("<h1>Bienvenue</h1><p>Bonjour ");


        if (name != null && !name.isEmpty() && age >= 18) {
            out.write("Tu peux passer ton permis !");
        } else {
            out.write("Prends ton skateboard !");
        }

        out.write("</p></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}