package practicecourt.io;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FileReader {

    public static void main(String[] args) {
        new FileReader().rearrange("C:\\Users\\reed.zhang\\Desktop\\CSHPOSC.20190501.txt");
    }

    /**
     * 读取文件（文件内容是sql查询出来的记录）并调整记录的顺序
     */
    public void rearrange(String filePath) {
        byte[] array;
        String s;
        int content;
        FileChannel fc = null;
        ByteBuffer buffer = ByteBuffer.allocate(50);
        StringBuffer sb = new StringBuffer();
        ArrayList<String> list = new ArrayList<>();

        try (FileInputStream fin = new FileInputStream(filePath)) {
            fc = fin.getChannel();

            content = fc.read(buffer);
            while (content != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    char c = (char) buffer.get();
                    if (c != '\n') {
                        sb.append(c);
                    } else {
                        list.add(sb.toString());
                        sb = new StringBuffer();
                    }
                }
                buffer.clear();
                content = fc.read(buffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (list.size() > 0) {
            list = (ArrayList<String>) list.stream().sorted().collect(Collectors.toList());
        }

        list.forEach(System.out::println);

    }
}
