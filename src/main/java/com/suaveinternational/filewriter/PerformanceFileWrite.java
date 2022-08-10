package com.suaveinternational.filewriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PerformanceFileWrite   {
    public static void main(String[] args)  {
        System.out.println("Project Directory: " + System.getProperty("user.dir"));

        try {
            BufferedReader br = new BufferedReader(
                new FileReader(new File(System.getProperty("user.dir")
                + "/target/jmeter/results/20220810-RESTHTTPGETRequest.jtl")));
            StringBuilder content = new StringBuilder();

            char[] buffer = new char[256];
            int index = 0;
            while((index = br.read(buffer)) != -1)  {
                content.append(buffer, 0, index);
            }
            br.close();

            FileWriter fw = new FileWriter(new File(System.getProperty("user.dir")
                + "/target/jmeter/results/20220810-RESTHTTPGETRequest.html"));

            fw.write(content.toString());
            fw.close();
        } catch (IOException ioe) {
            ioe.getMessage();
        }
    }
}