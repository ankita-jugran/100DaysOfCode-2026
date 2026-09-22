# Make It a Palindrome

## Problem Statement

Maya has an array **B** of length **N**. She can perform the following operation on **B**:

1. Pick any index **i** (1 ≤ i ≤ |B|) such that **B[i] > 1**
2. Select any two integers **P** and **Q** such that **P + Q = B[i]** and **P, Q ≥ 1**
3. Replace **B[i]** with **P** and **Q**

Note that the length of the array increases by **1** after each operation.

For example, if `B = [4, 6, 7, 2]`, she can select `i = 1` and choose `P = 1, Q = 3` (since `P + Q = B[1]`). After the operation the array becomes:
`[4, 6, 7, 2] → [1, 3, 6, 7, 2]`.

Maya wants to make **B** palindromic. Your task is to find the **minimum number of operations** required to do so.

> **Note:** An array is called a palindrome if it reads the same backwards and forwards, e.g. `[1, 3, 3, 1]` and `[6, 2, 6]` are palindromic. It is guaranteed that **B** can always be converted into a palindromic array using the above operation.

---

## Input Format

- The first line contains a single integer **N**, the size of the array **B**.
- The second line contains **N** space-separated integers:
  `B[1], B[2], ..., B[N]`,
  where each value satisfies `1 ≤ B[i] ≤ 10^5`.

---

## Constraints

- `1 ≤ N ≤ 10^5`
- `1 ≤ B[i] ≤ 10^5`

---

## Example 1

### Input
```text
4
3 7 6 4
```

### Output
```text
2
```

### Explanation

We can perform the following operations:

- Split `B[2] = 7` into `P = 1, Q = 6` → `[3, 1, 6, 6, 4]`
- Split `B[5] = 4` into `P = 1, Q = 3` → `[3, 1, 6, 6, 1, 3]`, which is a palindrome.

This takes **2** operations.

---

## Example 2

### Input
```text
5
1 4 5 4 1
```

### Output
```text
0
```

### Explanation

The array `[1, 4, 5, 4, 1]` is already palindromic, so **0** operations are needed.
