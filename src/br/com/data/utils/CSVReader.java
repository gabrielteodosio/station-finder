package br.com.data.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
  
  // TODO IF NEEDED
  private static String readFile(String path) throws IOException {
    StringBuilder sb = new StringBuilder();
    File file = new File(path);
    
    FileReader fr = null;
    try {
      fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line = null;
      line = br.readLine();
      do {
        line = br.readLine();
        
        if (line != null) sb.append(line).append('\n');
      } while(line != null);
    }
    catch (IOException e) {
      System.err.println("Error while trying to find file, please check the path passed:\n" + path);
    } finally {
      if (fr != null) {
        fr.close();
      }
    }
    
    return sb.toString();
  }
  
}
