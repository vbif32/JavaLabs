package third.task.additional;

/**
 *
 * Created by thecat on 05.02.15.
 */
public abstract class RegExpGenerator {

    protected String regExp = "";

    public abstract void generate(String... strings);

    public abstract boolean match(String expression);
}
