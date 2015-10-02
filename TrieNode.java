public class TrieNode {
    public TrieNode[] children;

    public TrieNode()
    {
        children = new TrieNode[42];

        for(int i = 0; i < 42; i++)
        {
            children[i] = null;
        }
    }
}
