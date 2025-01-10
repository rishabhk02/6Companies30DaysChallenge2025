package Amazon;

class Solution {
    public String convertToTitle(int colNum) {
        if(colNum<=26){
            return ""+(char)(colNum-1+'A');
        }
        int modVal=colNum%26;
        int val=colNum/26;
        if(modVal==0){
            modVal=26;
            val--;
        }

        if(val>26){
            return convertToTitle(val)+(char)(modVal-1+'A');
        }
        return ""+(char)(val-1+'A')+(char)(modVal-1+'A');
    }
}
