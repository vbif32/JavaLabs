package five.task;

import sdc.jloader.JLoader;
import simplelogger.SimpleLogger;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by Dartaan on 16.05.2015.
 */
public class Lab5ForJar extends Lab5Common {

    private static String res_name = "five/libs/variants/";

    public static File streamIntoFile(InputStream input, String name) throws IOException {
        byte[] buffer = new byte[input.available()];
        input.read(buffer);

        File targetFile = new File("TMP" + name);
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);
        outStream.close();
        return targetFile;
    }

    public static void main(String[] arg) throws IOException {

        File fileForJLoader;
        JLoader testJLoader = new JLoader();
        Lab5ForJar object = new Lab5ForJar();

        SimpleLogger.logMessage("Start", (byte)0);
        URL u = Lab5ForJar.class.getResource("/"+res_name);
        String fileName = u.toString();

        fileName = fileName.substring(fileName.indexOf("file:")+5, fileName.indexOf("!"));

        JarFile jf = new JarFile(fileName);
        List<String> names = new LinkedList<String>();

        // Заполняем массив names именами, которые лежат в папке
        for(Enumeration<JarEntry> en = jf.entries(); en.hasMoreElements(); ){
            JarEntry je = en.nextElement();
            String name = je.getName();
            if (name.startsWith(res_name) && !je.isDirectory())
                names.add(name.substring(res_name.length()));
        }

        for(String name : names){
            SimpleLogger.logMessage(name, (byte)0);

            fileForJLoader = streamIntoFile(Lab5ForJar.class.getResourceAsStream(res_name + name), name);

            // OutputStream os = new FileOutputStream(fileForJLoader);
            List jarContent = testJLoader.loadJar(fileForJLoader, true);
            // os.close();

            SimpleLogger.logMessage("==========================\n\n", (byte)0);

            for(int i = 0; i < jarContent.size(); ++i) {
                object.printClass((Class) jarContent.get(i));
            }
            SimpleLogger.logMessage(name + " Удален: " + fileForJLoader.delete(), (byte) 0);
            SimpleLogger.logMessage("==--==--==--==--==--==\n\n\n\n", (byte)0);
        }
    }
}