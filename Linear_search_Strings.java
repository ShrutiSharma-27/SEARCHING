import java.util.*;
public class Linear_search_Strings {
    public static void main(String[] args) {
        String name="Mountain";
        System.out.println(Arrays.toString(name.toCharArray()));
        char target1='u';
        System.out.println("result for 'u' : "+LinearSearch_String(name, target1));
        char target2='w';
        System.out.println("result for 'w' : "+LinearSearch_String(name, target2));
    }

    static boolean LinearSearch_String(String str, char target){
        if (str.length()==0){  //this has round brackets because it's a function but arr.length is a variable
            return false;
        }

        for (int i=0 ; i<str.length() ; i++){
            if (str.charAt(i)==target){
                return true;
            }
        }

        /* ******
        using for each loop
        for (char member : str.toCharArray()){
            if (member == target){
               return true;
            }
        }
        * ******/

        return false;
    }
}
