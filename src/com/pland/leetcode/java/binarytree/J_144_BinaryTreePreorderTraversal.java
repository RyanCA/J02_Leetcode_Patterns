package com.pland.leetcode.java.binarytree;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

############LOCAL TEST PASSED############

 *
 */

public class J_144_BinaryTreePreorderTraversal {
	
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
		
		
		J_144_BinaryTreePreorderTraversal test = new J_144_BinaryTreePreorderTraversal();
		ArrayList<Integer> list = (ArrayList<Integer>)test.preOrderTraversal(root);
		for(Integer item :list){
			System.out.println("item="+item); //Expected Result: 7->5->3->2->4->6
		}
	}
	
	public ArrayList<Integer> preOrderTraversal(TreeNode node){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = preOrderTraversal(node, list);
		return list;

	}
	
	private ArrayList<Integer> preOrderTraversal(TreeNode node, ArrayList<Integer> list){
		
		if(node != null){
			list.add(node.getNodeValue());
		}
		if(node.getLeft() != null){
			preOrderTraversal(node.getLeft(), list);
			
		}
		
		if(node.getRight() != null){
			preOrderTraversal(node.getRight(), list);
		}
		
		return list;
	}
		
	

}

/**
 * Define Tree Structure
 *
 */
//class TreeNode{
//	
//	private TreeNode left = null;
//	private TreeNode right = null;
//	int nodeValue = 0;
//	
//	public TreeNode(int nodeValue){
//		super();
//		this.nodeValue = nodeValue;
//	}
//	
//	public TreeNode(String nodeValue){
//		super();
//		this.nodeValue = Integer.valueOf(nodeValue);
//	}
//	
//	public int getNodeValue(){
//		return this.nodeValue;
//	}
//	
//	public TreeNode getLeft(){
//		return this.left;
//	}
//	
//	public TreeNode getRight(){
//		return this.right;
//	}
//	
//	public void setLeft(TreeNode left){
//		this.left = left;
//	}
//	
//	public void setRight(TreeNode right){
//		this.right = right;
//	}
//	
//	
//}
//

//class TreeConverter{
//	
//	/**
//	 * Convert string array to tree. Array contains the tree nodes in the order
//	 * of levels: Top down, left to right
//	 *  
//	 * 
//	 */
//	public static TreeNode arrayToTree(String [] temp){
//		if(temp == null) return null;
//		
//		TreeNode root = new TreeNode(temp[0]);
//		int level = 0;
//
//		root = constructSubBinTree(root, 0, temp);
//		
//		return root;
//
//		
//	}
//	
//	/**
//	 * # in the array is the sign to indicate it will be a null node in the tree
//	 * 
// 	 *                           7
// 	 *                         /   \
// 	 *                        5     4
// 	 *                       /\     /\
// 	 *                      3  #   6  #
// 	 *                     / \
// 	 *                    #   2
// 	 *                    
// 	 *     String temp[] = {"7", "5", "4", "3", "#","6","#","#", "2"};
// 	 *     
//	 */
//	
//	private static TreeNode constructSubBinTree(TreeNode node, int pos, String [] temp){
//		
//		int indexOfLeftNode = 2 * pos +1;
//		int indexOfRightNode = 2* pos +2;
//		TreeNode left = null;
//		TreeNode right = null;
//		
//		if(indexOfLeftNode <= temp.length -1){
//			if(!temp[indexOfLeftNode].equals("#")){
//				left = new TreeNode(temp[indexOfLeftNode]);
//				System.out.println("pos="+pos+" Constructing left node:"+left.getNodeValue());
//				node.setLeft(left);
//				constructSubBinTree(left, indexOfLeftNode, temp);
//			}
//			else{
//				System.out.println("pos="+pos+" Constructing left node:"+null);
//				node.setLeft(left);//set null on left node
//			}
//			
//		}
//		
//		if(indexOfRightNode <= temp.length -1){
//			if(!temp[indexOfRightNode].equals("#")){
//				right = new TreeNode(temp[indexOfRightNode]);
//				System.out.println("pos="+pos+" Constructing right node:"+right.getNodeValue());
//				node.setRight(right);
//				constructSubBinTree(right, indexOfRightNode, temp);
//			}
//			else{
//				System.out.println("pos="+pos+" Constructing right node:"+null);
//				node.setRight(right);//set null on right node
//			}
//		}
//		
//		return node;
//		
//		
//	}
//	
//	
//}