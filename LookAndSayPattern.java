public class LookAndSayPattern {
    public String countAndSay(int n) {
        if(n == 1)  return "1";
        String s = countAndSay(n-1);
        // s ko pdhna hai
        String ans = "";
        int i=0,j=0;
        while(j<s.length()) {
            if(s.charAt(i) == s.charAt(j)) j++;
            else{
                int freq = j-i;
                ans += freq;
                ans += s.charAt(i);
                i=j;
            }
        }
        int freq = j-i;
        ans += freq;
        ans += s.charAt(i);
        return ans;
    }
}

// 1
// 1 1
// 2 1
// 1 2 1 1
// 1 1 1 2 2 1