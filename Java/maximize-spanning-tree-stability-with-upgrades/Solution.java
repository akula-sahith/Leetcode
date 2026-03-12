import java.util.*;

class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
        }

        int find(int x){
            if(parent[x]!=x)
                parent[x]=find(parent[x]);
            return parent[x];
        }

        boolean union(int a,int b){
            int pa=find(a), pb=find(b);
            if(pa==pb) return false;

            if(rank[pa]<rank[pb])
                parent[pa]=pb;
            else if(rank[pb]<rank[pa])
                parent[pb]=pa;
            else{
                parent[pb]=pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        int maxS = 0;
        for(int[] e:edges) maxS = Math.max(maxS, e[2]);

        int lo = 0, hi = maxS*2;
        int ans = -1;

        while(lo <= hi){
            int mid = (lo + hi)/2;

            if(can(mid, n, edges, k)){
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean can(int x, int n, int[][] edges, int k){

        DSU dsu = new DSU(n);
        int upgrades = 0;
        int used = 0;

        // mandatory edges
        for(int[] e:edges){
            int u=e[0], v=e[1], s=e[2], must=e[3];

            if(must==1){
                if(s < x) return false;
                if(!dsu.union(u,v)) return false;
                used++;
            }
        }

        // optional edges without upgrade
        for(int[] e:edges){
            int u=e[0], v=e[1], s=e[2], must=e[3];

            if(must==0 && s>=x){
                if(dsu.union(u,v)) used++;
            }
        }

        // optional edges with upgrade
        for(int[] e:edges){
            int u=e[0], v=e[1], s=e[2], must=e[3];

            if(must==0 && s<x && 2*s>=x){
                if(dsu.union(u,v)){
                    upgrades++;
                    used++;
                    if(upgrades > k) return false;
                }
            }
        }

        return used == n-1;
    }
}