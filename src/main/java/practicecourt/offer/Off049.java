package practicecourt.offer;

/**
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。 HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌, 然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * <p>
 * 约瑟夫环
 */
public class Off049 {

    public int lastRemainingSolution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        Node current = null, pre = null;
        Node first = new Node(0);
        pre = first;

        // 构建环
        for (int i = 1; i < n; i++) {
            current = new Node(i);
            pre.next = current;
            pre = current;
        }
        if (pre != first) {
            pre.next = first;
        }

        // 开始模拟
        while (n > 1) {
            // m-1 是因为要删除的人是喊 m-1 那个数的人，比如有 5 人，指定的数是 2，则第一轮游戏喊到 1 的人出列
            for (int i = 0; i < m - 1; i++) {
                pre = first;
                first = first.next;
            }
            first = pre.next = first.next;
            n--;
        }

        return first.val;
    }
}

class Node {

    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}