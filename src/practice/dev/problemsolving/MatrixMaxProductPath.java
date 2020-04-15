package practice.dev.problemsolving;

public class MatrixMaxProductPath {

    public static void main(String[] args) {

        MatrixMaxProductPath c = new MatrixMaxProductPath();
        c.findMaxProductInMatrix();
    }

    public void findMaxProductInMatrix() {
        int[][] m = {
                {-1, 2, 3},
                {4, 5, -6},
                {7, 8, 9}
        };
        int[][] cache = new int[3][3];
        for(int i = 0; i < 3; ++i) {
            cache[i] = new int[3];
            for(int j = 0; j < 3; ++j) {
                cache[i][j] = 0;
            }
        }
        fmpm(cache, m, 3, 0 , 0);
        System.out.println(cache[2][2]);
    }

    private int fmpm(int[][]cache, int[][] m, int l, int r, int c) {
        int res = 1;
        if(c >= l || r >= l) {
            return res;
        }
        if(cache[r][c] != 0) {
            return cache[r][c];
        }
        int mx = Math.max(
                fmpm(cache, m, l, r+1, c),
                fmpm(cache, m, l, r, c+1)
        );
        if (mx <= 0) {
            res = m[r][c];
        } else {
            res = m[r][c] * mx;
        }
        cache[r][c] = res;
        return res;
    }

}
