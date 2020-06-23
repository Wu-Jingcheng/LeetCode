class Solution {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1 = start1[0];
        int y1 = start1[1];
        int x2 = end1[0];
        int y2 = end1[1];
        int x3 = start2[0];
        int y3 = start2[1];
        int x4 = end2[0];
        int y4 = end2[1];
        boolean hasAnswer = false;

        double[] ans = new double[2];
        if ((y4 - y3) * (x2 - x1) == (y2 - y1) * (x4 - x3)) {
            if ((y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)) {
                if (inside(x1, y1, x2, y2, x3, y3)) {
                    hasAnswer = update(ans, (double)x3, (double)y3, hasAnswer);
                }
                if (inside(x1, y1, x2, y2, x4, y4)) {
                    hasAnswer = update(ans, (double)x4, (double)y4, hasAnswer);
                }
                if (inside(x3, y3, x4, y4, x1, y1)) {
                    hasAnswer = update(ans, (double)x1, (double)y1, hasAnswer);
                }
                if (inside(x3, y3, x4, y4, x2, y2)) {
                    hasAnswer = update(ans, (double)x2, (double)y2, hasAnswer);
                }
            }
        } else {
            double t1 = (double)(x3 * (y4 - y3) + y1 * (x4 - x3) - y3 * (x4 - x3) - x1 * (y4 - y3)) / ((x2 - x1) * (y4 - y3) - (x4 - x3) * (y2 - y1));
            double t2 = (double)(x1 * (y2 - y1) + y3 * (x2 - x1) - y1 * (x2 - x1) - x3 * (y2 - y1)) / ((x4 - x3) * (y2 - y1) - (x2 - x1) * (y4 - y3));
            if (t1 >= 0.0 && t1 <= 1.0 && t2 >= 0.0 && t2 <= 1.0) {
                ans[0] = x1 + t1 * (x2 - x1);
                ans[1] = y1 + t1 * (y2 - y1);
                hasAnswer = true;
            }
        }
        if(hasAnswer) {
            return ans;
        }
        return new double[0];
    }

    // 判断 (xk, yk) 是否在「线段」(x1, y1)~(x2, y2) 上
    private boolean inside(int x1, int y1, int x2, int y2, int xk, int yk) {
        return (x1 == x2 || (Math.min(x1, x2) <= xk && xk <= Math.max(x1, x2))) && (y1 == y2 || (Math.min(y1, y2) <= yk && yk <= Math.max(y1, y2)));
    }

    private boolean update(double[] ans, double xk, double yk, boolean hasAnswer) {
        if (!hasAnswer || xk < ans[0] || (xk == ans[0] && yk < ans[1])){
            ans[0] = xk;
            ans[1] = yk;
            return true;
        }
        return hasAnswer;
    }

}