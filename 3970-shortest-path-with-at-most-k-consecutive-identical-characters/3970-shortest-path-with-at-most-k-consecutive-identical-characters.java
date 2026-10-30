class Solution {
    class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public void createGraph(int edges[][],ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        for(int edge[] : edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            graph[u].add(new Edge(u,v,wt));
        }
    }
    class Pair implements Comparable<Pair>{
        int n;
        int w;
        int streak;
        Pair(int n,int w,int s){
            this.n=n;
            this.w=w;
            this.streak=s;
        }
        @Override
        public int compareTo(Pair p2){
            return this.w-p2.w;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        ArrayList<Edge> graph[]=new ArrayList[n];
        createGraph(edges,graph);
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int dist[][]=new int[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][1]=0; //it states the distance of 0th node with streak 1 is 0
        pq.add(new Pair(0,0,1));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node=curr.n;
            int wt=curr.w;
            int streak=curr.streak;
            if(wt>dist[node][streak]) continue; //0>d[0][1]

            for(int i=0;i<graph[node].size();i++){
                Edge e=graph[node].get(i);
                int u=e.src;
                int v=e.dest;
                int w=e.wt;
                char currCh=labels.charAt(v);
                int newStreak=streak;
                if(labels.charAt(u)==currCh){
                    newStreak=streak+1;
                }else{
                    newStreak=1;
                }
                if(newStreak>k) continue;
                if((dist[u][streak]+w)<dist[v][newStreak]){
                    dist[v][newStreak]=dist[u][streak]+w;
                    pq.add(new Pair(v,dist[v][newStreak],newStreak));
                }
            }
        }

        int res=Integer.MAX_VALUE;
        for(int i=0;i<=k;i++){
            res=Math.min(res,dist[n-1][i]);
        }
        return res==Integer.MAX_VALUE ? -1 : res;
    }
}