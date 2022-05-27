package com.example.profiler.mock;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

  @GetMapping("/file-stream")
  public String fileStream(@RequestParam(defaultValue = "1") String s) {
    FileStream fs = new FileStream();
    try {
      long size = fs.readFile(s);
      return String.valueOf(size);
    } catch (IOException e) {
      return "error";
    }
  }

  @GetMapping("/file-stream2")
  public String fileStream2(@RequestParam(defaultValue = "1") String s) {
    FileStream fs = new FileStream();
    try {
      long size = fs.bufferedReadFile(s);
      return String.valueOf(size);
    } catch (IOException e) {
      return "error";
    }
  }

  @GetMapping("/file-mmap")
  public String fileMemMap(@RequestParam(defaultValue = "1") String s) {
    FileMemMapping fmm = new FileMemMapping();
    try {
      long size = fmm.readFile(s);
      return String.valueOf(size);
    } catch (IOException e) {
      return "error";
    }
  }
}
