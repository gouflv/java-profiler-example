package com.example.profiler.mock;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileStream {
  public long readFile(String size) throws IOException {
    String filePath = String.format("tmp/%mb.bin", size);

    try (InputStream input = new FileInputStream(filePath)) {
      long count = 0;
      while (input.read() != -1) {
        count++;
      }
      return count;
    }
  }
}
