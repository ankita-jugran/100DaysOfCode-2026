<h2 align="center">Week 6 Day 37 (21/07/2026)</h2>

## 1. Number of Recent Calls (LeetCode #933)
A problem that requires implementing a RecentCounter class which counts the number of recent requests within a certain time frame.

You must implement the `RecentCounter()` constructor, which initializes the counter with zero recent requests, and the `int ping(int t)` method, which adds a new request at time t (in milliseconds) and returns the number of requests that have happened in the past 3000 milliseconds (including the new request). Specifically, it should return the number of requests that have happened in the inclusive range [t - 3000, t]. It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

This problem is commonly asked in interviews and helps build concepts like:
- queue operations
- sliding window technique

which are important for efficient time-window based problems.

**Your task:** Implement the RecentCounter class with the constructor and ping method as described above.

### Constraints
- 1 <= t <= 10^9
- Each test case will call ping with strictly increasing values of t.
- At most 10^4 calls will be made to ping.

### Examples
**Input:**
```
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
```
**Output:**
```
[null, 1, 2, 3, 3]
```
---

## 2. Printer Queue
A queue simulation problem that requires tracking when a specific document gets printed based on priority rules.

A printer receives documents in a queue. Each document has a priority from 1 to 9, where a higher number means a more important document. The printer follows these rules:
- Look at the document at the front of the queue.
- If there is any document in the queue with a higher priority, move the front document to the back of the queue.
- Otherwise, print the front document.

Printing a document takes exactly one minute. You are given the initial priorities of all documents and the position of your document in the original queue.

This problem is commonly asked in interviews and helps build concepts like:
- queue simulation
- priority comparison

which are important for efficient queue based simulation problems.

**Your task:** Given an array `priorities` representing the initial priorities of all documents, and an integer `location` representing the position of your document in the original queue, determine how many minutes it takes until your document is printed.

### Constraints
- 1 <= n <= 100000
- 1 <= priorities[i] <= 9
- 0 <= location < n

### Examples
**Input:**
```
priorities = [2, 1, 3, 2]
location = 2
```
**Output:**
```
1
```
---
**Input:**
```
priorities = [1, 1, 9, 1, 1, 1]
location = 0
```
**Output:**
```
5
```
---
**Input:**
```
priorities = [2, 4, 3, 2, 1]
location = 2
```
**Output:**
```
2
```
---
