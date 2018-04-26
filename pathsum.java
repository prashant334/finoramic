public class Solution {
  //  public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
//  List<ArrayList<Integer>>  }
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if(A == null) 
        return result;
 
    ArrayList<Integer> inner = new ArrayList<Integer>();
    inner.add(A.val);
    dfs(A, B-A.val, result, inner);
    return result;
}

public void dfs(TreeNode t, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> inner){
    if(t.left==null && t.right==null && sum==0){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.addAll(inner);
        result.add(temp);
    }
 
    //search path of left node
    if(t.left != null){
        inner.add(t.left.val);
        dfs(t.left, sum-t.left.val, result, inner);
        inner.remove(inner.size()-1);
    }
 
    //search path of right node
    if(t.right!=null){
        inner.add(t.right.val);
        dfs(t.right, sum-t.right.val, result, inner);
        inner.remove(inner.size()-1);
    }
}


}
