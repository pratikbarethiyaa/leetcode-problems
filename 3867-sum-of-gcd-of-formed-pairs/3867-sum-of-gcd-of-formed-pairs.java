class Solution {
    public int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int preGcd[]=new int[n];
        preGcd[0]=nums[0];
        int max=nums[0];

        for(int i=1;i<n;i++){
            max=Math.max(max,nums[i]);
            preGcd[i]=gcd(max,nums[i]);
        }
        Arrays.sort(preGcd);

        long sum=0L;

        int l=0;
        int r=n-1;

        while(l<r){
            sum+=gcd(preGcd[l],preGcd[r]);
            l++;
            r--;
        }
        return sum;
    }
}