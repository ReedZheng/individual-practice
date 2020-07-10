package practicecourt.concurrent.computecompare;

/**
 * @Author: zhengfenghong
 * @Date: 2020/6/24 10:51
 */
public class ForLoop implements Calculate {

    @Override
    public Long sum(long[] nums) {
        Long result = 0L;
        for (Long num : nums) {
            result += num;
        }
        return result;
    }
}
