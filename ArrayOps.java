public class ArrayOps {
    public static void main(String[] args) {
        
    }
    
    //takes an array of integers {0,1,2...n} that is missing one integer, and return the value of the missing integer
    public static int findMissingInt (int [] array) {
        int n = array.length;
        //declaring an array that holds true or false for each index if the corresponding index exist as value in the array or not
        boolean check[] = new boolean[n+1];
        for(int i=0 ; i<n ; i++) 
            check[i] = false;
        for(int i=0 ; i<n ; i++) {
            check[array[i]] = true;
        }
        int j = 0;
        while(check[j])
            j++;
        return j;
    }

    //takes an array of integers as input and return the 2nd biggest integer in the array (return the 1st biggest integer if it appears more than once)
    public static int secondMaxValue(int [] array) {
        //declaring and initializing max and max2 as the smallest value of integer type variable
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int maxIndex = 0;
        //searching for the max value
        for(int i=0 ; i<array.length ; i++) {
            if(max<array[i]) {
                max = array[i];
                maxIndex = i;
            }
        }
        //searching for the max without looking at the index of 'max'
        for(int i=0 ; i<array.length ; i++) {
            if(max2 < array[i] && i != maxIndex)
                max2 = array[i];
        }
        return max2;
    }

    //takes 2 arrays of integers as input and return true if they contain the same integers (ignoring duplicates)
    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        boolean check = true;
        //checking if all of array1's integers appear in array2
        for(int i=0 ; i<array1.length ; i++) {
            for(int j=0 ; j<array2.length ; j++) {
                if(array1[i]==array2[j])
                    break;
                else if(j==array2.length-1)
                    check = false;
            }
        }
        //checking if all of array2's integers appear in array1
        for(int i=0 ; i<array2.length ; i++) {
            for(int j=0 ; j<array1.length ; j++) {
                if(array2[i]==array1[j])
                    break;
                else if(j==array1.length-1)
                    check = false;
            }
        }
        return check;
    }

    // takes an array of integers as input and return true if the array is either increasing in value or decreasing as you go from index 0 to n
    //ignoring equal values that are near eachother
    public static boolean isSorted(int [] array) {
        boolean increase=true, decrease=true;
        for(int i=0 ; i<array.length-1 && (increase || decrease); i++) {
            if(array[i]>array[i+1] && increase)
                increase = false;
            if(array[i]<array[i+1] && decrease)
                decrease = false;
        }
        return increase || decrease;
    }

}
