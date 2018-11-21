package main.java.practice;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
/*@author: ganesh.nandyala
program to read the contents from HDFS file
 */
public class ReadHDFSFile {
    public static void main(String args[]) throws URISyntaxException, IOException
    {
        String enteredPath;
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://ignite1.sankir.com:8020"),conf);
        Scanner sc  = new Scanner(System.in);

        System.out.println("Please enter full HDFS path with file name");
        enteredPath = sc.nextLine();
        Path path = new Path(enteredPath);

        InputStream is = fs.open(path);

        while(is.available() > 0)
        {
            System.out.print((char)is.read());
        }

        is.close();
        fs.close();

        /*System.out.println("Read from file reader");
        FileReader f = new FileReader(String.valueOf(path));
        BufferedReader br = new BufferedReader(f);
        String currentLine = br.readLine();
        while(currentLine != null)
        {
            System.out.println(currentLine);
            currentLine = br.readLine();
        }*/
    }
}
