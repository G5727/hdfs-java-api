package main.java.practice;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

/* author : ganesh.nandyala
Program to copy file from one location to another in HDFS.
 */
public class CopyFileFromLocationHDFS {
    public static void main(String args[]) throws URISyntaxException, IOException
    {
        Configuration conf = new Configuration();
        String srcPath,destPath;
        System.out.println("Please enter the Source HDFS Path");
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        srcPath = sc.nextLine();
        System.out.println("Please enter the Destination HDFS Path");
        destPath = sc1.nextLine();
        FileSystem fs = FileSystem.get(new URI("hdfs://quickstart.cloudera:8020"),conf);
        conf.set("fs.hdfs.impl",org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        conf.set("fs.file.impl",org.apache.hadoop.fs.LocalFileSystem.class.getName());

        Path spath = new Path(srcPath);
        Path dpath = new Path(destPath);

        boolean fu = FileUtil.copy(fs,spath,fs,dpath,true,conf);

        if(fu)
        {
            System.out.println("Sucessfully copied from "+srcPath+" to "+destPath);
        }
        else
        {
            System.out.println("Failed");
        }
    }
}
