package practicecourt.offer;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * <p>
 * 测试很重要。。
 */
public class Off048 {
    public boolean isContinuous(int[] numbers) {
        int len = numbers.length;
        if (len <= 0) {
            return false;
        }

        int max = 0, min = 14;
        boolean flag = false;
        int[] assistant = new int[14];

        for (int i : numbers) {
            if (i == 0) {
                continue;
            }
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }

            assistant[i] += 1;
        }

        for (int i : assistant) {
            if (i>1){
                flag = true;
                break;
            }
        }

        return !flag && max - min + 1 <= len;
    }

    public static void main(String[] args) {
        int[][] arrs = {{1, 0, 0, 1, 0}, {2, 0, 0, 0, 0}, {1, 6, 8, 0, 0}, {2, 0, 0, 5, 1}, {0, 0, 0, 0, 3}};

        for (int[] arr : arrs) {
            System.out.println(new Off048().isContinuous(arr));
        }
    }
}

