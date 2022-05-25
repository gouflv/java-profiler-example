package com.example.profiler.mock;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileMemMapping {

  public long readFile(String size) throws IOException {
    String filePath = String.format("tmp/%smb.bin", size);

    try (RandomAccessFile f = new RandomAccessFile(new File(filePath), "r")) {
      FileChannel channel = f.getChannel();
      MappedByteBuffer buff = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());

      long count = 0;
      for (long i = 0; i < buff.limit(); i++) {
        count++;
      }
      return count;
    }
  }

}
