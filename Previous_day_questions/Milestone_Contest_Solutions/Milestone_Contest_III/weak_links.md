# Weak Links

## Python

```python
def criticalJunctions(V, E, roads):
    graph = [[] for _ in range(V)]

    for u, v in roads:
        graph[u].append(v)
        graph[v].append(u)

    disc = [-1] * V
    low = [-1] * V
    parent = [-1] * V
    is_articulation = [False] * V
    time = 0

    def dfs(u):
        nonlocal time

        disc[u] = low[u] = time
        time += 1
        children = 0

        for v in graph[u]:
            if disc[v] == -1:
                parent[v] = u
                children += 1
                dfs(v)

                low[u] = min(low[u], low[v])

                if parent[u] == -1 and children > 1:
                    is_articulation[u] = True

                if parent[u] != -1 and low[v] >= disc[u]:
                    is_articulation[u] = True

            elif v != parent[u]:
                low[u] = min(low[u], disc[v])

    for u in range(V):
        if disc[u] == -1:
            dfs(u)

    result = [u for u in range(V) if is_articulation[u]]
    return result if result else [-1]
```

## C

```c
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int to;
    int next;
} Edge;

int *head, *disc, *low, *parent, *isArticulation;
Edge *edges;
int edgeCount = 0;
int timer = 0;

void addEdge(int u, int v) {
    edges[edgeCount].to = v;
    edges[edgeCount].next = head[u];
    head[u] = edgeCount++;
}

void dfs(int u) {
    disc[u] = low[u] = timer++;
    int children = 0;

    for (int i = head[u]; i != -1; i = edges[i].next) {
        int v = edges[i].to;

        if (disc[v] == -1) {
            parent[v] = u;
            children++;

            dfs(v);

            if (low[v] < low[u])
                low[u] = low[v];

            if (parent[u] == -1 && children > 1)
                isArticulation[u] = 1;

            if (parent[u] != -1 && low[v] >= disc[u])
                isArticulation[u] = 1;
        }
        else if (v != parent[u]) {
            if (disc[v] < low[u])
                low[u] = disc[v];
        }
    }
}

void criticalJunctions(int V, int E, int roads[][2]) {
    head = (int *)malloc(V * sizeof(int));
    disc = (int *)malloc(V * sizeof(int));
    low = (int *)malloc(V * sizeof(int));
    parent = (int *)malloc(V * sizeof(int));
    isArticulation = (int *)calloc(V, sizeof(int));
    edges = (Edge *)malloc(2 * E * sizeof(Edge));

    for (int i = 0; i < V; i++) {
        head[i] = -1;
        disc[i] = -1;
        low[i] = -1;
        parent[i] = -1;
    }

    for (int i = 0; i < E; i++) {
        addEdge(roads[i][0], roads[i][1]);
        addEdge(roads[i][1], roads[i][0]);
    }

    for (int i = 0; i < V; i++) {
        if (disc[i] == -1)
            dfs(i);
    }

    int found = 0;

    for (int i = 0; i < V; i++) {
        if (isArticulation[i]) {
            printf("%d ", i);
            found = 1;
        }
    }

    if (!found)
        printf("-1");

    printf("\n");

    free(head);
    free(disc);
    free(low);
    free(parent);
    free(isArticulation);
    free(edges);
}
```

## C++

```cpp
#include <bits/stdc++.h>
using namespace std;

void criticalJunctions(int V, vector<vector<int>>& roads) {
    vector<vector<int>> graph(V);

    for (auto &road : roads) {
        int u = road[0];
        int v = road[1];

        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    vector<int> disc(V, -1);
    vector<int> low(V, -1);
    vector<int> parent(V, -1);
    vector<bool> articulation(V, false);

    int timer = 0;

    function<void(int)> dfs = [&](int u) {
        disc[u] = low[u] = timer++;
        int children = 0;

        for (int v : graph[u]) {
            if (disc[v] == -1) {
                parent[v] = u;
                children++;

                dfs(v);

                low[u] = min(low[u], low[v]);

                if (parent[u] == -1 && children > 1)
                    articulation[u] = true;

                if (parent[u] != -1 && low[v] >= disc[u])
                    articulation[u] = true;
            }
            else if (v != parent[u]) {
                low[u] = min(low[u], disc[v]);
            }
        }
    };

    for (int i = 0; i < V; i++) {
        if (disc[i] == -1)
            dfs(i);
    }

    bool found = false;

    for (int i = 0; i < V; i++) {
        if (articulation[i]) {
            cout << i << " ";
            found = true;
        }
    }

    if (!found)
        cout << -1;

    cout << '\n';
}
```

## Java

```java
import java.util.*;

class Result {

    static void criticalJunctions(int V, int[][] roads) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] articulation = new boolean[V];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        int[] timer = {0};

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1)
                dfs(i, graph, disc, low, parent, articulation, timer);
        }

        StringBuilder result = new StringBuilder();
        boolean found = false;

        for (int i = 0; i < V; i++) {
            if (articulation[i]) {
                result.append(i).append(" ");
                found = true;
            }
        }

        if (!found)
            System.out.println("-1");
        else
            System.out.println(result.toString().trim());
    }

    static void dfs(
        int u,
        List<List<Integer>> graph,
        int[] disc,
        int[] low,
        int[] parent,
        boolean[] articulation,
        int[] timer
    ) {
        disc[u] = low[u] = timer[0]++;
        int children = 0;

        for (int v : graph.get(u)) {
            if (disc[v] == -1) {
                parent[v] = u;
                children++;

                dfs(v, graph, disc, low, parent, articulation, timer);

                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == -1 && children > 1)
                    articulation[u] = true;

                if (parent[u] != -1 && low[v] >= disc[u])
                    articulation[u] = true;
            }
            else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
```


