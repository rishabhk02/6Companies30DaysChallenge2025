package Google;

class Solution {
    String ones[] = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String diff[] = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String tens[] = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        int c = 0;
        String str = String.valueOf(num);
        int n = str.length();
        String res = "";
        for(int i=n-1; i>=0; i-=3){
            String cur = str.substring(Math.max(0,i-3+1),i+1);
            if(c==0){
                res = converToHun(cur)+res;
            }else if(c==1){
                String val = converToTho(cur);
                if(val.length()>0) res = val+" "+res;
            }else if(c==2){
                String val = converToMil(cur);
                if(val.length()>0) res = val+" "+res;
            }else{
                String val = converToBil(cur);
                if(val.length()>0) res = val+" "+res;
            }
            c++;
        }
        return res.trim();
    }

    String converToHun(String s){
        int n = s.length();
        String res = "";
        if(n==3 && s.charAt(0)!='0'){
            res = ones[s.charAt(0)-'0'] + " Hundred";
        }
        if(n>=2){
            int idx = (n>2)?1:0;
            if(s.charAt(idx)!='0'){
                String val = tens[s.charAt(idx)-'0'];
                if(s.charAt(idx)=='1'){
                    val = diff[s.charAt(idx+1)-'0'];
                }
                if(res.length()>0) res+=" "+val;
                else res+=val;
                if(s.charAt(idx)=='1'){
                    return res;
                }
            }
        }
        int idx = (n==3)?2:(n==2)?1:0;
        if(s.charAt(idx)!='0'){
            if(res.length()>0) res+=" "+ones[s.charAt(idx)-'0'];
            else res+=ones[s.charAt(idx)-'0'];
        }
        return res;
    }

    String converToTho(String s){
        String res = converToHun(s);
        if(res.length()>0)res = res+" Thousand";
        return res;
    }

    String converToMil(String s){
        String res = converToHun(s);
        if(res.length()>0)res = res+" Million";
        return res;
    }

    String converToBil(String s){
        String res = converToHun(s);
        if(res.length()>0)res = res+" Billion";
        return res;
    }

}
