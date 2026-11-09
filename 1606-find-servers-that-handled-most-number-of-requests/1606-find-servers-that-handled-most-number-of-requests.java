class Solution {
    class Pair implements Comparable<Pair>{
        int time;
        int server;
        Pair(int t,int s){
            this.time=t;
            this.server=s;
        }
        @Override
        public int compareTo(Pair p2){
            if(this.time==p2.time){
                return this.server-p2.server;
            }
            return this.time-p2.time;
        }
    }
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n=arrival.length;
        List<Integer> res=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        TreeSet<Integer> set=new TreeSet<>();
        int max=0;
        int count[]=new int[n];
        for(int i=0;i<Math.min(k,n);i++){
            pq.add(new Pair(arrival[i]+load[i],i));
            count[i]++;
            max=Math.max(count[i],max);
        }
        for(int i=k;i<n;i++){
            while(!pq.isEmpty() && pq.peek().time<=arrival[i]){
                Pair curr=pq.remove();
                set.add(curr.server);
            }
            if(set.isEmpty()){
                continue;
            }

            int idx=i%k;
            Integer server=set.ceiling(idx);
            if(server==null){
                server=set.first();
            }

            set.remove(server);
            pq.add(new Pair(arrival[i]+load[i],server));
            count[server]++;
            max=Math.max(count[server],max);
        }
        for(int i=0;i<n;i++){
            if(count[i]==max) res.add(i);
        }
        return res;
    }
}
/* 
    -check if the servers are free and put in q
    if not free check if there is one ending
    if not let it go
    else remove from q and increase the count
    oh... we also need to know which server became free so we need a map
    but wait ? we shld have a proper numbering so we will use orderset i.e treeset in java

*/