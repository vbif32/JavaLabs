package labs.first.task.variant1;

import labs.first.task.common.BigIntegerCommon;

/**
 * class for  the first variant
 */
public class BigIntegerVariant1 extends BigIntegerCommon {

    public BigIntegerVariant1() {
        super();
    }

    public BigIntegerVariant1(int number) {
        super(number);
    }

    public BigIntegerVariant1(long number) {
        super(number);
    }

    /**
     * Умножает текущее число на переданное
     * @param number переданное число на которое будет умножено текущее
     * @return произведение текущего и переданного числа
     */
    public BigIntegerVariant1 multiple(BigIntegerVariant1 number) {
        /**
         * Прочтите описание функции, впечатайте сюда свой код вместо этих комментариев
         */
        return this;
    }

    /**
     * Умножает текущее число на переданное
     * @param number переданное число на которое будет умножено текущее
     * @return произведение текущего и переданного числа
     */
    public BigIntegerVariant1 multiple(int number) {
        /**
         * Прочтите описание функции, впечатайте сюда свой код вместо этих комментариев
         */
        return this;
    }

    /**
     * Умножает текущее число на переданное
     * @param number переданное число на которое будет умножено текущее
     * @return произведение текущего и переданного числа
     */
    public BigIntegerVariant1 multiple(long number) {
        /**
         * Прочтите описание функции, впечатайте сюда свой код вместо этих комментариев
         */
        return this;
    }

    @Override
    public void testCommonFunctions() {
        super.testCommonFunctions();

        /**
         * Вызовите свои функции и выведите на экран результат по аналогии с функцией из общего класса
         * впечатайте сюда свой код вместо этих комментариев
         */
    }

    public static void main(String[] args) {
        BigIntegerVariant1 i = new BigIntegerVariant1((int)(Math.random()*512));
        i.testCommonFunctions();
    }
}
