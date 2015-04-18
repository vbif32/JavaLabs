package labs.second.instrument.creaturegenerator;


import labs.second.instrument.creaturegenerator.body.*;
import labs.second.instrument.creaturegenerator.generators.*;

/**
 *
 * Created by thecat on 29.01.15.
 */
public class CreatureGenerator {

    int num = 0;

    private CreatureGenerator(){

    }

    private static class CreatureGeneratorHolder{
        private static CreatureGenerator instance = new CreatureGenerator();
    }

    public static CreatureGenerator getInstance() {
        return CreatureGeneratorHolder.instance;
    }

    private Creature generateOne(){
        num++;
        Body body = (Body)BodyGenerator.getInstance().generate();
        Head head = (Head)HeadGenerator.getInstance().generate();
        Paws paws = (Paws)PawGenerator.getInstance().generate();
        Tail tail = Math.round(Math.random()) == 1 ? (Tail)TailGenerator.getInstance().generate() : null;
        Wings wings = Math.round(Math.random()) == 1 ? (Wings) WingsGenerator.getInstance().generate() : null;
        Hornes hornes = Math.round(Math.random()) == 1 ? (Hornes)HornGenerator.getInstance().generate() : null;
        return new Creature(body,head,paws,tail,wings,hornes);
    }

    public Creature [] generate(int number){
        Creature [] creatures = new Creature[number];
        for (int i = 0; i < number ; i++) {
            creatures[i] = generateOne();
        }
        creatures[999] = Creature.UNICORN;
        return creatures;
    }

}
