package com.javarush.ikolybaba_ufoquest.servlets;

import com.javarush.ikolybaba_ufoquest.dialogueTree.QuestMatrix;
import com.javarush.ikolybaba_ufoquest.dialogueTree.UfoQuestMatrix;
import lombok.AllArgsConstructor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * Сервлет логіки обробки сторінок квесту.
 **/
@AllArgsConstructor
@WebServlet("/jsp/logic")
public class LogicServlet extends HttpServlet {

    private final QuestMatrix questMatrix;

    public LogicServlet() {
        this.questMatrix = new UfoQuestMatrix();
    }

    // Константи відповідних параметрів
    private static final String SOURCE_PARAMETER = "source";
    private static final String BUTTON_PARAMETER = "button";
    private static final int JSP_PAGE_INDEX = 0;
    private static final int VICTORIES_INCREMENT_INDEX = 1;
    private static final int LOSSES_INCREMENT_INDEX = 2;
    private static final String VICTORIES_ATTRIBUTE = "victories";
    private static final String LOSSES_ATTRIBUTE = "losses";

    /**
     * Обробка GET-запитів з JSP-сторінок.
     **/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int[] stats = getStats(req);
        Integer victoriesCount = stats[0];
        Integer lossesCount = stats[1];
        String source = req.getParameter(SOURCE_PARAMETER);
        String button = req.getParameter(BUTTON_PARAMETER);
        List<Object> formDataList = questMatrix.getFormDataList(source, button);
        String jspPage = "/jsp/" + formDataList.get(JSP_PAGE_INDEX);
        victoriesCount += (Integer) formDataList.get(VICTORIES_INCREMENT_INDEX);
        lossesCount += (Integer) formDataList.get(LOSSES_INCREMENT_INDEX);
        session.setAttribute(VICTORIES_ATTRIBUTE, victoriesCount);
        session.setAttribute(LOSSES_ATTRIBUTE, lossesCount);
        req.getServletContext().getRequestDispatcher(jspPage).forward(req, resp);
    }


    private int[] getStats(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Integer victoriesCount = (Integer) session.getAttribute(VICTORIES_ATTRIBUTE);
        Integer lossesCount = (Integer) session.getAttribute(LOSSES_ATTRIBUTE);
        if (victoriesCount == null) {
            victoriesCount = 0;
        }
        if (lossesCount == null) {
            lossesCount = 0;
        }
        return new int[]{victoriesCount, lossesCount};
    }
}
