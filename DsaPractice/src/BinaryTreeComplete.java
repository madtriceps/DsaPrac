package DsaPrac.DsaPractice.src;

import java.util.LinkedList;
import java.util.Queue;

//We are gonna learn Binary tree data structure and the various questions regarding it.
public class BinaryTreeComplete {
    static class Node {
        int data ;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

    static class BinaryTree{
        static int idx = -1;

        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preorder (Node root){
            if(root == null){
                return ;
            }

            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root){
            if(root == null){
                return;
            }

            inorder(root.left);
            System.out.print(root.data +" ");
            inorder(root.right);
        }

        public static void postorder(Node root){
            if(root == null ){
//              Incase you also want to print the -1
//              System.out.print(-1+" ")
                return;
            }

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelOrder(Node root ){
            if(root == null ){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                //If current node is null
                if(currNode == null){
                    System.out.println();
                    //if this null node marks the end of queue
                    if(q.isEmpty()){
                        break;

                    }else{
//                  But if it's not the end of the queue, then add a new 'null' at the end of the queue
                        q.add(null);
                    }
                }
//              If the current node is not null but a number
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if(currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static int height(Node root){
            if(root == null){
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight,rightHeight)+1;
        }

        public static int nodesCount(Node root){
            if(root == null){
                return 0;
            }
            int leftNodesCount = nodesCount(root.left);
            int rightNodesCount = nodesCount(root.right);
            return leftNodesCount+rightNodesCount+1;
        }
        public static int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftNodesSum = sumOfNodes(root.left);
            int rightNodesSum =sumOfNodes(root.right);
            return leftNodesSum+rightNodesSum+root.data;
        }

/*      InCase of a Binary tree we define as the longest possible end-to-end route possible.
        Case A: It can either be that the routes passes through the root of the tree
        Case B: The path exists either in left or right branch of the tree solely.
        So we must take the Max of length of all  3 conditions:
        1. For Case A: the diameter is ( left height of tree + right height of tree)+1
        2:For Case B: the diameter is Max( diameter in left side of tree, diameter made by right tree)

        So finally the Max(point 1, point 2) is the answer.

        Further we have 2 ways to do this :
        1st Method: O(n^2) TC which calculatees diameter of tree and height separately
        2nd Method O(n) TC which calculates diameter of the tree and height of tree simultaneously at each level.
*/

//      Method 1 : O(n^2)
        public static int diameter1(Node root){
        if(root==null){
            return 0;
        }

        int diam1 = height(root.left)+height(root.right)+1;
        int diam2 = diameter1(root.left);
        int diam3 = diameter1(root.right);

        return Math.max(diam1, Math.max(diam2, diam3));

        }

//  Methdod 2: O(n)

//      We are creating our own class called TreeInfo which will always store two info about the nodes: its current height and diameter
        static class TreeInfo {
            int ht;
            int diam;

            public TreeInfo(int ht, int diam){
                this.ht = ht;
                this.diam = diam;
            }
}
        public static TreeInfo diameter2(Node root){

            if(root == null){
                return new TreeInfo(0,0);
            }

            TreeInfo leftTree = diameter2(root.left);
            TreeInfo rightTree = diameter2(root.right);

            int myHeight = Math.max(leftTree.ht, rightTree.ht)+1;

            int diam1 = leftTree.ht+ rightTree.ht+1;
            int diam2 = leftTree.diam;
            int diam3 = rightTree.diam;

            int myDiam = Math.max(diam1, Math.max(diam2, diam3));
            return new TreeInfo(myHeight, myDiam);
        }

    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);
        System.out.println(root.data);

        System.out.println("Printing PreOrder of Binary Tree:");
        tree.preorder(root);
        System.out.println("\nPrinting InOrder of Binary Tree:");
        tree.inorder(root);
        System.out.println("\nPrinting PostOrder of Binary Tree:");
        tree.postorder(root);
        System.out.println("\nPrinting Level order of Binary Tree:");
        tree.levelOrder(root);
        System.out.println("\nPrinting Height of Binary Tree:"+ tree.height(root));
        System.out.println("\nPrinting The Sum Of Nodes  in the  Binary Tree:"+ tree.sumOfNodes(root));
        System.out.println("\nPrinting The Diameter of the Binary Tree Method 1:"+ tree.diameter1(root));

//      Remember: Method 2 of Diameter also carries info of height of tree, so we can print that too
        System.out.println("\nPrinting The Diameter of the Binary Tree Method 2 : "+ tree.diameter2(root).diam);
        System.out.println("\nPrinting The Height of the Binary Tree Method 2   : "+ tree.diameter2(root).ht);

    }
}
