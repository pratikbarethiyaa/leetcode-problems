class ProductOfNumbers {
    List<Integer> stream;
    int lastZero;

    public ProductOfNumbers() {
        stream=new ArrayList<>();
        lastZero=-1;
    }
    
    public void add(int num) {
        if(stream.isEmpty()){
            if(num==0) lastZero=0;
            stream.add(num);
            return;
        }
        if(num==0){
            stream.add(0);
            lastZero=stream.size()-1;
            return;
        }
        if(stream.get(stream.size()-1)==0){
            stream.add(num);
            return;
        }
        stream.add(stream.get(stream.size()-1)*num);
    }
    
    public int getProduct(int k) {
        int idx=stream.size()-k-1;
        if(lastZero>idx){
            return 0;
        }
        if(idx==-1) return stream.get(stream.size()-1);
        if(stream.get(idx)==0){
            return stream.get(stream.size()-1);
        }
        return stream.get(stream.size()-1)/stream.get(idx);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */