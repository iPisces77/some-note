package org.example.io;

import java.io.InputStream;

/**
 * @author fuhaixin
 * @date 2022-12-23
 **/
public class Resources {

  public static InputStream getResourcesAsStream(String path) {
    return ClassLoader.getSystemResourceAsStream(path);
  }

}
