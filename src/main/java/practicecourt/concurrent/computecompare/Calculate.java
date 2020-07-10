package practicecourt.concurrent.computecompare;

import java.util.concurrent.ExecutionException;

/**
 * @Author: zhengfenghong
 * @Date: 2020/6/24 10:50
 */
public interface Calculate {

    Long sum(long[] nums) throws ExecutionException, InterruptedException;
}
