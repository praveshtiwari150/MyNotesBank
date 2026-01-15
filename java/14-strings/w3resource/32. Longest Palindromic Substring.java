class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";

        // odd length pal
        for(int axis = 0; axis<n; axis++){
            int orbit = 1;
            int len = 1;

            while(axis - orbit >= 0 && axis + orbit<n){
                if(s.charAt(axis-orbit) == s.charAt(axis+orbit)){
                    orbit++;
                    len+=2;
                }

                else {
                    break;
                }
            }

            if(len > res.length()){
                int startIndex = axis - len/2;
                res = s.substring(startIndex, startIndex+len);
            }
        }

        // even palindromes
        for(int axis = 0; axis < n-1; axis++){
            int orbit = 1;
            int len = 0;

            while(axis - orbit + 1 >= 0 && axis + orbit < n-1){
                if(s.charAt(axis-orbit + 1) == s.charAt(axis+orbit)){
                    orbit++;
                    len+=2;
                }

                else{
                    break;
                }
            }

            if(len > res.length()){
                int startIndex = axis - len/2 + 1;
                res =  s.substring(startIndex, startIndex + len);
            }
        }

        return res;
    }
}
