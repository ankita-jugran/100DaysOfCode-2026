package Day87;

import java.util.Arrays;
import java.util.Collections;

public class Question2 {
    public long minimumCoins(long[] coins, long amount) {
        Long[] boxedCoins = new Long[coins.length];
        for (int i = 0; i < coins.length; i++) {
            boxedCoins[i] = coins[i];
        }
        Arrays.sort(boxedCoins, Collections.reverseOrder());

        long count = 0;

        for (long coin : boxedCoins) {
            if (coin <= amount) {
                count += amount / coin;
                amount %= coin;
            }
        }

        return amount == 0 ? count : -1;
    }
}
