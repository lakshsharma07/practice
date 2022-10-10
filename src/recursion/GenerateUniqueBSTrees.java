package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateUniqueBSTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateTrees(3));
	}

	public static List<TreeNode> generateTrees(int n) {
	
		return generate(1,n);
	}
	
	static List<TreeNode> generate(int start ,int end)
    {
		
		System.out.println(start+"  ,  "+end);
        List<TreeNode> list = new ArrayList<>();
        if(start > end)
        {
            list.add(null);
            return list;
        }
        if(start == end)
        {
            list.add(new TreeNode(start));
            return list;
        }
        for(int i = start;i<=end;i++)
        {

            List<TreeNode> leftPossibleTrees = generate(start,i-1);
            List<TreeNode> rightPossibleTrees = generate(i+1,end);
            for(TreeNode lRoot : leftPossibleTrees)
            {
                for(TreeNode rRoot : rightPossibleTrees)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lRoot;
                    root.right = rRoot;
                    list.add(root);
                }
            }
        }
       // System.out.println(list);
        return list;
    }

}
