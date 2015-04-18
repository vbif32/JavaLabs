package labs.second.instrument.creaturegenerator;

import labs.second.instrument.creaturegenerator.body.*;

/**
 *
 * Created by thecat on 29.01.15.
 */
public class Creature {
    Body body = null;
    Head head = null;
    Paws paws = null;
    Tail tail = null;
    Wings wings = null;
    Horns horn = null;

    protected Creature(){}

    protected Creature(Body body, Head head, Paws paws, Tail tail, Wings wings, Horns horn) {
        this.body = body;
        this.head = head;
        this.paws = paws;
        this.tail = tail;
        this.wings = wings;
        this.horn = horn;
    }

    public static Creature UNICORN = new Creature(Body.HORSE,Head.HORSE,Paws.HORSE,Tail.HORSE,null,Horns.Uniue);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Creature)) return false;

        Creature creature = (Creature) o;

        if (body != creature.body) return false;
        if (head != creature.head) return false;
        if (horn != creature.horn) return false;
        if (paws != creature.paws) return false;
        if (tail != creature.tail) return false;
        if (wings != creature.wings) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = body != null ? body.hashCode() : 0;
        result = 31 * result + (head != null ? head.hashCode() : 0);
        result = 31 * result + (paws != null ? paws.hashCode() : 0);
        result = 31 * result + (tail != null ? tail.hashCode() : 0);
        result = 31 * result + (wings != null ? wings.hashCode() : 0);
        result = 31 * result + (horn != null ? horn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "body=" + body +
                ", head=" + head +
                ", paws=" + paws +
                ", tail=" + tail +
                ", wings=" + wings +
                ", horn=" + horn +
                '}';
    }
}
