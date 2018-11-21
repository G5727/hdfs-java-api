package main.java.practice;
/*@author: ganesh.nandyala
Program to check hdfs directory exists or not
 */
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.util.Scanner;
import java.net.URI;
import java.net.URISyntaxException;

import java.io.IOException;

public class Test {
    public static void main(String args[]) throws IOException,URISyntaxException
    {
        String enteredPath;
        Configuration conf = new Configuration();
        System.out.println(conf.get("fs.defaultFS"));
        FileSystem fs = FileSystem.get(new URI("hdfs://ignite1.sankir.com:8020"),conf);
        Scanner sc  = new Scanner(System.in);

        System.out.println("Please enter HDFS path");
        enteredPath = sc.nextLine();
        Path path = new Path(enteredPath);

        if(fs.exists(path))
        {
            System.out.println(fs.exists(path));
            System.out.println(path+" Path Exists");
        }
        else
        {
            System.out.println(fs.exists(path));
            System.out.println(path+" Path not exists");
        }

    }
}
