public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String word = "";
        for (String str : s.split("")) {
            try {
                int num = Integer.parseInt(str);
                word += str;
            }
            catch (NumberFormatException e) {
                if (((int)str.charAt(0)>=65 && (int)str.charAt(0)<=90) || ((int)str.charAt(0)>=97 && (int)str.charAt(0)<=122)) {
                    word += str;
                }
            }
        }
        word = word.toLowerCase();
        boolean answer = true;
        String[] arr = word.split("");
        for (int i=0; i<word.length()/2; i++) {
            if (arr[i].equals(arr[arr.length-1-i])) {
                continue;
            }
            else {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
