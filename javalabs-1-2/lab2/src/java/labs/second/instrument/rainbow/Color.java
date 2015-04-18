package labs.second.instrument.rainbow;

/**
 *
 * Created by TheCat on 13.01.2015.
 */
public final class Color {

    int red;
    int green;
    int blue;

    private Color(int r, int g, int b){
        this.red = r;
        this.green = g;
        this.blue = b;
        System.out.println(new ColorRecognizer().recognizeOne(this));
    }

    Color(Color first) {
        this.red = first.red;
        this.green = first.green;
        this.blue = first.blue;
        System.out.println(new ColorRecognizer().recognizeOne(this));
    }

    Color(Color first, Color second) {
        this.red = first.red + second.red;
        this.green = first.green + second.green;
        this.blue = first.blue + second.blue;
        System.out.println(new ColorRecognizer().recognizeOne(this));
    }

    Color(Color first, Color second, Color third) {
        this.red = first.red + second.red + third.red;
        this.green = first.green + second.green + third.green;
        this.blue = first.blue + second.blue + third.blue;
        System.out.println(new ColorRecognizer().recognizeOne(this));
    }

    public static Color RED = new Color(1,0,0);
    public static Color GREEN = new Color(0,1,0);
    public static Color BLUE = new Color(0,0,1);

}
