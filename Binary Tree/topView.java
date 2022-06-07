import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Pair
{
    Node value;
    int pos;
    Pair( Node Data, int position )
    {
        value = Data;
        pos = position;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void topView(Node root) {
      
        if( root == null ) return;

        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Queue<Pair> queue = new ArrayDeque<Pair>();
        Node curr = root;

        Pair pair = new Pair(curr, 0);
        queue.add(pair);
        while( queue.isEmpty() == false )
        {
            pair = queue.poll();
            curr = pair.value;
            int p = pair.pos;

            if( map.containsKey(p) == false )
                map.put(p, curr.data);

            if( curr.left != null )
                queue.add(new Pair(curr.left, p-1));

            if( curr.right != null )
                queue.add(new Pair(curr.right, p+1));
        }
        for( Map.Entry<Integer, Integer> entry : map.entrySet() )
            System.out.print(entry.getValue() + " ");

    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}