package com.javarush.ikolybaba_ufoquest.dialogueTree;

import java.util.List;

/**
 * Інтерфейс для квестів.
 **/
public interface QuestMatrix {

    /**
     * Метод класу, який реалізує даний інтерфейс,
     * має приймати параметри source і button із форми на JSP-сторінці
     * та повертати дані, необхідні сервлету.
     **/
    List<Object> getFormDataList(String source, String button);
}
