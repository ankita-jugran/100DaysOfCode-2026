package Day89;

public class Question2 {
    public int buyChoco(int[] prices, int money) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < first) {
                second = first;
                first = price;
            } else if (price < second) {
                second = price;
            }
        }

        int cost = first + second;

        if (cost <= money) {
            return money - cost;
        }

        return money;
    }
}
