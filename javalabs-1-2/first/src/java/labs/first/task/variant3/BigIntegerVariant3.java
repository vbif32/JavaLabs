package labs.first.task.variant3;

import labs.first.task.common.BigIntegerCommon;

/**
 *
 * Third class for the first lab
 */
public class BigIntegerVariant3 extends BigIntegerCommon {

    public BigIntegerVariant3() {
    }

    public BigIntegerVariant3(int number) {
        super(number);
    }

    public BigIntegerVariant3(long number) {
        super(number);
    }

    /**
     * Возвращает текущее число представленное в двоичном виде
     * т.е. new BigIntegerVariant3(7).convertToBinary().toString() должно выдать "111", а хранить в себе {1,1,1,0,0,0,0,0,0,0}
     * @return текущее число представленное в двоичном виде
     */
    public BigIntegerVariant3 convertToBinary(){
        /**
         * Прочтите описание функции, впечатайте сюда свой код вместо этих комментариев
         * При необходимости измените возвращаемое значение
         */
        return this;
    }

    /**
     * Преобразовывает переданное число в BigInteger, представленное в двоичном виде
     * @param num целое число
     * @return число представленное в двоичном виде
     */
    public BigIntegerVariant3 convertToBinary(int num){
        /**
         * Прочтите описание функции, впечатайте сюда свой код вместо этих комментариев
         * При необходимости измените возвращаемое значение
         */
        return new BigIntegerVariant3();
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
        BigIntegerVariant3 var3 = new BigIntegerVariant3(467347);
        var3.testCommonFunctions();
    }
}
