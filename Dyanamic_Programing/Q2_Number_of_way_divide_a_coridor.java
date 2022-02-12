package Dyanamic_Programing;
/*
!Name: Aritra Ghorai
!Date:04/02/2022
?Program Details: 
*/

public class Q2_Number_of_way_divide_a_coridor {
    private int mod = (int) 1e9 + 7;

    public int numberOfWays(String corridor) {
        return helper(corridor.toCharArray(), 0, 0, new Integer[corridor.length() + 1][3]);

    }

    public int helper(char[] arr, int index, int numberOfSheat, Integer[][] storage) {
        if (index == arr.length) {
            if (numberOfSheat == 2)
                return 1;
            return 0;
        }
        if (storage[index][numberOfSheat] != null)
            return storage[index][numberOfSheat];
        int res = 0;
        // *When numberof sheat is 2
        if (numberOfSheat == 2) {
            // *if the index is plant
            if (arr[index] == 'P') {
                res += helper(arr, index + 1, 0, storage);
                res += helper(arr, index + 1, numberOfSheat, storage);
                res %= mod;
            } else {
                res += helper(arr, index + 1, 1, storage);
                res %= mod;
            }
        } else {
            res += helper(arr, index + 1, numberOfSheat = arr[index] == 'P' ? numberOfSheat : numberOfSheat + 1,
                    storage);
            res %= mod;
        }
        return storage[index][numberOfSheat] = res;
    }
}
