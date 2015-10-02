public class Trie {
    private TrieNode root;

    public Trie()
    {
        root = new TrieNode();
    }

    public TrieNode getNode(String s)
    {
        TrieNode node = root;

        for(int i = 0; i < s.length(); i++)
        {
            int index = findIndex(s.charAt(i));

            
        }
    }

    /**
     * Finds index of the character in the array
     *
     * @param c character to look for
     * @return position in the array
     */
    private int findIndex(char c)
    {
        c = Character.toLowerCase(c);

        if(Character.isLetter(c))
        {
            return (int)c -  97;
        }
        else if(Character.isDigit(c))
        {
            return 25 + (int)c - 48;
        }
        else
        {
            switch(c)
            {
                case '!':
                    return 36;
                    break;

                case '@':
                    return 37;
                    break;

                case '$':
                    return 38;
                    break;

                case '%':
                    return 39;
                    break;

                case '&':
                    return 40;
                    break;

                case '*':
                    return 41;
                    break;
            }
        }
    }
}
