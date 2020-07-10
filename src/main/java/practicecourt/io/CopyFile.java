package practicecourt.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description:
 * @Author: reed
 */
public class CopyFile {

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(
            "F:\\a-learn\\reedzheng-learn-master\\learn\\README.md");
        FileOutputStream outputStream = new FileOutputStream(
            "F:\\a-learn\\reedzheng-learn-master\\learn\\README.bak.md");

        FileChannel inputStreamChannel = inputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            int read = inputStreamChannel.read(buffer);
            if (read == -1) {
                break;
            }

            buffer.flip(); // 写切换为读
            outputStreamChannel.write(buffer); // 读 buffer，将数据输出到文件
            buffer.clear(); // clear 后才能继续往 buffer 中写入
        }

        inputStreamChannel.close();
        outputStreamChannel.close();
        inputStream.close();
        outputStream.close();
    }
}
