/**
 * https://blog.csdn.net/wzy_2017/article/details/78910697
 */

#include <iostream>

#define inf 99999999
#define nmax 110

using namespace std;

int edge[nmax][nmax] ,n ,m;

int main() {
	while(cin >> n >> m && n != 0) {
		int i ,j;
		for (int i=0 ; i <= n ;i++) {
			for (int j=0 ; j <= n ; j++) {
				edge[i][j] = inf;
			}
			edge[i][i] = 0;
		}
		while (m--) {
			cin>>i>>j;
			cin>>edge[i][j];
			edge[j][i] = edge[i][j];
		}
		
		//floyd
		int k;
		for (k=1 ; k <= n ; k++) {
			for (i=1 ; i <= n ; i++) {
				for (j=1 ; j <= n ; j++) {
					if (edge[i][k] < inf && edge[i][j] > edge[i][k] + edge[k][j]) {
						edge[i][j] = edge[i][k] + edge[k][j];
					}
				}
			}
		}
		cout << edge[1][n] <<endl;
	}
}
