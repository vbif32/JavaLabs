package labs.first.task.variant4;

import labs.first.task.common.BigIntegerCommon;
import java.util.Arrays;



/**
 *
 * Fourth class for the first lab
 */
public class BigIntegerVariant4 extends BigIntegerCommon {

    public BigIntegerVariant4() {
        super();
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
        
        int answerIndex = 0;
        BigIntegerVariant4 answer = new BigIntegerVariant4();
        answer.negative = this.negative;
        answer.digits = Arrays.copyOf(answer.digits, this.digits.length);
        Arrays.fill(answer.digits,(byte)(-1));

        while(answer.digits[8] == -1 | answer.digits[8] == -1 ){
            this.longDivision(16);
            answer.digits[answerIndex] =  this.digits[(this.digits.length - 1)];
            this.digits[(this.digits.length - 1)] = 0;
            answerIndex++;
        }

        for (int i = 0; i < answer.digits.length; i++){
            if (answer.digits[i] == -1) answer.digits[i] = 0;
        }

        return answer;
    }

    public BigIntegerVariant4 longDivision(int divider) {

        byte modulo = 0;
        boolean firstNumberFound = false;
        boolean firstEterationEnd = false;
        int tmp = 0;
        int resultIndex = 0;

        BigIntegerVariant4 result = new BigIntegerVariant4();
        result.digits = Arrays.copyOf(result.digits, this.digits.length);
        Arrays.fill(result.digits,(byte)(-1));

            for (int i = (this.digits.length - 1); i >= 0;) {

                if (this.digits[i] != 0) firstNumberFound = true;

                if (firstNumberFound) {
                    for ( int j = 0; tmp < divider & i >= 0; j++) {

                        if ( j >= 1 & tmp < divider & firstEterationEnd ){
                            result.digits[resultIndex] = 0;
                            resultIndex++;
                        }
                        tmp = 10 * tmp + this.digits[i];
                       /* if (i < 1) break;
                        else*/ i--;}

                    if ((i >= 0) | (tmp > 15)) {
                        result.digits[resultIndex] = (byte) (tmp / divider);
                        tmp %= divider;
                        resultIndex++;

                        if (i == 0 & tmp==0) {
                            result.digits[resultIndex] = 0;
                            resultIndex++;}
                    }
                    firstEterationEnd = true;
                } else i--;

                if (i < 0) {
                    modulo = (byte) (tmp);
                    i--;
                }

            }


        firstNumberFound = false;
        Arrays.fill(this.digits, (byte) (0));

        for (int i = 0, j = 0; j < this.digits.length; ) {

            if (result.digits[this.digits.length - 1 - j] != (-1))
                firstNumberFound = true;

            if (firstNumberFound) {
                this.digits[i] = result.digits[this.digits.length - 1 - j];
                i++; }

            j++;
        }

        this.digits[this.digits.length - 1] = modulo;
        return this;
    }



    /**
     * Преобразовывает переданное число в BigInteger, представленное в шестнадцатеричном виде
     * @param num целое число
     * @return число представленное в двоичном виде
     */
    public BigIntegerVariant4 convertToHex(int num){
        if (num < 0) {
            this.negative = true;
            num *= -1;
        }

        for (int i = 0; num != 0; i++) {
            this.digits[i] = (byte)(num % 16);
            num /= 16;}

        return this;
    }

    public BigIntegerVariant4 convertToHex(long num){
        if (num < 0) {
            this.negative = true;
            Math.abs(num);
        }

        for (int i = 0; num != 0; i++) {

            if (this.digits.length == i+1)
                this.digits = Arrays.copyOf(this.digits, this.digits.length+1);

            this.digits[i] = (byte)( num % 16);
            num /= 16;}

        return this;
    }

    @Override
    public void testCommonFunctions() {
        super.testCommonFunctions();

        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("Проверка int to hex; " + (new BigIntegerVariant4(Integer.MAX_VALUE).convertToHex().toString()));
        System.out.println("Проверка -int to hex; " + (new BigIntegerVariant4(-Integer.MAX_VALUE).convertToHex().toString()));
        System.out.println("Проверка long to hex; " + (new BigIntegerVariant4(Long.MAX_VALUE).convertToHex().toString()));
        System.out.println("Проверка 256 to hex; " + (new BigIntegerVariant4(256).convertToHex().toString()));
        System.out.println("Проверка -129 to hex; " + (new BigIntegerVariant4(-129).convertToHex().toString()));
        System.out.println("Проверка Integer.MAX_VALUE to hex; " + (new BigIntegerVariant4().convertToHex(Integer.MAX_VALUE).toString()));
        System.out.println("Проверка Long.MAX_VALUE to hex; " + (new BigIntegerVariant4().convertToHex(Long.MAX_VALUE).toString()));

        System.out.println("Проверка 202374880 to hex; " + (new BigIntegerVariant4().convertToHex(202374880).toString()));
        System.out.println("Проверка -11325013 to hex " + (new BigIntegerVariant4().convertToHex(-11325013).toString()));
    }

    public static void main(String[] args) {
        BigIntegerVariant4 var4 = new BigIntegerVariant4();
        var4.testCommonFunctions();
    }
}
