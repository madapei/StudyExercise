package com.mapei.javatest.test_thread;

import java.io.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/1/7
 */
public class TryWithResourcesTest {
    public static void main(String[] args) throws IOException{
        TryWithResourcesTest test = new TryWithResourcesTest();
//        test.normalTry();
        test.tryWithResource();
    }

    /*private void normalTry() throws IOException{
        MyInputStream inputStream = null;
        try {
            inputStream = new MyInputStream();
            inputStream.myRead();
            System.out.println("**************");
        }
        finally {
            if (inputStream != null){
                inputStream.close();
            }
        }
    }*/

    private void tryWithResource() throws IOException{
        try(MyInputStreamReader reader = new MyInputStreamReader();
            MyInputStream inputStream = new MyInputStream(reader)){
            inputStream.myRead();
            System.out.println("**************");
        }
        catch (IOException e){
            System.out.println("------ this is catch -------");
        }
    }
}
class MyInputStream implements AutoCloseable{
    public MyInputStream(MyInputStreamReader reader){

    }
    public void myRead() throws IOException{
        System.out.println("-------- myRead()---------");
        throw new IOException("This is my Read Exception");
    }

    @Override
    public void close() throws IOException{
        System.out.println("--------- myClose() --------");
        throw new IOException("This is my Close Exception");
    }
}

class MyInputStreamReader implements AutoCloseable{
    @Override
    public void close(){
        System.out.println("---------Reader.close()--------");
    }
}
