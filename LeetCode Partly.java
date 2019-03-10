#46. Permutations
class Solution {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> tempList = new ArrayList<Integer>();
	public List<List<Integer>> permute(int[] nums){
		dfs(nums);
	    return res;
	}
	public void dfs(int[] nums) {
	    if (tempList.size() == nums.length) {
	        res.add(new ArrayList<Integer>(tempList));
	            return;
	    }
	    for (int i = 0; i < nums.length; i++) {
	        if (!tempList.contains(nums[i])) {
	            tempList.add(nums[i]);
	            dfs(nums);
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
}

#48 remote image
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        if (n <= 1) {
            return;
        }

        //旋转次数
        int count = n * n / 4;
        
        int x = 0;
        int y = 0;
        int z = 0;
        
        int x1, y1, x2, y2;

        for (int i = 0; i < count; i++) {
            if (z >= (n - 1) - 2 * x) {
                x += 1;
                z = 0;
            }
            y = z + x;
            z += 1;
            
            x1 = x;
            y1 = y;

            for (int j = 0; j < 3; j++) {
                x2 = n - 1 - y1;
                y2 = x1;

                matrix[x1][y1] = matrix[x1][y1] ^ matrix[x2][y2];
                matrix[x2][y2] = matrix[x1][y1] ^ matrix[x2][y2];
                matrix[x1][y1] = matrix[x1][y1] ^ matrix[x2][y2];

                x1 = x2;
                y1 = y2;
            }
        }
    }