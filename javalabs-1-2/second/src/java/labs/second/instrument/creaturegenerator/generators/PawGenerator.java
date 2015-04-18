package labs.second.instrument.creaturegenerator.generators;

import labs.second.instrument.creaturegenerator.body.CreaturePart;
import labs.second.instrument.creaturegenerator.body.Paws;

/**
 *
 * Created by thecat on 29.01.15.
 */
public class PawGenerator extends AbstractCreaturePartGenerator {

    private static PawGenerator ourInstance = new PawGenerator();

    public static PawGenerator getInstance() {
        return ourInstance;
    }

    private PawGenerator() {
    }

    @Override
    public CreaturePart generate() {
        num++;
        return Paws.values()[(int)(Math.random()*4)];
    }
}
