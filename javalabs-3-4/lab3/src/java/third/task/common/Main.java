package third.task.common;

import labs.third.instrument.ConsoleReader;
import labs.third.instrument.TextGenerator;
import labs.third.instrument.ThirdUnit;
import java.util.regex.*;

/**
 * Main-class для общей части
 */
public class Main implements ThirdUnit{

    private static int varkala;
    private static int wild_brandashmyg_actions;
    private static boolean was_hlivky_shorek;

    private static String VARKALA = "варкалось";
    private static String WILD = "дикий";
    private static String BRANDASHYG = "брандашмыг";
    private static String HLIVKY = "хливкий";
    private static String SHOREK = "шорёк";

    private void findWord(String s, int[] i) {
        if (i[0] < s.length()-1) {
            if (!s.substring(i[0], i[0] + 1).matches("[а-яёЁА-я]")) {
                i[0]++;
            }
            while (s.substring(i[0], i[0] + 1).matches("[а-яёЁА-я]")) {
                i[0]++;
            }
        }
    }

    public int UnitNumber() {
        return 3;
    }

    @Override
    public String FIO() {
        return "Федин Михаил Андреевич";
    }

    @Override
    public String GroupNumber() {
        return "ИИБ-2-14";
    }

    @Override
    public void setText(String s) {
        int beginWord;
        int endWord;
        int[] i = {0};
        StringBuilder curWord;

        while (i[0] < s.length()){
            beginWord = i[0];
            this.findWord(s, i);
            endWord = i[0];

            if (s.substring(beginWord, endWord).toLowerCase().equals(VARKALA)){
                varkala++;
            }
            else if (s.substring(beginWord, endWord).toLowerCase().equals(WILD)){
                i[0]++;
                beginWord = i[0];
                this.findWord(s, i);
                endWord = i[0];
                if (s.substring(beginWord, endWord).toLowerCase().equals(BRANDASHYG) && s.substring(endWord, endWord+1).equals(" ")){
                    wild_brandashmyg_actions++;
                }
            }
            if (!was_hlivky_shorek) {
                if (s.substring(beginWord, endWord).toLowerCase().equals(HLIVKY)) {
                    i[0]++;
                    beginWord = i[0];
                    this.findWord(s, i);
                    endWord = i[0];
                    if (s.substring(beginWord, endWord).toLowerCase().equals(SHOREK) && s.charAt(i[0] + 1) == ' ') {
                        was_hlivky_shorek = true;
                    }
                }
            }
            if (i[0] == s.length()-1){
                break;
            }
            while (!s.substring(i[0], i[0] + 1).matches("[а-яА-я]")) {
                i[0]++;
            }
        }
}

    public void testCommonFunction(){
        System.out.println("Main ");
        System.out.println("Лабораторная работа №" + this.UnitNumber());
        System.out.println("Наименование группы: " + this.GroupNumber());
        System.out.println("Студент: " + this.FIO());
        System.out.println("Варкалось " + varkala + " раз.");
        System.out.println("Дикий брандашмыг совершил : " + wild_brandashmyg_actions + " действий.");
        if (was_hlivky_shorek){
            System.out.println("Хливкий шорёк не обнаружен.");
        }
        else{
            System.out.println("В тексте встречался хливкий шорёк.");
        }
        System.out.println((19%3)+1);
    }

    public static void main(String[] args) {
        varkala = 0;
        wild_brandashmyg_actions = 0;
        was_hlivky_shorek = false;
        Main varCommon = new Main();
        TextGenerator.generateCommmon(varCommon);
        varCommon.testCommonFunction();
    }
}


