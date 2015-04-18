package labs.second.instrument.creaturegenerator.generators;

import labs.second.instrument.creaturegenerator.body.CreaturePart;
import labs.second.instrument.creaturegenerator.body.Head;

/**
 *
 * Created by thecat on 29.01.15.
 */
public class HeadGenerator extends AbstractCreaturePartGenerator {
    private static HeadGenerator ourInstance = new HeadGenerator();

    public static HeadGenerator getInstance() {
        return ourInstance;
    }

    private HeadGenerator() {
    }

    @Override
    public CreaturePart generate() {
        num++;
        return Head.values()[(int)(Math.random()*4)];
    }
}
