package GoldmanSachs;

class DataStream {
    int v; int k; int prev;
    public DataStream(int value, int k) {
        this.v=value; this.k=k; prev=0;
    }
    
    public boolean consec(int num) {
        if(num==v) prev++;
        else prev=0;
        return prev>=k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */