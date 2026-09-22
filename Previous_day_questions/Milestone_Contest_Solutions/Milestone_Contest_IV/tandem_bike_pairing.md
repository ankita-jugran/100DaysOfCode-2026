# Tandem Bike Pairing

## Python

```python
def tandemBikePairing(weights):
    max_teams = 0

    # Since 1 <= weight <= N, possible target sums range from 2 to 2N.
    for target in range(2, 2 * len(weights) + 1):
        count = [0] * (len(weights) + 1)

        for w in weights:
            count[w] += 1

        teams = 0

        for w in range(1, len(weights) + 1):
            partner = target - w

            if partner < 1 or partner > len(weights):
                continue

            if w > partner:
                continue

            if w == partner:
                teams += count[w] // 2
            else:
                teams += min(count[w], count[partner])

        max_teams = max(max_teams, teams)

    return max_teams


t = int(input())

for _ in range(t):
    n = int(input())
    weights = list(map(int, input().split()))

    print(tandemBikePairing(weights))
```

## C

```c
#include <stdio.h>
#include <stdlib.h>

int tandemBikePairing(int weights[], int n) {
    int maxTeams = 0;

    for (int target = 2; target <= 2 * n; target++) {
        int *count = calloc(n + 1, sizeof(int));

        for (int i = 0; i < n; i++)
            count[weights[i]]++;

        int teams = 0;

        for (int w = 1; w <= n; w++) {
            int partner = target - w;

            if (partner < 1 || partner > n)
                continue;

            if (w > partner)
                continue;

            if (w == partner)
                teams += count[w] / 2;
            else {
                teams += count[w] < count[partner]
                       ? count[w]
                       : count[partner];
            }
        }

        if (teams > maxTeams)
            maxTeams = teams;

        free(count);
    }

    return maxTeams;
}

int main() {
    int t;
    scanf("%d", &t);

    while (t--) {
        int n;
        scanf("%d", &n);

        int *weights = malloc(n * sizeof(int));

        for (int i = 0; i < n; i++)
            scanf("%d", &weights[i]);

        printf("%d\n", tandemBikePairing(weights, n));

        free(weights);
    }

    return 0;
}
```

## C++

```cpp
#include <bits/stdc++.h>
using namespace std;

int tandemBikePairing(const vector<int>& weights) {
    int n = weights.size();
    int maxTeams = 0;

    // Possible target sums are from 2 to 2N.
    for (int target = 2; target <= 2 * n; target++) {
        vector<int> count(n + 1, 0);

        for (int w : weights)
            count[w]++;

        int teams = 0;

        for (int w = 1; w <= n; w++) {
            int partner = target - w;

            if (partner < 1 || partner > n)
                continue;

            if (w > partner)
                continue;

            if (w == partner)
                teams += count[w] / 2;
            else
                teams += min(count[w], count[partner]);
        }

        maxTeams = max(maxTeams, teams);
    }

    return maxTeams;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--) {
        int N;
        cin >> N;

        vector<int> weights(N);

        for (int& w : weights)
            cin >> w;

        cout << tandemBikePairing(weights) << '\n';
    }

    return 0;
}
```

## Java

```java
import java.util.*;

public class Main {

    static int tandemBikePairing(int[] weights) {
        int n = weights.length;
        int maxTeams = 0;

        for (int target = 2; target <= 2 * n; target++) {
            int[] count = new int[n + 1];

            for (int w : weights)
                count[w]++;

            int teams = 0;

            for (int w = 1; w <= n; w++) {
                int partner = target - w;

                if (partner < 1 || partner > n)
                    continue;

                if (w > partner)
                    continue;

                if (w == partner)
                    teams += count[w] / 2;
                else
                    teams += Math.min(count[w], count[partner]);
            }

            maxTeams = Math.max(maxTeams, teams);
        }

        return maxTeams;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int[] weights = new int[N];

            for (int i = 0; i < N; i++)
                weights[i] = sc.nextInt();

            System.out.println(tandemBikePairing(weights));
        }

        sc.close();
    }
}
```


