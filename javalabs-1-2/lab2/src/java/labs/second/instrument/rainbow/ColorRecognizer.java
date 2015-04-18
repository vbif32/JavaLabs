package labs.second.instrument.rainbow;

/**
 *
 * Created by TheCat on 14.01.2015.
 */
public final class ColorRecognizer {

    public final void recognize(Color [] colors){
        for (Color color : colors) {
            System.out.println(color != null ? recognizeOne(color) : "Безцветный");
        }
    }

    String recognizeOne(Color color){
        if (color.blue == color.red && color.red == color.green) {
            if(color.red == 0)
                return "Черный "+ color;
            else
                return "Белый "+ color;
        } else if(color.red > 0 && color.blue == 0 && color.green == 0){
            return "Красный " + color;
        } else if (color.red == 0 && color.blue > 0 && color.green == 0){
            return "Синий " + color;
        } else if (color.red == 0 && color.blue == 0 && color.green > 0){
            return "Зеленый " + color;
        } else if ((color.red - color.green) == 1 && color.blue == 0){
            return "Оранжевый " + color;
        } else if (color.red == color.green && color.red != 0 && color.blue == 0){
            return "Желтый " + color;
        } else if ((color.blue - color.green) == 1 && color.red == 0) {
            return "Голубой "+ color;
        } else if ((color.blue == color.red) && color.green == 0) {
            return "Фиолетовый "+ color;
        }
        return "Ересь какая-то "+ color;
    }
}
