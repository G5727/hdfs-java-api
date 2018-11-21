package main.java.practice;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
/* @author: ganesh.nandyala
Java class to create File in HDFS
 */
public class CreateHDFSFile {
    public static void main(String args[]) throws URISyntaxException, IOException
    {
        Configuration conf = new Configuration();
        Scanner sc = new Scanner(System.in);
        String enteredFileName;
        boolean isFileCreated;
        System.out.println("Please enter File Name to create :");
        enteredFileName = sc.nextLine();

        FileSystem fs = FileSystem.get(new URI("hdfs://quickstart.cloudera:8020"),conf);
        conf.set("fs.hdfs.impl",org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        conf.set("fs.file.impl",org.apache.hadoop.fs.LocalFileSystem.class.getName());
        Path path = new Path(fs.getWorkingDirectory()+"/"+enteredFileName);
        isFileCreated = fs.createNewFile(path);

        if(isFileCreated)
        {
            System.out.println("Entered File "+enteredFileName+" sucessfully created");
        }
        else
        {
            System.out.println("Failed");
        }
    }
}
