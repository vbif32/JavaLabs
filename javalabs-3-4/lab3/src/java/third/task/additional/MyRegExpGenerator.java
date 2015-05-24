package third.task.additional;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dartaan on 24.05.2015.
 */
public class MyRegExpGenerator extends RegExpGenerator {

    @Override
    public void generate(String... strings) {

    }

    @Override
    public boolean match(String expression) {
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(expression);
        if (m.matches())
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

    }
}
