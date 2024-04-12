package com.javarush.kolybaba.ufoquest.dialogueTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UfoQuestMatrixTest {

    // Константи індексів отриманих даних
    private static final int JSP_PAGE_INDEX = 0;
    private static final int VICTORIES_INCREMENT_INDEX = 1;
    private static final int LOSSES_INCREMENT_INDEX = 2;


    private UfoQuestMatrix matrix;

    @BeforeEach
    void setUp() {
        matrix = new UfoQuestMatrix();
    }

    /**
     * Перевірка ініціалізації даних в конструкторі
     **/
    @Test
    void constructor_InitializationTest() throws NoSuchFieldException, IllegalAccessException {
        // Використання рефлексії для доступу до приватного поля
        Field field = UfoQuestMatrix.class.getDeclaredField("collection");
        field.setAccessible(true);
        Map<String, Map<String, List<Object>>> collection = (Map<String, Map<String, List<Object>>>) field.get(matrix);

        // Перевірка ініціалізації колекції
        assertNotNull(collection);
        assertFalse(collection.isEmpty());

        // Перевірка ініціалізації даних для конкретних сторінок
        assertNotNull(collection.get("quest1"));
        assertNotNull(collection.get("quest2"));
        assertNotNull(collection.get("quest3"));
        assertNotNull(collection.get("quest4"));
        assertNotNull(collection.get("quest5"));
        assertNotNull(collection.get("quest6"));
        assertNotNull(collection.get("quest7"));
        assertNotNull(collection.get("victory"));
    }

    /** Перевірка коректності отриманих даних для переходу на відповідні сторінки
     * та обрахунку статистики **/

    @ParameterizedTest
    @CsvSource({
            "quest1, Прийняти виклик, /bridgeClimb.jsp, 0, 0",
            "quest1, Відхилити виклик, /rejectCall.jsp, 0, 1",
            "quest2, Піднятися на місток, /whatPlanet.jsp, 0, 0",
            "quest2, Відмовитись підніматися на місток, /rejectBridge.jsp, 0, 1",
            "quest3, Сатурн, /wrongAnswer.jsp, 0, 1",
            "quest3, Юпітер, /whatStar.jsp, 0, 0",
            "quest4, Проксима Центавра, /whatSpacecraft.jsp, 0, 0",
            "quest4, Сіріус, /wrongAnswer.jsp, 0, 1",
            "quest5, Viking 1, /whatEclipse.jsp, 0, 0",
            "quest5, Voyager 1, /wrongAnswer.jsp, 0, 1",
            "quest6, Місячне затемнення, /wrongAnswer.jsp, 0, 1",
            "quest6, Сонячне затемнення, /whatObject.jsp, 0, 0",
            "quest7, Гравітаційна лінза, /wrongAnswer.jsp, 0, 1",
            "quest7, Горизонт подій, /victory.jsp, 0, 0",
            "victory, Продовжити, /stats.jsp, 1, 0"
    })
    void getFormDataListTest(String source, String button, String expectedUrl, int expectedVictoriesIncrement, int expectedLossesIncrement) {
        List<Object> formDataList = matrix.getFormDataList(source, button);
        assertEquals(expectedUrl, formDataList.get(JSP_PAGE_INDEX));
        assertEquals(expectedVictoriesIncrement, formDataList.get(VICTORIES_INCREMENT_INDEX));
        assertEquals(expectedLossesIncrement, formDataList.get(LOSSES_INCREMENT_INDEX));
    }

}