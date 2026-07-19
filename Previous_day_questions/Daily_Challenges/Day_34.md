<h2 align="center">Week 5 Day 34 (18/07/2026)</h2>

## 1. Implement Queue using Stacks (LeetCode #232)
A problem that builds intuition for stack-to-queue simulation by teaching how a first-in-first-out (FIFO) queue can be implemented using only two stacks, which natively support last-in-first-out (LIFO) operations.

Implement a MyQueue class that simulates the behaviour of a queue using only standard stack operations (push, pop, top/peek, size, and empty). The class should support the following operations: 
push(x) which pushes element x to the back of the queue, 
pop() which removes and returns the element from the front of the queue, 
peek() which returns the element at the front of the queue without removing it, and 
empty() which returns true if the queue is empty and false otherwise.

This problem is commonly asked in interviews and helps build concepts like:
- stack simulation
- queue problems

which are important for efficient stack and queue conversion problems.

**Your task:** Implement the MyQueue class with push(x), pop(), peek(), and empty() methods using only two stacks, ensuring correct FIFO behaviour.

### Examples

**Input:**
```
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
```
**Output:**
```
[null, null, null, 1, 1, false]
```

---

## 2. Maximum People Visible in a Line
A problem that builds intuition for visibility constraints and teaches stack techniques by determining how many people each person in a line can see. Given an array arr[] where arr[i] represents the height of the ith person standing in a line, a person i can see another person j if arr[j] is strictly smaller than arr[i] and no person k standing between them has a height greater than or equal to arr[i]. Each person can look in both directions-forward and backward. Find the maximum number of people that any single person can see, counting themselves.

This problem is commonly asked in interviews and helps build concepts like:
- stack for visibility range computation
- left and right boundary tracking

which are important for stack based range and visibility problems.

**Your task:** Find and return the maximum number of people any single person can see (including themselves) using an optimized approach.

### Examples

**Input:**
```
arr[] = [6, 2, 5, 4, 5, 1, 6]
```
**Output:**
```
6
```

---

**Input:**
```
arr[] = [1,3,6,4]
```
**Output:**
```
4
```

---
