package com.github.mgljava.basicstudy.designpattern.factory.factory_method;

public class GifReaderFactory implements ReaderFactory {

  @Override
  public Reader getReader() {
    return new GifReader();
  }
}
