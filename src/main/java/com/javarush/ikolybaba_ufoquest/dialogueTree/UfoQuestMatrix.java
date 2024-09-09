package com.javarush.ikolybaba_ufoquest.dialogueTree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Клас реалізації квесту UfoQuest.
 **/
public class UfoQuestMatrix implements QuestMatrix {

    // Колекція являє собою мапу, де ключем є сторінка запитання,
    // значенням є внутрішня мапа. У внутрішній мапі ключ це кнопка форми,
    // значення це список атрибутів даної кнопки.
    private final Map<String, Map<String, List<Object>>> collection;

    // Константи сторінок квесту.
    private static final String QUEST_1 = "quest1";
    private static final String QUEST_2 = "quest2";
    private static final String QUEST_3 = "quest3";
    private static final String QUEST_4 = "quest4";
    private static final String QUEST_5 = "quest5";
    private static final String QUEST_6 = "quest6";
    private static final String QUEST_7 = "quest7";
    private static final String VICTORY = "victory";


    // Константи для кнопок.
    private static final String ACCEPT_CALL = "Прийняти виклик";
    private static final String REJECT_CALL = "Відхилити виклик";
    private static final String BRIDGE_CLIMB_FIRST = "Піднятися на місток";
    private static final String BRIDGE_CLIMB_SECOND = "Відмовитись підніматися на місток";
    private static final String WHAT_PLANET_FIRST = "Сатурн";
    private static final String WHAT_PLANET_SECOND = "Юпітер";
    private static final String WHAT_STAR_FIRST = "Проксима Центавра";
    private static final String WHAT_STAR_SECOND = "Сіріус";
    private static final String WHAT_SPACECRAFT_FIRST = "Viking 1";
    private static final String WHAT_SPACECRAFT_SECOND = "Voyager 1";
    private static final String WHAT_ECLIPSE_FIRST = "Місячне затемнення";
    private static final String WHAT_ECLIPSE_SECOND = "Сонячне затемнення";
    private static final String WHAT_OBJECT_FIRST = "Гравітаційна лінза";
    private static final String WHAT_OBJECT_SECOND = "Горизонт подій";
    private static final String CONTINUE = "Продовжити";


    // Константи для інкременту значень "victories" та "losses".
    private static final int INCREMENT_VALUE = 1;
    private static final int DONT_INCREMENT_VALUE = 0;


    // Константи для URL.
    private static final String BRIDGE_CLIMB_URL = "/bridgeClimb.jsp";
    private static final String REJECT_CALL_URL = "/rejectCall.jsp";
    private static final String REJECT_BRIDGE_URL = "/rejectBridge.jsp";
    private static final String WHAT_PLANET_URL = "/whatPlanet.jsp";
    private static final String WHAT_STAR_URL = "/whatStar.jsp";
    private static final String WHAT_SPACECRAFT_URL = "/whatSpacecraft.jsp";
    private static final String WHAT_ECLIPSE_URL = "/whatEclipse.jsp";
    private static final String WHAT_OBJECT_URL = "/whatObject.jsp";
    private static final String WRONG_ANSWER_URL = "/wrongAnswer.jsp";
    private static final String VICTORY_URL = "/victory.jsp";
    private static final String STATS_URL = "/stats.jsp";

    /**
     * Ініціалізація колекції в конструкторі.
     **/
    public UfoQuestMatrix() {
        collection = new HashMap<>();
        initializeMatrix();
    }

    /**
     * Заповнення колекції.
     **/
    private void initializeMatrix() {
        initializeQuest1();
        initializeQuest2();
        initializeQuest3();
        initializeQuest4();
        initializeQuest5();
        initializeQuest6();
        initializeQuest7();
        initializeVictory();
    }

    private void initializeQuest1() {
        addQuest(QUEST_1, Map.of(
                ACCEPT_CALL, createFormData(BRIDGE_CLIMB_URL, DONT_INCREMENT_VALUE, DONT_INCREMENT_VALUE),
                REJECT_CALL, createFormData(REJECT_CALL_URL, DONT_INCREMENT_VALUE, INCREMENT_VALUE)
        ));
    }

    private void initializeQuest2() {
        addQuest(QUEST_2, Map.of(
                BRIDGE_CLIMB_FIRST, createFormData(WHAT_PLANET_URL, DONT_INCREMENT_VALUE, DONT_INCREMENT_VALUE),
                BRIDGE_CLIMB_SECOND, createFormData(REJECT_BRIDGE_URL, DONT_INCREMENT_VALUE, INCREMENT_VALUE)
        ));
    }

    private void initializeQuest3() {
        addQuest(QUEST_3, Map.of(
                WHAT_PLANET_FIRST, createFormData(WRONG_ANSWER_URL, DONT_INCREMENT_VALUE, INCREMENT_VALUE),
                WHAT_PLANET_SECOND, createFormData(WHAT_STAR_URL, DONT_INCREMENT_VALUE, DONT_INCREMENT_VALUE)
        ));
    }

    private void initializeQuest4() {
        addQuest(QUEST_4, Map.of(
                WHAT_STAR_FIRST, createFormData(WHAT_SPACECRAFT_URL, DONT_INCREMENT_VALUE, DONT_INCREMENT_VALUE),
                WHAT_STAR_SECOND, createFormData(WRONG_ANSWER_URL, DONT_INCREMENT_VALUE, INCREMENT_VALUE)
        ));
    }

    private void initializeQuest5() {
        addQuest(QUEST_5, Map.of(
                WHAT_SPACECRAFT_FIRST, createFormData(WHAT_ECLIPSE_URL, DONT_INCREMENT_VALUE, DONT_INCREMENT_VALUE),
                WHAT_SPACECRAFT_SECOND, createFormData(WRONG_ANSWER_URL, DONT_INCREMENT_VALUE, INCREMENT_VALUE)
        ));
    }

    private void initializeQuest6() {
        addQuest(QUEST_6, Map.of(
                WHAT_ECLIPSE_FIRST, createFormData(WRONG_ANSWER_URL, DONT_INCREMENT_VALUE, INCREMENT_VALUE),
                WHAT_ECLIPSE_SECOND, createFormData(WHAT_OBJECT_URL, DONT_INCREMENT_VALUE, DONT_INCREMENT_VALUE)
        ));
    }

    private void initializeQuest7() {
        addQuest(QUEST_7, Map.of(
                WHAT_OBJECT_FIRST, createFormData(WRONG_ANSWER_URL, DONT_INCREMENT_VALUE, INCREMENT_VALUE),
                WHAT_OBJECT_SECOND, createFormData(VICTORY_URL, DONT_INCREMENT_VALUE, DONT_INCREMENT_VALUE)
        ));
    }

    private void initializeVictory() {
        addQuest(VICTORY, Map.of(
                CONTINUE, createFormData(STATS_URL, INCREMENT_VALUE, DONT_INCREMENT_VALUE)
        ));
    }

    private void addQuest(String quest, Map<String, List<Object>> formData) {
        collection.put(quest, formData);
    }

    private List<Object> createFormData(String url, int incrementValue, int dontIncrementValue) {
        List<Object> formData = new ArrayList<>();
        formData.add(url);
        formData.add(incrementValue);
        formData.add(dontIncrementValue);
        return formData;
    }

    @Override
    public List<Object> getFormDataList(String source, String button) {
        return collection.get(source).get(button);
    }
}
