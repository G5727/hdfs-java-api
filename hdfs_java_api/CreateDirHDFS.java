package main.java.practice;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

/* author: ganesh.nandyala
Java class to create directory in HDFS
 */

public class CreateDirHDFS {
    public static void main(String args[]) throws URISyntaxException, IOException
    {
        String enterDir;
        Configuration conf = new Configuration();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter directory name to create in HDFS");
        enterDir = sc.nextLine();
        FileSystem fs = FileSystem.get(new URI("hdfs://quickstart.cloudera:8020"),conf);
        conf.set("fs.hdfs.impl",org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        conf.set("fs.file.impl",org.apache.hadoop.fs.LocalFileSystem.class.getName());
        Path path = new Path(fs.getWorkingDirectory()+"/"+enterDir);
        fs.mkdirs(path);
        System.out.println(enterDir+" directory sucessfully created on below path \n"+ fs.getWorkingDirectory());
    }
}
