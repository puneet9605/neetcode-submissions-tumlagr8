/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Set<Node> visted = new HashSet<>();
        Map<Integer, Node>nodes = new HashMap<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(node);
        visted.add(node);
        while(!queue.isEmpty()){
            Node root = queue.removeFirst();
            Node newNode;
            if(!nodes.containsKey(root.val)){
                newNode = new Node(root.val);
                nodes.put(root.val, newNode);
            } else {
                newNode = nodes.get(root.val);
                }
            for(Node neigh: root.neighbors){
                Node newNeigh;
                if(!nodes.containsKey(neigh.val)){
                    newNeigh = new Node(neigh.val);
                    nodes.put(neigh.val, newNeigh);
                } else {
                    newNeigh = nodes.get(neigh.val);
                }
                newNode.neighbors.add(newNeigh);
                if(!visted.contains(neigh)){
                    queue.add(neigh);
                    visted.add(neigh);
                }
            }
        }
        return  nodes.get(1);
        
    }
}