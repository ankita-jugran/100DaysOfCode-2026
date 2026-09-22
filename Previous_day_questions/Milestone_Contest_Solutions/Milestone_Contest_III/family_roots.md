# Family Roots

## Python

```python
def familyRoots(n, tree, p, q):
    parent = {}
    root = tree[0]

    for i in range(1, n):
        if tree[i] == -1:
            continue

        parent[tree[i]] = tree[(i - 1) // 2]

    ancestors = set()
    current = p

    while True:
        ancestors.add(current)
        if current == root:
            break
        current = parent[current]

    current = q

    while current not in ancestors:
        current = parent[current]

    return current
```

## C

```c
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int id;
    int parent;
} Person;

int compare(const void *a, const void *b) {
    Person *x = (Person *)a;
    Person *y = (Person *)b;
    return x->id - y->id;
}

int findParent(Person people[], int count, int id) {
    for (int i = 0; i < count; i++) {
        if (people[i].id == id)
            return people[i].parent;
    }
    return -1;
}

int familyRoots(int n, int tree[], int p, int q) {
    Person *people = malloc(n * sizeof(Person));
    int count = 0;
    int root = tree[0];

    for (int i = 1; i < n; i++) {
        if (tree[i] == -1)
            continue;

        people[count].id = tree[i];
        people[count].parent = tree[(i - 1) / 2];
        count++;
    }

    int *ancestors = calloc(n + 1, sizeof(int));

    int current = p;

    while (1) {
        if (current >= 0 && current <= n)
            ancestors[current] = 1;

        if (current == root)
            break;

        current = findParent(people, count, current);
    }

    current = q;

    while (!ancestors[current]) {
        current = findParent(people, count, current);
    }

    free(people);
    free(ancestors);

    return current;
}

int main() {
    int n;
    scanf("%d", &n);

    int *tree = malloc(n * sizeof(int));

    for (int i = 0; i < n; i++)
        scanf("%d", &tree[i]);

    int p, q;
    scanf("%d %d", &p, &q);

    printf("%d\n", familyRoots(n, tree, p, q));

    free(tree);
    return 0;
}
```

## C++

```cpp
#include <bits/stdc++.h>
using namespace std;

int familyRoots(int n, vector<int> tree, int p, int q) {
    unordered_map<int, int> parent;

    int root = tree[0];

    for (int i = 1; i < n; i++) {
        if (tree[i] == -1)
            continue;

        parent[tree[i]] = tree[(i - 1) / 2];
    }

    unordered_set<int> ancestors;

    int current = p;

    while (true) {
        ancestors.insert(current);

        if (current == root)
            break;

        current = parent[current];
    }

    current = q;

    while (!ancestors.count(current)) {
        current = parent[current];
    }

    return current;
}

int main() {
    int n;
    cin >> n;

    vector<int> tree(n);

    for (int i = 0; i < n; i++)
        cin >> tree[i];

    int p, q;
    cin >> p >> q;

    cout << familyRoots(n, tree, p, q) << '\n';

    return 0;
}
```

## Java

```java
import java.util.*;

public class Solution {

    public static int familyRoots(int n, int[] tree, int p, int q) {
        Map<Integer, Integer> parent = new HashMap<>();

        int root = tree[0];

        for (int i = 1; i < n; i++) {
            if (tree[i] == -1)
                continue;

            parent.put(tree[i], tree[(i - 1) / 2]);
        }

        Set<Integer> ancestors = new HashSet<>();

        int current = p;

        while (true) {
            ancestors.add(current);

            if (current == root)
                break;

            current = parent.get(current);
        }

        current = q;

        while (!ancestors.contains(current)) {
            current = parent.get(current);
        }

        return current;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] tree = new int[n];

        for (int i = 0; i < n; i++)
            tree[i] = sc.nextInt();

        int p = sc.nextInt();
        int q = sc.nextInt();

        System.out.println(familyRoots(n, tree, p, q));

        sc.close();
    }
}
```


