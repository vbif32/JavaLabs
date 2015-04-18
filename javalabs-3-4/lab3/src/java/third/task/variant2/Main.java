package third.task.variant2;

import labs.third.instrument.ConsoleReader;

/**
 * Main-class для второго варианта
 */
public class Main{


    private static final String DAY_VALIDATOR =
            "^((0[1-9])|(1\\d)|(2\\d)|(3[01]))";

    private static final String MONTH_VALIDATOR =
            "((0[1-9])|(1[0-2]))";

    private static final String YEAR_VALIDATOR =
            "(\\-?\\d{1,51}$)";

    private static final String MONTHS =
            "(янв|фев|мар|апр|май|июн|июл|авг|сен|окт|ноя|дек)";

    private static final String DATE_VALIDATOR =
            "(" + DAY_VALIDATOR + "\\.(" + MONTH_VALIDATOR + "|" + MONTHS + ")\\." + YEAR_VALIDATOR +
            ")|(" +  DAY_VALIDATOR + "/(" + MONTH_VALIDATOR + "|" + MONTHS + ")/" + YEAR_VALIDATOR +
            ")|(" + DAY_VALIDATOR + "-(" + MONTH_VALIDATOR + "|" + MONTHS + ")-" + YEAR_VALIDATOR + ")";

    public static void main(String[] args) {
            System.out.println("Input Date ");
            System.out.println(DATE_VALIDATOR);
            String str = ConsoleReader.read();

            System.out.println("Main " + str);
            if (str.matches(DATE_VALIDATOR))
                System.out.println("Является датой ");
            else
                System.out.println("Не является датой ");
    }
}

