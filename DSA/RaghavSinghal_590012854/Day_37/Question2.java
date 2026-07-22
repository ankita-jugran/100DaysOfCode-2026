import java.util.*;

class Solution {
    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public int printerQueue(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<>();

        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Document(i, priorities[i]));
        }

        int time = 0;

        while (!queue.isEmpty()) {
            Document current = queue.poll();

            
            boolean hasHigher = false;
            for (Document doc : queue) {
                if (doc.priority > current.priority) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.offer(current); 
            } else {
                time++; 

                if (current.index == location) {
                    return time;
                }
            }
        }

        return -1;
    }
}