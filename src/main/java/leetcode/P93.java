package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P93 {

    public static void main(String[] args) {
        String str = "25525511135";
        List<String> list = restoreIpAddresses(str);
        for (String string: list
             ) {
            System.out.println(string);
        }
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public static boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }


  /*  public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        doRestore(result, "", s, 0);
        return result;
    }

    private static void doRestore(List<String> result, String path, String s, int k) {
        if (s.isEmpty() || k == 4) {
            if (s.isEmpty() && k == 4) {
                result.add(path.substring(1));
            }
            return;
        }
        //当第一个字段为0的时候就单独成一段
        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) {
            // Avoid leading 0
            String part = s.substring(0, i);
            if (Integer.valueOf(part) <= 255) {
                doRestore(result, path + "." + part, s.substring(i), k + 1);
            }
        }
    }*/
}
