/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map <Node,Node> nodeMap = new HashMap<>();
        Node pointer = head;
        while(pointer!=null){
            nodeMap.put(pointer, new Node(pointer.val));
            pointer = pointer.next;
        }
        pointer = head;
        while(pointer!=null){
           Node newNode = nodeMap.get(pointer);
           newNode.next = nodeMap.get(pointer.next);
           newNode.random = nodeMap.get(pointer.random);
           pointer = pointer.next;
        }
        return nodeMap.get(head);
        
    }
}
