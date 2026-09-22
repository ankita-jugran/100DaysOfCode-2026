# Grid Slider

## Problem Statement

You are given a square grid of size **N x N**. Every cell in the grid is either **open** (`.`) or **blocked** (`X`).

A single game piece sits on one of the open cells. On each move, the piece slides in one of the four directions — up, down, left, or right — travelling through open cells in a straight line. It keeps going until it is stopped by either the edge of the grid or a blocked cell, and it may come to rest on **any** open cell it passes over along that line (it does not have to slide all the way to the wall).

Given the piece's starting cell and a goal cell, your task is to find the **minimum number of moves** needed to bring the piece from the start to the goal.

> **Note:** If the goal cell can never be reached from the starting cell, the answer is **-1**.

---

## Coordinates

Each cell is identified by a pair **(X, Y)**, where **X** is the row index and **Y** is the column index, both starting from **0** in the top-left corner of the grid.

---

## Input Format

- The first line contains a single integer **N**, the size of the grid (the grid has **N** rows and **N** columns).
- Each of the next **N** lines contains a string of length **N**, representing one row of the grid (`.` for an open cell, `X` for a blocked cell).
- The last line contains four space-separated integers **startX startY goalX goalY** — the row and column of the starting cell, followed by the row and column of the goal cell.

---

## Output Format

Print a single integer — the minimum number of moves required to reach the goal cell from the starting cell, or **-1** if it cannot be reached.

---

## Constraints

- `2 ≤ N ≤ 100`
- `0 ≤ startX, startY, goalX, goalY ≤ N - 1`
- The starting cell and the goal cell are always open (`.`).

---

## Example 1

### Input
```text
3
.X.
.X.
...
0 0 0 2
```

### Output
```text
3
```

### Explanation

The piece starts at cell **(0, 0)**, the top-left corner, and must reach cell **(0, 2)**, the top-right corner. The grid looks like this, with `.X.` on rows 0 and 1, and `...` on row 2:

```
. X .
. X .
. . .
```

A blocked cell sits directly at **(0, 1)** and **(1, 1)**, so the piece cannot slide straight across row 0 or straight down column 1. One shortest path is:

- **Move 1:** Slide down column 0, from (0, 0) to (2, 0) — stopped by the bottom edge of the grid.
- **Move 2:** Slide right along row 2, from (2, 0) to (2, 2) — stopped by the right edge of the grid.
- **Move 3:** Slide up column 2, from (2, 2) to (0, 2) — this is the goal cell.

This reaches the goal in **3 moves**, which is the minimum possible.
