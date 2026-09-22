# Make It a Palindrome


## Python

```python
#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'makeItAPalindrome' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER_ARRAY b
#

def makeItAPalindrome(n, b):
    l, r = 0, n - 1
    left_sum, right_sum = b[l], b[r]
    ops = 0

    while l < r:
        if left_sum == right_sum:
            l += 1
            r -= 1
            if l < r:
                left_sum, right_sum = b[l], b[r]
        elif left_sum < right_sum:
            ops += 1
            right_sum -= left_sum
            l += 1
            if l <= r:
                left_sum = b[l]
        else:
            ops += 1
            left_sum -= right_sum
            r -= 1
            if l <= r:
                right_sum = b[r]

    return ops

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    b = list(map(int, input().rstrip().split()))

    result = makeItAPalindrome(n, b)

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
 * Complete the 'makeItAPalindrome' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY b
 */

int makeItAPalindrome(int n, int* b, int b_count) {
    int l = 0, r = b_count - 1;
    long long leftSum = b[l];
    long long rightSum = b[r];
    int ops = 0;

    while (l < r) {
        if (leftSum == rightSum) {
            l++;
            r--;
            if (l < r) {
                leftSum = b[l];
                rightSum = b[r];
            }
        } else if (leftSum < rightSum) {
            ops++;
            rightSum -= leftSum;
            l++;
            if (l <= r) {
                leftSum = b[l];
            }
        } else {
            ops++;
            leftSum -= rightSum;
            r--;
            if (l <= r) {
                rightSum = b[r];
            }
        }
    }

    return ops;
}

int main()
{
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");

    int n = parse_int(ltrim(rtrim(readline())));

    char* b_line = readline();

    int* b = malloc(n * sizeof(int));
    int b_count = 0;

    char* token = strtok(b_line, " \t\r\n");
    while (token != NULL) {
        b[b_count++] = parse_int(token);
        token = strtok(NULL, " \t\r\n");
    }

    int result = makeItAPalindrome(n, b, b_count);

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
 * Complete the 'makeItAPalindrome' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY b
 */

int makeItAPalindrome(int n, vector<int> b) {
    int l = 0, r = n - 1;
    long long leftSum = b[l];
    long long rightSum = b[r];
    int ops = 0;

    while (l < r) {
        if (leftSum == rightSum) {
            l++;
            r--;
            if (l < r) {
                leftSum = b[l];
                rightSum = b[r];
            }
        } else if (leftSum < rightSum) {
            ops++;
            rightSum -= leftSum;
            l++;
            if (l <= r) {
                leftSum = b[l];
            }
        } else {
            ops++;
            leftSum -= rightSum;
            r--;
            if (l <= r) {
                rightSum = b[r];
            }
        }
    }

    return ops;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string n_temp;
    getline(cin, n_temp);

    int n = stoi(ltrim(rtrim(n_temp)));

    string b_temp_temp;
    getline(cin, b_temp_temp);

    vector<string> b_temp = split(rtrim(b_temp_temp));

    vector<int> b(b_temp.size());

    for (size_t i = 0; i < b_temp.size(); i++) {
        int b_item = stoi(b_temp[i]);

        b[i] = b_item;
    }

    int result = makeItAPalindrome(n, b);

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
     * Complete the 'makeItAPalindrome' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY b
     */

    public static int makeItAPalindrome(int n, List<Integer> b) {
        int l = 0, r = n - 1;
        long leftSum = b.get(l);
        long rightSum = b.get(r);
        int ops = 0;

        while (l < r) {
            if (leftSum == rightSum) {
                l++;
                r--;
                if (l < r) {
                    leftSum = b.get(l);
                    rightSum = b.get(r);
                }
            } else if (leftSum < rightSum) {
                ops++;
                rightSum -= leftSum;
                l++;
                if (l <= r) {
                    leftSum = b.get(l);
                }
            } else {
                ops++;
                leftSum -= rightSum;
                r--;
                if (l <= r) {
                    rightSum = b.get(r);
                }
            }
        }

        return ops;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] bTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < bTemp.length; i++) {
            int bItem = Integer.parseInt(bTemp[i].trim());
            b.add(bItem);
        }

        int result = Result.makeItAPalindrome(n, b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
```

---
