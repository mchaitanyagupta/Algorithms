class Solution {
    public int numberOfSubstrings(String s) {
        int[] map = new int[3];
        int st = 0, e = 0, res = 0;

        for(e = 0; e < s.length(); e++){
            char c = s.charAt(e);
            map[c - 'a']++;
            while(map[0] > 0 && map[1] > 0 && map[2] > 0){
                res += s.length() - e;
                map[s.charAt(st) - 'a']--;
                st++;
            }
        }
        return res;
    }
}
//major pattern of thesliding window pattren using variable size window
