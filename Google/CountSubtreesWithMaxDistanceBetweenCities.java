package Google;
import java.util.*;

class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int dist[][] = new int[n][n];
        for(int row[]: dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        for(int edge[]: edges){
            int u=edge[0]-1; int v=edge[1]-1;
            dist[u][v]=1; dist[v][u]=1;
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE){
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }

        int res[] = new int[n-1];
        for(int i=1; i<(1<<n); i++){
            int maxD = helper(i,dist);
            if(maxD>0){
                res[maxD-1]++;
            }
        }

        return res;
    }

    int helper(int mask, int dist[][]){
        int nodes=0; int edges=0; int maxD=0;
        for(int i=15; i>=0; i--){
            if((mask&1<<i)==0) continue;
            nodes++;
            for(int j=i-1; j>=0; j--){
                if((mask&1<<j)==0) continue;
                if(dist[i][j]==1) edges++;
                maxD=Math.max(maxD,dist[i][j]);
            }
        }
        return (nodes==edges+1)?maxD:-1;
    }
}
