package com.pland.leetcode.java.binarytree;

/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

############LOCAL TEST PASSED############
 *
 */

public class J_111_BinaryTreeMinDepth {
	
	
	


	
	public static void main(String args[]){
		
		/**
		 * Self-Testing
		 */
		
	 	/**
	 	 *                           7
	 	 *                         /   \
	 	 *                        5     4
	 	 *                       /\     /\
	 	 *                      3  #   6  #
	 	 *                     / \
	 	 *                    #   2
	 	 *                    
	 	 *                   
	 	 */
		
		String temp[] = {"7", "5", "4", "3", "#","6","#","#", "2"};
		TreeNode node = TreeConverter.arrayToTree(temp);
		
		J_111_BinaryTreeMinDepth test = new J_111_BinaryTreeMinDepth();
		System.out.println("The min depth is "+test.minDepthOfBinTree(node));
	}
	
	public int minDepthOfBinTree(TreeNode node){
		int depth = 0;
		if(node != null){
			depth = this.recursiveForDepth(node, 1);
		}
		return depth;
	}
	
	private int recursiveForDepth(TreeNode node, int depth){

		int localDepth = depth;
		int leftDepth = depth;
		int rightDepth = depth;
		
        if(node != null){
        	
    	    if(node.getLeft() != null ||
    	        node.getRight() != null){
    	    	
    	       localDepth +=1;
    	       leftDepth +=1;
    	       rightDepth +=1;
    		   if(node.getLeft() != null){
    			   leftDepth = this.recursiveForDepth(node.getLeft(), localDepth);
    		   }
    		   if(node.getRight() != null){
    			   rightDepth = this.recursiveForDepth(node.getRight(), localDepth);
    		   }
    		   localDepth = leftDepth >= rightDepth ? rightDepth : leftDepth;
    	    }
    	    return localDepth;
    	   
        }
        return localDepth;
	}

}


/**
 * Define Tree Structure
 *
 */
class TreeNode{
	
	private TreeNode left = null;
	private TreeNode right = null;
	int nodeValue = 0;
	
	public TreeNode(int nodeValue){
		super();
		this.nodeValue = nodeValue;
	}
	
	public TreeNode(String nodeValue){
		super();
		this.nodeValue = Integer.valueOf(nodeValue);
	}
	
	public int getNodeValue(){
		return this.nodeValue;
	}
	
	public TreeNode getLeft(){
		return this.left;
	}
	
	public TreeNode getRight(){
		return this.right;
	}
	
	public void setLeft(TreeNode left){
		this.left = left;
	}
	
	public void setRight(TreeNode right){
		this.right = right;
	}
	
	
}

class TreeConverter{
	
	/**
	 * Convert string array to tree. Array contains the tree nodes in the order
	 * of levels: Top down, left to right
	 *  
	 * 
	 */
	public static TreeNode arrayToTree(String [] temp){
		if(temp == null) return null;
		
		TreeNode root = new TreeNode(temp[0]);
		int level = 0;

		root = constructSubBinTree(root, 0, temp);
		
		return root;

		
	}
	
	/**
	 * # in the array is the sign to indicate it will be a null node in the tree
	 * 
 	 *                           7
 	 *                         /   \
 	 *                        5     4
 	 *                       /\     /\
 	 *                      3  #   6  #
 	 *                     / \
 	 *                    #   2
 	 *                    
 	 *     String temp[] = {"7", "5", "4", "3", "#","6","#","#", "2"};
 	 *     
	 */
	
	private static TreeNode constructSubBinTree(TreeNode node, int pos, String [] temp){
		
		int indexOfLeftNode = 2 * pos +1;
		int indexOfRightNode = 2* pos +2;
		TreeNode left = null;
		TreeNode right = null;
		
		if(indexOfLeftNode <= temp.length -1){
			if(!temp[indexOfLeftNode].equals("#")){
				left = new TreeNode(temp[indexOfLeftNode]);
				System.out.println("pos="+pos+" Constructing left node:"+left.getNodeValue());
				node.setLeft(left);
				constructSubBinTree(left, indexOfLeftNode, temp);
			}
			else{
				System.out.println("pos="+pos+" Constructing left node:"+null);
				node.setLeft(left);//set null on left node
			}
			
		}
		
		if(indexOfRightNode <= temp.length -1){
			if(!temp[indexOfRightNode].equals("#")){
				right = new TreeNode(temp[indexOfRightNode]);
				System.out.println("pos="+pos+" Constructing right node:"+right.getNodeValue());
				node.setRight(right);
				constructSubBinTree(right, indexOfRightNode, temp);
			}
			else{
				System.out.println("pos="+pos+" Constructing right node:"+null);
				node.setRight(right);//set null on right node
			}
		}
		
		return node;
		
		
	}
	
	
}
