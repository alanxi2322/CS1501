import java.io.*;

public class pwcheck {
    public static final String DICTIONARY_FILE = "dictionary.txt";

    public static void main(String[] args) {
        boolean generatePasswords;

        if (args.length == 1 && args[0].equals("-g"))
            generatePasswords = true;
        else
            generatePasswords = false;

        // DLB Data structure
        Trie dlb = new Trie();

        // read file into the DLB
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(DICTIONARY_FILE)));
            String line = null;

            while ((line = reader.readLine()) != null) {
                if (line.length() > 0)
                    dlb.addWord(line.toLowerCase());
            }

        } catch (FileNotFoundException e) {
            System.out.println(DICTIONARY_FILE + " not found! exiting");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("Something went wrong and we have to exit! Sorry");
            System.exit(2);
        }

        dlb.showWords();

    }
}