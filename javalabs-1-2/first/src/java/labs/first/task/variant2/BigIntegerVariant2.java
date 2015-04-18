package labs.first.task.variant2;

import labs.first.task.common.BigIntegerCommon;

/**
 *
 * class for  the second variant
 */
public class BigIntegerVariant2 extends BigIntegerCommon {

    public BigIntegerVariant2() {
    }

    public BigIntegerVariant2(int number) {
        super(number);
    }

    public BigIntegerVariant2(long number) {
        super(number);
    }

    /**
     * Вычисляет факториал равный n!, где n - текущее значение
     * @return факториал текущего числа
     */
    public BigIntegerVariant2 factorial() {
        /**
         * Прочтите описание функции, впечатайте сюда свой код вместо этих комментариев
         * При необходимости измените возвращаемое значение
         */
        return this;
    }

    /**
     * Вычисляет факториал переданной переменной
     * @param n переменная факториал, которой мы считаем
     * @return факториал
     */
    public static BigIntegerVariant2 factorial(int n){
        /**
         * Прочтите описание функции, впечатайте сюда свой код вместо этих комментариев
         * При необходимости измените возвращаемое значение
         */
        return new BigIntegerVariant2();
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
        BigIntegerVariant2 v = new BigIntegerVariant2();
        v.testCommonFunctions();
    }
}
