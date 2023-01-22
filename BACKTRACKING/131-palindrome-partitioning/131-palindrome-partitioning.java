class Solution {
    List<List<String>> ans;
    int n;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        n = s.length();

        return partition(s, 0, new ArrayList<>());
    }
    public List<List<String>> partition(String s, int idx, List<String> tmp){
        if(idx == n){ 
            ans.add(new ArrayList<>(tmp));
            return ans;
        }

        for(int i = idx; i < n; i++){
            if(isPalindrome(s, idx, i)){
                tmp.add(s.substring(idx, i+1)); // i + 1 coz, end is exclusive
                partition(s, i + 1, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
        return ans;
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start <= end)
            if(s.charAt(start++) != s.charAt(end--)) return false;
        return true;
    }
}