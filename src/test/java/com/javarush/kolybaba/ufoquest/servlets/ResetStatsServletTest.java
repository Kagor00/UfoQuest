package com.javarush.kolybaba.ufoquest.servlets;

import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

class ResetStatsServletTest {

    @Test
    void doPostTest() throws IOException, ServletException {

        // Створення мок об'єктів
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        ServletContext servletContext = mock(ServletContext.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        // Налаштування моків HttpSession
        when(request.getSession()).thenReturn(session);

        // Налаштування моків ServletContext
        when(request.getServletContext()).thenReturn(servletContext);

        // Налаштування методу getRequestDispatcher у ServletContext для повернення моку RequestDispatcher
        when(servletContext.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        // Створення екземпляру сервлета
        ResetStatsServlet resetStatsServlet = new ResetStatsServlet();

        // Виклик методу doPost сервлета
        resetStatsServlet.doPost(request, response);

        // Перевірка, що removeAttribute викликався двічі на HttpSession з вказаними іменами атрибутів
        verify(session, times(1)).removeAttribute("victories");
        verify(session, times(1)).removeAttribute("losses");

        // Перевірка, що sendRedirect викликався один раз з вказаною URL
        verify(response, times(1)).sendRedirect("stats.jsp");
    }
}
