package practicecourt.io.bigfileread;

public class Main {

    // https://blog.csdn.net/liuxiao723846/article/details/77007790?utm_medium=distribute.wap_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.wap_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
    // 对文件分区, 内存文件映射
    public static void main(String[] args) {
        BigFileReader.Builder builder = new BigFileReader.Builder("F:\\book\\bigfile.txt",
            new IHandle() {
                @Override
                public void handle(String line) {
//                         System.out.println(line);
                }
            });
        builder.withTreahdSize(10)
            .withCharset("gbk")
            .withBufferSize(1024 * 1024);
        BigFileReader bigFileReader = builder.build();
        bigFileReader.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bigFileReader.shutdown();

    }

}