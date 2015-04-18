package labs.first.task.common;

import labs.Unit;
import labs.first.CommonNumeric;

import java.util.Arrays;

/**
 * Common class for the first lab
 */
public class BigIntegerCommon implements Unit, CommonNumeric {

    public byte[] digits = new byte[10];
    protected boolean negative;

    public BigIntegerCommon() {
        for (int i = 0; i < digits.length; i++) {
            digits[i] = 0;
        }
    }

    public BigIntegerCommon(byte[] digits) {
        this.digits = digits;
    }

    public BigIntegerCommon(byte[] digits, boolean negative) {
        this(digits);
        this.negative = negative;
    }

    public BigIntegerCommon(int number) {
        /**
         * Реализуйте конструктор создающий объект текущего класса
         * по переданному в него числу типа int
         * (заполните массив так, чтобы в каждом элементе массива лежал один разряд числа,
         * т.е. число 364524 должно выглядеть как byte [] = {4,2,5,4,6,3,0,0,0,0})
         * или разместите разряды в массиве в удобной вам последовательности,
         * обратите внимание что выбранную последовательность необходимо использовать во всех функциях,
         * т.е. при изменении последовательности необходимо переписать функцию
         * @see #toString()
         */

        if (number < 0) {
            this.negative = true;
            number *= -1;
        }

        for (int i = 0; i < digits.length & number != 0; i++){
            digits[i] = (byte)(number % 10);
            number = number / 10;
        }
    }

    public BigIntegerCommon(long number) {
        /**
         * Реализуйте функцию аналогично предыдущей,
         * учтите что размерность типа long больше,
         * чем размерность изначального массива
         * Для оптимизации расширения массива воспользуйтесь функцией
         * @see System#arraycopy из ядра Java или
         * @see java.util.Arrays#copyOf из пакета java.util
         * Пример использования есть в коде
         */

        digits = Arrays.copyOf(digits, 19);

        if (number < 0) {
            this.negative = true;
            number *= -1;
        }

        for (int i = 0; i < digits.length & number != 0; i++){
            digits[i] = (byte)(number % 10);
            number = number / 10;
        }
    }

    public int UnitNumber() {
        return 1;
    }

    @Override
    public String FIO() {
        /**
         * Впечатайте вместо return null - return "Фамилия Имя Отчество"
         */
        return "Федин Михаил Андреевич";
    }

    @Override
    public String GroupNumber() {
        /**
         * Впечатайте вместо return null - return "Название группы"
         */
        return "ИИБ-2-14";
    }

    /**
     * Прибавляет переданное значение к текущему,
     * при выходе за размерность массива разрядов расширяет его
     *
     * @param bigIntegerCommon добавляемое значение
     * @return сумму текущего и переданного значений
     */
    public BigIntegerCommon add(BigIntegerCommon bigIntegerCommon) {

        if (bigIntegerCommon.digits.length > this.digits.length)
            this.digits = Arrays.copyOf(this.digits, bigIntegerCommon.digits.length);
        else if (bigIntegerCommon.digits.length < this.digits.length)
            bigIntegerCommon.digits = Arrays.copyOf(bigIntegerCommon.digits, this.digits.length);

        if (this.negative == bigIntegerCommon.negative) {
            for (int i = 0; i < this.digits.length; i++) {
                this.digits[i] += bigIntegerCommon.digits[i];

                if (this.digits[i] > 10) {
                    if (this.digits.length == i+1) {
                        this.digits = Arrays.copyOf(this.digits, this.digits.length+1);
                        bigIntegerCommon.digits = Arrays.copyOf(this.digits, this.digits.length+1);
                    }
                    this.digits[i + 1] += (byte) (this.digits[i] / 10);
                    this.digits[i] = (byte) (this.digits[i] % 10);
                }

            }
        }

        if (this.negative != bigIntegerCommon.negative){
            bigIntegerCommon.negative = !bigIntegerCommon.negative;
            this.subtract(bigIntegerCommon);
        }

        return this;
    }

    /**
     * Прибавляет переданное значение к текущему
     * при выходе за размерность массива разрядов расширяет его
     *
     * @param bigIntegerCommon добавляемое значение
     * @return сумму текущего и переданного значений
     */
    public BigIntegerCommon add(int bigIntegerCommon) {

        /**
         * Прочтите описание функции, впечатайте сюда свой код вместо этих комментариев
         * при необходимости замените возвращаемое значение
         */

        if (this.negative == bigIntegerCommon < 0) {
            for (int i = 0; i < 10; i++) {
                this.digits[i] += Math.abs ( bigIntegerCommon % 10);
                bigIntegerCommon = bigIntegerCommon / 10;

                if (this.digits[i] > 10) {
                    if (this.digits.length == i+1) {
                        this.digits = Arrays.copyOf(this.digits, this.digits.length+1);
                    }
                    this.digits[i + 1] += (byte) (this.digits[i] / 10);
                    this.digits[i] = (byte) (this.digits[i] % 10);
                }

                if (bigIntegerCommon == 0)
                    break;

            }
        }

        if (this.negative != bigIntegerCommon <= 0){
            bigIntegerCommon = bigIntegerCommon * -1;
            this.subtract(bigIntegerCommon);
        }

        return this;
    }

    /**
     * Прибавляет переданное значение к текущему
     * при выходе за размерность массива разрядов расширяет его
     *
     * @param bigIntegerCommon добавляемое значение
     * @return сумму текущего и переданного значений
     */
    public BigIntegerCommon add(long bigIntegerCommon) {
        /**
         * Прочтите описание функции, впечатайте сюда свой код вместо этих комментариев
         * при необходимости замените возвращаемое значение
         */

        if (this.negative == bigIntegerCommon < 0) {
            for (int i = 0; i < 19; i++) {
                this.digits[i] += Math.abs ( bigIntegerCommon % 10);
                bigIntegerCommon = bigIntegerCommon / 10;

                if (this.digits[i] > 10) {
                    if (this.digits.length == i+1) {
                        this.digits = Arrays.copyOf(this.digits, this.digits.length+1);
                    }
                    this.digits[i + 1] += (byte) (this.digits[i] / 10);
                    this.digits[i] = (byte) (this.digits[i] % 10);
                }

                if (bigIntegerCommon == 0)
                    break;
            }
        }

        if (this.negative != bigIntegerCommon <= 0){
            bigIntegerCommon = bigIntegerCommon * -1;
            this.subtract(bigIntegerCommon);
        }

        return this;
    }

    /**
     * Вычитает переданное значение из текущего
     * при выходе за размерность массива разрядов расширяет его
     *
     * @param bigIntegerCommon вычитаемое значение
     * @return разницу текущего и переданного значений
     */
    public BigIntegerCommon subtract(BigIntegerCommon bigIntegerCommon){
        /**
         * Прочтите описание функции, впечатайте сюда свой код вместо этих комментариев
         * при необходимости замените возвращаемое значение
         */

        if (bigIntegerCommon.digits.length > this.digits.length)
            this.digits = Arrays.copyOf(this.digits, bigIntegerCommon.digits.length);
        else if (bigIntegerCommon.digits.length < this.digits.length)
            bigIntegerCommon.digits = Arrays.copyOf(bigIntegerCommon.digits, this.digits.length);

        if (this.negative == bigIntegerCommon.negative) {

            for (int i = this.digits.length-1; i >= 0; i--) {
                if (this.digits[i] < bigIntegerCommon.digits[i]) {

                    this.negative = bigIntegerCommon.negative;
                    for (int j = 0; j < digits.length; j++) {

                        this.digits[j] = (byte) (bigIntegerCommon.digits[j] - this.digits[j]);
                        if (this.digits[j] < 0) {
                            this.digits[j] += 10;
                            this.digits[j + 1] += 1;
                        }
                    }

                    break;
                }
                else if (this.digits[i] > bigIntegerCommon.digits[i]) {

                    for (int j = 0; j < digits.length; j++) {

                        this.digits[j] = (byte) (this.digits[j] - bigIntegerCommon.digits[j]);
                        if (this.digits[j] < 0) {
                            this.digits[j] += 10;
                            this.digits[j + 1] += -1;
                        }
                    }

                    break;
                }
                else if (this.digits[i] == bigIntegerCommon.digits[i]) {
                    this.digits[i] = 0;
                    bigIntegerCommon.digits[i] = 0;
                }
            }
        }
        else if (this.negative != bigIntegerCommon.negative) {
            bigIntegerCommon.negative = !bigIntegerCommon.negative;
            this.add(bigIntegerCommon);
        }

        return this;
    }
    /**
     * Вычитает переданное значение из текущего
     * при выходе за размерность массива разрядов расширяет его
     *
     * @param bigIntegerCommon вычитаемое значение
     * @return разницу текущего и переданного значений
     */
    public BigIntegerCommon subtract(int bigIntegerCommon){

        if (this.negative == bigIntegerCommon < 0) {

            for (int i = this.digits.length-1; i >= 0; i--) {
                if (this.digits[i] < ((int)(bigIntegerCommon / Math.pow(10, i)))) {

                    this.negative = !this.negative;
                    for (int j = 0; j < digits.length; j++) {

                        this.digits[j] = (byte)((Math.abs(bigIntegerCommon % 10) - this.digits[j]));
                        bigIntegerCommon = Math.abs(bigIntegerCommon / 10);

                        if (this.digits[j] < 0) {
                            this.digits[j] += 10;
                            this.digits[j + 1] += 1;
                        }
                    }

                    break;
                } else if (this.digits[i] > ((int)(bigIntegerCommon / Math.pow(10, i)))) {

                    for (int j = 0; j < digits.length; j++) {

                        this.digits[j] = (byte) (this.digits[j] - (Math.abs(bigIntegerCommon % 10)));
                        bigIntegerCommon = Math.abs(bigIntegerCommon / 10);

                        if (this.digits[j] < 0) {
                            this.digits[j] += 10;
                            this.digits[j + 1] += -1;
                        }
                    }

                    break;
                } else if (i == 0) {
                    Arrays.fill(this.digits,(byte) 0);
                }
            }
        }

        else if (this.negative != bigIntegerCommon <= 0) {
            bigIntegerCommon = bigIntegerCommon * -1;
            this.add(bigIntegerCommon);
        }

        return this;
    }

    /**
     * Вычитает переданное значение из текущего
     * при выходе за размерность массива разрядов расширяет его
     *
     * @param bigIntegerCommon вычитаемое значение
     * @return разницу текущего и переданного значений
     */
    public BigIntegerCommon subtract(long bigIntegerCommon){

        if (this.negative == bigIntegerCommon < 0) {

            for (int i = this.digits.length-1; i >= 0; i--) {
                if (this.digits[i] < ((int)(bigIntegerCommon / Math.pow(10, i)))) {

                    this.negative = !this.negative;
                    for (int j = 0; j < digits.length; j++) {

                        this.digits[j] = (byte) ((Math.abs(bigIntegerCommon % 10)) - this.digits[j]);
                        bigIntegerCommon = Math.abs( bigIntegerCommon / 10);

                        if (this.digits[j] < 0) {
                            this.digits[j] += 10;
                            this.digits[j + 1] += 1;
                        }
                    }

                    break;
                } else if (this.digits[i] > ((int)(bigIntegerCommon / Math.pow(10, i)))) {

                    for (int j = 0; j < digits.length; j++) {

                        this.digits[j] = (byte) (this.digits[j] - (Math.abs(bigIntegerCommon % 10)));
                        bigIntegerCommon = Math.abs(bigIntegerCommon / 10);

                        if (this.digits[j] < 0) {
                            this.digits[j] += 10;
                            this.digits[j + 1] += -1;
                        }
                    }

                    break;
                } else if (i == 0) {
                    Arrays.fill(this.digits,(byte) 0);
                }
            }
        }

        else if (this.negative != bigIntegerCommon <= 0) {
            bigIntegerCommon = bigIntegerCommon * -1;
            this.add(bigIntegerCommon);
        }

        return this;
    }

    public void testCommonFunctions() {
        System.out.println("Лабораторная работа №" + this.UnitNumber());
        System.out.println("Наименование группы: " + this.GroupNumber());
        System.out.println("Студент: " + this.FIO());
        System.out.println("Проверка функций add/subtract(int )");
        System.out.println("Проверка a - a = 0; " + (new BigIntegerCommon(Integer.MAX_VALUE).subtract(new BigIntegerCommon(Integer.MAX_VALUE)).equals(new BigIntegerCommon()) ? "успешно" : "некорректно"));
        System.out.println("Проверка a + (- a) = 0; " + (new BigIntegerCommon(Integer.MAX_VALUE).add(new BigIntegerCommon(-Integer.MAX_VALUE)).equals(new BigIntegerCommon()) ? "успешно" : "некорректно " + new BigIntegerCommon(Integer.MAX_VALUE).subtract(new BigIntegerCommon(-Integer.MAX_VALUE))));
        System.out.println("Проверка a + 0 = a; " + (new BigIntegerCommon(Integer.MAX_VALUE).add(new BigIntegerCommon()).equals(new BigIntegerCommon(Integer.MAX_VALUE)) ? "успешно" : "некорректно " + new BigIntegerCommon(Integer.MAX_VALUE).add(new BigIntegerCommon())));
        System.out.println("Проверка 50 - 25 = " + (new BigIntegerCommon(50).subtract(25))+ " " + (new BigIntegerCommon(50).subtract(25).equals(new BigIntegerCommon(25))));
        System.out.println("Проверка -50 - 25 = " + (new BigIntegerCommon(-50).subtract(25)) +" "+(new BigIntegerCommon(-50).subtract(25).equals(new BigIntegerCommon(-75))));
        System.out.println("Проверка 50 - (-25) = " + (new BigIntegerCommon(50).subtract(-25)) +" "+(new BigIntegerCommon(50).subtract(-25).equals(new BigIntegerCommon(75))));
        System.out.println("Проверка -50 - (-25) = " + (new BigIntegerCommon(-50).subtract(-25)) +" "+(new BigIntegerCommon(-50).subtract(-25).equals(new BigIntegerCommon(-25))));
        System.out.println("Проверка -50 - (-25) = " + (new BigIntegerCommon(12648430).subtract(0)));

        System.out.println("------------------------------------");
        System.out.println("Проверка функций add/subtract(long )");
        System.out.println("Проверка a - a = 0; " + (new BigIntegerCommon(Long.MAX_VALUE).subtract(new BigIntegerCommon(Long.MAX_VALUE)).equals(new BigIntegerCommon()) ? "успешно" : "некорректно " + new BigIntegerCommon(Long.MAX_VALUE).subtract(new BigIntegerCommon(Long.MAX_VALUE))));
        System.out.println("Проверка a + a = 0; " + (new BigIntegerCommon(Long.MAX_VALUE).add(new BigIntegerCommon(Long.MAX_VALUE)).equals(new BigIntegerCommon()) ? "успешно" : "некорректно " + new BigIntegerCommon(Long.MAX_VALUE).subtract(new BigIntegerCommon(Long.MAX_VALUE))));
        System.out.println("Проверка a + (- a) = 0; " + (new BigIntegerCommon(Long.MAX_VALUE).add(new BigIntegerCommon(-Long.MAX_VALUE)).equals(new BigIntegerCommon()) ? "успешно" : "некорректно " + new BigIntegerCommon(Long.MAX_VALUE).subtract(new BigIntegerCommon(-Integer.MAX_VALUE))));
        System.out.println("Проверка a + 0 = a; " + (new BigIntegerCommon(Long.MAX_VALUE).add(new BigIntegerCommon()).equals(new BigIntegerCommon(Long.MAX_VALUE)) ? "успешно" : "некорректно " + new BigIntegerCommon(Long.MAX_VALUE).add(new BigIntegerCommon())));
        System.out.println("Проверка 50 - 25 = " + (new BigIntegerCommon(50L).subtract(25L))+ " " + (new BigIntegerCommon(50L).subtract(25L).equals(new BigIntegerCommon(25))));
        System.out.println("Проверка -50 - 25 = " + (new BigIntegerCommon(-50).subtract(25L)) +" "+(new BigIntegerCommon(-50).subtract(25L).equals(new BigIntegerCommon(-75))));
        System.out.println("Проверка 50 - (-25) = " + (new BigIntegerCommon(50).subtract(-25L)) +" "+(new BigIntegerCommon(50).subtract(-25).equals(new BigIntegerCommon(75))));
        System.out.println("Проверка -50 - (-25) = " + (new BigIntegerCommon(-50L).subtract(-25)) +" "+(new BigIntegerCommon(-50).subtract(-25L).equals(new BigIntegerCommon(-25))));
    }

    /**
     * Сравнивает текущее число с передаваемым
     * @param c2 число для сравнения с текущим
     * @return int a: a < 0 число меньше текущего, a > 0 число больше текущего, a = 0 числа равны
     */
    public int compare(BigIntegerCommon c2){
        if(c2.digits.length > this.digits.length){
            this.digits = Arrays.copyOf(this.digits,c2.digits.length);
        } else {
            c2.digits = Arrays.copyOf(c2.digits, this.digits.length);
        }
        for (int i = (this.digits.length - 1); i > -1 ; i--) {
            if((c2.digits[i] - this.digits[i]) != 0){
                return (c2.digits[i] - this.digits[i]);
            }
        }
        return 0;
    }

    public BigIntegerCommon setNegative(boolean negative) {
        this.negative = negative;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder bld = new StringBuilder();
        bld.append(this.negative ? "-" : "");
         char[] hexChar = {'A', 'B', 'C', 'D', 'E', 'F'};
        boolean flag = false;
        for (int i = (this.digits.length - 1); i > -1; i--) {
            if(this.digits[i] != 0 || flag){
                flag = true;
                if (this.digits[i] < 10)
                    bld.append(this.digits[i]);
                else
                    bld.append(hexChar[this.digits[i] - 10]);
            }
        }
        return bld.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BigIntegerCommon that = (BigIntegerCommon) o;

        if(that.digits.length > this.digits.length){
            this.digits = Arrays.copyOf(this.digits,that.digits.length);
        } else {
            that.digits = Arrays.copyOf(that.digits, this.digits.length);
        }

        return Arrays.equals(digits, that.digits);
    }

    @Override
    public int hashCode() {
        return digits != null ? Arrays.hashCode(digits) : 0;
    }


}