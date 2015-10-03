public class Trie {
    private TrieNode root;
    private String myDictionary;
    public String allowedCharacters;

    public Trie() {
        root = new TrieNode();
        allowedCharacters = "abcdefghijklmnopqrstuvwxyz!@$%&*";
    }

    public TrieNode getNode(String s) {
        TrieNode node = root;

        for (int i = 0; i < s.length(); i++) {
            int index = findIndex(s.charAt(i));

            if (index == -1)
                return null;

            node = root.children[index];
        }

        return node;
    }

    public void addWord(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            int index = allowedCharacters.indexOf(word.charAt(i));

            if (index == -1) {
                System.out.println("Invalid character in dictionary.txt! Exiting");
                System.exit(3);
            }

            if (node.children[index] == null)
                node.children[index] = new TrieNode();

            node = node.children[index];
        }

        node.isWord = true;
    }

    public String getWords() {
        myDictionary = "";
        getWords(root, myDictionary);

        return myDictionary;
    }

    private void getWords(TrieNode node, String prefix) {
        if (node == null)
            return;

        for (int i = 0; i < 42; i++) {
            if (node.children[i] != null) {
                if (node.children[i].isWord == true) {
                    myDictionary += prefix;
                    //System.out.print(prefix);
                    myDictionary += allowedCharacters.charAt(i);
                    //System.out.print(allowedCharacters.charAt(i));
                    myDictionary += "\n";
                    //System.out.println("");
                }
                getWords(node.children[i], prefix + allowedCharacters.charAt(i));
            }
        }
    }

    /**
     * Finds index of the character in the array
     *
     * @param c character to look for
     * @return position in the array
     * or -1 in invalid character
     */
    private int findIndex(char c) {
        c = Character.toLowerCase(c);

        if (Character.isLetter(c)) {
            return (int) c - 97;
        } else if (Character.isDigit(c)) {
            return 25 + (int) c - 48;
        } else {
            switch (c) {
                case '!':
                    return 36;

                case '@':
                    return 37;

                case '$':
                    return 38;

                case '%':
                    return 39;

                case '&':
                    return 40;

                case '*':
                    return 41;
            }
        }

        // invalid character
        return -1;
    }
}
