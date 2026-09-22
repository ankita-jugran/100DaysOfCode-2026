#include <stdio.h>

int main()
{
	int r, c;
	scanf("%d %d", &r, &c);

	int grid[r][c];

	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			scanf("%d", &grid[i][j]);
		}
	}

	int p;
	scanf("%d", &p);

	int portals[p][3];

	for (int i = 0; i < p; i++)
	{
		scanf("%d %d %d", &portals[i][0], &portals[i][1], &portals[i][2]);
	}

	for (int k = 0; k < p; k++)
	{
		int pr = portals[k][0];
		int pc = portals[k][1];
		int bonus = portals[k][2];

		grid[pr][pc] += bonus;
	}

	int dp[r][c];

	dp[0][0] = grid[0][0];

	for (int j = 1; j < c; j++)
	{
		dp[0][j] = dp[0][j - 1] + grid[0][j];
	}

	for (int i = 1; i < r; i++)
	{
		dp[i][0] = dp[i - 1][0] + grid[i][0];
	}

	for (int i = 1; i < r; i++)
	{
		for (int j = 1; j < c; j++)
		{
			if (dp[i - 1][j] > dp[i][j - 1])
			{
				dp[i][j] = dp[i - 1][j];
			}
			else
			{
				dp[i][j] = dp[i][j - 1];
			}

			dp[i][j] += grid[i][j];
		}
	}

	printf("%d\n", dp[r - 1][c - 1]);

	return 0;
}
