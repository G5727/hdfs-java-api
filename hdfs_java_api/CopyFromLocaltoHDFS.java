package main.java.practice;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

/*@author: ganesh.nandyala
Program to copy the local file to HDFS path
 */
public class CopyFromLocaltoHDFS {

    public static void main(String args[]) throws URISyntaxException, IOException {
        String enteredPath;
        Configuration conf = new Configuration();
        System.out.println(conf.get("fs.defaultFS"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the HDFS Path with file name");
        enteredPath = sc.nextLine();
        FileSystem fs = FileSystem.get(new URI("hdfs://ignite1.sankir.com:8020"),conf);
        conf.set("fs.hdfs.impl",org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        conf.set("fs.file.impl",org.apache.hadoop.fs.LocalFileSystem.class.getName());

        Path path = new Path(enteredPath);
        Path destPath = new Path("/home/ganesh/FileNew1.txt");

        fs.copyToLocalFile(path,destPath);

        System.out.println("File copied from hdfs to local");

        fs.close();
    }
}
