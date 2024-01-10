public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        
    }

    public static String capVowelsLowRest (String string) {
        String newStr = "";
        for(int i=0 ; i<string.length() ; i++) {
            if(isVowel(string.charAt(i))) {
                if(string.charAt(i)>90)
                    newStr += (char)(string.charAt(i)-32);
                else
                    newStr += string.charAt(i);
            }
            else {
                if(string.charAt(i)== ' ' || string.charAt(i)>90)
                    newStr += string.charAt(i);
                else
                    newStr += (char)(string.charAt(i)+32);
            }
        }
        return newStr;
    }

    public static boolean isVowel(char ch) {
        String vowels = "aeiouAEIOU";
        return vowels.indexOf(ch) != -1;
    }

    public static String camelCase (String string) {
        String newStr = "";
        indexOfSpaces(string);
        string = lowerCase(string);
        for(int i=0 ; i<string.length() ; i++) {
            if(!space_indexes[i]) {
                if(i==0)
                    newStr += string.charAt(i);
                else if(!space_indexes[i-1])
                    newStr += string.charAt(i);
                else if(newStr != "")
                    newStr += (char)(string.charAt(i) - 32);
                else
                    newStr += string.charAt(i);
            }
        }
        return newStr;
    }

    static boolean[] space_indexes = new boolean[1000000];
    public static void indexOfSpaces(String str) {
        for(int i=0 ; i<space_indexes.length ; i++)
            space_indexes[i] = false;
        for(int i=0 ; i<str.length() ; i++){
            if(str.charAt(i) == ' ')
                space_indexes[i] = true;
        }
    }

    public static String lowerCase(String str) {
        String newStr = "";
        for(int i=0 ; i<str.length() ; i++)
            if(str.charAt(i)<91 && str.charAt(i) != ' ')
                newStr += (char)(str.charAt(i)+32);
            else
                newStr += str.charAt(i);
        return newStr;
    }

    public static int[] allIndexOf (String string, char chr) {
        int counter = 0;
        for(int i=0 ; i<string.length() ; i++) {
            if(string.charAt(i)==chr)
                counter++;
        }
        int j=0;
        int[] chrIndex = new int[counter];
        for(int i=0 ; i<string.length() ; i++) {
            if(string.charAt(i)==chr) {
                chrIndex[j] = i;
                j++;
            }
        }
        return chrIndex;
    }
}
