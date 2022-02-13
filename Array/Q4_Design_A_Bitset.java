package Array;

/*
 !Name: Aritra Ghorai
 !Date:13/02/2022
 ?Program Details: 
   */
public class Q4_Design_A_Bitset {
    public static void main(String[] args) {
        Bitset b = new Bitset(5);
        b.fix(3);
        b.fix(1);
        System.out.println(b.toString());
        b.flip();
        System.out.println(b.toString());
    }
}

class Bitset {
    int[] arr;
    int size;
    int count = 0;
    boolean flip = false;

    public Bitset(int s) {
        arr = new int[s];
        size = s;
    }

    public void fix(int idx) {
        if (!flip) {
            if (arr[idx] == 0) {
                arr[idx] = 1;
                count++;
            }
        } else {
            if (arr[idx] == 1) {
                count++;
                arr[idx] = 0;
            }
        }
    }

    public void unfix(int idx) {
        if (!flip) {
            if (arr[idx] == 1) {
                arr[idx] = 0;
                count--;
            }
        } else {
            if (arr[idx] == 0) {
                count--;
                arr[idx] = 1;
            }
        }
    }

    public void flip() {
        count = size - count;
        flip = !flip;
    }

    public boolean all() {
        return size == count;
    }

    public boolean one() {
        return count >= 1;
    }

    public int count() {
        return count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (!flip)
                sb.append(arr[i]);
            else
                sb.append(arr[i] == 0 ? 1 : 0);
        }

        return sb.toString();
    }

}
