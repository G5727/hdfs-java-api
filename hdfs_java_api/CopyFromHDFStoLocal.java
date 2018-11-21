package main.java.practice;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class CopyFromHDFStoLocal {
    public static void main(String args[]) throws URISyntaxException, IOException
    {
        String enteredPath;
        Configuration conf = new Configuration();
        System.out.println("Please enter the File name with full path");
        Scanner sc = new Scanner(System.in);
        enteredPath = sc.nextLine();
        FileSystem fs = FileSystem.get(new URI("hdfs://quickstart.cloudera:8020"),conf);
        conf.set("fs.hdfs.impl",org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        conf.set("fs.file.impl",org.apache.hadoop.fs.LocalFileSystem.class.getName());

        Path srcpath = new Path(enteredPath);
        Path destPath = new Path("/user/cloudera/ganesh");

        fs.copyFromLocalFile(srcpath,destPath);
        System.out.println("File copied into HDFS");
        fs.close();
    }
}
