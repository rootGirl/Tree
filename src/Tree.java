import java.util.*;
public class Tree {

    class Node{
        int data = -1;
        Node left = null;
        Node right = null;
        public Node(int data){
            this.data=data;
        }
    }

    Node head =null;

    public void findNode(int[] arr){
        Arrays.sort(arr);
        binarySearch(arr, 0, arr.length);
    }

    public void binarySearch(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        int mid = (start+end)/2;
        Node newNode = new Node(arr[mid]);
        if(head==null){
            head=newNode;
        }else{
            Node current=head;
            buildBinaryTree(current,newNode);
        }
        binarySearch(arr, start, mid);
        binarySearch(arr, mid+1, end);
    }


    public void buildBinaryTree(Node current, Node newNode){
        if(newNode.data<=current.data){
            if(current.left!=null){
                current=current.left;
                buildBinaryTree(current, newNode);
            }else{
                current.left=newNode;
            }
        }else{
            if(current.right!=null){
                current=current.right;
                buildBinaryTree(current, newNode);
            }else{
                current.right=newNode;
            }
        }
    }

    public void printTree(Node current){
        ArrayList<Node> list = new ArrayList();
        ArrayList<Node> temp = new ArrayList();
        list.add(current);
        System.out.println(current.data);
        while(!list.isEmpty()){
            for(int i=0;i<list.size();i++) {
                if (list.get(i).left != null) {
                    System.out.println(list.get(i).left.data);
                    temp.add(list.get(i).left);
                }
                if (list.get(i).right != null) {
                    System.out.println(list.get(i).right.data);
                    temp.add(list.get(i).right);
                }
            }
            list.clear();
            for(int i=0;i<temp.size();i++) {
                if (temp.get(i).left != null) {
                    System.out.println(temp.get(i).left.data);
                    list.add(temp.get(i).left);
                }
                if (temp.get(i).right != null) {
                    System.out.println(temp.get(i).right.data);
                    list.add(temp.get(i).right);
                }
            }
            temp.clear();
        }
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8};
        Tree tree = new Tree();
        tree.findNode(arr);
        tree.printTree(tree.head);

    }


}
