int countStudents(int* students, int studentsSize, int* sandwiches, int sandwichesSize)
{
    int count0 = 0, count1 = 0;

    for (int i = 0; i < studentsSize; i++)
    {
        if (students[i] == 0)
            count0++;
        else
            count1++;
    }

    for (int i = 0; i < sandwichesSize; i++)
    {
        if (sandwiches[i] == 0)
        {
            if (count0 == 0)
                return count1;

            count0--;
        }
        else
        {
            if (count1 == 0)
                return count0;

            count1--;
        }
    }

    return 0;
}