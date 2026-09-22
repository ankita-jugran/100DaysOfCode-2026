# Weak Links

## Problem Statement

A region has **V** towns, numbered from **0** to **V − 1**. Some pairs of towns are joined by two-way roads. You are given the list of roads, where each road connects two towns **u** and **v**.

The road network may be split into several separate regions, where towns in the same region can reach each other and towns in different regions cannot.

A town is called a **critical junction** if closing it, together with every road that touches it, increases the number of separate regions in the network.

Your task is to find all critical junctions and print them in increasing order.

> **Note:** If there is no critical junction, print **-1**.

---

## Input Format

- The first line contains two space-separated integers **V** and **E**, the number of towns and the number of roads.
- Each of the next **E** lines contains two space-separated integers **u** and **v**, meaning there is a two-way road between town **u** and town **v**.

---

## Output Format

Print the critical junctions in increasing order, separated by single spaces. If there are none, print `-1`.

---

## Constraints

- `1 ≤ V ≤ 10^5`
- `0 ≤ E ≤ 2 × 10^5`
- `0 ≤ u, v ≤ V − 1`
- There are no self-loops and no repeated roads.

---

## Example 1

### Input
```text
5 5
0 1
1 4
4 3
4 2
2 3
```

### Output
```text
1 4
```

### Explanation

- Closing town **1** cuts town **0** off from the rest, so the network splits into two regions.
- Closing town **4** separates towns **0, 1** from towns **2, 3**, so the network splits into two regions.
- Closing any other town keeps the remaining towns in the same number of regions.

So the critical junctions are **1** and **4**.

---

## Example 2

### Input
```text
4 3
0 1
1 2
2 0
```

### Output
```text
-1
```

### Explanation

Towns **0, 1, 2** form a triangle, so closing any one of them leaves the other two connected. Town **3** has no roads at all, and closing it does not split anything.

No town increases the number of regions when closed, so the answer is **-1**.
