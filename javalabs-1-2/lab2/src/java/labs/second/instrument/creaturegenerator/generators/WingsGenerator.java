package labs.second.instrument.creaturegenerator.generators;

import labs.second.instrument.creaturegenerator.body.CreaturePart;
import labs.second.instrument.creaturegenerator.body.Wings;

/**
 * Created by thecat on 29.01.15.
 */
public class WingsGenerator extends AbstractCreaturePartGenerator {
    private static WingsGenerator ourInstance = new WingsGenerator();

    public static WingsGenerator getInstance() {
        return ourInstance;
    }

    private WingsGenerator() {
    }

    @Override
    public CreaturePart generate() {
        num++;
        return Wings.values()[(int)(Math.random()*2)];
    }
}
