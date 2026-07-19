import java.util.* ;
public class Question2 {
    public static int maximumPeople(int[] heights) {
        int size = heights.length;
        int[] left = new int[size];
        int[] right = new int[size];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int index = 0; index < size; index++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[index]) {
                stack.pop();
            }
            left[index] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(index);
        }
        stack.clear();

        for (int index = size - 1; index >= 0; index--) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[index]) {
                stack.pop();
            }
            right[index] = stack.isEmpty() ? size : stack.peek();
            stack.push(index);
        }
        int maxVisible = 1;
        for (int index = 0; index < size; index++) {
            int leftVisible = index - left[index] - 1;
            int rightVisible = right[index] - index - 1;
            int total = leftVisible + rightVisible + 1;
            maxVisible = Math.max(maxVisible, total);
        }
        return maxVisible;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of people: ");
        int size = sc.nextInt();
        int[] heights = new int[size];
        System.out.println("Enter the heights:");
        for (int index = 0; index < size; index++) {
            heights[index] = sc.nextInt();
        }
        System.out.println("Maximum visible people = " + maximumPeople(heights));
        sc.close();
    }
}