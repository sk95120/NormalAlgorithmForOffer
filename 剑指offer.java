#36 数组中的逆序对
int count = 0 ;
public int InversePairs(int [] array){
	if(array==null){
		return 0;
	}
	mergSort(array,0,array.length-1);
	return count;
}

private void mergSort(int [] data,int start, int end){	
	int mid = (start + end ) / 2;
	if(start < end ){
		mergSort(data,start,mid);
		mergSort(data,mid+1,end);
		merge(data,start,mid,end);
	}
}

public void merge(int [] data,int start , int mid ,int end){
	int arr[]= new int[end - start + 1];
	int c = 0 ;
	int s = start ;
	int index = mid + 1 ;
	while(start<=mid && index <= end){
		if(data[start] < data[index] ){
			arr[c++]=data[start++];
		}else{
			arr[c++]=data[index++];
			count+=mid+1-start;
			count %= 1000000007;
		}
	}

	while(start <= mid){
		arr[c++] = data[start++];
	}
	while(index <= end){
		arr[c++] = data[indx++];
	}
	for(int d : arr){
		data[s++] = d ;
	}
}	
#37 链表公共节点
public ListNode FindFirstCommonNode(ListNode pHead1,ListNode pHead2){
	ListNode p1 = pHead1 ;
	ListNode p2 = pHead2 ;
	while(p1 != p2 ){
		p1 = (p1 != null ? p1.nextNode : pHead2);
		p2 = (p2 != null ? p2.nextNode : pHead1);
	}
	return p1 ;
}

#38 数字在数组中出现的次数 二分查找+递归
public int GetNumberOfK(int [] array , int k){
	int result = 0 ;
	int mind = array.length / 2 ;

	if(array == null || array.length == 0){
		return 0;
	}
	if(array.length == 1){
		if(array[0] == k){
			return 1 ;
		}else{
			return 0 ;
		}
	}

	if(k < array[mid]){
		result += GetNumberOfK(Arrays.copyOfRange(array,0,mid),k);
	}else if(k > array[mid]){
		result += GetNumberOfK(Arrays.copyOfRange(array,mid,array.length),k);
	}else{
		for( int i = mid ; i < array.length ; i++ ){
			if(array[i] == k ){
				result++
			}else{
				break;
			}
		}
		for(int i = mid-1 ;  i >= 0 ; i-- ){
			if(array[i] == k){
				result++;
			}elss{
				break ;
			}
		}
	}
	return result;
}

#39 树的深度 递归遍历左右子树
public int TreeDepth(TreeNode root){
	if(root == null ){
		return 0 ;
	}
	int left = TreeDepth(root.left);
	int right = TreeDepth(root.right);
	return left > right ? left+1 : right+1 ;
}
#39.1 平衡二叉树
public boolean IsBalanced_Solution(TreeNode root){
	if(root == null){
		return true ;
	}
	int left = getDepth(root.left);
	int right = getDepth(root.right);
	int diff = left - right ;
	if(diff >= -1 && diff <= 1){
		return true ;
	}else{
		return false ;
	}
}
public int getDepth(TreeNode root){
	if(root == null){
		return 0 ;
	}
	int depth = 0 ;
	int leftNode = getDepth(root.left);
	int rightNode = getDepth(root.right);
	depth = leftNode > rightNode ? leftNode : rightNode ;
	return depth + 1 ; 
}

#40 public void FindNumsAppearOnce(int [] array,int num1[] int num2[]){
	if(array == null){
		return ;
	}
	num1[0] = 0 ;
	num2[0] = 0 ;
	int number = array[0];
	for( int i = 1 ; i < array.length ; i++ ){
		number ^= array[i];
	}
	//抑或后数字1出现的位置
	int index = 0 ;
	while((number & 1) == 0){
		number = number >> 1 ;
		index ++ ;
	}


	for( int i = 0 ; i < array.length ; i++ ){
		//判断index位是不是0
		boolean isBit = ((array[i]>>index)&1)==0;
		if(isBit){
			num1[0] ^= array[i];
		}else{
			num2[0] ^= array[i];
		}
	}
}

