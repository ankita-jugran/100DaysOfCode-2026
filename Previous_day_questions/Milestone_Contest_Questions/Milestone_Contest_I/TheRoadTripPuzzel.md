# The Road Trip Puzzle

## Problem Statement

There are **n** gas stations arranged in a circle. You are given two arrays, **gas** and **cost**, where **gas[i]** is the amount of fuel available at station **i**, and **cost[i]** is the amount of fuel needed to drive from station **i** to the next station **(i + 1)**.

You have a car with an unlimited fuel tank, and you begin the journey with an empty tank at some chosen station.

Your task is to determine the index of the station from which you can start and complete a full clockwise loop around the circuit without ever running out of fuel. If no such starting station exists, return **-1**.

> **Note:** If a valid starting station exists, it is guaranteed to be unique.

---

## Input Format

- The first line contains a single integer **n**, the number of gas stations.
- The second line contains **n** space-separated integers:
  `gas[1], gas[2], ..., gas[n]`
- The third line contains **n** space-separated integers:
  `cost[1], cost[2], ..., cost[n]`

---

## Constraints

- `1 ≤ n ≤ 10^6`
- `1 ≤ gas[i], cost[i] ≤ 10^3`

---

## Example 1

### Input
```text
4
4 5 7 4
6 6 3 5
```

### Output
```text
2
```

### Explanation

Start at station **2** with a full tank from that station: fuel available = **7**.

- Travel to station 3: remaining fuel = `7 - 3 + 4 = 8`
- Travel to station 0: remaining fuel = `8 - 5 + 4 = 7`
- Travel to station 1: remaining fuel = `7 - 6 + 5 = 6`
- Return to station 2: remaining fuel = `6 - 6 = 0`

The tank never goes negative, so station **2** is a valid starting point.

---

## Example 2

### Input
```text
2
3 9
7 6
```

### Output
```text
-1
```

### Explanation

There is no station from which the full loop can be completed without running out of fuel, so the answer is **-1**.
