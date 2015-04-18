package labs.second.instrument.rainbow;

/**
 *
 * Created by TheCat on 13.01.2015.
 */
public final class Mixer {
    /**
     * Смешивает цвета и возвращает результат
     * @param colors список смешавымаех цветов
     * @return полученный цвет
     */
    public Color mix(Color... colors){
        /**
         * !!! Так писать не надо !!!
         */
        return colors.length == 1 ? new Color(colors[0]) : colors.length == 2 ? new Color(colors[0],colors[1]): colors.length == 3 ? new Color(colors[0],colors[1],colors[2]) : new Color(Color.RED,Color.GREEN,Color.BLUE);
    }
}
