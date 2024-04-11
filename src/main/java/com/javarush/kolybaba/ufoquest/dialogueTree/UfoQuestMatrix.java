package com.javarush.kolybaba.ufoquest.dialogueTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UfoQuestMatrix implements QuestMatrix {
    private final Map<String, Map<String, List<Object>>> collection = new HashMap<>();

    // Константи для ключів колекції
    private static final String QUEST_1 = "quest1";
    private static final String QUEST_2 = "quest2";
    private static final String QUEST_3 = "quest3";
    private static final String QUEST_4 = "quest4";
    private static final String QUEST_5 = "quest5";
    private static final String QUEST_6 = "quest6";
    private static final String QUEST_7 = "quest7";
    private static final String VICTORY = "victory";


    // Константи для кнопок
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


    // Константи для інкременту значень "victories" та "losses"
    private static final int INCREMENT_VALUE = 1;
    private static final int DONT_INCREMENT_VALUE = 0;


    // Константи для URL
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


    public UfoQuestMatrix() {
        initializeMatrix();
    }


    private void initializeMatrix() {

        // Quest 1
        Map<String, List<Object>> quest1 = new HashMap<>();
        List<Object> quest1Accept = new ArrayList<>();
        quest1Accept.add(BRIDGE_CLIMB_URL);
        quest1Accept.add(DONT_INCREMENT_VALUE); // victories
        quest1Accept.add(DONT_INCREMENT_VALUE); // losses
        quest1.put(ACCEPT_CALL, quest1Accept);

        List<Object> quest1Reject = new ArrayList<>();
        quest1Reject.add(REJECT_CALL_URL);
        quest1Reject.add(DONT_INCREMENT_VALUE); // victories
        quest1Reject.add(INCREMENT_VALUE); // losses
        quest1.put(REJECT_CALL, quest1Reject);

        collection.put(QUEST_1, quest1);

        // Quest 2
        Map<String, List<Object>> quest2 = new HashMap<>();
        List<Object> quest2Accept = new ArrayList<>();
        quest2Accept.add(WHAT_PLANET_URL);
        quest2Accept.add(DONT_INCREMENT_VALUE); // victories
        quest2Accept.add(DONT_INCREMENT_VALUE); // losses
        quest2.put(BRIDGE_CLIMB_FIRST, quest2Accept);

        List<Object> quest2Reject = new ArrayList<>();
        quest2Reject.add(REJECT_BRIDGE_URL);
        quest2Reject.add(DONT_INCREMENT_VALUE); // victories
        quest2Reject.add(INCREMENT_VALUE); // losses
        quest2.put(BRIDGE_CLIMB_SECOND, quest2Reject);

        collection.put(QUEST_2, quest2);

        // Quest 3
        Map<String, List<Object>> quest3 = new HashMap<>();
        List<Object> quest3First = new ArrayList<>();
        quest3First.add(WRONG_ANSWER_URL);
        quest3First.add(DONT_INCREMENT_VALUE); // victories
        quest3First.add(INCREMENT_VALUE); // losses
        quest3.put(WHAT_PLANET_FIRST, quest3First);

        List<Object> quest3Second = new ArrayList<>();
        quest3Second.add(WHAT_STAR_URL);
        quest3Second.add(DONT_INCREMENT_VALUE); // victories
        quest3Second.add(DONT_INCREMENT_VALUE); // losses
        quest3.put(WHAT_PLANET_SECOND, quest3Second);

        collection.put(QUEST_3, quest3);

        // Quest 4
        Map<String, List<Object>> quest4 = new HashMap<>();
        List<Object> quest4First = new ArrayList<>();
        quest4First.add(WHAT_SPACECRAFT_URL);
        quest4First.add(DONT_INCREMENT_VALUE); // victories
        quest4First.add(DONT_INCREMENT_VALUE); // losses
        quest4.put(WHAT_STAR_FIRST, quest4First);

        List<Object> quest4Second = new ArrayList<>();
        quest4Second.add(WRONG_ANSWER_URL);
        quest4Second.add(DONT_INCREMENT_VALUE); // victories
        quest4Second.add(INCREMENT_VALUE); // losses
        quest4.put(WHAT_STAR_SECOND, quest4Second);

        collection.put(QUEST_4, quest4);

        // Quest 5
        Map<String, List<Object>> quest5 = new HashMap<>();
        List<Object> quest5First = new ArrayList<>();
        quest5First.add(WHAT_ECLIPSE_URL);
        quest5First.add(DONT_INCREMENT_VALUE); // victories
        quest5First.add(DONT_INCREMENT_VALUE); // losses
        quest5.put(WHAT_SPACECRAFT_FIRST, quest5First);

        List<Object> quest5Second = new ArrayList<>();
        quest5Second.add(WRONG_ANSWER_URL);
        quest5Second.add(DONT_INCREMENT_VALUE); // victories
        quest5Second.add(INCREMENT_VALUE); // losses
        quest5.put(WHAT_SPACECRAFT_SECOND, quest5Second);

        collection.put(QUEST_5, quest5);

        // Quest 6
        Map<String, List<Object>> quest6 = new HashMap<>();
        List<Object> quest6First = new ArrayList<>();
        quest6First.add(WRONG_ANSWER_URL);
        quest6First.add(DONT_INCREMENT_VALUE); // victories
        quest6First.add(INCREMENT_VALUE); // losses
        quest6.put(WHAT_ECLIPSE_FIRST, quest6First);

        List<Object> quest6Second = new ArrayList<>();
        quest6Second.add(WHAT_OBJECT_URL);
        quest6Second.add(DONT_INCREMENT_VALUE); // victories
        quest6Second.add(DONT_INCREMENT_VALUE); // losses
        quest6.put(WHAT_ECLIPSE_SECOND, quest6Second);

        collection.put(QUEST_6, quest6);

        // Quest 7
        Map<String, List<Object>> quest7 = new HashMap<>();
        List<Object> quest7First = new ArrayList<>();
        quest7First.add(WRONG_ANSWER_URL);
        quest7First.add(DONT_INCREMENT_VALUE); // victories
        quest7First.add(INCREMENT_VALUE); // losses
        quest7.put(WHAT_OBJECT_FIRST, quest7First);

        List<Object> quest7Second = new ArrayList<>();
        quest7Second.add(VICTORY_URL);
        quest7Second.add(DONT_INCREMENT_VALUE); // victories
        quest7Second.add(DONT_INCREMENT_VALUE); // losses
        quest7.put(WHAT_OBJECT_SECOND, quest7Second);

        collection.put(QUEST_7, quest7);

        // Victory
        Map<String, List<Object>> victory = new HashMap<>();
        List<Object> listForm = new ArrayList<>();
        listForm.add(STATS_URL);
        listForm.add(INCREMENT_VALUE); // victories
        listForm.add(DONT_INCREMENT_VALUE); // losses
        victory.put(CONTINUE, listForm);

        collection.put(VICTORY, victory);
    }

    @Override
    public List<Object> getFormAttributes(String source, String button) {
        return collection.get(source).get(button);
    }
}