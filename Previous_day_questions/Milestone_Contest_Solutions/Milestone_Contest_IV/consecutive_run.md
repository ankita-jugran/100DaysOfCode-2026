# Consecutive Run

## Python

```python
def consecutiveRun(a):
    # best[value] = (length, index, previous_index)
    best = {}
    parent = [-1] * len(a)

    max_len = 0
    last_index = -1

    for i, x in enumerate(a):
        if x - 1 in best:
            length = best[x - 1][0] + 1
            previous_index = best[x - 1][1]
        else:
            length = 1
            previous_index = -1

        # Keep the best subsequence ending with x seen so far.
        if x not in best or length > best[x][0]:
            best[x] = (length, i, previous_index)
            parent[i] = previous_index

        if length > max_len:
            max_len = length
            last_index = i

    answer = []
    while last_index != -1:
        answer.append(last_index + 1)
        last_index = parent[last_index]

    answer.reverse()

    print(max_len)
    print(*answer)


n = int(input())
a = list(map(int, input().split()))

consecutiveRun(a)
```

## C

```c
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    long long value;
    int length;
    int index;
    int previous_index;
} State;

int compareLongLong(const void *a, const void *b) {
    long long x = *(const long long *)a;
    long long y = *(const long long *)b;

    if (x < y) return -1;
    if (x > y) return 1;
    return 0;
}

int lowerBound(long long arr[], int size, long long target) {
    int left = 0, right = size;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] < target)
            left = mid + 1;
        else
            right = mid;
    }

    return left;
}

void consecutiveRun(long long a[], int n) {
    long long *values = malloc(n * sizeof(long long));
    int *parent = malloc(n * sizeof(int));
    int *bestLength = calloc(n, sizeof(int));
    int *bestIndex = malloc(n * sizeof(int));

    for (int i = 0; i < n; i++) {
        values[i] = a[i];
        parent[i] = -1;
        bestIndex[i] = -1;
    }

    qsort(values, n, sizeof(long long), compareLongLong);

    int uniqueCount = 0;
    for (int i = 0; i < n; i++) {
        if (i == 0 || values[i] != values[i - 1])
            values[uniqueCount++] = values[i];
    }

    int maxLength = 0;
    int lastIndex = -1;

    for (int i = 0; i < n; i++) {
        int current = lowerBound(values, uniqueCount, a[i]);

        int length = 1;
        int previous = -1;

        int previousValue = lowerBound(values, uniqueCount, a[i] - 1);

        if (previousValue < uniqueCount &&
            values[previousValue] == a[i] - 1 &&
            bestIndex[previousValue] != -1) {
            length = bestLength[previousValue] + 1;
            previous = bestIndex[previousValue];
        }

        if (length > bestLength[current]) {
            bestLength[current] = length;
            bestIndex[current] = i;
            parent[i] = previous;
        }

        if (length > maxLength) {
            maxLength = length;
            lastIndex = i;
        }
    }

    int *answer = malloc(maxLength * sizeof(int));
    int count = 0;

    while (lastIndex != -1) {
        answer[count++] = lastIndex + 1;
        lastIndex = parent[lastIndex];
    }

    printf("%d\n", maxLength);

    for (int i = count - 1; i >= 0; i--) {
        printf("%d", answer[i]);
        if (i > 0) printf(" ");
    }
    printf("\n");

    free(values);
    free(parent);
    free(bestLength);
    free(bestIndex);
    free(answer);
}

int main() {
    int n;
    scanf("%d", &n);

    long long *a = malloc(n * sizeof(long long));

    for (int i = 0; i < n; i++)
        scanf("%lld", &a[i]);

    consecutiveRun(a, n);

    free(a);
    return 0;
}
```

## C++

```cpp
#include <bits/stdc++.h>
using namespace std;

void consecutiveRun(const vector<long long>& a) {
    int n = a.size();

    // best[x] = {length, ending_index}
    unordered_map<long long, pair<int, int>> best;

    vector<int> parent(n, -1);

    int maxLength = 0;
    int lastIndex = -1;

    for (int i = 0; i < n; i++) {
        long long x = a[i];

        int length = 1;
        int previous = -1;

        auto it = best.find(x - 1);

        if (it != best.end()) {
            length = it->second.first + 1;
            previous = it->second.second;
        }

        if (!best.count(x) || length > best[x].first) {
            best[x] = {length, i};
            parent[i] = previous;
        }

        if (length > maxLength) {
            maxLength = length;
            lastIndex = i;
        }
    }

    vector<int> answer;

    while (lastIndex != -1) {
        answer.push_back(lastIndex + 1);
        lastIndex = parent[lastIndex];
    }

    reverse(answer.begin(), answer.end());

    cout << maxLength << '\n';

    for (int i = 0; i < (int)answer.size(); i++) {
        if (i) cout << ' ';
        cout << answer[i];
    }

    cout << '\n';
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<long long> a(n);

    for (auto& x : a)
        cin >> x;

    consecutiveRun(a);

    return 0;
}
```

## Java

```java
import java.util.*;

public class Main {

    static class State {
        int length;
        int index;

        State(int length, int index) {
            this.length = length;
            this.index = index;
        }
    }

    static void consecutiveRun(long[] a) {
        int n = a.length;

        // best[value] = best length and ending index for this value
        Map<Long, State> best = new HashMap<>();

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int maxLength = 0;
        int lastIndex = -1;

        for (int i = 0; i < n; i++) {
            long x = a[i];

            int length = 1;
            int previous = -1;

            State previousState = best.get(x - 1);

            if (previousState != null) {
                length = previousState.length + 1;
                previous = previousState.index;
            }

            State currentState = best.get(x);

            if (currentState == null || length > currentState.length) {
                best.put(x, new State(length, i));
                parent[i] = previous;
            }

            if (length > maxLength) {
                maxLength = length;
                lastIndex = i;
            }
        }

        List<Integer> answer = new ArrayList<>();

        while (lastIndex != -1) {
            answer.add(lastIndex + 1);
            lastIndex = parent[lastIndex];
        }

        Collections.reverse(answer);

        System.out.println(maxLength);

        for (int i = 0; i < answer.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(answer.get(i));
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] a = new long[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextLong();

        consecutiveRun(a);

        sc.close();
    }
}
```


