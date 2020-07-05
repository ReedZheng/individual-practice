package practicecourt.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description:
 * @Author: reed
 */
public class Server {
    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    private String str = "";

    public static void main(String[] args) throws Exception {
        System.out.println("server started...");
        new Server().start();
    }

    public void start() throws Exception {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.bind(new InetSocketAddress("localhost",
                8808));

        selector = Selector.open();
        System.out.println(selector);
        channel.register(selector,
                SelectionKey.OP_ACCEPT);

        while (!Thread.currentThread()
                .isInterrupted()) {
            // 当注册到Selector的所有Channel注册完后，调用Selector的select()方法，将会不断轮询检查是否有
            // 以上设置的状态产生，如果产生便会加入到SelectionKey集合中，进行后续操作。
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                if (!next.isValid()) {
                    continue;
                }
                if (next.isAcceptable()) {
                    accept(next);
                } else if (next.isReadable()) {
                    read(next);
                } else if (next.isWritable()) {
                    write(next);
                }
                iterator.remove();
            }
        }
    }

    public void accept(SelectionKey key) throws Exception {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        SocketChannel clientChannel = ssc.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(selector,
                SelectionKey.OP_READ);
        System.out.println("a new client connected " + clientChannel.getRemoteAddress());
    }

    public void read(SelectionKey key) throws Exception {
        System.out.println("进入 read");
        SocketChannel socketChannel = (SocketChannel) key.channel();
        this.readBuffer.clear();
        int numRead;
        try {
            numRead = socketChannel.read(this.readBuffer);
        } catch (IOException e) {
            key.cancel();
            socketChannel.close();
            return;
        }

        str = new String(readBuffer.array(),
                0,
                numRead);
        System.out.println("server 收到消息: " + str);
        socketChannel.register(selector,
                SelectionKey.OP_WRITE);
        System.out.println("退出 read");
    }

    public void write(SelectionKey key) throws Exception {
        System.out.println("进入 write");
        SocketChannel channel = (SocketChannel) key.channel();
        String s = "uuuu";
        writeBuffer.clear();
        writeBuffer.put(s.getBytes());
        writeBuffer.flip();
        channel.write(writeBuffer);
        channel.register(selector,
                SelectionKey.OP_READ);
        System.out.println("退出 write");
    }
}
