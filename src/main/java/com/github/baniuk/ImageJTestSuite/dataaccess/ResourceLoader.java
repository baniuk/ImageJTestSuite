package com.github.baniuk.ImageJTestSuite.dataaccess;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Allow to load resource file either from jar or file system.
 * 
 * @author p.baniukiewicz
 *
 */
public class ResourceLoader {

  /**
   * Load resource file from either jar or filesystem.
   * 
   * <p>If class loader is an object run from jar, this method will make binary copy of resource in
   * temporary folder and return path to it.
   * 
   * <p>This code is taken from <a
   * href="https://stackoverflow.com/questions/941754/how-to-get-a-path-to-a-resource-in-a-java-jar-file">Stackoverflow</a>
   * 
   * 
   * @param c class loader
   * @param resource resource name and relative path
   * @return path to resource file
   */
  public static Path loadResource(ClassLoader c, String resource) {
    File file = null;
    URL res = c.getResource(resource);
    if (res.toString().startsWith("jar:")) {
      try {
        InputStream input = c.getResourceAsStream(resource);
        file = File.createTempFile(new Date().getTime() + "", "");
        OutputStream out = new FileOutputStream(file);
        int read;
        byte[] bytes = new byte[1024];

        while ((read = input.read(bytes)) != -1) {
          out.write(bytes, 0, read);
        }
        out.flush();
        out.close();
        input.close();
        file.deleteOnExit();
        return file.toPath();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    } else {
      // if resource is unpacked already
      return Paths.get(res.getFile());
    }

  }
}
