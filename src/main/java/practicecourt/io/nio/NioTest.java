package practicecourt.io.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {

    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("C:\\Users\\reed.zhang\\Desktop\\1.txt", "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        /*ByteBuffer byteBuffer2 = ByteBuffer.allocate(29);
        ByteBuffer[] buffers = {byteBuffer, byteBuffer2};
        channel.read(buffers);

        byteBuffer.flip();
        while(byteBuffer.hasRemaining()) {
            System.out.print((char) byteBuffer.get());
        }
        System.out.println();
        System.out.println("--------------------------------");
        byteBuffer2.flip();
        while(byteBuffer2.hasRemaining()) {
            System.out.print((char) byteBuffer2.get());
        }*/

        int flag = channel.read(byteBuffer);
        while (flag != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear();
            flag = channel.read(byteBuffer);
        }
        file.close();


        /*RandomAccessFile file2 = new RandomAccessFile("C:\\Users\\reed.zhang\\Desktop\\RRES0001-TEST.sql", "rw");
        FileChannel channel2 = file2.getChannel();
        channel.transferTo(0, channel.size(), channel2);*/
    }
}
