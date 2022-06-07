/************************************************************

    Following is the TreeNode class structure:

    class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

************************************************************/
import java.util.*;
class Pair
{
    BinaryTreeNode value;
    int pos;
    Pair( BinaryTreeNode Data, int position )
    {
        value = Data;
        pos = position;
    }
}

public class Solution {    
    
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// Write your code here.
         ArrayList<Integer> ans = new ArrayList<Integer>();
        if( root == null ) return ans;

        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Queue<Pair> queue = new ArrayDeque<Pair>();
        BinaryTreeNode curr = root;

        Pair pair = new Pair(curr, 0);
        queue.add(pair);
        while( queue.isEmpty() == false )
        {
            pair = queue.poll();
            curr = pair.value;
            int p = pair.pos;

            if( map.containsKey(p) == false )
                map.put(p, curr.val);

            if( curr.left != null )
                queue.add(new Pair(curr.left, p-1));

            if( curr.right != null )
                queue.add(new Pair(curr.right, p+1));
        }
        for( Map.Entry<Integer, Integer> entry : map.entrySet() )
            ans.add(entry.getValue());
        
        return ans;
	}
}