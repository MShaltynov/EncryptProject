package com.example.stage1project;

import java.util.ArrayList;

public class TextAnalizer {

    //метод кодировки в цезаря по заданному офсету


    public String encrypt(String message, int offset) {
        StringBuilder stringBuilderResult = new StringBuilder();
        for (Character character : message.toCharArray()) {
            if ((character == ' ') || (character == '\n')) {
                stringBuilderResult.append((char) character);
            } else {
/*                int firstChar = character - 'a';
                int nextChar = (firstChar + offset) % 256;
                int finalChar = nextChar + 'a';
                result.append((char) finalChar);*/
                int finalChar = character + offset;
                stringBuilderResult.append((char) finalChar);
            }
        }
        return stringBuilderResult.toString();
    }

    //раскодировать текст
    public String decrypt(String text, int offset) {
        ArrayList<Character> characterArrayList = new ArrayList<>();
        StringBuilder resultDecrypt = new StringBuilder();

        //перебираем в течении 100 циклов
        for (int i = 0; i < 100; i++) {
            //--------------------------------------------
            for (Character cha : text.toCharArray()) {
                if ((cha.equals(' ')) || (cha.equals('\n'))) {
                    resultDecrypt.append((char) cha);
                    characterArrayList.add(cha);
                } else {
                    int finalChar = cha - i;
                    resultDecrypt.append((char) finalChar);
                    characterArrayList.add((char) finalChar);
                }
            }
            //тут буду перебирать по буквам в поисках истины
            for (int j = 0; j < characterArrayList.size(); j++) {
                //Проверяем на большую букву и чтобы не первое предложение, далее смотрим чтобы не было до него было и пробел и точка
                if (Character.isUpperCase(characterArrayList.get(j))) {
                    //Проверяем чтобы не первая буква в предложении
                    if ((j > 2) && (characterArrayList.get(j - 1) == ' ') && (characterArrayList.get(j - 2) == '.')) {
                        //Проверяем чтобы был пробел до него
                        System.out.println("Удвлось раскодировать! Результат:");
                        System.out.println(resultDecrypt.toString());
                        return "Удалось раскодировать! Результат за "+i+" циклов:\n"+ resultDecrypt.toString();
                    }
                }

            }
            //обнудяем строку от предыдущего мусора
            resultDecrypt.delete(0, resultDecrypt.length());

        }
        return "Не удалось расходировать";
    }
}
