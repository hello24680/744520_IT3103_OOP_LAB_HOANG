package soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "src/hust/soict/hedspi/garbage/test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();

        //su dung string thong thuong
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b;
        }

        /*
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        */

        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
