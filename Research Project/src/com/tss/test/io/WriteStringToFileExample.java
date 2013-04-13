package com.tss.test.io;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * How do I write string data to file?
 *
 */
public class WriteStringToFileExample
{
  public static void main(String[] args)
  {
    try
    {
      // Here we'll write our data into a file called
      // sample.txt, this is the output.
      File file = new File("sample.txt");
      // We'll write the string below into the file
      String data = "Learning Java Programming - Text changed";

      // To write a file called the writeStringToFile
      // method which require you to pass the file and
      // the data to be written.
      FileUtils.writeStringToFile(file, data);
    } catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
