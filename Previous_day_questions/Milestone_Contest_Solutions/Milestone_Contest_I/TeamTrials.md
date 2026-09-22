# Team Trials


## Python

```python
#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'maxBalancedSquad' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER_ARRAY skill
#

def maxBalancedSquad(n, skill):
    skill = sorted(skill)

    left = 0
    best = 0

    for right in range(n):
        while skill[right] - skill[left] > 5:
            left += 1

        window = right - left + 1

        if window > best:
            best = window

    return best

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    skill = list(map(int, input().rstrip().split()))

    result = maxBalancedSquad(n, skill)

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
 * Complete the 'maxBalancedSquad' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY skill
 */

int compare_ints(const void* a, const void* b) {
    long long diff = (long long)(*(int*)a) - (long long)(*(int*)b);
    if (diff < 0) return -1;
    if (diff > 0) return 1;
    return 0;
}

int maxBalancedSquad(int n, int* skill, int skill_count) {
    qsort(skill, n, sizeof(int), compare_ints);

    int left = 0;
    int best = 0;

    for (int right = 0; right < n; right++) {
        while (skill[right] - skill[left] > 5) {
            left++;
        }

        int window = right - left + 1;

        if (window > best) {
            best = window;
        }
    }

    return best;
}

int main()
{
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");

    int n = parse_int(ltrim(rtrim(readline())));

    char* skill_line = readline();
    int* skill = malloc(n * sizeof(int));
    int skill_count = 0;

    char* token = strtok(skill_line, " \t\r\n");
    while (token != NULL) {
        skill[skill_count++] = parse_int(token);
        token = strtok(NULL, " \t\r\n");
    }

    int result = maxBalancedSquad(n, skill, skill_count);

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
 * Complete the 'maxBalancedSquad' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY skill
 */

int maxBalancedSquad(int n, vector<int> skill) {
    sort(skill.begin(), skill.end());

    int left = 0;
    int best = 0;

    for (int right = 0; right < n; right++) {
        while (skill[right] - skill[left] > 5) {
            left++;
        }

        int window = right - left + 1;

        if (window > best) {
            best = window;
        }
    }

    return best;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string n_temp;
    getline(cin, n_temp);

    int n = stoi(ltrim(rtrim(n_temp)));

    string skill_temp_temp;
    getline(cin, skill_temp_temp);

    vector<string> skill_temp = split(rtrim(skill_temp_temp));

    vector<int> skill(skill_temp.size());

    for (size_t i = 0; i < skill_temp.size(); i++) {
        int skill_item = stoi(skill_temp[i]);

        skill[i] = skill_item;
    }

    int result = maxBalancedSquad(n, skill);

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
     * Complete the 'maxBalancedSquad' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY skill
     */

    public static int maxBalancedSquad(int n, List<Integer> skill) {
        Collections.sort(skill);

        int left = 0;
        int best = 0;

        for (int right = 0; right < n; right++) {
            while (skill.get(right) - skill.get(left) > 5) {
                left++;
            }

            int window = right - left + 1;

            if (window > best) {
                best = window;
            }
        }

        return best;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] skillTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> skill = new ArrayList<>();

        for (int i = 0; i < skillTemp.length; i++) {
            int skillItem = Integer.parseInt(skillTemp[i].trim());
            skill.add(skillItem);
        }

        int result = Result.maxBalancedSquad(n, skill);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
```

---
