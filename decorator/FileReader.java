package decorator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReader {

   
    private static File resolve(String fileName) {
        System.out.println("--- Searching for: " + fileName);
        System.out.println("    Working dir:   " + new File(".").getAbsolutePath());

        
        File f = new File(fileName);
        System.out.println("    Try 1: " + f.getAbsolutePath() + " → " + f.exists());
        if (f.exists()) return f;

        
        f = new File("decorator", fileName);
        System.out.println("    Try 2: " + f.getAbsolutePath() + " → " + f.exists());
        if (f.exists()) return f;

        
        File classDir = new File(FileReader.class.getProtectionDomain()
                .getCodeSource().getLocation().getFile());
        System.out.println("    Class location: " + classDir.getAbsolutePath());

        f = new File(classDir, fileName);
        System.out.println("    Try 3: " + f.getAbsolutePath() + " → " + f.exists());
        if (f.exists()) return f;

        f = new File(classDir, "decorator/" + fileName);
        System.out.println("    Try 4: " + f.getAbsolutePath() + " → " + f.exists());
        if (f.exists()) return f;

       
        return new File(fileName);
    }

    public static ArrayList<String> getLines(String fileName) {
        ArrayList<String> lines = new ArrayList<>();
        File file = resolve(fileName);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            System.err.println("Error reading file.");
            e.printStackTrace();
        }
        return lines;
    }
}