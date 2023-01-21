class Solution {
    int n;
    List<String> result;

    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        result = new ArrayList<>();

        if(n > 12) return new ArrayList<>();

        int parts = 0;
        String curr = "";

        restoreIpAddresses(s, 0, parts, curr);

        return result;
    }
    public void restoreIpAddresses(String s, int idx, int parts, String curr){
        if(parts > 4) return;

        if(idx == n && parts == 4){
            result.add(curr.substring(0, curr.length() - 1)); // remove last dot
            return;
        }

        if(idx + 1 <= n)
            restoreIpAddresses(s, idx + 1, parts + 1, curr + s.substring(idx, idx + 1) + ".");

        if(idx + 2 <= n && isValid(s.substring(idx, idx + 2)))
            restoreIpAddresses(s, idx + 2, parts + 1, curr + s.substring(idx, idx + 2) + ".");
        
        if(idx + 3 <= n && isValid(s.substring(idx, idx + 3)))
            restoreIpAddresses(s, idx + 3, parts + 1, curr + s.substring(idx, idx + 3) + ".");
    }
    public boolean isValid(String str){
        if(str.charAt(0) == '0') return false; // check for leading zeroes
        
        int val = Integer.parseInt(str);

        return val <= 255; // in range 0 to 255
    }
}