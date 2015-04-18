package labs.first.task.variant4;

import com.sun.imageio.plugins.common.BitFile;
import labs.first.task.common.BigIntegerCommon;

/**
 *
 * Fourth class for the first lab
 */
public class BigIntegerVariant4 extends BigIntegerCommon {

    public BigIntegerVariant4() {
    }

    public BigIntegerVariant4(int number) {
        super(number);

    }

    public BigIntegerVariant4(long number) {
        super(number);
    }

    /**
     * Возвращает текущее число представленное в шестнадцатеричном виде
     * т.е. new BigIntegerVariant4(256).convertToHex().toString() должно выдать "FF", а хранить в себе {16,16,0,0,0,0,0,0,0,0}
     * Не забудьте переопределить toString() причем так, чтобы он работал для обоих представлений
     * @return текущее число представленное в двоичном виде
     */
    public BigIntegerVariant4 convertToHex(){
        /**
         * Прочтите описание функции, впечатайте сюда свой код вместо этих комментариев
         * При необходимости измените возвращаемое значение
         */



        return this;
    }

    /**
     * Преобразовывает переданное число в BigInteger, представленное в шестнадцатеричном виде
     * @param num целое число
     * @return число представленное в двоичном виде
     */
    public BigIntegerVariant4 convertToHex(int num){

        if (num < 0)
            this.negative = true;

        for (int i = 0; num > 0; i++) {
            this.digits[i] = (byte)( num % 16);
        }

        return new BigIntegerVariant4();
    }

    @Override
    public void testCommonFunctions() {
        super.testCommonFunctions();
        /**
         * Вызовите свои функции и выведите на экран результат по аналогии с функцией из общего класса
         * впечатайте сюда свой код вместо этих комментариев
         */

        System.out.println("------------------------------------");
        System.out.println("------------------------------------");

        System.out.println("Проверка функций add/subtract(int )");
        System.out.println("Проверка a to hex; " + (new BigIntegerVariant4(Integer.MAX_VALUE).convertToHex().toString()));
        System.out.println("Проверка -a to hex; " + (new BigIntegerVariant4(-Integer.MAX_VALUE).convertToHex().toString()));
        System.out.println("Проверка 0 to hex; " + (new BigIntegerVariant4(0).convertToHex().toString()));
        System.out.println("Проверка 202374880 to hex; " + (new BigIntegerVariant4().convertToHex(202374880).toString()));
        System.out.println("Проверка -11325013 to hex " + (new BigIntegerVariant4().convertToHex(-11325013).toString()));
    }

    public static void main(String[] args) {
        BigIntegerVariant4 var4 = new BigIntegerVariant4();
        var4.testCommonFunctions();
    }
}
