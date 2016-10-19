package com.pland.leetcode.java.binarytree;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 *
 *############LOCAL TEST PASSED############
 */
public class J_102_BinaryTreeLevelOrderTraversal {
	
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
		
		TreeNode root = TreeConverter.arrayToTree(temp);
		J_102_BinaryTreeLevelOrderTraversal test = new J_102_BinaryTreeLevelOrderTraversal();
		
		ArrayList<ArrayList<TreeNode>> array = (ArrayList<ArrayList<TreeNode>>)test.levelOrderTraversal(root);
		
		int size = array.size();
		
		Integer [][] result = new Integer[size][];
		
		for(int i = 0; i< size; i++){
			int subSize = array.get(i).size();
			ArrayList<TreeNode> subArray = (ArrayList<TreeNode>) array.get(i);
			result[i] = new Integer[subSize];
			for(int j=0; j< subSize; j++){
				result[i][j] = subArray.get(j).getNodeValue();
				
			}
		}
		
		for(Integer[] valueOnLevel : result){
			for(Integer item : valueOnLevel){
				System.out.print("item="+item+" ");
			}
			System.out.println();
			/**
			 * Expected Result:
			 * 7
			 * 5,4
			 * 3,6
			 * 2
			 */
		}
		
	}
	
	public ArrayList<ArrayList<TreeNode>> levelOrderTraversal(TreeNode root){
		
		int depth = this.depthOfBinTree(root);

		ArrayList<ArrayList<TreeNode>> array = new ArrayList<ArrayList<TreeNode>>(depth);
		

        for(int i = 0; i<depth; i++){
        	if(i == 0){
        		ArrayList<TreeNode> tempArray = new ArrayList<TreeNode>();
        		tempArray.add(root);
        		array.add(tempArray);
        	}
        	else{
        		ArrayList<TreeNode> parentArray = (ArrayList<TreeNode>)array.get(i-1);
        		ArrayList<TreeNode> tempArray = new ArrayList<TreeNode>();
        		for(TreeNode node : parentArray){
        			if(node.getLeft() != null){
        				tempArray.add(node.getLeft());
        			}
        			if(node.getRight() != null){
        				tempArray.add(node.getRight());
        			}
        		}
        		array.add(tempArray);
        		
        		
        	}
        }
		
		
		return array;
	}
	
	private int depthOfBinTree(TreeNode root){
		int depth = 0;
		if(root != null){
			depth = this.recursiveForDepth(root, 1);
		}
		return depth;
	}
	
	private int recursiveForDepth(TreeNode node, int depth){
		
		int nextDepth = depth;
		int finalDepth = depth;
		int leftDepth = depth;
		int rightDepth = depth;
		
		
		if(node.getLeft() != null || node.getRight() != null){
			nextDepth+=1;
			if(node.getLeft() != null){
				leftDepth = this.recursiveForDepth(node.getLeft(), nextDepth);
			}
			
			if(node.getRight() != null){
				rightDepth = this.recursiveForDepth(node.getRight(), nextDepth);
			}
			
			finalDepth = (leftDepth>rightDepth)?leftDepth:rightDepth;
			
			
		}
		return finalDepth;
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
