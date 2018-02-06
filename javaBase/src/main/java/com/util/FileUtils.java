package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件的工具类
 */
public class FileUtils {
    /**
     * 复制文件的方法
     * 源文件：必须是一个文件
     * 目标: 文件/文件夹
     *   A 如果目标是文件, 就将源文件复制到目标文件
     *   B 如果目标是文件夹, 就将原文件不改名
     *   复制到文件夹中.
     * 异常: 源文件不存在, 源文件是文件夹
     *   复制过程出现错误.
     * @throws FileNotFoundException 源文件不存在
     *   或者 源文件是文件夹
     * @throws IOException 复制过程出现错误
     */
    public static void cp(String src, String dst)
            throws FileNotFoundException, IOException {
        //算法: 检查数据输出的完整性
        File srcFile = new File(src);
        if(! srcFile.exists()){
            throw new FileNotFoundException(
                    "木有文件"+src);
        }
        if(srcFile.isDirectory()){
            throw new FileNotFoundException(
                    "源文件不能是文件夹!");
        }
        File dstFile = new File(dst);
        if(dstFile.exists()&&dstFile.isDirectory()){
            dstFile =
                    new File(dstFile, srcFile.getName());
        }
        FileInputStream in = null;
        FileOutputStream out = null;
        try{
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(dstFile);
            byte[] buf = new byte[1024*8];
            int n;
            while((n=in.read(buf))!=-1){
                out.write(buf, 0, n);
            }
        }catch(IOException e){
            e.printStackTrace();
            throw e;
        }finally{
            if(in!=null) in.close();
            if(out!=null) out.close();
        }
    }
    /**
     * 复制文件
     * @param src
     * @param dst
     * @throws CopyException 复制失败时候抛出
     */
    public static void copy(String src,String dst)
            throws CopyException{
        File srcFile = new File(src);
        if(! srcFile.exists()){
            throw new CopyException("源文件木有!"+src);
        }
        if(srcFile.isDirectory()){
            throw new CopyException("源是目录!");
        }
        File dstFile = new File(dst);
        if(dstFile.exists()&dstFile.isDirectory()){
            dstFile =
                    new File(dstFile, srcFile.getName());
        }
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(dstFile);
            int n;
            byte[] buf = new byte[1024*8];
            while((n = in.read(buf))!=-1){
                out.write(buf, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
            //抛出带有根本原因e的CopyException异常
            throw new CopyException("复制失败!", e);
        } finally{
            try{
                if(in!=null) in.close();
                if(out!=null) out.close();
            }catch(IOException e){
                //不需要抛出的异常, 这个异常没法处理!
                e.printStackTrace();
            }
        }

    }
}






