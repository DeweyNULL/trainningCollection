package Netty;

import org.apache.ibatis.annotations.SelectKey;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @program testCollections
 * @description: NIO 客户端
 * @author: xielinzhi
 * @create: 2020/04/24 11:24
 */

public class SocketClient {

    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    SocketClient(String host,int port){
        this.host = host;
        this.port = port;
        try {
            selector = Selector.open();
            socketChannel  = SocketChannel.open(new InetSocketAddress(host,port));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            this.username = socketChannel.getLocalAddress().toString();
            System.out.println(username+" is ok ...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg){
        String info= username + ": " +msg;
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void read(){
        try {
            int readChannel = selector.select();
            if(readChannel>0){
                Iterator<SelectionKey> iterator = selector.keys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isReadable()){
                        SocketChannel socketChannel = (SocketChannel)key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        socketChannel.read(buffer);
                        String msg = new String(buffer.array());
                        System.out.println(msg.trim());
                    }
                }
                iterator.remove();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SocketClient socketClient = new SocketClient("127.0.0.1",10030);

        new Thread(() -> {
            while (true){
                socketClient.read();
            }
        },"线程1").start();

        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNext()){
            String msg = scanner.next();
            socketClient.sendMsg(msg);
        }

    }
}
