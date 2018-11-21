package main.java.practice;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

/* author: ganesh.nandyala
Java class to move file from one location to another location
 */
public class MoveFileFromLocationHDFS {
    public static void main(String args[]) throws URISyntaxException, IOException
    {
        boolean isMoved;
        Configuration conf = new Configuration();
        String srcPath,destPath;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter source path");
        srcPath = sc.nextLine();
        System.out.println("Please enter destination path");
        Scanner sc1 = new Scanner(System.in);
        destPath = sc.nextLine();
        FileSystem fs = FileSystem.get(new URI("hdfs://quickstart.cloudera:8020"),conf);
        conf.set("fs.hdfs.impl",org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        conf.set("fs.file.impl",org.apache.hadoop.fs.LocalFileSystem.class.getName());

        Path spath = new Path(srcPath);
        Path dpath = new Path(destPath);

        isMoved = fs.rename(spath,dpath);

        if(isMoved)
        {
            System.out.println("File Sucessfully moved "+srcPath+" to "+destPath);
        }
        else
        {
            System.out.println("Failed");
        }
    }
}
