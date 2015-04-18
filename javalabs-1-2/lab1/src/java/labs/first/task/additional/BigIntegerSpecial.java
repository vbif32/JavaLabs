package labs.first.task.additional;

import labs.Unit;
import labs.first.CommonNumeric;
import java.util.Arrays;

public class BigIntegerSpecial implements ExtensionNumeric, Unit{

    protected byte[] digits = new byte[10]; // массив целой части
    protected byte[] fraction = new byte[1];// массив дробной части
    protected boolean negative;             // знак
    protected boolean withPoint;            // точка дроби

    public BigIntegerSpecial() {
        for (int i = 0; i < digits.length; i++) {
            digits[i] = 0;
        }
    }

    public BigIntegerSpecial(byte[] digits) {
        this.digits = digits;
    }

    public BigIntegerSpecial(byte[] digits, boolean negative) {
        this(digits);
        this.negative = negative;
    }

    public BigIntegerSpecial(int number) {

        if (number < 0) {
            this.negative = true;
            number *= -1;
        }

        for (int i = 0; i < digits.length & number != 0; i++){
            digits[i] = (byte)(number % 100);
            number = number / 100;
        }
    }

    public BigIntegerSpecial(long number) {

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

    public BigIntegerSpecial(float number){
        int numberAfterPoint = 0;
        long tmp= (long)(number);
        /*
        целая часть хранится как раньше в обратном порядке, т.к. незначащие нули находятся в начале числа - конце массива
        дроная часть хранится в отдельном массиве в прямом порядке, т.к. незначащие нули находятся в конце числа,
         а конец массив подгоняется под конец числа
        */
        if ( number < 0)
        {
            this.negative = true;
            number *= -1;
        }

        for (int i = 0; number != (float)(0); i++) // делаем поступившее число целым и считаем количество чисел после запятой
        {
            number -= tmp % 10;
            numberAfterPoint = i+1;
            number *= 10;

            tmp *= 10;
            tmp += number % 10;
        }

        if (numberAfterPoint > 0) // заполняем массив дробной части
        {
            this.withPoint = true;
            if ( numberAfterPoint % 2 == 0)
            {
                this.fraction = Arrays.copyOf(this.fraction, numberAfterPoint / 2);
            }
            else
            {
                this.fraction = Arrays.copyOf(this.fraction, numberAfterPoint / 2 + 1);
            }

            for(int i = numberAfterPoint; i > 0; i--, i--)
            {
                if (numberAfterPoint % 2 !=0)
                {
                    this.fraction[i] = (byte)(number % 10);
                    number /= 10;
                    i--;
                }
                else // общий случай
                {
                    this.fraction[i] = (byte) (number % 100);
                    number /= 100;
                }
            }
        }

        for(int i = 0; number > 0; i++) // раскидываем целую часть числа по массиву
        {
            if (i == this.digits.length) // расширение массива при необходимости
            {
                this.digits = Arrays.copyOf(this.digits, this.digits.length+1);
            }
            this.fraction[i] = (byte) (number % 100);
            number /= 100;
        }

    }


    public BigIntegerSpecial add(BigIntegerSpecial bigIntegerSpecial) {
        int tmp; // требуется т.к. при сложении можно выйти за размер элемента массива

        if (bigIntegerSpecial.digits.length != this.digits.length)/*расширение целой части*/ {
            this.digits = Arrays.copyOf(this.digits, Math.max(this.digits.length, bigIntegerSpecial.digits.length));
        }
        if (bigIntegerSpecial.digits.length != this.digits.length)/*расширение дробной части*/ {
            this.digits = Arrays.copyOf(this.digits, Math.max(this.digits.length, bigIntegerSpecial.digits.length));
        }

        if (this.negative == bigIntegerSpecial.negative) /* если одного знака, то складываем сохраняя знак */ {
            if (withPoint) {
                for (int i = this.fraction.length; i > 0; i--) /* цикл дробной части*/ {
                    tmp = this.fraction[i] + bigIntegerSpecial.fraction[i];

                    if (tmp > 100) {
                        if (this.fraction.length == i - 1) {
                            this.digits[0] += (byte) (tmp / 100);
                        } else {
                            this.fraction[i - 1] += (byte) (this.fraction[i] / 100);
                        }
                    }
                    this.fraction[i] = (byte) (tmp % 100);
                }
            }
            for (int i = 0; i < this.digits.length; i++)/* цикл целой части*/  {
                tmp = this.digits[i] + bigIntegerSpecial.digits[i];

                if (tmp > 100) { // если сумма больше ста
                    if (this.digits.length == i+1)/*расширение массива*/ {
                        this.digits = Arrays.copyOf(this.digits, this.digits.length+1);
                        bigIntegerSpecial.digits = Arrays.copyOf(this.digits, this.digits.length+1);
                    }                              // перекидывание в след разряд
                    this.digits[i + 1] += (byte) (this.digits[i] / 100);
                    this.digits[i] = (byte) (this.digits[i] % 100);
                }
            }

            this.fractionOrder();
        }
        else /* иначе перенаправляем на вычитание*/  {
            bigIntegerSpecial.negative = !bigIntegerSpecial.negative;
            this.subtract(bigIntegerSpecial);
        }

        return this;
    }

    public BigIntegerSpecial subtract(BigIntegerSpecial bigIntegerSpecial) {

        if (bigIntegerSpecial.digits.length != this.digits.length)/*расширение целой части*/ {
            this.digits = Arrays.copyOf(this.digits, Math.max(this.digits.length, bigIntegerSpecial.digits.length));
        }
        if (bigIntegerSpecial.digits.length != this.digits.length)/*расширение дробной части*/ {
            this.digits = Arrays.copyOf(this.digits, Math.max(this.digits.length, bigIntegerSpecial.digits.length));
        }

        if (this.negative == bigIntegerSpecial.negative)/* если одного знака, то вычитаем*/ {
            if (withPoint){
                for (int i = 0; i < this.fraction.length; i++)/*цикл дробной части*/ {
                    if (this.fraction[i] < bigIntegerSpecial.fraction[i]) {

                        this.digits[0] += -1;
                        for (int j = 0; j <= i; j++) {
                            this.fraction[j] = 99;
                        }

                        for (int j = i; j >= 0; j--) {

                            this.fraction[j] = (byte) (bigIntegerSpecial.fraction[j] - this.fraction[j]);
                            if (this.fraction[j] < 0) {
                                this.fraction[j] += 100;
                                this.fraction[j - 1] += -1;
                            }
                        }

                        break;
                    } else if (this.fraction[i] > bigIntegerSpecial.fraction[i]) {

                        for (int j = i; j >= 0; j--) {

                            this.fraction[j] = (byte) (this.fraction[j] - bigIntegerSpecial.fraction[j]);
                            if (this.fraction[j] < 0) {
                                this.fraction[j] += 100;
                                this.fraction[j - 1] += -1;
                            }
                        }

                        break;
                    } else if (this.fraction[i] == bigIntegerSpecial.fraction[i]) {
                        this.fraction[i] = 0;
                        bigIntegerSpecial.fraction[i] = 0;
                    }
                }
            }
            for (int i = this.digits.length-1; i >= 0; i--)/*цикл целой части*/ {
                if (this.digits[i] < bigIntegerSpecial.digits[i]) {

                    this.negative = bigIntegerSpecial.negative;
                    for (int j = 0; j < digits.length; j++) {

                        this.digits[j] = (byte) (bigIntegerSpecial.digits[j] - this.digits[j]);
                        if (this.digits[j] < 0) {
                            this.digits[j] += 100;
                            this.digits[j + 1] += 1;
                        }
                    }

                    break;
                } else if (this.digits[i] > bigIntegerSpecial.digits[i]) {

                    for (int j = 0; j < digits.length; j++) {

                        this.digits[j] = (byte) (this.digits[j] - bigIntegerSpecial.digits[j]);
                        if (this.digits[j] < 0) {
                            this.digits[j] += 100;
                            this.digits[j + 1] += -1;
                        }
                    }

                    break;
                } else if (this.digits[i] == bigIntegerSpecial.digits[i]) {
                    this.digits[i] = 0;
                    bigIntegerSpecial.digits[i] = 0;
                }
            }
        }
        else /* иначе перенаправляем на сложение*/ {
            bigIntegerSpecial.negative = !bigIntegerSpecial.negative;
            this.add(bigIntegerSpecial);
        }

        return this;
    }

    public BigIntegerSpecial multiply(BigIntegerSpecial bigIntegerSpecial) {
        BigIntegerSpecial i;
        i = bigIntegerSpecial;

            for (; i.equals(0); i.subtract(1)) {
                    this.add(bigIntegerSpecial);
            }
        this.negative = (this.negative != bigIntegerSpecial.negative);
        return null;
    }

    public BigIntegerSpecial devide(BigIntegerSpecial bigIntegerSpecial) {
        BigIntegerSpecial tmp = new BigIntegerSpecial();
        boolean more = true;

        while (more){
            for (int i = this.digits.length-1; i >= 0; i--) {
                if (this.digits[i] > bigIntegerSpecial.digits[i]){
                    more = true;
                    this.subtract(bigIntegerSpecial);
                    tmp.add(1);
                    break;
                }
                else if (this.digits[i] > bigIntegerSpecial.digits[i]) {
                    more = false;
                    break;
                }
            }
        }
        tmp.negative = (this.negative != bigIntegerSpecial.negative);
        return tmp;
    }

    public BigIntegerSpecial factorial() {
        BigIntegerSpecial i = new BigIntegerSpecial();
        i.digits = Arrays.copyOf(i.digits, this.digits.length);

        BigIntegerSpecial result = new BigIntegerSpecial();
        result.digits = Arrays.copyOf(i.fraction, this.digits.length);

        result.withPoint = this.withPoint = false;

        for (; !i.digits.equals(this.digits); i.add(1)){
            result.multiply(this);
        }
        return result;
    }

    public boolean isFloat() {
        for (int i = 0; i < this.fraction.length; i++)
        {
            if (this.fraction[i] != 0)
                return true;
        }
        return false;
    }

    private void fractionOrder ()/*удаляет незначащие нули из дробной части*/ {
        int excessZeros =0;
        for (int i = this.fraction.length -1 ; this.fraction[i] != 0; i--) {
                excessZeros++;
        }
        this.fraction = Arrays.copyOf(this.fraction, this.fraction.length-excessZeros);

    }


    public BigIntegerSpecial add(int number) {
        this.add((long)(number));
        return this;
    }

    public BigIntegerSpecial add(long number) {

        if (this.negative == (number < 0)) {
            if (number < 0){
                number *= -1;
            }
            for (int i = 0; number > 0; i++) {
                this.digits[i] += number % 100;
                number = number / 100;

                if (this.digits[i] > 100) {
                    if (this.digits.length == i + 1) {
                        this.digits = Arrays.copyOf(this.digits, this.digits.length + 1);
                    }
                    this.digits[i + 1] += (byte) (this.digits[i] / 10);
                    this.digits[i] = (byte) (this.digits[i] % 10);
                }
            }
        } else {
            number = number * -1;
            this.subtract(number);
        }

        return this;
    }

    public BigIntegerSpecial subtract(int number) {
        this.subtract((long)(number));
        return this;
    }

    public BigIntegerSpecial subtract(long number) {

        if (this.negative == number < 0) {

            if (number < 0){
                number *= -1;
            }

            for (int i = this.digits.length-1; i >= 0; i--) {
                if (this.digits[i] < ((int)(number / Math.pow(100, i)))) {

                    this.negative = !this.negative;
                    for (int j = 0; j < digits.length; j++) {

                        this.digits[j] = (byte)(number % 100 - this.digits[j]);
                        number = number / 100;

                        if (this.digits[j] < 0) {
                            this.digits[j] += 100;
                            this.digits[j + 1] += 1;
                        }
                    }

                    break;
                } else if (this.digits[i] > ((long)(number / Math.pow(100, i)))) {
                    for (int j = 0; j < digits.length; j++) {
                        this.digits[j] = (byte) (this.digits[j] - Math.abs(number % 100));
                        number = number / 100;

                        if (this.digits[j] < 0) {
                            this.digits[j] += 100;
                            this.digits[j + 1] += -1;
                        }
                    }
                    break;
                } else if (i == 0) {
                    Arrays.fill(this.digits,(byte) 0);
                }
            }
        } else {
            number = number * -1;
            this.add(number);
        }

        return this;
    }

    public void testCommonFunctions() {
        System.out.println("Лабораторная работа №" + this.UnitNumber());
        System.out.println("Наименование группы: " + this.GroupNumber());
        System.out.println("Студент: " + this.FIO());
        System.out.println("Проверка функций add/subtract(int )");
        System.out.println("Проверка a " + (new BigIntegerSpecial((float)(3.1416))));
     /*   System.out.println("Проверка a - a = 0; " + (new BigIntegerSpecial(Integer.MAX_VALUE).subtract(new BigIntegerSpecial(Integer.MAX_VALUE)).equals(new BigIntegerSpecial()) ? "успешно" : "некорректно"));
        System.out.println("Проверка a + (- a) = 0; " + (new BigIntegerSpecial(Integer.MAX_VALUE).add(new BigIntegerSpecial(-Integer.MAX_VALUE)).equals(new BigIntegerSpecial()) ? "успешно" : "некорректно " + new BigIntegerSpecial(Integer.MAX_VALUE).subtract(new BigIntegerSpecial(-Integer.MAX_VALUE))));
        System.out.println("Проверка a + 0 = a; " + (new BigIntegerSpecial(Integer.MAX_VALUE).add(new BigIntegerSpecial()).equals(new BigIntegerSpecial(Integer.MAX_VALUE)) ? "успешно" : "некорректно " + new BigIntegerSpecial(Integer.MAX_VALUE).add(new BigIntegerSpecial())));
        System.out.println("Проверка 50 - 25 = " + (new BigIntegerSpecial(50).subtract(25))+ " " + (new BigIntegerSpecial(50).subtract(25).equals(new BigIntegerSpecial(25))));
        System.out.println("Проверка -50 - 25 = " + (new BigIntegerSpecial(-50).subtract(25)) +" "+(new BigIntegerSpecial(-50).subtract(25).equals(new BigIntegerSpecial(-75))));
        System.out.println("Проверка 50 - (-25) = " + (new BigIntegerSpecial(50).subtract(-25)) +" "+(new BigIntegerSpecial(50).subtract(-25).equals(new BigIntegerSpecial(75))));
        System.out.println("Проверка -50 - (-25) = " + (new BigIntegerSpecial(-50).subtract(-25)) +" "+(new BigIntegerSpecial(-50).subtract(-25).equals(new BigIntegerSpecial(-25))));
        System.out.println("Проверка -50 - (-25) = " + (new BigIntegerSpecial(12648430).subtract(0)));

        System.out.println("------------------------------------");
        System.out.println("Проверка функций add/subtract(long )");
        System.out.println("Проверка a - a = 0; " + (new BigIntegerSpecial(Long.MAX_VALUE).subtract(new BigIntegerSpecial(Long.MAX_VALUE)).equals(new BigIntegerSpecial()) ? "успешно" : "некорректно " + new BigIntegerSpecial(Long.MAX_VALUE).subtract(new BigIntegerSpecial(Long.MAX_VALUE))));
        System.out.println("Проверка a + a = 0; " + (new BigIntegerSpecial(Long.MAX_VALUE).add(new BigIntegerSpecial(Long.MAX_VALUE)).equals(new BigIntegerSpecial()) ? "успешно" : "некорректно " + new BigIntegerSpecial(Long.MAX_VALUE).subtract(new BigIntegerSpecial(Long.MAX_VALUE))));
        System.out.println("Проверка a + (- a) = 0; " + (new BigIntegerSpecial(Long.MAX_VALUE).add(new BigIntegerSpecial(-Long.MAX_VALUE)).equals(new BigIntegerSpecial()) ? "успешно" : "некорректно " + new BigIntegerSpecial(Long.MAX_VALUE).subtract(new BigIntegerSpecial(-Integer.MAX_VALUE))));
        System.out.println("Проверка a + 0 = a; " + (new BigIntegerSpecial(Long.MAX_VALUE).add(new BigIntegerSpecial()).equals(new BigIntegerSpecial(Long.MAX_VALUE)) ? "успешно" : "некорректно " + new BigIntegerSpecial(Long.MAX_VALUE).add(new BigIntegerSpecial())));
        System.out.println("Проверка 50 - 25 = " + (new BigIntegerSpecial(50L).subtract(25L))+ " " + (new BigIntegerSpecial(50L).subtract(25L).equals(new BigIntegerSpecial(25))));
        System.out.println("Проверка -50 - 25 = " + (new BigIntegerSpecial(-50).subtract(25L)) +" "+(new BigIntegerSpecial(-50).subtract(25L).equals(new BigIntegerSpecial(-75))));
        System.out.println("Проверка 50 - (-25) = " + (new BigIntegerSpecial(50).subtract(-25L)) +" "+(new BigIntegerSpecial(50).subtract(-25).equals(new BigIntegerSpecial(75))));
        System.out.println("Проверка -50 - (-25) = " + (new BigIntegerSpecial(-50L).subtract(-25)) +" "+(new BigIntegerSpecial(-50).subtract(-25L).equals(new BigIntegerSpecial(-25))));*/
    }

    public BigIntegerSpecial setNegative(boolean negative) {
        this.negative = negative;
        return this;
    }

    public int UnitNumber() {
        return 1;
    }

    @Override
    public String FIO() {
        return "Федин Михаил Андреевич";
    }

    @Override
    public String GroupNumber() {
        return "ИИБ-2-14";
    }

    public static void main(String[] args) {
        BigIntegerSpecial var4 = new BigIntegerSpecial();
        var4.testCommonFunctions();
    }

    public ExtensionNumeric add(CommonNumeric bigIntegerCommon) {
        return null;
    }
    public ExtensionNumeric subtract(CommonNumeric bigIntegerCommon) {
        return null;
    }
    public ExtensionNumeric multiply(CommonNumeric bigIntegerCommon) {
        return null;
    }
    public ExtensionNumeric devide(CommonNumeric bigIntegerCommon) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder bld = new StringBuilder();
        bld.append(this.negative ? "-" : "");
        boolean flag = false;
        for (int i = (this.digits.length - 1); i > -1; i--) {
            if(this.digits[i] != 0 || flag){
                flag = true;
                bld.append(this.digits[i]);
            }
        }
        if(withPoint){
            bld.append('.');
            for (int i = 0; i < this.fraction.length; i++){
                bld.append(this.fraction[i]);
            }

        }
        return bld.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BigIntegerSpecial that = (BigIntegerSpecial) o;

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
