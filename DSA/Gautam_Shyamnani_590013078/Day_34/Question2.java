public class Question2 {

    public static int maxVisible(int[] arr) {
        int n = arr.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int count = 1; 

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) count++;
                else break; 
            }

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) count++;
                else break; 
            }

            max = Math.max(max, count);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(maxVisible(arr1));
    }
}