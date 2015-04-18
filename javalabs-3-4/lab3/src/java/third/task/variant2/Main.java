package third.task.variant2;

import labs.third.instrument.ConsoleReader;

/**
 * Main-class для второго варианта
 */
public class Main{

    private static final String DATE_VALIDATOR =
            "^([01]\\d?|2\\d|3[01])[./-]" +
            "((0[1-9]|1[0-2])|(янв|фев|мар|апр|май|июн|июл|авг|сен|окт|ноя|дек))[./-]" +
            "\\d{1,4}$";

    public static void main(String[] args) {
            System.out.println("Input Date ");
            String str = ConsoleReader.read();

            System.out.println("Main " + str);
            if (str.matches(DATE_VALIDATOR))
                System.out.println("Является датой ");
            else
                System.out.println("Не является датой ");
    }
}

