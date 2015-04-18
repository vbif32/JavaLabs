package labs.second.instrument.creaturegenerator.generators;

import labs.second.instrument.creaturegenerator.body.CreaturePart;
import labs.second.instrument.creaturegenerator.body.Horns;

/**
 *
 * Created by thecat on 29.01.15.
 */
public class HornGenerator extends AbstractCreaturePartGenerator {
    private static HornGenerator ourInstance = new HornGenerator();

    public static HornGenerator getInstance() {
        return ourInstance;
    }

    private HornGenerator() {
    }

    @Override
    public CreaturePart generate() {
        num++;
        return Horns.values()[(int)Math.round(Math.random())];
    }
}
