package labs.six.instruments.variant1;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * Created by thecat on 16.05.15.
 */
public interface ServerAnswerer {

    /**
     * Записывает ответ на запрос клиента (из браузера)
     * @param query запрос
     * @param writeMe поток в который записывается ответ (файл с необходимой страницей)
     */
    public void askMe(StringBuilder query, OutputStream writeMe) throws IOException;
}
