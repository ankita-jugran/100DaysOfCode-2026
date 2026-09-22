# Chocolate Cuts

## Python

```python
def chocolateCuts(n, cuts):
    cuts = [0] + sorted(cuts) + [n]
    c = len(cuts)

    dp = [[0] * c for _ in range(c)]

    for length in range(2, c):
        for left in range(c - length):
            right = left + length
            dp[left][right] = float('inf')

            for k in range(left + 1, right):
                cost = (
                    cuts[right] - cuts[left]
                    + dp[left][k]
                    + dp[k][right]
                )
                dp[left][right] = min(dp[left][right], cost)

    return dp[0][c - 1]
```

---

## C

```c
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int chocolateCuts(int n, int *cuts, int c) {
    int size = c + 2;

    int *points = (int *)malloc(size * sizeof(int));
    points[0] = 0;
    points[size - 1] = n;

    for (int i = 0; i < c; i++)
        points[i + 1] = cuts[i];

    qsort(points, size, sizeof(int), compare);

    int **dp = (int **)malloc(size * sizeof(int *));
    for (int i = 0; i < size; i++) {
        dp[i] = (int *)calloc(size, sizeof(int));
    }

    for (int length = 2; length < size; length++) {
        for (int left = 0; left + length < size; left++) {
            int right = left + length;
            dp[left][right] = INT_MAX;

            for (int k = left + 1; k < right; k++) {
                int cost = points[right] - points[left]
                         + dp[left][k]
                         + dp[k][right];

                if (cost < dp[left][right])
                    dp[left][right] = cost;
            }
        }
    }

    int answer = dp[0][size - 1];

    for (int i = 0; i < size; i++)
        free(dp[i]);

    free(dp);
    free(points);

    return answer;
}
```

---

## C++

```cpp
#include <bits/stdc++.h>

using namespace std;

int chocolateCuts(int n, vector<int> cuts) {
    cuts.push_back(0);
    cuts.push_back(n);

    sort(cuts.begin(), cuts.end());

    int c = cuts.size();

    vector<vector<int>> dp(c, vector<int>(c, 0));

    for (int length = 2; length < c; length++) {
        for (int left = 0; left + length < c; left++) {
            int right = left + length;

            dp[left][right] = INT_MAX;

            for (int k = left + 1; k < right; k++) {
                int cost = cuts[right] - cuts[left]
                         + dp[left][k]
                         + dp[k][right];

                dp[left][right] = min(dp[left][right], cost);
            }
        }
    }

    return dp[0][c - 1];
}
```

---

## Java

```java
import java.util.*;

class Result {

    public static int chocolateCuts(int n, List<Integer> cuts) {
        cuts.add(0);
        cuts.add(n);

        Collections.sort(cuts);

        int c = cuts.size();

        int[][] dp = new int[c][c];

        for (int length = 2; length < c; length++) {
            for (int left = 0; left + length < c; left++) {
                int right = left + length;

                dp[left][right] = Integer.MAX_VALUE;

                for (int k = left + 1; k < right; k++) {
                    int cost = cuts.get(right) - cuts.get(left)
                             + dp[left][k]
                             + dp[k][right];

                    dp[left][right] =
                        Math.min(dp[left][right], cost);
                }
            }
        }

        return dp[0][c - 1];
    }
}
```



---
