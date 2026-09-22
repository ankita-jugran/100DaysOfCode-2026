# Family Roots

## Problem Statement

A family tree records a family's history starting from one oldest person, called the **root**. Every person has **at most two children**, and every person in the tree has a **unique ID**.

You are given the family tree and the IDs of two people, **p** and **q**. Both people are always present in the tree.

Your task is to find the **closest common ancestor** of **p** and **q**, meaning the person who is an ancestor of both and who is the lowest such person in the tree (the one furthest from the root).

> **Note:** A person counts as their own ancestor. So if **p** is an ancestor of **q**, the answer is **p**.

---

## Input Format

- The first line contains a single integer **N**, the number of entries in the tree description.
- The second line contains **N** space-separated integers describing the tree in **level order** (top to bottom, left to right). The value **-1** stands for a missing child. The children of a missing child are not listed.
- The third line contains two space-separated integers **p** and **q**.

---

## Output Format

Print a single integer, the ID of the closest common ancestor of **p** and **q**.

---

## Constraints

- `1 ≤ N ≤ 10^5`
- `1 ≤ ID ≤ 10^5` for every person in the tree
- All IDs in the tree are distinct.
- **p** and **q** are always present in the tree.

---

## Example 1

### Input
```text
7
1 2 3 4 5 6 7
4 5
```

### Output
```text
2
```

### Explanation

The tree looks like this:

```text
        1
       / \
      2   3
     / \ / \
    4  5 6  7
```

Persons **4** and **5** are both children of person **2**. The ancestors of **4** are 2 and 1, and the ancestors of **5** are also 2 and 1. The lowest one they share is **2**.

---

## Example 2

### Input
```text
7
1 2 3 -1 4 -1 5
2 4
```

### Output
```text
2
```

### Explanation

The tree looks like this:

```text
      1
     / \
    2   3
     \   \
      4   5
```

Person **2** is the parent of person **4**, so **2** is an ancestor of both itself and **4**. The closest common ancestor is **2**.
