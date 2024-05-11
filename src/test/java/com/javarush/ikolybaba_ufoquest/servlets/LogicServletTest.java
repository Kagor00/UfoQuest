package com.javarush.ikolybaba_ufoquest.servlets;

import com.javarush.ikolybaba_ufoquest.dialogueTree.QuestMatrix;
import com.javarush.ikolybaba_ufoquest.dialogueTree.UfoQuestMatrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class LogicServletTest {

    private LogicServlet logicServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private QuestMatrix questMatrix;

    @BeforeEach
    void setUp() {
        questMatrix = Mockito.mock(UfoQuestMatrix.class); // Мокуємо questMatrix
        logicServlet = new LogicServlet(questMatrix); // Передаємо мок questMatrix через конструктор
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        // Мокуємо поведінку getSession для HttpServletRequest
        when(request.getSession()).thenReturn(session);
    }

    @Test
    void doGetTest() throws Exception {

        // Очікувані параметри для перевірки
        String source = "testSource";
        String button = "testButton";

        // Мокуємо поведінку getParameter для HttpServletRequest
        when(request.getParameter("source")).thenReturn(source);
        when(request.getParameter("button")).thenReturn(button);

        // Очікуваний результат від questMatrix.getFormDataList
        List<Object> formDataList = new ArrayList<>();
        formDataList.add("testPage.jsp");
        formDataList.add(1); // Імітуючи інкремент виграшів
        formDataList.add(0); // Імітуючи нульовий інкремент поразок
        when(questMatrix.getFormDataList(source, button)).thenReturn(formDataList);

        // Мокуємо поведінку getSession для HttpServletRequest
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);

        // Мокуємо поведінку getServletContext через HttpServletRequest
        ServletContext servletContext = mock(ServletContext.class);
        when(request.getServletContext()).thenReturn(servletContext);

        // Мокуємо поведінку getServletContext через HttpServletRequest
        when(request.getServletContext()).thenReturn(servletContext);

        // Мокуємо поведінку getRequestDispatcher для ServletContext
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        when(servletContext.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);


        // Виклик методу
        logicServlet.doGet(request, response);

        // Перевірка викликів методів
        verify(request, times(1)).getParameter("source");
        verify(request, times(1)).getParameter("button");
        verify(session, times(1)).setAttribute(eq("victories"), eq(1)); // Перевіряємо, що victoriesCount збільшився на 1
        verify(session, times(1)).setAttribute(eq("losses"), eq(0)); // Перевіряємо, що lossesCount не змінився
        verify(request.getServletContext(), times(1)).getRequestDispatcher("/jsp/testPage.jsp"); // Перевіряємо, що відправлено на вірну сторінку
        verify(request.getServletContext().getRequestDispatcher("/jsp/testPage.jsp"), times(1)).forward(request, response); // Перевіряємо, що викликано метод forward з вірними параметрами
    }
}

