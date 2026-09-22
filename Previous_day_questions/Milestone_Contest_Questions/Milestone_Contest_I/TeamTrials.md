# Team Trials

## Problem Statement

A sports coach is running tryouts with **n** players competing for spots on the team. Each player has a skill rating, and the rating of the **i-th** player is **skill[i]**.

The coach wants to select as many players as possible for the final squad, since a fuller roster gives more options during the season. But to keep the team balanced, the coach can only pick players together if every pair of selected players has skill ratings differing by **no more than 5**.

Determine the **maximum number of players** the coach can select for the squad while keeping it balanced.

> **Note:** All selected players will train together as one unit, so their skill levels can't be too far apart — that's why no two players in the squad can differ in skill rating by more than 5.

---

## Input Format

- The first line contains a single integer **n**, the number of players trying out.
- The second line contains **n** space-separated integers:
  `skill[1], skill[2], ..., skill[n]`,
  where **skill[i]** is the skill rating of the i-th player.

---

## Constraints

- `1 ≤ n ≤ 2 × 10^5`
- `1 ≤ skill[i] ≤ 10^9`

---

## Example 1

### Input
```text
6
1 10 17 12 15 2
```

### Output
```text
3
```

### Explanation

Selecting the players with skill ratings **[12, 17, 15]** keeps every pair within 5 points of each other, and no larger squad can be formed under this rule.

---

## Example 2

### Input
```text
10
1337 1337 1337 1337 1337 1337 1337 1337 1337 1337
```

### Output
```text
10
```

### Explanation

Every player has the exact same skill rating, so all 10 players can be picked for the squad.

---

## Example 3

### Input
```text
6
1 1000 10000 10 100 1000000000
```

### Output
```text
1
```

### Explanation

No two players have skill ratings within 5 of each other, so the largest squad the coach can form has only **1** player.
