package labs.second.task.variant2;

import labs.second.task.variant2.body.*;
/**
 * Created by Dartaan on 09.03.2015.
 */
public class Dragon {
    Color color = null;
    Size size = null;
    Head head = null;
    Tail tail = null;
    Wings wings = null;
    boolean isEgg = true;

    protected Dragon(){}

    protected Dragon(Color color, Size size, Head head, Tail tail, Wings wings) {
        this.color = color;
        this.size = size;
        this.head = head;
        this.tail = tail;
        this.wings = wings;
        this.isEgg = true;

    }

    public static Dragon RATHIAN = new Dragon(Color.GREEN, Size.SMALL, Head.ONE, Tail.SPIKE, Wings.LEATHER);
    public static Dragon RATHALOS = new Dragon(Color.RED, Size.MEDIUM, Head.TWO, Tail.SPIKE, Wings.LEATHER);
    public static Dragon DEATHWING = new Dragon(Color.BLACK, Size.BIG, Head.THREE, Tail.MACE, Wings.SCALY);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dragon)) return false;

        Dragon creature = (Dragon) o;

        if (color != creature.color) return false;
        if (size != creature.size) return false;
        if (head != creature.head) return false;
        if (tail != creature.tail) return false;
        if (wings != creature.wings) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (head != null ? head.hashCode() : 0);
        result = 31 * result + (tail != null ? tail.hashCode() : 0);
        result = 31 * result + (wings != null ? wings.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "color=" + color +
                ", size=" + size +
                ", head=" + head +
                ", tail=" + tail +
                ", wings=" + wings +
                '}';
    }
}
