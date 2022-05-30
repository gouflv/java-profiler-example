package com.example.profiler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import com.example.profiler.mock.FileStream;

import org.junit.jupiter.api.Test;

public class FileStreamTest {

  @Test
  void read() {
    FileStream fs = new FileStream();
    try {
      long size = fs.readFile("1");
      System.out.print("read1:" + size);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
