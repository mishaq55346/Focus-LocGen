import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        GenerateLocal();
    }

    static void GenerateLocal(){
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File directory, String fileName) {
                return fileName.endsWith(".txt");
            }
        };

        File inputDir = new File("input/");
        File outputDir = new File("output/");
        String[] inputNames = inputDir.list();
        print(inputNames);
        System.out.println("-------------------------");

        String[] temp;

        for (int i = 0; i < inputNames.length; i++) {
            try {
                temp = LocTemplGen.read(inputDir + "/" + inputNames[i]);
                LocTemplGen.write(outputDir + "/" + inputNames[i].replace(".txt", "") + "_focus_l_russian.yml", temp, "russian");
                LocTemplGen.write(outputDir + "/" + inputNames[i].replace(".txt", "") + "_focus_l_english.yml", temp, "english");
                System.out.println(outputDir + "/" + inputNames[i].replace(".txt", "") + "_focus_l_russian.yml file created");
                System.out.println(outputDir + "/" + inputNames[i].replace(".txt", "") + "_focus_l_english.yml file created");
                System.out.println("--------------------------------------------------");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    static void print(String[] mas){
        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i]);
        }

    }
}

