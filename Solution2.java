package demo;

public class Solution2 {

    //定义有相图的边长
    private static int STAMP = 20;
    //权值最大
    private static int MaxPointNum = 0 ;
    //路径
    private static  int IndexOfChainStr = 0 ;
    private static  int[] ChainStr = new int[STAMP*STAMP +2];

    private int DAG(int[] point , boolean[][] vert ,int index,int tempPointNum ){
        if(point == null || vert== null) {
            return -1;
        }

        while (tempPointNum < MaxPointNum && NoChainLoop()){
            MaxPointNum += point[index];

            for(int i = 0 ; i < STAMP ; i++){
                int tempPoint = -1;
                int temp = -1;
                if(i!=index && vert[index][i] ){
                    DAG(point,vert,i,tempPointNum + point[i]);
                }else{
                    return 0;
                }
                ChainStr[IndexOfChainStr++] = temp;
                //TODO 线程安全
                index = temp ;
                MaxPointNum = tempPointNum > MaxPointNum? tempPointNum: MaxPointNum;
            }
        }

        return MaxPointNum;
    }

    private boolean NoChainLoop() {
        //ChainStr charToList
        return true;
    }

    public static void mian(String args){

        //定义权重，有向路径
        int[] point = new int[STAMP+2];
        boolean[][] vert = new boolean[STAMP+2][STAMP+2];

        //随机生成有相图
        for(int i = 0; i < STAMP ; i++ ){
            point[i] = (int)(Math.random() * 100);
        }
        for(int i =0; i <STAMP ;i++ ){
            for(int j =0; i <STAMP ;i++ ){
                vert[i][j] =( Math.random()>0.4 );
            }
        }

        //求有向无环图的最大权值
        Solution2 solution2 = new Solution2();
        solution2.DAG(point,vert,0,-1);
    }

}
