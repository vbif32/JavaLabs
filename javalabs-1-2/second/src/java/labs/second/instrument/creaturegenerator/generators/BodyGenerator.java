package labs.second.instrument.creaturegenerator.generators;

import labs.second.instrument.creaturegenerator.body.Body;
import labs.second.instrument.creaturegenerator.body.CreaturePart;

/**
 *
 * Created by thecat on 29.01.15.
 */
public class BodyGenerator extends AbstractCreaturePartGenerator{
    private static BodyGenerator ourInstance = new BodyGenerator();

    public static BodyGenerator getInstance() {
        return ourInstance;
    }

    private BodyGenerator() {
    }


    @Override
    public CreaturePart generate() {
        num++;
        return Body.values()[(int)(Math.random()*4)];
    }
}
