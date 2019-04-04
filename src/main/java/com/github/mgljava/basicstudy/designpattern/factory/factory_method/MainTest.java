package com.github.mgljava.basicstudy.designpattern.factory.factory_method;

public class MainTest {

  public static void main(String[] args) {

    ReaderFactory jpgReaderFactory = new JpgReaderFactory();
    final Reader reader = jpgReaderFactory.getReader();
    reader.read();

    final PngReaderFactory pngReaderFactory = new PngReaderFactory();
    pngReaderFactory.getReader().read();

    new GifReaderFactory().getReader().read();
  }
}
