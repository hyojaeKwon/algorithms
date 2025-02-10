package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 길찾기게임 {

    class Solution {
        private static final List<Integer> preorderList = new ArrayList<>();
        private static final List<Integer> postorderList = new ArrayList<>();

        private static void insertNode(Node parent, Node child) {
            if (parent.x < child.x) {
                if (parent.right != null) insertNode(parent.right, child);
                else parent.right = child;
            } else {
                if (parent.left != null) insertNode(parent.left, child);
                else parent.left = child;
            }
        }

        private static void preorder(Node node) {
            if (node == null) return;
            preorderList.add(node.num);
            preorder(node.left);
            preorder(node.right);
        }

        private static void postorder(Node node) {
            if (node == null) return;
            postorder(node.left);
            postorder(node.right);
            postorderList.add(node.num);
        }

        public int[][] solution(int[][] nodeinfo) {
            int n = nodeinfo.length;
            int[][] answer = new int[2][n];

            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
            }

            answer = new int[2][nodeinfo.length];
            Arrays.sort(nodes, (o1, o2) -> {
                if (o1.y == o2.y) return 0;
                return o2.y - o1.y;
            });

            Node rootNode = nodes[0];
            for (int i = 1; i < n; i++) {
                insertNode(rootNode, nodes[i]);
            }


            preorder(rootNode);
            postorder(rootNode);
            for (int i = 0; i < n; i++) {
                answer[0][i] = preorderList.get(i);
                answer[1][i] = postorderList.get(i);
            }

            return answer;
        }

        class Node {
            int num, x, y;
            Node left, right;

            Node(int num, int x, int y) {
                this.num = num;
                this.x = x;
                this.y = y;
            }
        }


    }
}
