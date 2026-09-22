# Tandem Bike Pairing

## Problem Statement

A cycling club has **N** members signed up for a tandem-bike relay. The **i-th** member has a weight of **wi**.

A tandem bike can only be ridden by exactly **two** people at a time, and for the relay to be fair, every tandem team that competes must carry the **same combined weight**.

In other words, if you form **k** tandem teams **(a1, b1), (a2, b2), ..., (ak, bk)** — where **ai** and **bi** are the weights of the two riders on the **i-th** bike — then it must hold that:

**a1 + b1 = a2 + b2 = ... = ak + bk = s**

for some fixed value **s** that you get to choose. Each club member can ride on at most one tandem bike (some members may be left without a team).

Your task is to choose the target combined weight **s** so that the **number of tandem teams** you can form is as large as possible.

Since the club runs many relay events, you must answer this for **T** independent test cases.

---

## Input Format

- The first line contains a single integer **T**, the number of test cases.
- For each test case:
  - The first line contains a single integer **N**, the number of club members.
  - The second line contains **N** space-separated integers **w1, w2, ..., wN**, the weight of each member.

---

## Output Format

For each test case, print a single integer — the maximum number of tandem teams that can be formed for some optimally chosen combined weight **s**.

---

## Constraints

- `1 ≤ T ≤ 1000`
- `1 ≤ N ≤ 50`
- `1 ≤ wi ≤ N`

---

## Example 1

### Input
```text
5
5
1 2 3 4 5
8
6 6 6 6 6 6 8 8
8
1 2 2 1 2 1 1 2
3
1 3 3
6
1 1 3 4 2 2
```

### Output
```text
2
3
4
1
2
```

### Explanation

- **Test case 1:** With target weight **s = 6**, the members with weight 1 and 5 form one bike, and the members with weight 2 and 4 form another. That's **2** teams — the best possible here.
- **Test case 2:** With target weight **s = 12**, the six members weighing 6 can be paired into 3 bikes of combined weight 12 each. That's **3** teams, and the two members weighing 8 are left without a partner.
- **Test case 3:** With target weight **s = 3**, every member weighing 1 can be paired with a member weighing 2. There are 4 members of weight 1 and 4 of weight 2, giving **4** teams.
- **Test case 4:** Choosing either **s = 4** or **s = 6** gives the same result: only **1** team can be formed, since only two of the three members can be paired at a time.
- **Test case 5:** With target weight **s = 3**, the club can form **2** teams. The single member weighing 3 has no valid partner for that target weight and sits out.
