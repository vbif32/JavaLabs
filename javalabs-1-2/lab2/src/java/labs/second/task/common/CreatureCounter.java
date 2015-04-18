package labs.second.task.common;

import labs.second.instrument.creaturegenerator.Creature;

/**
 *
 * Общий класс для второй лабораторной работы
 */
public interface CreatureCounter {

    /**
     * Вызывает генератор существ
     * @see labs.second.instrument.creaturegenerator.CreatureGenerator
     * @return массив различных существ
     */
    public Creature [] generateCreatures();

    /**
     * Подсчитывает количество Единорогов
     * @see labs.second.instrument.creaturegenerator.Creature#UNICORN
     * @param creatures массив существ
     * @return количество искомых существ в выборке
     */
    public int countUnicorn(Creature[] creatures);

    /**
     * Подсчитывает количество Людей(голова человека, туловище человека, лапы человека, хвоста, крыльев и рогов нет)
     * @param creatures массив существ
     * @return количество искомых существ в выборке
     */
    public int countHuman(Creature[] creatures);

    /**
     * Подсчитывает количество Гриффонов(голова орла, крылья орла, лапы, туловище и хвост льва)
     * @param creatures массив существ
     * @return количество искомых существ в выборке
     */
    public int countGriffins(Creature[] creatures);

}
