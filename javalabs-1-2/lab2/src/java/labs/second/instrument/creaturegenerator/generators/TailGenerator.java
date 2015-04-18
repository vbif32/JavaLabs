package labs.second.instrument.creaturegenerator.generators;

import labs.second.instrument.creaturegenerator.body.CreaturePart;
import labs.second.instrument.creaturegenerator.body.Tail;

/**
 * Created by thecat on 29.01.15.
 */
public class TailGenerator extends AbstractCreaturePartGenerator {
    private static TailGenerator ourInstance = new TailGenerator();

    public static TailGenerator getInstance() {
        return ourInstance;
    }

    private TailGenerator() {
    }

    @Override
    public CreaturePart generate() {
        num++;
        return Tail.values()[(int)(Math.random()*3)];
    }

}

