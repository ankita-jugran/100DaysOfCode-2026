# Grid Slider

## Python

```python
from collections import deque

def gridSlider(grid, startX, startY, goalX, goalY):
    n = len(grid)

    dist = [[-1] * n for _ in range(n)]
    dist[startX][startY] = 0

    q = deque([(startX, startY)])
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    while q:
        x, y = q.popleft()

        if x == goalX and y == goalY:
            return dist[x][y]

        for dx, dy in directions:
            nx, ny = x + dx, y + dy

            while 0 <= nx < n and 0 <= ny < n and grid[nx][ny] == '.':
                if dist[nx][ny] == -1:
                    dist[nx][ny] = dist[x][y] + 1
                    q.append((nx, ny))

                nx += dx
                ny += dy

    return -1


n = int(input())
grid = [input().strip() for _ in range(n)]
startX, startY, goalX, goalY = map(int, input().split())

print(gridSlider(grid, startX, startY, goalX, goalY))
```

## C

```c
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int x;
    int y;
} Cell;

int gridSlider(char **grid, int n, int startX, int startY,
               int goalX, int goalY) {
    int **dist = malloc(n * sizeof(int *));

    for (int i = 0; i < n; i++) {
        dist[i] = malloc(n * sizeof(int));

        for (int j = 0; j < n; j++)
            dist[i][j] = -1;
    }

    Cell *queue = malloc(n * n * sizeof(Cell));
    int front = 0, rear = 0;

    queue[rear++] = (Cell){startX, startY};
    dist[startX][startY] = 0;

    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};

    while (front < rear) {
        Cell current = queue[front++];

        if (current.x == goalX && current.y == goalY) {
            int answer = dist[current.x][current.y];

            for (int i = 0; i < n; i++)
                free(dist[i]);

            free(dist);
            free(queue);

            return answer;
        }

        for (int d = 0; d < 4; d++) {
            int nx = current.x + dx[d];
            int ny = current.y + dy[d];

            while (nx >= 0 && nx < n &&
                   ny >= 0 && ny < n &&
                   grid[nx][ny] == '.') {

                if (dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[current.x][current.y] + 1;
                    queue[rear++] = (Cell){nx, ny};
                }

                nx += dx[d];
                ny += dy[d];
            }
        }
    }

    for (int i = 0; i < n; i++)
        free(dist[i]);

    free(dist);
    free(queue);

    return -1;
}

int main() {
    int n;
    scanf("%d", &n);

    char **grid = malloc(n * sizeof(char *));

    for (int i = 0; i < n; i++) {
        grid[i] = malloc((n + 1) * sizeof(char));
        scanf("%s", grid[i]);
    }

    int startX, startY, goalX, goalY;
    scanf("%d %d %d %d", &startX, &startY, &goalX, &goalY);

    printf("%d\n",
           gridSlider(grid, n, startX, startY, goalX, goalY));

    for (int i = 0; i < n; i++)
        free(grid[i]);

    free(grid);

    return 0;
}
```

## C++

```cpp
#include <bits/stdc++.h>
using namespace std;

int gridSlider(const vector<string>& grid,
               int startX, int startY,
               int goalX, int goalY) {
    int n = grid.size();

    vector<vector<int>> dist(n, vector<int>(n, -1));
    queue<pair<int, int>> q;

    dist[startX][startY] = 0;
    q.push({startX, startY});

    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};

    while (!q.empty()) {
        auto [x, y] = q.front();
        q.pop();

        if (x == goalX && y == goalY)
            return dist[x][y];

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            while (nx >= 0 && nx < n &&
                   ny >= 0 && ny < n &&
                   grid[nx][ny] == '.') {

                if (dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.push({nx, ny});
                }

                nx += dx[d];
                ny += dy[d];
            }
        }
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<string> grid(n);

    for (string& row : grid)
        cin >> row;

    int startX, startY, goalX, goalY;
    cin >> startX >> startY >> goalX >> goalY;

    cout << gridSlider(grid, startX, startY, goalX, goalY) << '\n';

    return 0;
}
```

## Java

```java
import java.util.*;

public class Main {

    static int gridSlider(char[][] grid,
                          int startX, int startY,
                          int goalX, int goalY) {
        int n = grid.length;

        int[][] dist = new int[n][n];

        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<int[]> queue = new ArrayDeque<>();

        dist[startX][startY] = 0;
        queue.offer(new int[]{startX, startY});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];

            if (x == goalX && y == goalY)
                return dist[x][y];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                while (nx >= 0 && nx < n &&
                       ny >= 0 && ny < n &&
                       grid[nx][ny] == '.') {

                    if (dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }

                    nx += dx[d];
                    ny += dy[d];
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] grid = new char[n][n];

        for (int i = 0; i < n; i++)
            grid[i] = sc.next().toCharArray();

        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int goalX = sc.nextInt();
        int goalY = sc.nextInt();

        System.out.println(
            gridSlider(grid, startX, startY, goalX, goalY)
        );

        sc.close();
    }
}
```


