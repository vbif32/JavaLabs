package labs.second.task.common;

import labs.second.instrument.creaturegenerator.Creature;
import labs.second.instrument.creaturegenerator.CreatureCounters;
import labs.second.instrument.rainbow.RainbowShine;
/**
 *
 * Created by Dartaan on 09.03.2015.
 */
public class Lab2Common {

    public static void main(String[] args) {


        System.out.println("Лабораторная работа №" + new RainbowShine().UnitNumber());
        System.out.println("Наименование группы: " + new RainbowShine().GroupNumber());
        System.out.println("Студент: " + new RainbowShine().FIO());
        System.out.println("---------------------------------");
        new RainbowShine().shine();
        Creature[] creatures = new CreatureCounters().generateCreatures();
        System.out.println("Количество единорогов: " + new CreatureCounters().countUnicorn(creatures));
        System.out.println("Количество людей: " + new CreatureCounters().countHuman(creatures));
        System.out.println("Количество грифонов: " + new CreatureCounters().countGriffins(creatures));
    }
}
