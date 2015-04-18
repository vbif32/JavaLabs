package labs.second.instrument.creaturegenerator;

import labs.second.instrument.creaturegenerator.body.*;
import labs.second.task.common.CreatureCounter;

/**
 * Created by Dartaan on 09.03.2015.
 */



public class CreatureCounters implements CreatureCounter {

    public static Creature HUMAN = new Creature(Body.HUMAN,Head.HUMAN,Paws.HUMAN,null,null,null);
    public static Creature GRIFFIN = new Creature(Body.LION,Head.EAGLE,Paws.LION,Tail.LION,Wings.EAGLE,null);

    /**
     * Вызывает генератор существ
     *
     * @return массив различных существ
     * @see labs.second.instrument.creaturegenerator.CreatureGenerator
     */
    public Creature[] generateCreatures() {

        Creature[] creatures = new CreatureGenerator().generate(1000000);
        return creatures;
    }

    /**
     * Подсчитывает количество Единорогов
     *
     * @param creatures массив существ
     * @return количество искомых существ в выборке
     * @see labs.second.instrument.creaturegenerator.Creature#UNICORN
     */
    public int countUnicorn(Creature[] creatures) {
        int counter = 0;
        for (int i = 0; i < creatures.length; i++) {
            if (creatures[i].equals(Creature.UNICORN)){
                    counter++;
            }
        }
        return counter;
    }

    /**
     * Подсчитывает количество Людей(голова человека, туловище человека, лапы человека, хвоста, крыльев и рогов нет)
     *
     * @param creatures массив существ
     * @return количество искомых существ в выборке
     */
    public int countHuman(Creature[] creatures) {
        int counter = 0;
        for (int i = 0; i < creatures.length; i++) {
            if (creatures[i].equals(HUMAN)){
                    counter++;
            }
        }
        return counter;
    }

    /**
     * Подсчитывает количество Гриффонов(голова орла, крылья орла, лапы, туловище и хвост льва)
     *
     * @param creatures массив существ
     * @return количество искомых существ в выборке
     */
    public int countGriffins(Creature[] creatures) {
        int counter = 0;
        for (int i = 0; i < creatures.length; i++) {
            if (creatures[i].equals(GRIFFIN)){
                    counter++;
            }
        }
        return counter;
    }
}

