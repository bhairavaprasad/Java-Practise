package com.tss.test.io;

import java.io.File;

/**
 * How do I get the absolute path of a file?
 *
 */
public class AbsolutePathExample
{
    public static void main(String[] args)
    {
        // Create an instance of File called file.
        File file = new File("JavaProgrammingBook.pdf");
        
        //File file = new File("AbsolutePathExample.java");

        // Now we want to know where is exactly this file is
        // located in our file system. To do this we can use
        // the getAbsolutePath() method of the File class.
        String absolutePath = file.getAbsolutePath();

        // Print out the JavaProgrammingBook.pdf location to
        // the console.
        System.out.println("AbsolutePath = " + absolutePath);
    }
}

