import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
 
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val){
        this.val = val;
    }
}

public class BFS {
    public List<List<Integer>> bfs(TreeNode root){
        List<List<Integer>> answer = new ArrayList<>();

        if(root == null){
            return answer;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            answer.add(currentLevel);
        }
        return answer;
    }
}