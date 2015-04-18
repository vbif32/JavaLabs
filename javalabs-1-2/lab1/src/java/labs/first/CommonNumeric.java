package labs.first;

/**
 *
 * Created by TheCat on 18.01.2015.
 */
public interface CommonNumeric {

    public CommonNumeric add(int commonNumeric);

    public CommonNumeric add(long commonNumeric);

    public CommonNumeric subtract(int commonNumeric);

    public CommonNumeric subtract(long commonNumeric);

    public void testCommonFunctions();

    public CommonNumeric setNegative(boolean negative);
}
