package practicecourt.io.nio;

import java.net.Socket;

public class NioTest3 {

    public static final String IP_ADDR = "localhost";//服务器地址
    public static final int PORT = 9001;//服务器端口号

    public static void main(String[] args) {
        System.out.println("客户端启动...");
        System.out.println("当接收到服务器端字符为 \"OK\" 的时候, 客户端将终止\n");
        //        while (true) {
        Socket socket = null;
        try {
            //创建一个流套接字并将其连接到指定主机上的指定端口号
            socket = new Socket(IP_ADDR, PORT);

        } catch (Exception e) {
            System.out.println("客户端异常:" + e.getMessage());
        } finally {

        }
        //        }
    }
}    