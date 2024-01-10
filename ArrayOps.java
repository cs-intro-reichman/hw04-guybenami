public class ArrayOps {
    public static void main(String[] args) {
        int arr[] = {1,2,3,3,2,1,3,2,3,2,4,1,3,2};
        int arr2[] = {5,4,4,3,3,3,3,3,4,1};
        System.out.println(isSorted(arr2));
    }
    
    public static int findMissingInt (int [] array) {
        int n = array.length;
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

    public static int secondMaxValue(int [] array) {
        int max = -2147483648;
        int max2 = -2147483648;
        int maxIndex = 0;
        for(int i=0 ; i<array.length ; i++) {
            if(max<array[i]) {
                max = array[i];
                maxIndex = i;
            }
        }
        for(int i=0 ; i<array.length ; i++) {
            if(max2 < array[i] && i != maxIndex)
                max2 = array[i];
        }
        return max2;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        boolean check = true;
        for(int i=0 ; i<array1.length ; i++) {
            for(int j=0 ; j<array2.length ; j++) {
                if(array1[i]==array2[j])
                    break;
                else if(j==array2.length-1)
                    check = false;
            }
        }
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
