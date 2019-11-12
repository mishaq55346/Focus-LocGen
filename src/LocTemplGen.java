import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LocTemplGen {
    LocTemplGen(){}

    static void write(String filename, String[] lines, String language) throws IOException {
        FileWriter nFile = new FileWriter(filename);
        nFile.write("l_"+language+":\n");
        for (int i = 0; i < lines.length; i++) {
            nFile.write(" " + lines[i] + ":0 \"\"\n");
            nFile.write(" " + lines[i] + "_desc:0 \"\"\n");
        }
        nFile.close();
    }
    static String[] read(String filename) throws IOException {
        String temp = "";
        FileReader fr = new FileReader(filename);
        Scanner sc = new Scanner(fr);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.replace(" ", "");
            line = line.replace("\t", "");
            if (line.contains("focus={") && !line.startsWith("#")){
                while(!line.contains("id")){
                    line = sc.nextLine();
                    line = line.replace(" ", "");
                }
                temp += (line + "\n");
            }
        }
        temp = temp.replace("\t", "");
        temp = temp.replace(" ", "");
        temp = temp.replace("id=", "");
        return temp.split("\n");
    }
}
