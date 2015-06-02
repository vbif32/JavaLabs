package third.task.additional;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpGeneratorImpl extends RegExpGenerator {

    StringBuilder[] regs;

    @Override
    public void generate(String... strings) {

        int minStrLen = findMinStringLength(strings);
        int maxStrLen = findMaxStringLength(strings);

        if (regs == null){
            regs = new StringBuilder[maxStrLen];
            for (int i = 0; i < regs.length; i++){
                 regs[i] = new StringBuilder("");
            }
        } else if (regs.length < maxStrLen)
            regs = Arrays.copyOf(regs, maxStrLen);

        for (String str : strings){
            for (int i = 0; i < str.length(); i++){
                String tmp = str.substring(i, i+1);
                if (tmp.matches("\\d") && !regs[i].toString().contains("\\d")) {
                    regs[i].append("\\d|");
                } else if (tmp.matches("\\s") && !regs[i].toString().contains("\\s")) {
                    regs[i].append("\\s|");
                } else if (tmp.matches("[A-Z]") && !regs[i].toString().contains("A-Z")) {
                    regs[i].append("[A-Z]|");
                } else if (tmp.matches("[a-z]") && !regs[i].toString().contains("a-z")) {
                    regs[i].append("[a-z]|");
                } else if (tmp.matches("[А-Я]") && !regs[i].toString().contains("А-Я")) {
                    regs[i].append("[А-Я]|");
                } else if (tmp.matches("[а-я]") && !regs[i].toString().contains("а-я")) {
                    regs[i].append("[а-я]|");
                } else if (!tmp.matches("\\w|[А-Яа-я]")){
                    regs[i].append("[");
                    regs[i].append(tmp);
                    regs[i].append("]|");
                }

                // первая оптимизация - объединение двух классов с латинскими буквами разного регистра
                if (regs[i].toString().contains("[A-Z]|") && regs[i].toString().contains("[a-z]|")){
                    regs[i].delete(regs[i].indexOf("[A-Z]|"), regs[i].indexOf("[A-Z]|")+6);
                    regs[i].delete(regs[i].indexOf("[a-z]|"), regs[i].indexOf("[a-z]|")+6);
                    regs[i].append("[A-Za-z]|");
                }

                // аналогично для русских букв
                if (regs[i].toString().contains("[А-Я]|") && regs[i].toString().contains("[а-я]|")){
                    regs[i].delete(regs[i].indexOf("[А-Я]|"), regs[i].indexOf("[А-Я]|")+6);
                    regs[i].delete(regs[i].indexOf("[а-я]|"), regs[i].indexOf("[а-я]|")+6);
                    regs[i].append("[А-Яа-я]|");
                }

                // вторая оптимизация, замена на латинских букв и цифр на \\w
                if(regs[i].toString().contains("\\d")
                && regs[i].toString().contains("[A-Za-z]|")){
                    regs[i].delete(regs[i].indexOf("\\d|"), regs[i].indexOf("\\d|")+3);
                    regs[i].delete(regs[i].indexOf("[A-Za-z]|"), regs[i].indexOf("[A-Za-z]|")+9);
                    regs[i].append("\\w");
                } else if( regs[i].toString().contains("\\d")
                && regs[i].toString().contains("[a-zA-Z]|")){
                    regs[i].delete(regs[i].indexOf("\\d|"), regs[i].indexOf("\\d|")+3);
                    regs[i].delete(regs[i].indexOf("[a-zA-Z]|"), regs[i].indexOf("[a-zA-Z]|")+9);
                    regs[i].append("\\w");
                }



            }
        }

        //склейка окончательной регулярки
        StringBuilder tmp = new StringBuilder();
        tmp.append("^");
        for (int i = 0; i < regs.length; i++){
            tmp.append("(");
            tmp.append(regs[i]);
            tmp.append(")");
            if (tmp.toString().contains("|)")) // удаление лишнего символа или
                tmp.delete(tmp.indexOf("|)"), tmp.indexOf("|)")+1);
            if (i > minStrLen)
                tmp.append("?");
        }
        tmp.append("$");
        regExp = tmp.toString();
    }

    public int findMaxStringLength(String... strings){
        int result = 0;
        for (String str : strings){
            result = Math.max(result, str.length());
        }
        return result;
    }

    public int findMinStringLength(String... strings){
        int result = Integer.MAX_VALUE;
        for (String str : strings){
            result = Math.min(result, str.length());
        }
        return result;
    }

    @Override
    public boolean match(String expression) {
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(expression);
        if (m.matches()) {
            System.out.println("совпадение найдено");
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        RegExpGeneratorImpl test = new RegExpGeneratorImpl();
        test.generate("aaa", "abF", "ad2");
        System.out.println(test.regExp);
        test.match("aaa");
        test.match("aba");
        test.match("ad2");

    }
}
