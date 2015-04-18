package labs.second.instrument.creaturegenerator.generators;

import labs.second.instrument.creaturegenerator.body.CreaturePart;

/**
 *
 * Created by thecat on 29.01.15.
 */
public abstract class AbstractCreaturePartGenerator {

    protected int num;
    public abstract CreaturePart generate();

    public int getNum() {
        return num;
    }
}
