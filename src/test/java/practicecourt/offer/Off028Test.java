package practicecourt.offer;

import org.junit.Test;
import practicecourt.offer.assistant.RandomListNode;

public class Off028Test {

    RandomListNode n5 = new RandomListNode(5, null, null);
    RandomListNode n4 = new RandomListNode(4, n5, null);
    RandomListNode n3 = new RandomListNode(3, n4, null);
    RandomListNode n2 = new RandomListNode(2, n3, n5);
    RandomListNode n1 = new RandomListNode(1, n2, n4);

    @Test
    public void customClone() {
        n5.random = n1;
        n4.random = n2;
        n3.random = n2;

        RandomListNode randomListNode = new Off028().customClone(n1);

        while (randomListNode != null) {
            System.out.print(randomListNode.label + " ");
            randomListNode = randomListNode.next;
        }

    }
}