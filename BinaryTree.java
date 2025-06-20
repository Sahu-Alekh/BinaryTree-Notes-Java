public class BinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTrees {
        static int idx = -1;
        public static Node CreateTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }

            Node newnNode = new Node(nodes[idx]);
            newnNode.left = CreateTree(nodes);
            newnNode.right = CreateTree(nodes);

            return newnNode;
        }

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            inorder(root.right);
            System.out.print(root.data + "");
        }

        //
    }
    public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTrees Ans = new BinaryTrees();
        Node ansers = Ans.CreateTree(nodes);

        Ans.inorder(ansers);
    }
}
