package Day88;

import java.util.Arrays;

public class Question2 {
    static class Job {
        int deadline;
        long profit;

        Job(int deadline, long profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    private int[] parent;

    public long maxProfit(int[] deadline, long[] profit) {
        int n = deadline.length;
        Job[] jobs = new Job[n];

        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        Arrays.sort(jobs, (a, b) -> Long.compare(b.profit, a.profit));

        parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }

        long totalProfit = 0;

        for (Job job : jobs) {
            int availableSlot = find(job.deadline);

            if (availableSlot > 0) {
                totalProfit += job.profit;
                parent[availableSlot] = find(availableSlot - 1);
            }
        }

        return totalProfit;
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
