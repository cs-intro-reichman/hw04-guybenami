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

    //takes a (valid) string as input and return the same string with upper case vowels and lower case evertything else
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

    //return true if a given char is a vowel and false otherwise
    public static boolean isVowel(char ch) {
        String vowels = "aeiouAEIOU";
        return vowels.indexOf(ch) != -1;
    }

    // takes a (valid) string as input and return the same string without spaces and all lower case
    // except for the first letter of each word from the second word (incusive) and on
    public static String camelCase (String string) {
        String newStr = "";
        //calling the indexOfSpaces() function
        boolean[] space_indexes = indexOfSpaces(string);
        //calling the lowerCase() funtion (that i created)
        string = lowerCase(string);

        //going through the string char by char and mutating it according to the requirments
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


    //takes a (valid) string as input and return a boolean array that hold true if the corresponding index in the given string is a space
    public static boolean[] indexOfSpaces(String str) {
        boolean[] space_indexes = new boolean[str.length()];
        for(int i=0 ; i<space_indexes.length ; i++)
            space_indexes[i] = false;
        for(int i=0 ; i<str.length() ; i++){
            if(str.charAt(i) == ' ')
                space_indexes[i] = true;
        }
        return space_indexes;
    }

    //take a (valid) string as input and return the same string with only lower cases letters
    public static String lowerCase(String str) {
        String newStr = "";
        for(int i=0 ; i<str.length() ; i++)
            if(str.charAt(i)<91 && str.charAt(i) != ' ')
                newStr += (char)(str.charAt(i)+32);
            else
                newStr += str.charAt(i);
        return newStr;
    }

    //takes a (valid) string and a char as input and return the indexes of the string in which the char appears
    public static int[] allIndexOf (String string, char chr) {
        int counter = 0;
        //checking how many times chr appears in string
        for(int i=0 ; i<string.length() ; i++) {
            if(string.charAt(i)==chr)
                counter++;
        }
        int j=0;
        //declaaring an array to hold the wanted indexes
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
