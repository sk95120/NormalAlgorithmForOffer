/**
 * https://blog.csdn.net/wzy_2017/article/details/78910697
 */

#include <iostream>

#define inf 99999999
#define nmax 110

using namespace std;

int edge[nmax][nmax] ,n ,m;
int dst[nmax];
int book[nmax];

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
		
		//dijkstra
		for (i=1 ; i < n ; i++) {
			dst[i] = edge[1][s];
		}
		for (i=1 ; i < n ; i++) {
			book[i] = 0;
		}
		for (i = 1 ; i < n-1 ; i++) {
			min = inf;
			for (j = 1 ; j <=n lj++) {
				if(book[j] == 0 && dst[i] < min) {
					min = dst[j];
					u = j;
				}
			}
			book[u] = 1;
			for (k =1 ; k<= n ; k++) {
				if (edge[u][k] < inf && book[k] == 0) {
					if (dst[k] > dst[u] + edge[u][k]) {
						dst[k] = dst[u] + edge[u][k];
					}
				}
			}
		}
		
		cout << edge[1][n] <<endl;
	}
}
