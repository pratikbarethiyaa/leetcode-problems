class Solution {
    public boolean canAliceWin(int n) {
        int val=10;
        int turn=0;  //0 for alice, 1 for bob
        while(val<=n){
            n-=val;
            val--;
            turn=(turn==0) ? 1 : 0;
        }
        return turn==0 ? false : true;
    }
}