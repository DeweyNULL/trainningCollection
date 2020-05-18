package Netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2020/04/24 10:45
 */

public class SocketServer {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    private int port ;

    SocketServer(int port){
        this.port = port;
        try {
            GroupChatInit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private void GroupChatInit() throws Exception{
            selector = Selector.open();
            serverSocketChannel =ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(10030));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void listen() throws Exception{
        while (true){
            int count = selector.select();

            if(count > 0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()){
                        SocketChannel sc = serverSocketChannel.accept();
                        sc.configureBlocking(false);
                        sc.register(selector,SelectionKey.OP_READ);
                        System.out.println(sc.getRemoteAddress()+"上线");
                    }

                    if(key.isReadable()){
                        readDate(key);
                    }
                }
                iterator.remove();
            }else {
                System.out.println("waiting....");
            }
        }
    }

    private void readDate(SelectionKey key) {
        SocketChannel channel = (SocketChannel)key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int count = 0;
        try {
            count = channel.read(byteBuffer);
            if(count>0){
                String msg = new String(byteBuffer.array());

                //发消息给所有用户
                for (SelectionKey tempKey: selector.keys() ) {
                    if( tempKey.channel() instanceof SocketChannel && tempKey.channel() != channel ){
                        SocketChannel tempChannel = (SocketChannel)tempKey.channel();
                        tempChannel.write(byteBuffer);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            key.cancel();
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        SocketServer socketServer = new SocketServer(10030);
        try {
            socketServer.listen();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
