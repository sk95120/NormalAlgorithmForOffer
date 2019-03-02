#12 打印1到n位最大数
public void printToMaxOfNDigits(int n){
	int[] array = new int[n];
	if(n<=0){
		return ;
	}
	printArray(array,0);
}
private void printArray(int[] array,int n){
	for(int i = 0 ; i < 10 ; i++){
		if(n != array.length){
			array[i] = i ;
			printArray(array,n+1);
		}else{
			boolean isFirstNo0 = false ;
			for(int j = 0;j<array.length;j++){
				if(array[j]!=0){
					System.out.print(array[j]);
					if(!isFirstNo0){
						isFirstNo0 = true;
					}
				}else{
					if(isFirstNo0){
						System.out.print(array[j]);
					}
				}
			}
			System.out.println();
			return ;
		}
	}
}

#13 O(1)时间删除链表节点
public void deleteNode(ListNode head,ListNode deListNode){
	if(deListNode == Null || head == Null){
		return ;
	}
	if(head == deListNode){
		head = Null;
	}else{
		//若删除节点是末尾节点，往后移动一个
		if(deListNode.nextNode==Null){
			ListNode ponitListNode = head;
			while(ponitListNode.nextNode.nextNode != Null){
				ponitListNode = ponitListNode.nextNode;
			}
		ponitListNode.nextNode = null;	
		}else{
			deListNode.data = deListNode.nextNode.data;
			deListNode.nextNode = deListNode.nextNode.nextNode;
		}
	}
}

#14 调整为奇数在前
public void reOrderArray(int[] array){
	if(array == null){
		return ;
	}

	for(int i = 1 ; i < array.length ; i++){
		int temp = array[i];
		int j = i -1 ;
		if(array[i] % 2 != 0){
			while(j>=0){
				if(array[j]%2!=0){
					break;
				}
				if(array[j]%2 == 0){
					int t = array[j+1];
					array[j+1] = array[j];
					array[j] = t ;
					j--;
				}
			}
		}
		array[j+1] = temp ;
	}
}
#15 第k个指针
public ListNode FindthToTail(ListNode head,int k){
	if(head == null || k <= 0){
		return null;
	}
	ListNode fast = head;
	ListNode slow = head;
	while(k-- >1){
		if(fast.next!=null){
			fast = fast.next;
		}else{
			return null ;
		}
	}
	while(fast.next != null){
		fast = fast.next;
		slow = slow.next;
	}
	return slow ;
}

#16 输出一个反转列表
public ListNode ReverseList(ListNode head){
	if(head == null){
		return null;
	}
	ListNode temp = null ; 
	while(head != null){
		ListNode p = head.next ;
		head.next = temp ;
		temp = head ;
		head = p;
	}
	return temp ;
}

#两个单调递增链表，输出两个链表合成后的链表
public ListNode Merge(ListNode list1,ListNode list2){
	if(list1 == null){
		return list2;
	}
	if(list2 == null ){
		return list1;
	}
	ListNode newHead = null ;
	if(list1.val <= list2.val){
		newHead = list1 ;
		newHead.next = Merge(list1.next,list2);
	}else{
		newHead = list2;
		newHead.next = Merge(list1,list2.next);
	}
	return newHead;
}

#18 二叉树镜像
import java.util.Stack;
public void  Mirror(TreeBode root){
	if(root == null){
		return;
	}

	Stack<TreeNode> stack = new Stack<>();
	while(root != null || !stack.isEmpty()){
		while(root!=null){
			TreeNode temp = root.left ;
			root.left = root.right ;
			root.right = temp ;
			stack.push(root);
			root = root.left;
		}
		if(!stack.isEmpty()){
			root = stack.pop();
			root = root.right;
		}
	}
	
}
#20 打印矩阵
public ArrayList<Integer> printMatrix(int[][] matrix){
	ArrayList<Integer> list = new ArrayList<>();
	if(matrix == null){
		return list;
	}
	int start = 0 ;
	while(matrix[0].length > start*2 && matrix.length >start*2){
		printOnCircle(matrix,start,list);
		start ++ ;
	}
	return list;
}

private void printOnCircle(int[][] matrix , int start , ArrayList<Integer> list){
	int endX = matrix[0].length -1 -start ;
	int endY = matrix.length -1 - start ; //终止行减去起始行
	for(int i = start ; i < endX ; i++){
		list.add(matrix[start][i]);
	}
	if(start < endY){
		for( int i = start+1 ; i <= endY ; i++ ){
			list.add(matrix[i][endX]);
		}
	}
	//从右到左，判断是否重复打印
	if( start < endX && start < endY ){
		for( int i = endX-1 ; i >= start ; i-- ){
			list.add(matrix[endY][i]);
		}
	}
	//从下到上，判断是否重复打印
	if(start < endX && start < endY - 1 ){
		for( int i = endY -1 ; i >= start+1 ; i -- ){
			list.add(matrix[i][start]);
		}
	}
}

public ArrayList<Integer> printMatrix(int [][] array) {
    ArrayList<Integer> result = new ArrayList<Integer> ();
    if(array.length==0) return result;
    int n = array.length,m = array[0].length;
    if(m==0) return result;
    int layers = (Math.min(n,m)-1)/2+1;//这个是层数
    for(int i=0;i<layers;i++){
        for(int k = i;k<m-i;k++) result.add(array[i][k]);//左至右
        for(int j=i+1;j<n-i;j++) result.add(array[j][m-i-1]);//右上至右下
        for(int k=m-i-2;(k>=i)&&(n-i-1!=i);k--) result.add(array[n-i-1][k]);//右至左
        for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--) result.add(array[j][i]);//左下至左上
    }
    return result;       
}

#21 处理栈
public void push(int node){
	stack1.push(node);
	if(stack2.isEmpty()){
		stack2.push(node);
	}else{
		if(stack2.peek()>node){
			stack2.push(node);
		}
	}
}

public void pop(){
	if(stack1.pop() == stack.peek()){
		stack2.pop();
	}
}

public int top(){
	return stack1.peek();
}

public int min(){
	return stack2.peek();
}

##22 栈弹出顺序比较
public boolean IsPopOrder(int[] pushA,int[] popA){
	if(pushA == null || popA == null){
		return false ;
	}
	Stack<Integer> stack = new Stack<>();
	int index = 0 ;

	for( int i = 0 ; i < pushA.length ; i++ ){
		stack.push(pushA[i]);
		while(!stack.isEmpty&&stack.peek() == popA[index]){
			stack.pop();
			index++;
		}
		return stack.isEmpty();
	}
}

#从上到下，打印同层的二叉树
public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
	ArrayList<Integer> list = new ArrayList<>();
	if(root == null ){
		return list
	}
	LinkedList<TreeNode> queue = new LinkedList<>();
	queue.add(root);

	while(!queue.isEmpty()){
		TreeNode node = queue.poll();
		list.add(node.val);
		if(node.left != null){
			queue.addLast(node.left);
		}
		if(node.right!=null){
			queue.addLast(node.right);
		}
	}
	return list;
}

#24二叉树后续遍历

public boolean VerifySquenceOfBST(int[] sequence){
	if(sequence == null || sequence.length == 0){
		return false;
	}
	int restart = 0;
	int length = sequence.length;
	for(int i = 0; i<length -1  ; i++ ){
		if(sequence[i] < sequence[length-1] ){
			restart ++ ;
		}
	}
	if(restart==0){
		VerifySquenceOfBST(Arrays.copyOfRange( sequence,0,length-1));
	}else{
		for(int i = restart; i < length-1 ; i++ ){
			if(sequence[i] <= sequence[length-1] ){
				return false ;
			}
		}
		VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,restart));
		VerifySquenceOfBST(Arrays.copyOfRange(sequence,restart,length-1));
	}
	return true ;
}

#25 二叉树根节点和整数
public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target){
	private  ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
	private  ArrayList<Integer> list = new ArrayList<Integer>();
	if(root == null){
		return resultList ;
	}
	list.add(root.val);
	target -= root.val;

	if(target == 0 && root.left == null && root.right == null){
		resultList.add(new ArrayList<>(list));
	}else{
		FindPath(root.left,target);
		FindPath(root.right,target);
	}
	//每返回上一层，退回一个节点
	list.remove(list.size()-1);
	return resultList ;
}

#26 复杂链表的复制
public RandomListNode Clone2(RandomListNode pHead){
	if(pHead == null){
		return null;
	}
	RandomListNode head = new RandomListNode(pHead.label);
	RandomListNode temp = head ;

	while(pHead.next != null){
		temp.next = new RandomListNode(pHead.next.label);
		if(pHead.random != null){
			temp.random = new RandomListNode(pHead.random.label);
		}
		pHead = pHead.next;
		temp = temp.next;
	}
	return head;
}

#27 搜索树换成双向链表
public TreeNode Convert(TreeNode pRootOfTree){
	TreeNode lastlist = convertNode(pRootOfTree,null);
	TreeNode pHead = lastlist ;
	while(pHead != null && pHead.left != null){
		pHead = pHead.left ;
	}
	return pHead;
}

public TreeNode convertNode(TreeNode root,TreeNode lastlist){
	if(root == null){
		return null;
	}
	TreeNode cur = root;
	if(cur.left!=null){
		lastlist = convertNode(cur.left,lastlist);
	}
	cur.left = lastlist ;
	if(lastlist != null){
		lastlist.right = cur ;
	}
	lastlist = cur ;
	if(cur.right != null){
		lastlist = convertNode(cur.right,lastlist);
	}
	return lastlist ;
}
#28 递归的方式字符交换
public ArrayList<String> Permutation(String str){
	ArrayList<String> result = new ArrayList<String>();
	if(str == null || str.length()==0){
		return result ;
	}
	char[] chars = str.toCharArray();
	TreeSet<String> temp = new TreeSet<>();
	Permutation(chars,0,temp);
	result.addAll(temp);
	return result ;
}

public void Permutation(char[] chars,int index,TreeSet<String> result){
	if(chars== null || chars.length == 0){
		return ;
	}
	if(index < 0 || index > chars.length-1){
		return ;
	}
	if(index == chars.length-1){
		result.add(String.valueOf(chars));
	}else{
		for( int i = index ; i <= chars.length-1 ; i++ ){
			swap(chars,index,i);
			Permutation(chars,index+1,result);
			//回退
			swap(chars,index,i);
		}
	}
}

public void swap(char[] c,int a ,int b){
	char temp = c[a];
	c[a] = c[b];
	c[b] = temp ;
}
#29 数量超过长度一半的字母
public int MoreThanHalfNum_Solution(int[] array){
	int maxConunt = array[0];
	int number = array[0];
	int count = 1;
	for( int i = 1 ; i < array.length ; i++ ){
		if(number != array[i]){
			if(count==0){
				number = array[i];
				count = 1;
			}else {
				count -- ;
			}	
		}else{
			count ++ ;
		}	

		if(count == 1){
			maxConunt = number ;
		}
	}
	//验证
	int num = 0 ;
	for( int j = 0 ; j < array.length ; j++ ){
		if(array[j] == maxConunt){
			num++;
		}
	}
	if(num*2 > array.length ){
		return maxConunt;
	}
	return 0 ;
}
#30 输入法n个整数，找出其中k个最小数
public ArrayList<Integer> GetLeastNumbers_Solution(int[] input ,int k){
	ArrayList<Integer> list = new ArrayList<>();
	if(input == null || k <= 0 || k > input.length){
		return list ;
	}
	int[] kArray = Arrays.copyOfRange(input,0,k);
	//创建大堆根
	buildHeap(kArray);

	for( int i = k ; i < input.length ; i++ ){
		if(input[i]<kArray[0]){
			kArray[0] = input[i] ;
			maxHeap(kArray,0);
		}
	}

	for(int i = kArray.length-1; i >= 0 ; i-- ){
		list.add(kArray[i]);
	}
	return list ;
}

public void buildHeap(int[] input){
	for( int i = input.length/2 - 1 ; i >= 0 ; i-- ){
		maxHeap(input,i);
	}
}

private void maxHeap(int[] array,int i){
	int left = 2*i + 1 ;
	int right = left + 1 ;
	int largest = 0 ;

	if(left < array.length && array[left] > array[i] ){
		largest = left ;
	}else{
		largest = i ;
	}

	if(right < array.length && array[right] > array[largest]){
		largest = right ;
	}

	if(largest != i){
		int temp = array[i];
		array[i] = array[largest];
		array[largest] = temp ;
		maxHeap(array,largest);
	}
}
#31连续子数组的最大和
public int FindGreatstSumOfSubArray(int[] array){
	if(array == null || array.length == 0){
		return 0 ;
	}
	int cur = array[0];
	int greast = array[0];

	for(int i = 1 ; i < array.length ; i++ ){
		if(cur<0){
			cur = array[i];
		}else{
			cur += array[i];
		}

		if(cur > greast){
			greast = cur ;
		}
	}
	return greast ;
}

#32 从1到整数n中1出现的次数
public long CountOne2(long n){
	long count = 0 ;
	long i = 1 ;
	long current = 0,after = 0 ,before = 0 ;
	while((n/i)!= 0){
		before = n / (i * 10) ; //高位
		current = (n / i) % 10 ; //当前位
		after = n - (n / i ) * i  ;//低位

		if(current == 0){
			//如果为0，出现1的次数由更高位决定，等于高位数字*当前位数
			count = count + before * i ;
		}else if( current == 1 ){
			//如果为1，出现1的次数由高位和低位决定，高位*当前位+低位+1
			count = count + before * i + after + 1 ;
		}else{
			//如果大于1，出现1的次数由高位和低位决定，（高位+1）*当前位
			count = count + ( before + 1) * i ;
		}
		//前移1位
		i = i * 10 ;
	}
	return count;
}