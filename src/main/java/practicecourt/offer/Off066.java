package practicecourt.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用 Insert() 读取数据流，使用 GetMedian() 获取当前读取数据的中位数。
 * <p>
 * 用例: [5,2,3,4,1,6,7,0,8]
 * <p>
 * 对应输出应该为:
 * <p>
 * "5.00 3.50 3.00 3.50 3.00 3.50 4.00 3.50 4.00 "
 * <p>
 * 这题牛客上边用的是大小顶堆，注意一点：对于海量数据和流的数据，用最大堆和最小堆来管理 PriorityQueue 底层数据结构就是小顶堆，重写 comparator 可实现大顶堆
 */
public class Off066 {

    ArrayList<Integer> list = new ArrayList<>();
    /**
     * 记录偶数个还是奇数个
     */
    int count = 0;
    /**
     * 小顶堆
     */
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    /**
     * from 牛客
     * @param args
     */
    /**
     * 大顶堆
     */
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
        (Integer o1, Integer o2) -> o2 - o1);

    public static void main(String[] args) {
        Off066 obj = new Off066();
        obj.insert2(5);
        System.out.println(obj.getMedian2());
        obj.insert2(2);
        System.out.println(obj.getMedian2());
        obj.insert2(3);
        System.out.println(obj.getMedian2());
        obj.insert2(4);
        System.out.println(obj.getMedian2());
        obj.insert2(1);
        System.out.println(obj.getMedian2());
        obj.insert2(6);
        System.out.println(obj.getMedian2());
        obj.insert2(7);
        System.out.println(obj.getMedian2());
        obj.insert2(0);
        System.out.println(obj.getMedian2());
        obj.insert2(8);
        System.out.println(obj.getMedian2());
    }

    public void insert(Integer num) {
        list.add(num);
    }

    public Double getMedian() {
        int count = list.size();
        list = (ArrayList<Integer>) list.stream().sorted().collect(Collectors.toList());

        // 偶数
        if ((count & 1) == 0) {
            return (list.get(count / 2 - 1) + list.get(count / 2)) / 2.0;
        } else {
            return Double.valueOf(list.get(count / 2));
        }
    }

    /**
     * 每次插入小顶堆的是当前大顶堆中最大的数 每次插入大顶堆的是当前小顶堆中最小的数 这样保证小顶堆中的数永远大于等于大顶堆中的数 中位数就可以方便地从两者的根结点中获取了
     *
     * @param num
     */
    public void insert2(Integer num) {
        // 个数为偶数的话，则先插入到大顶堆，然后将大顶堆中最大的数插入小顶堆中
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        } else {
            // 个数为奇数的话，则先插入到小顶堆，然后将小顶堆中最小的数插入大顶堆中
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }

    public Double getMedian2() {
        // 当前为偶数个，则取小顶堆和大顶堆的堆顶元素求平均
        if ((count & 1) == 0) {
            return new Double(minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            // 当前为奇数个，则直接从小顶堆中取元素即可
            return new Double(minHeap.peek());
        }
    }
}
