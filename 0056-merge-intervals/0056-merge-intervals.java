class Solution {
    public int[][] merge(int[][] intervals){
        int n=intervals.length;
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        List<List<Integer>> list=new ArrayList<>();

        List<Integer> l=new ArrayList<>();
        l.add(intervals[0][0]);
        l.add(intervals[0][1]);
        list.add(l);
    
        for(int i=1;i<n;i++){
            int last=list.get(list.size()-1).get(1);
            if(intervals[i][0]<=list.get(list.size()-1).get(1)){
                list.get(list.size() - 1).set(1, Math.max(last, intervals[i][1]));            
            }else{
                list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
        }
        int arr[][]=new int[list.size()][2];
        int i=0;
        for(List<Integer> l1: list){
            arr[i][0]=l1.get(0);
            arr[i][1]=l1.get(1);
            i++;
        }
    return arr;
    }
}