package com.javaCommApi;

import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenfengfu on 2018/1/18.
 */
public class IO {

    @Test
    public void fileTest() {
        File file = new File("./src/test/java/com");
        System.out.println(file.length());
        File[] childFile = file.listFiles();
        for (File child : childFile) {
            System.out.println(child.getName() + "  ");
        }
        File[] files = file.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith("OO.txt");
            }
        });
        System.out.println(files.length);
    }

    @Test
    // 随机文件访问类
    public void randomAccessFileTest() throws IOException {
        String fileParent = "./src/test/java/com/lib";
        String fileName = "test.txt";
        File parentFile = new File(fileParent);
        File file = new File(parentFile, fileName);
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        System.out.println(raf.getFilePointer()); // 指针位置
        raf.seek(raf.length()); // 移动指针到最后
        raf.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).getBytes(), 0, 19);
        raf.write("\r\n".getBytes());
        raf.seek(0);
        byte[] bytes = new byte[10];
        raf.read(bytes);
        System.out.println(new String(bytes));
        System.out.println(raf.readLine()); // 读取指针所在行的剩余部分
        raf.close();

    }


}
