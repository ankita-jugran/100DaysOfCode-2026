package Day86;

import java.util.Arrays;

public class Question2 {
    static class Item {
        long value;
        long weight;

        Item(long value, long weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public double fractionalKnapsack(long[] value, long[] weight, long capacity) {
        int n = value.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(value[i], weight[i]);
        }

        Arrays.sort(items, (a, b) -> Double.compare(
                (double) b.value / b.weight,
                (double) a.value / a.weight
        ));

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity == 0) {
                break;
            }

            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += (double) item.value * capacity / item.weight;
                capacity = 0;
            }
        }

        return totalValue;
    }
}
