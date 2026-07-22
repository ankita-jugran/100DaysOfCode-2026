class Pair {
    int i, p;

    Pair(int i, int p) {
        this.i = i;
        this.p = p;
    }
}

int printerQueue(int[] priorities, int location) {
    Queue<Pair> q = new LinkedList<>();

    for (int i = 0; i < priorities.length; i++)
        q.offer(new Pair(i, priorities[i]));

    int time = 0;

    while (!q.isEmpty()) {
        Pair cur = q.poll();

        boolean higher = false;
        for (Pair x : q) {
            if (x.p > cur.p) {
                higher = true;
                break;
            }
        }

        if (higher) {
            q.offer(cur);
        } else {
            time++;
            if (cur.i == location)
                return time;
        }
    }

    return -1;
}