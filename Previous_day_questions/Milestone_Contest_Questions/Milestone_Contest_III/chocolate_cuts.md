# Chocolate Cuts

## Problem Statement

A bakery has a chocolate bar of length **N**. The bar is marked at every integer position from **0** to **N**.

You are given an array **CUTS** of size **C**. Each value in it is a position where a cut must be made. The cuts can be made in **any order** you like.

The cost of a single cut is the **length of the piece** being cut at that moment. The total cost is the sum of the costs of all cuts.

Your task is to find the **minimum possible total cost** to make all the cuts.

> **Note:** All integers in the **CUTS** array are distinct.

---

## Input Format

- The first line contains two space-separated integers **N** and **C**, the length of the chocolate bar and the size of the **CUTS** array.
- The second line contains **C** space-separated integers, the elements of **CUTS**.

---

## Output Format

Print a single integer, the minimum total cost to make all the cuts.

---

## Constraints

- `2 ≤ N ≤ 10^5`
- `1 ≤ C ≤ 10^3`
- `1 ≤ CUTS[i] ≤ N - 1`

---

## Example 1

### Input
```text
4 2
1 3
```

### Output
```text
7
```

### Explanation

Consider the cuts in the order `[1, 3]`:

- The first cut at position **1** is made on a piece of length **4**, so the cost is **4**. The bar splits into pieces of length **1** and **3**.
- The second cut at position **3** is made on the piece of length **3**, so the cost is **3**. That piece splits into pieces of length **2** and **1**.

Total cost = 4 + 3 = **7**.

Changing the order of the cuts gives the same cost here, so the answer is **7**.

---

## Example 2

### Input
```text
5 1
2
```

### Output
```text
5
```

### Explanation

There is only one cut, at position **2**. It is made on the full bar of length **5**, so the cost is **5**.
