import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
        FontsFactory factory = new FontsFactory();

        Fonts font1 = factory.getFonts("Arial-Red-12");
        Fonts font2 = factory.getFonts("Calibri-Blue-14");
        Fonts font3 = factory.getFonts("Verdana-Black-16");
        Fonts font4 = factory.getFonts("Arial-Blue-14");

        String text = "HelloWorldCS3560";
        List<CharacterNode> document = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            Fonts assignedFont;

            if (i <= 3) {
                assignedFont = font1;   // "Hell"
            } else if (i <= 7) {
                assignedFont = font2;   // "oWor"
            } else if (i <= 11) {
                assignedFont = font3;   // "ldCS"
            } else {
                assignedFont = font4;   // "3560"
            }
            document.add(new CharacterNode(c, assignedFont));
        } // end for loop

        String fileName = "document.txt";
        saveDocument(document, fileName);
        System.out.println("Document saved to " + fileName);

        System.out.println("\nLoading document from disk...");
        loadDocument(fileName);


    } // end main

    private static void saveDocument(List<CharacterNode> document, String fileName) {
        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (CharacterNode node : document) {
                writer.println(node.getCharacter() +
                        "," + node.getStyle().getName() +
                        "," + node.getStyle().getColor() +
                        "," + node.getStyle().getSize());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // end saveDocument

    private static void loadDocument(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            FontsFactory factory = new FontsFactory();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                char c = parts[0].charAt(0); // Takes each character one by one
                String fontKey = parts[1] + "-" + parts[2] + "-" + parts[3];
                Fonts style = factory.getFonts(fontKey);

                System.out.println("Loaded Char: " + c + " | Style: " + fontKey);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // end loadDocument
} // end Driver
