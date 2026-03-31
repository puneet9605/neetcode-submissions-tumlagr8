class Node {
    char c;
    boolean end;
    Map<Character, Node> next;
    Node(char c){
        this.c = c;
        next = new HashMap<>();
    }
}
class PrefixTree {
    Map<Character, Node> root;


    public PrefixTree() {
       root = new HashMap<>();
    }

    public void insert(String word) {
        buildTree(root, word, 0);
    }

    public boolean search(String word) {
        return dfs(root, word,true,0);

    }

    public boolean startsWith(String prefix) {
        return dfs(root, prefix, false,0);

    }

    public void buildTree(Map<Character, Node> root,String word,int i){
        Node node;
        if (root.containsKey(word.charAt(i))){
            node = root.get(word.charAt(i));

        }
        else {
            node =new Node(word.charAt(i));
            root.put(word.charAt(i), node);
        }
        if(i==word.length()-1){
            node.end = true;

        } else {
            buildTree(node.next, word, i+1);

        }
    }

    boolean dfs(Map<Character, Node> root, String word, boolean full, int i){
        if (i == word.length() - 1) {
            Node next = root.get(word.charAt(i));
            return next != null && (!full || next.end);
        }
         if (!root.containsKey(word.charAt(i))){
            return false;
        }
        Node next = root.get(word.charAt(i));
        return dfs(next.next, word, full, i+1);

    }
}
