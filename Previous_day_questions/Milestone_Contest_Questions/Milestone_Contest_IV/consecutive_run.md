# Consecutive Run

## Problem Statement

A conveyor scanner logs the ID number printed on every package that passes by, in the exact order they pass. This produces an array of **N** integers, one per package.

You want to pick out some of these packages (without changing their relative order) so that the ID numbers you picked, read from left to right, form a run of **consecutive integers in increasing order** — that is, a sequence of the form **[x, x+1, x+2, ..., x+k-1]** for some starting value **x** and some length **k**.

You are allowed to skip over any packages you don't want (not necessarily contiguous ones); the packages you keep must stay in their original order.

Your task is to find the **maximum possible length k** of such a run, and report the **positions (indices)** of the packages that make up one such longest run.

> **Note:** Indices in the output are **1-indexed**, based on each package's position in the original array. If more than one longest run is possible, printing the indices for any one of them is accepted.

---

## Input Format

- The first line contains a single integer **N**, the number of packages scanned.
- The second line contains **N** space-separated integers **a1, a2, ..., aN**, the ID number of each package, in the order they were scanned.

---

## Output Format

- On the first line, print **k** — the length of the longest run of consecutive increasing integers you can obtain as a subsequence.
- On the second line, print **k** space-separated integers — the indices (1-indexed) of the packages forming any one such longest run, listed in increasing order of index.

---

## Constraints

- `1 ≤ N ≤ 2 × 10^5`
- `1 ≤ a[i] ≤ 10^9`
- Time limit: **2 seconds**
- Memory limit: **256 megabytes**

---

## Example 1

### Input
```text
7
3 3 4 7 5 6 8
```

### Output
```text
4
2 3 5 6
```

### Explanation
Picking packages at indices 2, 3, 5, 6 gives ID numbers **3, 4, 5, 6** — a run of 4 consecutive increasing integers, which is the longest possible here.

---

## Example 2

### Input
```text
6
1 3 5 2 4 6
```

### Output
```text
2
1 4
```

### Explanation
Picking packages at indices 1 and 4 gives ID numbers **1, 2** — a run of length 2. No longer run of consecutive integers can be formed while keeping the original order.

---

## Example 3

### Input
```text
4
10 9 8 7
```

### Output
```text
1
1
```

### Explanation
The array is strictly decreasing, so no two packages can be combined into an increasing run. The best you can do is a single package, giving a run of length 1. (Any single index would be a valid answer.)

---

## Example 4

### Input
```text
9
6 7 8 3 4 5 9 10 11
```

### Output
```text
6
1 2 3 7 8 9
```

### Explanation
Picking indices 1, 2, 3, 7, 8, 9 gives ID numbers **6, 7, 8, 9, 10, 11** — a run of 6 consecutive increasing integers, the longest possible for this array.
