package com.javarush.kolybaba.ufoquest.dialogueTree;

import java.util.List;

/**
 * Інтерфейс для квестів
 **/
public interface QuestMatrix {

    /**
     * Метод класу, який реалізує даний інтерфейс,
     * має приймати параметр source і button із форми на jsp-сторінці
     * та повертати дані, які потрібні сервлету
     **/
    List<Object> getFormData(String source, String button);
}
