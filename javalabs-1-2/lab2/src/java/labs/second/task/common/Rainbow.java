package labs.second.task.common;

/**
 *
 * Created by TheCat on 18.01.2015.
 */
public interface Rainbow {

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
    public void shine();
}
