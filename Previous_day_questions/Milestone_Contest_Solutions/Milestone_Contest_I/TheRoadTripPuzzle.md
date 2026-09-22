# The Road Trip Puzzle


## Python

```python
#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'findStartingStation' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER_ARRAY gas
#  3. INTEGER_ARRAY cost
#

def findStartingStation(n, gas, cost):
    total = 0
    tank = 0
    start = 0

    for i in range(n):
        diff = gas[i] - cost[i]
        total += diff
        tank += diff

        if tank < 0:
            start = i + 1
            tank = 0

    if total < 0:
        return -1

    return start

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    gas = list(map(int, input().rstrip().split()))

    cost = list(map(int, input().rstrip().split()))

    result = findStartingStation(n, gas, cost)

    fptr.write(str(result) + '\n')

    fptr.close()
```

---

## C

```c
#include <assert.h>
#include <ctype.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* readline();
char* ltrim(char*);
char* rtrim(char*);

int parse_int(char*);

/*
 * Complete the 'findStartingStation' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY gas
 *  3. INTEGER_ARRAY cost
 */

int findStartingStation(int n, int* gas, int gas_count, int* cost, int cost_count) {
    long long total = 0;
    long long tank = 0;
    int start = 0;

    for (int i = 0; i < n; i++) {
        long long diff = (long long)gas[i] - cost[i];
        total += diff;
        tank += diff;

        if (tank < 0) {
            start = i + 1;
            tank = 0;
        }
    }

    if (total < 0) {
        return -1;
    }

    return start;
}

int main()
{
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");

    int n = parse_int(ltrim(rtrim(readline())));

    char* gas_line = readline();
    int* gas = malloc(n * sizeof(int));
    int gas_count = 0;

    char* token = strtok(gas_line, " \t\r\n");
    while (token != NULL) {
        gas[gas_count++] = parse_int(token);
        token = strtok(NULL, " \t\r\n");
    }

    char* cost_line = readline();
    int* cost = malloc(n * sizeof(int));
    int cost_count = 0;

    token = strtok(cost_line, " \t\r\n");
    while (token != NULL) {
        cost[cost_count++] = parse_int(token);
        token = strtok(NULL, " \t\r\n");
    }

    int result = findStartingStation(n, gas, gas_count, cost, cost_count);

    fprintf(fptr, "%d\n", result);

    fclose(fptr);

    return 0;
}

char* readline() {
    size_t alloc_length = 1024;
    size_t data_length = 0;

    char* data = malloc(alloc_length);

    while (true) {
        char* cursor = data + data_length;
        char* line = fgets(cursor, alloc_length - data_length, stdin);

        if (!line) {
            break;
        }

        data_length += strlen(cursor);

        if (data_length < alloc_length - 1 || data[data_length - 1] == '\n') {
            break;
        }

        alloc_length <<= 1;

        data = realloc(data, alloc_length);

        if (!data) {
            data = '\0';

            break;
        }
    }

    if (data_length > 0 && data[data_length - 1] == '\n') {
        data[data_length - 1] = '\0';

        data = realloc(data, data_length);

        if (!data) {
            data = '\0';
        }
    } else {
        data = realloc(data, data_length + 1);

        if (!data) {
            data = '\0';
        } else {
            data[data_length] = '\0';
        }
    }

    return data;
}

char* ltrim(char* str) {
    if (!str) {
        return '\0';
    }

    if (!*str) {
        return str;
    }

    while (*str != '\0' && isspace(*str)) {
        str++;
    }

    return str;
}

char* rtrim(char* str) {
    if (!str) {
        return '\0';
    }

    if (!*str) {
        return str;
    }

    char* end = str + strlen(str) - 1;

    while (end >= str && isspace(*end)) {
        end--;
    }

    *(end + 1) = '\0';

    return str;
}

int parse_int(char* str) {
    char* endptr;
    int value = strtol(str, &endptr, 10);

    if (endptr == str || (*endptr != '\0' && !isspace(*endptr))) {
        exit(EXIT_FAILURE);
    }

    return value;
}
```

---

## C++

```cpp
#include <bits/stdc++.h>

using namespace std;

string ltrim(const string&);
string rtrim(const string&);
vector<string> split(const string&);

/*
 * Complete the 'findStartingStation' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY gas
 *  3. INTEGER_ARRAY cost
 */

int findStartingStation(int n, vector<int> gas, vector<int> cost) {
    long long total = 0;
    long long tank = 0;
    int start = 0;

    for (int i = 0; i < n; i++) {
        long long diff = (long long)gas[i] - cost[i];
        total += diff;
        tank += diff;

        if (tank < 0) {
            start = i + 1;
            tank = 0;
        }
    }

    if (total < 0) {
        return -1;
    }

    return start;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string n_temp;
    getline(cin, n_temp);

    int n = stoi(ltrim(rtrim(n_temp)));

    string gas_temp_temp;
    getline(cin, gas_temp_temp);

    vector<string> gas_temp = split(rtrim(gas_temp_temp));

    vector<int> gas(gas_temp.size());

    for (size_t i = 0; i < gas_temp.size(); i++) {
        int gas_item = stoi(gas_temp[i]);

        gas[i] = gas_item;
    }

    string cost_temp_temp;
    getline(cin, cost_temp_temp);

    vector<string> cost_temp = split(rtrim(cost_temp_temp));

    vector<int> cost(cost_temp.size());

    for (size_t i = 0; i < cost_temp.size(); i++) {
        int cost_item = stoi(cost_temp[i]);

        cost[i] = cost_item;
    }

    int result = findStartingStation(n, gas, cost);

    fout << result << "\n";

    fout.close();

    return 0;
}

string ltrim(const string& str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), [](unsigned char ch) { return !isspace(ch); })
    );

    return s;
}

string rtrim(const string& str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), [](unsigned char ch) { return !isspace(ch); }).base(),
        s.end()
    );

    return s;
}

vector<string> split(const string& str) {
    vector<string> tokens;

    string::size_type start = 0;
    string::size_type end = 0;

    while ((end = str.find(' ', start)) != string::npos) {
        if (end != start) {
            tokens.push_back(str.substr(start, end - start));
        }

        start = end + 1;
    }

    if (start < str.length()) {
        tokens.push_back(str.substr(start));
    }

    return tokens;
}
```

---

## Java

```java
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.math.*;

class Result {

    /*
     * Complete the 'findStartingStation' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY gas
     *  3. INTEGER_ARRAY cost
     */

    public static int findStartingStation(int n, List<Integer> gas, List<Integer> cost) {
        long total = 0;
        long tank = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            long diff = gas.get(i) - cost.get(i);
            total += diff;
            tank += diff;

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        if (total < 0) {
            return -1;
        }

        return start;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] gasTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> gas = new ArrayList<>();

        for (int i = 0; i < gasTemp.length; i++) {
            int gasItem = Integer.parseInt(gasTemp[i].trim());
            gas.add(gasItem);
        }

        String[] costTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> cost = new ArrayList<>();

        for (int i = 0; i < costTemp.length; i++) {
            int costItem = Integer.parseInt(costTemp[i].trim());
            cost.add(costItem);
        }

        int result = Result.findStartingStation(n, gas, cost);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
```

---
