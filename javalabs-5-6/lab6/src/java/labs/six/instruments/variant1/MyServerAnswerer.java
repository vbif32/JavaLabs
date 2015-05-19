package labs.six.instruments.variant1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.*;

public class MyServerAnswerer implements ServerAnswerer {


    private static String commonFolder = "javalabs-5-6\\lab6\\pages\\";

    private static Pattern patternRequestedHtmlFile = Pattern.compile("/[^/]+\\.html");
    private static String patternLocalhost = "Host: localhost";

    @Override
    public void askMe(StringBuilder query, OutputStream writeMe) throws IOException {

        Path FilePath;
        Matcher matcherFilename = patternRequestedHtmlFile.matcher(query);

        if (query.toString().contains(patternLocalhost)) {
            if (matcherFilename.find()) {
                FilePath = Paths.get(
                        commonFolder +
                                query.substring(matcherFilename.start() + 1, matcherFilename.end())
                );
                writeMe.write(Files.readAllBytes(FilePath));
            } else
                writeMe.write("404 File not found.".getBytes());
        }
    }

    public static void main(String[] args) {
        WebListener test = new WebListener(new MyServerAnswerer());
        test.startListen();
    }
}
