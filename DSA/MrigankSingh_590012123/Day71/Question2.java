package Day71;

public class Question2 {
    public String encryptGrid(String s) {
        StringBuilder textBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                textBuilder.append(c);
            }
        }
        String text = textBuilder.toString();
        int len = text.length();
        if (len == 0) {
            return "";
        }

        int cols = (int) Math.ceil(Math.sqrt((double) len));
        int rows = (int) Math.ceil((double) len / cols);

        char[][] grid = new char[rows][cols];
        int idx = 0;
        for (int r = 0; r < rows && idx < len; r++) {
            for (int c = 0; c < cols && idx < len; c++) {
                grid[r][c] = text.charAt(idx++);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int c = 0; c < cols; c++) {
            StringBuilder col = new StringBuilder();
            for (int r = 0; r < rows; r++) {
                if (grid[r][c] != '\0') {
                    col.append(grid[r][c]);
                }
            }
            if (col.length() > 0) {
                if (result.length() > 0) {
                    result.append(' ');
                }
                result.append(col);
            }
        }
        return result.toString();
    }
}
