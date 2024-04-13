package com.javarush.kolybaba.ufoquest.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Сервлет для обнулення статистики квесту.
 **/
@WebServlet("/jsp/resetStats")
public class ResetStatsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("victories");
        session.removeAttribute("losses");
        response.sendRedirect("stats.jsp");
    }
}
