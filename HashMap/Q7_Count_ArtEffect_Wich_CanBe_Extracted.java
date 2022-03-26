package HashMap;

/*
 !Name: Aritra Ghorai
 !Date:22/03/2022
 ?Program Details:2201. Count Artifacts That Can Be Extracted
 *https://leetcode.com/problems/count-artifacts-that-can-be-extracted/
   */
public class Q7_Count_ArtEffect_Wich_CanBe_Extracted {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        // *Create 2d in which position the arteffect is digged
        int[][] hash = new int[n][n];
        // *Point the diged position
        for (int[] di : dig) {
            hash[di[0]][di[1]] = 1;
        }
        int count = 0;
        // *Now Chack How Many ArtEffect Is Fully Dig
        for (int[] arteffect : artifacts) {
            int r1 = arteffect[0], c1 = arteffect[1], r2 = arteffect[2], c2 = arteffect[3];
            boolean flag = true;
            for (int i = r1; i <= r2 && flag; i++) {
                for (int j = c1; j <= c2; j++) {
                    if (hash[i][j] == 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;

    }
}
