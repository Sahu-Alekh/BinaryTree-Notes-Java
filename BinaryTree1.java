import java.util.*;

public class heightTree {

    //Creating Blue Print of our tree
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

    //Creating a Binary tree Preorder (recursive form)
    static class BinaryTree {
        static int idx = -1;
        public static Node AddNode(int arr[]) {
            idx++;
            if(arr[idx] == -1) {
                return null;
            }

            Node newNode = new Node(arr[idx]);
            newNode.left = AddNode(arr);
            newNode.right = AddNode(arr);

            return newNode;
        }

        //Treversing In array with Preorder Traversal Formate
        public static void Preorder(Node root) {
            if(root == null) {
                return;
            }
            System.out.println(root.data + " ");
            Preorder(root.left);
            Preorder(root.right);
        }

        //Treversing In array with Indore traversals Formate
        public static void Indore(Node root) {
            if(root == null) {
                return;
            }
            Indore(root.left);
            System.out.print(root.data + " ");
            Indore(root.right);
        }

        //Treversing In array with PostOrder traversals Formate
        public static void PostOrder(Node root) {
            if(root == null) {
                return;
            }
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data + " ");
        }

        //Level Order Triversial
        public static void LevelOrder(Node root) {
            if(root == null) {
                return;
            }

            Queue<Node> qu = new LinkedList<>();
            qu.add(root);
            qu.add(null);    
            
            while (!qu.isEmpty()) {
                //Taking out a node to check what it is null or a node
                Node CurrNode = qu.remove();

                //Null hits in the queue it prints a next Line
                if(CurrNode == null) {
                    System.out.println();
                    if(qu.isEmpty()) {
                        break;
                    } else {
                        qu.add(null);
                    }
                //Otherwise it add the Left node and right Node in the queue
                } else {
                    System.out.print(CurrNode.data);
                    if(CurrNode.left != null) {
                        qu.add(CurrNode.left);
                    }
                    if(CurrNode.right != null) {
                        qu.add(CurrNode.right);
                    }
                }
            }
        }

        //calculating height of the tree
        public static int height(Node root) {
            if(root == null) {
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        //Count nubers of node in tree
        public static int Count(Node root) {
            if(root == null) {
                return 0;
            }

            int LeftCount = Count(root.left);
            int rightCount = Count(root.right);

            return LeftCount + rightCount + root.data;
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1};
        BinaryTree q = new BinaryTree();
        Node no = q.AddNode(arr);
        q.Preorder(no);
        q.Indore(no);
        q.PostOrder(no);
        q.LevelOrder(no);
        System.out.println(q.height(no));

        System.out.println(q.Count(no));
    }
}
