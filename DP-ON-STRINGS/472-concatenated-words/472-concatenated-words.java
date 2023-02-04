class Solution {
    Map<String, Boolean> map = new HashMap<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n = words.length;
        Set<String> set = new HashSet<>();
        for (String s : words) set.add(s);

        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (f(words[i], set)) res.add(words[i]);
        }

        return res;
    }

    private boolean f(String word, Set<String> set) {
        if (map.get(word) != null) return map.get(word);

        for (int i = 0; i < word.length(); i++) {
            String prefix = word.substring(0, i + 1);
            String suffix = word.substring(i + 1, word.length());

            if ((set.contains(prefix) && set.contains(suffix)) || 
                set.contains(prefix) && f(suffix, set)) {
                    map.put(word, true);
                    return true;
                }
        }

        map.put(word, false);
        return false;
    }
}