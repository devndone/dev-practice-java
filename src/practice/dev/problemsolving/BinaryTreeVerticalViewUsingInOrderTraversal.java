package practice.dev.problemsolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeVerticalViewUsingInOrderTraversal {
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.right = new TreeNode(9);

		printVerticalOrder(root);
	}

	public static void printVerticalOrder(TreeNode node) {
		Map<Integer, List<TreeNode>> map = new TreeMap<>(Collections.reverseOrder());

		printVerticalOrder(node, map, 0);

		for (Map.Entry<Integer, List<TreeNode>> entry : map.entrySet()) {
			List<TreeNode> list = entry.getValue();

			for (TreeNode treeNode : list) {
				System.out.print(treeNode.value + " ");
			}
			System.out.println();
		}
	}

	private static void printVerticalOrder(TreeNode node, Map<Integer, List<TreeNode>> map, int level) {
		if (node == null) {
			return;
		}

		if (map.containsKey(level)) {
			map.get(level).add(node);
		} else {
			List<TreeNode> list = new ArrayList<>();
			list.add(node);
			map.put(level, list);
		}

		if (node.left != null) {
			printVerticalOrder(node.left, map, level + 1);
		}

		if (node.right != null) {
			printVerticalOrder(node.right, map, level - 1);
		}
	}

	public static class TreeNode {

		int value;
		TreeNode left;
		TreeNode right;

		/**
		 * @param value
		 */
		public TreeNode(int value) {
			super();
			this.value = value;
		}

	}
}
