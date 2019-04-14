#47 不用+、-、*、/四则运算符号，求两个数和。
public int Add(int num1,int num2){
	while(num2!=0){

		// 计算个位
		int temp = num1 ^ num2;
		// 计算进位（1+1）
		num2 = (num1 & num2) << 1;
		num1 = temp;
	}
	return num1; 
}

#48 字符串判断
public int StrToInt(String str) {
	if (str == null || str.length() == 0)
		return 0;
	int mark = 0;
	int number = 0;
	char[] chars = str.toCharArray();
	if (chars[0] == '-')
		mark = 1;
	for (int i = mark; i < chars.length; i++) {
		if (chars[i] == '+') {
			continue;
		}
		if (chars[i] < 48 || chars[i] > 57) {
			return 0;
		}
		number = number * 10 + chars[i] - 48;
	}
	return mark == 0 ? number : -number;
}

#51 重复的数字
public boolean duplicate(int numbers[],int length,int [] duplication) {
	
	if(numbers == null || length==0 || length==1){
		return false;
	}    
	for( int i = 0 ; i < length ; i++ ){
		int index = numbers[i];
		if(index >= length){
			index-=length;
		}
		if(numbers[index] >= length ){
			duplication[0]=index;
			return true;
		}
		numbers[index] += length ;
	}
	return false ;
}

#52 数组内的前n位相乘
public int[] multipy(int[] A){
	int length = A.length;
	int[] B = new int[length];
	if(length!=0){
		B[0]=1;
		//计算下三角连乘
		for(int i=1;i<length; i++){
			B[i]=B[i-1]*A[i-1];
		}
		//计算上三角连乘
		int temp = 1 ;
		for(int j = length-2; j>=0 ; j-- ){
			temp *= A[j+1];
			B[j]*=temp ;
		}
	}
	return B;
}

#53 字符串匹配
	public boolean match(char[] str ,char[] pattern){	
        if(str ==null || pattern==null){
            return false ;
        }
        if(str.length == 1){
            if(pattern.length==1){
                if(str[0]==pattern[0]||pattern[0]=='.'){
                    return true;
                }
                return false;
            }
        }

        int sindex = 0;
        int pindex = 0;
        return matchIndex(str,sindex,pattern,pindex);
    }

    public boolean matchIndex(char[] str ,int sindex ,char[] pattern ,int pindex){
        //str和pattern同时到达末尾，则匹配成功。
        if(sindex == str.length && pindex==pattern.length){
            return true;
        }
        //若pattern先到达末尾，则匹配失败
        if(sindex!=str.length&&pindex == pattern.length){
            return false;
        }
        //若pattern第二个字符时*
        if(pindex+1<pattern.length&&pattern[pindex+1]=='*'){
            if(sindex!= str.length&&pattern[pindex]==str[sindex] ||
                sindex!=str.length&&pattern[pindex]=='.'){
                return matchIndex(str,sindex+1,pattern,pindex+2)
                        ||matchIndex(str,sindex,pattern,pindex+2)
                        ||matchIndex(str,sindex+1,pattern,pindex);
            }else{
                return matchIndex(str,sindex,pattern,pindex+2);
            }
        }
        //若pattern第二个字符不是*
        if (sindex != str.length && pattern[pindex] == str[sindex] ||
            sindex != str.length && pattern[pindex] == '.'){
            return matchIndex(str,sindex+1,pattern,pindex+1);
        }
            
        return false;
    }

#54 查看是否为数字
public boolean isNumeric(char[] str) {
	if (str == null)
		return false;
	int index = 0;
	int ecount = 0;
	int point = 0;
// 如果第一个字符是符号就跳过
	if (str[0] == '-' || str[0] == '+')
		index++;
	for (int i = index; i < str.length; i++) {
		if (str[i] == '-' || str[i] == '+') {
			if (str[i-1] != 'e' && str[i-1] != 'E')
				return false;
			continue;
		}
		if (str[i] == 'e' || str[i] == 'E') {
			ecount++;
			if (ecount > 1)
			return false;
			if (i == 0 || str[i-1] < 48 || str[i-1] > 57 || i == str.length-1)
				return false;
			point++;
			continue;
		}
		if (str[i] == '.') {
			point++;
		if (point > 1)
			return false;
		continue;
	}
// 出现非数字且不是e/E则返回false（小数点和符号用continue跳过了）
	if ((str[i] < 48 || str[i] > 57) && (str[i] != 'e') && (str[i] != 'E'))
		return false;
	}
	return true;
}

# 55 请实现一个函数用来找出字符流中第一个只出现一次的字符
char[] chars = new char[256];
StringBuilder sb = new StringBuilder();
public void Insert(char ch) {
    sb.append(ch);
    chars[ch]++;
}
public char FirstAppearingOnce() {
    char[] str = sb.toString().toCharArray();
    for (char c : str) {
        if (chars[c] == 1) {
            return c;
        }
    }
    return '#';
}

#56 环的入口
public ListNode EntryNodeOfLoop(ListNode pHead) {
	if (pHead == null || pHead.next == null)
		return null;
	ListNode slow = pHead;
	ListNode fast = pHead;
	while (fast != null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;
		if (slow == fast){
			fast = pHead;
			while (fast != slow) {
				fast = fast.next;
				slow = slow.next;
			}
			if (fast == slow)
				return slow;
		}
	}
	return null;
}

#57 删除重复
public ListNode deleteDuplication(ListNode pHead) {
	if (pHead == null)
		return null;
	// 新建一个节点，防止头结点被删除
	ListNode first = new ListNode(-1);
	first.next = pHead;
	ListNode p = pHead;
	// 指向前一个节点
	ListNode preNode = first;
	while (p != null && p.next != null) {
		if (p.val == p.next.val) {
			int val = p.val;
			// 向后重复查找
			while (p != null && p.val == val) {
				p = p.next;
			}
			// 上个非重复值指向下一个非重复值：即删除重复值
			preNode.next = p;
		}else {
			// 如果当前节点和下一个节点值不等，则向后移动一位
			preNode = p;
			p = p.next;
		}
	}
	return first.next;
}

#58 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅
public TreeLinkNode GetNext(TreeLinkNode pNode) {
	if (pNode == null)
		return null;
	if (pNode.right != null) {
		pNode = pNode.right;
		while (pNode.left != null) {
			pNode = pNode.left;
		}
		return pNode;
	}
	while (pNode.next != null) {
		// 找第一个当前节点是父节点左孩子的节点
		if (pNode.next.left == pNode)
		return pNode.next;
		pNode = pNode.next;
	}
	return null;
}

#59 是否对称

public boolean isSymmetrical(TreeNode pRoot){
	if (pRoot == null)
		return true;
	return isCommon(pRoot.left, pRoot.right);
}

public boolean isCommon(TreeNode leftNode, TreeNode rightNode) {
	if (leftNode == null && rightNode == null)
		return true;
	if (leftNode != null && rightNode != null)
		return leftNode.val == rightNode.val &&
		isCommon(leftNode.left,rightNode.right) &&
		isCommon(leftNode.right,rightNode.left);
	return false;
}

#60 之字顺序

import java.util.*;
public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	if (pRoot == null)
		return res;
	Stack<TreeNode> s1 = new Stack<>(); // s1表示奇数，从右向左输出
	Stack<TreeNode> s2 = new Stack<>(); // s2表示偶数，从左向右输出
	s1.push(pRoot);
	int level = 1;
	while (!s1.empty() || !s2.empty()) {
		if (level % 2 != 0) {
			ArrayList<Integer> list = new ArrayList<>();
			while (!s1.empty()) {
				TreeNode node = s1.pop();
				if (node != null) {
					list.add(node.val);
					s2.push(node.left);
					s2.push(node.right);
				}
			}
			if (!list.isEmpty()) {
				res.add(list);
				level++;
			}
		} else {
			ArrayList<Integer> list = new ArrayList<>();
			while (!s2.empty()) {
				TreeNode node = s2.pop();
				if (node != null) {
					list.add(node.val);
					s1.push(node.right);
					s1.push(node.left);
				}
			}
			if (!list.isEmpty()) {
				res.add(list);
				level++;
			}
		}	
	}
	return res;
}

#61 同一层
public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	if (pRoot == null)
		return res;
	LinkedList<TreeNode> queue = new LinkedList<>();
	queue.add(pRoot);
	ArrayList<Integer> list = new ArrayList<>();
	int start = 0;
	int end = 1;
	while (!queue.isEmpty()) {
		TreeNode node = queue.pop();
		list.add(node.val);
		start++;
		if (node.left != null)
			queue.offer(node.left);
		if (node.right != null)
			queue.offer(node.right);
		if (start == end) {
			start = 0;
			end = queue.size();
			res.add(new ArrayList<>(list));
			list.clear();
		}
	}
	return res;
}

#62 请实现两个函数，分别用来序列化和反序列化二叉树
public String Serialize(TreeNode root) {
	StringBuffer sb = new StringBuffer();
	if (root == null){
		sb.append("#,");
		return sb.toString();
	}
	sb.append(root.val + ",");
	sb.append(Serialize(root.left));
	sb.append(Serialize(root.right));
	return sb.toString();
}
public int index = -1;
public TreeNode Deserialize(String str) {
	index++;
	int len = str.length();
	String[] strr = str.split(",");
	TreeNode node = null;
	if (index >= len)
		return null;
	if (!strr[index].equals("#")){
		node = new TreeNode(Integer.valueOf(strr[index]));
		node.left = Deserialize(str);
		node.right = Deserialize(str);
	}
	return node;
}

#63 给定一颗二叉搜索树，请找出其中的第k大的结点
二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序，第k个结点就是第K大的节点，分别递
归查找左右子树的第K个节点，或使用非递归借用栈的方式查找，当count=k时返回根节点

int count = 0;
public TreeNode KthNode(TreeNode pRoot, int k) {
	if (pRoot == null || k < count)
		return null;
	TreeNode p =pRoot;
	Stack<TreeNode> LDRStack = new Stack<TreeNode>();
	TreeNode kthNode = null;
	while(p != null || !LDRStack.isEmpty()){
		while(p != null){
			LDRStack.push(p);
			p = p.left;
			TreeNode node = LDRStack.pop();
			System.out.print(node.val+",");
			count++;
			if(count == k){
				kthNode = node;
			}
			p = node.right;
		}
		return kthNode;
	}
}

#64 数据流中的中位数
	int count = 0;
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(16, new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	});


public void Insert(Integer num) {
	count++;
	// 当数据的个数为奇数时，进入大根堆
	if ((count & 1) == 1) {
		minHeap.offer(num);
		maxHeap.offer(minHeap.poll());
	} else {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
	}
}
public Double GetMedian() {
	if (count == 0)
		return null;
	// 当数据个数是奇数时，中位数就是大根堆的顶点
	if ((count & 1) == 1) {
		return Double.valueOf(maxHeap.peek());
	} else {
		return Double.valueOf((minHeap.peek() + maxHeap.peek())) / 2;
	}
}

#65 找出所有滑动窗口里数值的最大值
public ArrayList<Integer> maxInWindows(int [] num, int size) {
	ArrayList<Integer> list = new ArrayList<>();
	if (num == null || size < 1 || num.length < size)
		return list;
	int length = num.length - size + 1;
	for (int i = 0; i < length; i++) {
		int current = size + i;
		int max = num[i];
		for (int j = i; j < current; j++) {
			if (max < num[j]) {
				max = num[j];
			}
		}
		list.add(max);
	}
	return list;
}

#66 用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
	int flag[] = new int[matrix.length];
	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
			if (helper(matrix, rows, cols, i, j, str, 0, flag))
				return true;
			}
		}
	return false;
	}

private boolean helper(char[] matrix,int rows,int cols,int i,int j,char[] str,int k,int[] flag) {
	int index = i * cols + j;
	if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
		return false;
	if(k == str.length - 1)
		return true;
	flag[index] = 1;
	if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
	|| helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
	|| helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
	|| helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
		return true;
	}
	flag[index] = 0;
	return false;
}

#67 机器人能够达到多少个格子
public int movingCount(int threshold, int rows, int cols) {
	int flag[][] = new int[rows][cols]; //记录是否已经走过
	return helper(0, 0, rows, cols, flag, threshold);
}
	
private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
	if (i < 0 || i >= rows || j < 0 || j >= cols ||
	numSum(i) + numSum(j) > threshold || flag[i][j] == 1)
		return 0;
	flag[i][j] = 1;
	return helper(i - 1, j, rows, cols, flag, threshold)
	+ helper(i + 1, j, rows, cols, flag, threshold)
	+ helper(i, j - 1, rows, cols, flag, threshold)
	+ helper(i, j + 1, rows, cols, flag, threshold) + 1;
}

private int numSum(int i) {
	int sum = 0;
	while (i > 0) {
		sum += i % 10;
		i = i / 10;
	}
	return sum;
}