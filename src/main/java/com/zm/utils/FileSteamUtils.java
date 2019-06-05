package com.zm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;



public class FileSteamUtils {
    
    public static void getFile() {
        File file = new File("C:\\Users\\Borgni\\Desktop\\新建文件夹\\输入输出流.txt");
        File target = new File("C:\\Users\\Borgni\\Desktop\\新建文件夹\\target.txt");
        FileInputStream fileStream = null;
        FileOutputStream out = null;
        
        try {
            fileStream = new FileInputStream(file);
            out = new FileOutputStream(target);
            byte[] b = new byte[1024];
            int result = 0; 
            while((result = fileStream.read(b)) != -1) {
                System.out.println("读取到了：" + result);
                out.write(b, 0, result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fileStream.close();
                out.close();
                System.out.println("流被关闭了！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void getReader() throws IOException {
            /*文件输入流*/
            FileInputStream filInputStream = new FileInputStream(new File("C:\\Users\\Borgni\\\\Desktop\\新建文件夹\\输入输出流.txt"));
            filInputStream.available();
            /*从中获取通道*/
            FileChannel channel1 = filInputStream.getChannel();
            /*分配48字节capacity的ByteBuffer*/
            ByteBuffer bufferHeader = ByteBuffer.allocate(8);
            ByteBuffer bufferBody = ByteBuffer.allocate(8);
            
            ByteBuffer[] bufferArray = {bufferHeader,bufferBody};
            /*把数据从channel中读取到ByteBuffer*/
            channel1.read(bufferArray);
            System.out.println("bufferHeader:"+bufferHeader);
            System.out.println("bufferBody:"+bufferBody);
            bufferHeader.flip();
            while(bufferHeader.hasRemaining()){
                System.out.println("Channel1.main():"+bufferHeader.get());
            }
            
            ByteBuffer bufferHeader2 = ByteBuffer.allocate(8);
            ByteBuffer bufferBody2 = ByteBuffer.allocate(8);
            bufferHeader2.put("a".getBytes());
            bufferBody2.put("b".getBytes());
            /*注意切换成读模式，否则channel2中得不到正确的信息*/
            bufferHeader2.flip();
            bufferBody2.flip();
            System.out.println("bufferHeader2:"+bufferHeader2);
            System.out.println("bufferBody2:"+bufferBody2);
            ByteBuffer[] bufferArray2 = {bufferHeader2,bufferBody2};
            /*文件输入流*/
            FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\Borgni\\Desktop\\新建文件夹\\输入输出流.txt"));
            /*从中获取通道*/
            FileChannel channel2 = fileOutputStream.getChannel();
            channel2.write(bufferArray2);
            
            fileOutputStream.close();
            filInputStream.close();
    } 
    
    public static void main(String[] args) {
//        FileSteamUtils.getFile();
        try {
            FileSteamUtils.getReader();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
