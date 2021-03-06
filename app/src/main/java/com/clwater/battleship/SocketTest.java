package com.clwater.battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketTest {
    public void client() throws IOException {
        //客户端
//1、创建客户端Socket，指定服务器地址和端口
        Socket socket =new Socket("192.168.199.184",10086);
//2、获取输出流，向服务器端发送信息
        OutputStream outputStream  = socket.getOutputStream();//字节输出流
        PrintWriter pw =new PrintWriter(outputStream);//将输出流包装成打印流
        pw.write("用户名：admin；密码：123");
        pw.flush();
        socket.shutdownOutput();
//3、获取输入流，并读取服务器端的响应信息
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(inputStream));
        String info = null;
        while((info=bufferedReader.readLine())!=null){
            System.out.println("我是客户端，服务器说："+info);
        }

//4、关闭资源
        bufferedReader.close();
        inputStream.close();
        pw.close();
        outputStream.close();
        socket.close();
    }
}
