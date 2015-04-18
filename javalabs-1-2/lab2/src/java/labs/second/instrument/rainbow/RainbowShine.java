package labs.second.instrument.rainbow;

import labs.Unit;
import labs.second.task.common.Rainbow;
/**
 * Created by Dartaan on 09.03.2015.
 */
public class RainbowShine implements Unit, Rainbow  {

    /**
     * Вызов функции выводит в консоль все цвета радуги в правильном порядке
     * Каждый цвет описан в виде: Название Имя класса Color @ hashcode
     * Пример:
     * Красный labs.second.instrument.rainbow.Color@17b68215
     Оранжевый labs.second.instrument.rainbow.Color@28084850
     Желтый labs.second.instrument.rainbow.Color@37c390b8
     Зеленый labs.second.instrument.rainbow.Color@4f163cdc
     Голубой labs.second.instrument.rainbow.Color@8523ca2
     Синий labs.second.instrument.rainbow.Color@3cf5b814
     Фиолетовый labs.second.instrument.rainbow.Color@4f0ab3f2
     hashcode каждого из цветов может отличаться от примера
     * Класс Color находится здесь:
     * @see labs.second.instrument.rainbow.Color
     */

    public void shine() {

        new Color(Color.RED);                           //Красный
        new Color(Color.RED, Color.RED, Color.GREEN);   //Оранжевый
        new Color(Color.RED, Color.GREEN);              //Желтый
        new Color(Color.GREEN);                         //Зеленый
        new Color(Color.BLUE, Color.BLUE, Color.GREEN); //Голубой
        new Color(Color.BLUE);                          //Синий
        new Color(Color.RED,Color.BLUE);              //Фиолетовый
    }

    public int UnitNumber() {
        return 2;
    }

    @Override
    public String FIO() {
        return "Федин Михаил Андреевич";
    }

    @Override
    public String GroupNumber() {
        return "ИИБ-2-14";
    }

}
