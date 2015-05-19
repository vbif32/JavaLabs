package five.task;

import sun.management.Agent;

import java.io.File;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;

public class lab5Ex {

    /** Creates a new instance of Main */
    public lab5Ex() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            Field f = Class.forName("Agent").getField("instrumentation");
            Instrumentation i = (Instrumentation) f.get(null);
            Class c[] = i.getAllLoadedClasses();
            System.out.println("test Ints : " + c[0].getName());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


