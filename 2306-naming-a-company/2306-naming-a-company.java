class Solution {
    public long distinctNames(String[] ideas) {
        int n = ideas.length;
        Set<String>[] grps = new HashSet[26];
        
        for(int i = 0; i < 26; i++)
            grps[i] = new HashSet<>();
        for(String idea : ideas)
            grps[idea.charAt(0) - 'a'].add(idea.substring(1));
        
        long ans = 0;
        for(int i = 0; i < 26; i++){
            for(int j = i + 1; j < 26; j++){
                
                long commons = 0;
                for(String ideaA : grps[i])
                    if(grps[j].contains(ideaA))
                        commons++;
                
                ans += 2 * (grps[i].size() - commons) * (grps[j].size() - commons);
            }
        }
        return ans;
    }
}