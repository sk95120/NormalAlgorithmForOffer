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

