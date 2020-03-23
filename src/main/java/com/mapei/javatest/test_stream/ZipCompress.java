package com.mapei.javatest.test_stream;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/21
 */
public class ZipCompress {
    public static void main(String[] args) {
        try {
            //压缩文件
            FileOutputStream f = new FileOutputStream("F:\\test_file\\newZip.zip");
            CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
            System.out.println("Checksum:" + csum.getChecksum().getValue());
            ZipOutputStream zos = new ZipOutputStream(f);
            BufferedOutputStream out = new BufferedOutputStream(zos);
            zos.setComment("A book of fashion");
            String[] array = {"StreamTest.txt", "The Devil Wears Prada .txt"};
            for (String arg : array){
                System.out.println("Writing file " + arg);
                BufferedReader in = new BufferedReader(new FileReader("F:\\test_file\\" + arg));
                zos.putNextEntry(new ZipEntry(arg));
                int c;
                while((c = in.read()) != -1){
                    out.write(c);
                }
                in.close();
                out.flush();
            }
            zos.close();
//            System.out.println("Checksum:" + csum.getChecksum().getValue());

            //解压文件
            System.out.println("Reading file");
            FileInputStream fi = new FileInputStream("F:\\test_file\\newZip.zip");
            CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
            ZipInputStream in2 = new ZipInputStream(fi);
            BufferedInputStream bis = new BufferedInputStream(in2);
            ZipEntry ze;
            while ((ze = in2.getNextEntry()) != null){
                System.out.println("Reading file "+ ze);
                int x;
                while ((x = in2.read()) != -1){
                    System.out.write(x);
                }
            }
//            System.out.println("Checksum:" + csumi.getChecksum().getValue());
            in2.close();

            //通过ZipFile解压文件
            ZipFile zf = new ZipFile("F:\\test_file\\newZip.zip");
            Enumeration e = zf.entries();
            while (e.hasMoreElements()){
                ZipEntry ze2 = (ZipEntry) e.nextElement();
                System.out.println("File:" + ze2);
                BufferedInputStream ins = new BufferedInputStream(zf.getInputStream(ze2));
                BufferedOutputStream outs = new BufferedOutputStream(new FileOutputStream("D:/DDDDD/" + ze2.getName()));
                int i;
                while ((i = ins.read()) != -1){
                    outs.write(i);
                }
                outs.flush();
                ins.close();
                outs.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
