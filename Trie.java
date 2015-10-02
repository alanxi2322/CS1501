public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
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
            int index = findIndex(word.charAt(i));

            if(index == -1)
            {
                System.out.println("Invalid character in dictionary.txt! Exiting");
                System.exit(3);
            }

            if(node.children[index] == null)
                node.children[index] = new TrieNode();

            node = node.children[index];
        }

        node.isWord = true;
    }

    public void showWords()
    {
        TrieNode node = root;

        for(int i = 0; i < 42; i++)
        {
            //if(node.children[i] != null)
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
