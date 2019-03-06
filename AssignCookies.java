class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int content = 0;
        int cookie = 0;
        for (int each:g){
            while(cookie<s.length&&s[cookie]<each){
                cookie++;
            }
            if (cookie==s.length){
                return content;
            }
            else if (each<=s[cookie]){
                content++;
                cookie++;
            }
        }
        return content;
    }
}




/////////////
Arrays.sort(g);
Arrays.sort(s);
int i = 0;
for(int j=0;i<g.length && j<s.length;j++) {
	if(g[i]<=s[j]) i++;
}
return i;
