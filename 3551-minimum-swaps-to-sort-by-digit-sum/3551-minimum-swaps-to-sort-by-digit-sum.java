class Solution {

    public int getDigSum(int n){
        int sum=0;
        while(n>0){
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n=nums.length;
        Integer digArr[]=new Integer[n];
        
        for(int i=0;i<n;i++){
            digArr[i]=nums[i];
        }

        Arrays.sort(digArr, (a, b) -> {
        int num1DigSum = getDigSum(a);
        int num2DigSum = getDigSum(b);

        if (num1DigSum != num2DigSum) {
            return Integer.compare(num1DigSum, num2DigSum);
        }
        return Integer.compare(a, b);
    });

        int swaps=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<n;i++){
            int currEle=nums[i];
            int expEle=digArr[i];

            if(currEle==expEle) continue;

            int idx=map.get(expEle);
            nums[i]=expEle;
            nums[idx]=currEle;

            map.put(expEle,i);
            map.put(currEle,idx);

            swaps++;
        }
        return swaps;
    }
}