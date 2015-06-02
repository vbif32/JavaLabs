package labs.second.task.additional;


/**
 * Created by Dartaan on 02.06.2015.
 */
public class Dragon {

    Properties properties;

    protected Dragon(){
        properties = new Properties();
    }

    protected Dragon(Properties exProperties) {
        properties = exProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dragon)) return false;

        Dragon dragon = (Dragon) o;

        if (this.properties == dragon.properties)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Dragon:\n" + properties.toString() + "}";
    }
}