/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
  public Node connect(Node root) {
    Node leftMostDummy = new Node(), cur = leftMostDummy, parent = root;
    while (parent != null) {
      if (parent.left != null) {
        cur.next = parent.left;
        cur = cur.next;
      }
      if (parent.right != null) {
        cur.next = parent.right;
        cur = cur.next;
      }
      parent = parent.next;
      if (parent == null) {
        parent = leftMostDummy.next;
        cur = leftMostDummy;
        leftMostDummy.next = null;
      }
    }
    return root;
  }
}
