package com.pland.interviews.citi;

import java.util.ArrayList;

/**
 * Given a tree node, return its father node. If given root node, return itself
 * 
 * The key is to put tree node to an array, and based on child index in the array,
 * find the parent index.
 * 
 * It's also considered as breadth traversal question
 *
 */
public class FatherNodeOfGivenTreeNode {
	
	public TreeNode getParentNode(TreeNode root, TreeNode childNode){
		
		if(root == null || childNode == null){
			
			throw new ParameterIsNullException();
		}
		
		if(root == childNode){
			return childNode;
		}
		
		ArrayList<ArrayList<TreeNode>> list = 
				new ArrayList<ArrayList<TreeNode>>();
		
		this.convertTreeNode2List(root, 0, list);
		
//		for(ArrayList<TreeNode> subList : list){
//			System.out.println("######");
//			for(TreeNode node : subList){
//				System.out.println(node!=null?node.value:null);
//			}
//		}
		
		/**
		 * Change list from ArrayList<ArrayList<TreeNode>> to ArrayList<TreeNode>
		 * And there is a rule to find the parent index based on child index in a lenear array
		 */
		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
		for(ArrayList<TreeNode> subList : list){
			for(TreeNode node : subList){
				nodeList.add(node);
			}
		}
		
		/**
		 * Find the parent index in ArrayList<TreeNode>
		 */
		int counter = 0;
		int parentNodeIndex = 0;
		TreeNode parentNode = null;
		boolean isNodeExisted = false;
		
		for(TreeNode node : nodeList){
			if(childNode == node){
				isNodeExisted = true;
				break;
			}
			counter++;
		}
		
		if(isNodeExisted == false){
			throw new ChildNodeNotInTreeException();
		}
		
		boolean isCounterEvenNumber = (counter % 2 == 0) ? true : false;
		
		if(isCounterEvenNumber){
			parentNodeIndex=(counter-2)/2;
		}
		else{
			parentNodeIndex=(counter-1)/2;
		}
		
		System.out.println("Parent Index="+parentNodeIndex);
		
		/**
		 * get the parent index
		 */
		parentNode = nodeList.get(parentNodeIndex);
		
		System.out.println("Parent value="+parentNode.value);
		
		return parentNode;
		
		
		
		
	}
	
	/**
	 * Put tree into ArrayList<ArrayList<TreeNode>>
	 * 
	 * @param root
	 * @param level: starting from 0. increased one by one
	 * @param list
	 */
	private void convertTreeNode2List(
			TreeNode root, int level, ArrayList<ArrayList<TreeNode>> list){
		
		if( list == null){
			throw new ParameterIsNullException();
		}
		
		if(list.size() == level){
			list.add(new ArrayList<TreeNode>());
		}
		
		list.get(level).add(root);
		
		level++;
		boolean isLeftChildNotNull = ((root != null) && (root.left != null)) ? true : false;
		boolean isRightChildNotNull = ((root != null) && (root.right != null)) ? true : false;
		
		if(isLeftChildNotNull || isRightChildNotNull){
			if(isLeftChildNotNull && isRightChildNotNull){
				convertTreeNode2List(root.left, level, list);
				convertTreeNode2List(root.right, level, list);
			}
			else if (isLeftChildNotNull) {
				convertTreeNode2List(root.left, level, list);
				convertTreeNode2List(null, level, list);
			}
			else if (isRightChildNotNull){
				convertTreeNode2List(null, level, list);
				convertTreeNode2List(root.right, level, list);
			}
		}
	    
		
	}
	
 	/**
 	 *                           7
 	 *                         /   \
 	 *                        5     4
 	 *                       /     /
 	 *                      3     6
 	 *                       \
 	 *                        2
 	 */
	
	public static void main(String args[]){
		
		 FatherNodeOfGivenTreeNode fatherNodeOfGivenTreeNode = new FatherNodeOfGivenTreeNode();
		
		 TreeNode root = fatherNodeOfGivenTreeNode.new TreeNode(7);
		 root.left = fatherNodeOfGivenTreeNode.new TreeNode(5);
		 root.left.left = fatherNodeOfGivenTreeNode.new TreeNode(3);
		 root.left.left.right = fatherNodeOfGivenTreeNode.new TreeNode(2);
		 root.right = fatherNodeOfGivenTreeNode.new TreeNode(4);
		 root.right.left = fatherNodeOfGivenTreeNode.new TreeNode(6);
		 
		 TreeNode node = fatherNodeOfGivenTreeNode.getParentNode(root, root.right.left);
		
	}
	
    class TreeNode{
    	int value;
    	TreeNode left;
    	TreeNode right;
    	
    	TreeNode(int value){
    		this.value = value;
    	}
    }
    
    class ParameterIsNullException extends RuntimeException{
    	
    }
    
    class ChildNodeNotInTreeException extends RuntimeException{
    	
    }

}
