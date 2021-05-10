package com.leetcode.Offer;

/**
 * Created by D on 2021/5/10.
 */
public class _13 {
    //记录访问过的节点
    int visit[][] = null;

    public int movingCount(int m, int n, int k) {
        visit = new int[m][n];
        return dfs(m, n, k, 0, 0);
    }

    public int dfs(int m, int n, int k, int mStart, int nStart) {
        if (mStart >= 0 && mStart < m && nStart >= 0 && nStart < n
                && (nStart / 10 + nStart % 10 + mStart / 10 + mStart % 10) <= k
                && visit[mStart][nStart] == 0) {
            visit[mStart][nStart] = 1;
            return dfs(m, n, k, mStart+1, nStart)+dfs(m, n, k, mStart-1, nStart)
                    +dfs(m, n, k, mStart, nStart+1)+dfs(m, n, k, mStart, nStart-1);
        }
        return 0;

    }
}
