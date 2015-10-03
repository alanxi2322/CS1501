import java.io.*;

public class pwcheck {
    public static final String DICTIONARY_FILE = "dictionary.txt";
    public static final String MY_DICTIONARY_FILE = "my_dictionary.txt";
    public static final String GOOD_PASSWORDS_FILE = "good_passwords.txt";
    public static final String allowedCharacters = "abcdefghijklmnopqrstuvwxyz!@$%&*";

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

        try {
            if (generatePasswords == true) {
                // write full list of words to text file
                File file = new File(MY_DICTIONARY_FILE);

                // create file if needed
                if (!file.exists())
                    file.createNewFile();

                BufferedWriter writer = new BufferedWriter((new FileWriter(file.getAbsoluteFile())));

                writer.write(dlb.getWords());
                writer.close();
            }

            // find all good passwords
            String goodPasswords = "";

        }
        catch (Exception e)
        {
            System.out.println("Some exception occured: " + e.getMessage());
        }
    }
}