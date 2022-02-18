import java.util.*;

public class FindMedianFromDataStream {
    public class MedianFinder {
        PriorityQueue<Integer> bigQueue;
        PriorityQueue<Integer> smallQueue;
        int count;
        MedianFinder () {
            bigQueue = new PriorityQueue<>();
            smallQueue = new PriorityQueue<>(Collections.reverseOrder());
            count=0;
        }
        void addNum(int num) {
            if (smallQueue.isEmpty()) {
                smallQueue.add(num);
            }
            else {
                if (smallQueue.peek() >= num) {
                    smallQueue.add(num);
                    bigQueue.add(smallQueue.poll());
                }
                else {
                    bigQueue.add(num);
                }
                if (smallQueue.size()>bigQueue.size()) {
                    bigQueue.add(smallQueue.poll());
                }
                else if (bigQueue.size()>smallQueue.size()) {
                    smallQueue.add(bigQueue.poll());
                }
            }
            count++;
        }
        double findMedian() {
            if (smallQueue.size() > bigQueue.size()) {
                return (double)smallQueue.peek();
            }
            else if (bigQueue.size()>smallQueue.size()) {
                return (double)bigQueue.peek();
            }
            else {
                return (smallQueue.peek()+bigQueue.peek())/2.0;
            }
        }
    }
}
