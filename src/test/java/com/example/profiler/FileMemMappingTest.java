package com.example.profiler;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.example.profiler.mock.FileMemMapping;

public class FileMemMappingTest {

  @Test
  void read() {
    FileMemMapping fs = new FileMemMapping();
    try {
      long size = fs.readFile("1");
      System.out.print("read1:" + size);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
