public class TrieNode {
    public TrieNode[] children;
    public boolean isWord;

    public TrieNode()
    {
        // create children references
        children = new TrieNode[42];

        // clear word terminator flag
        isWord = false;

        // assign null
        for(int i = 0; i < 42; i++)
        {
            children[i] = null;
        }
    }
}
