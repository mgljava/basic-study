package com.github.mgljava.basicstudy.designpattern.factory.factory_method;

public class PngReaderFactory implements ReaderFactory {

  @Override
  public Reader getReader() {
    return new PngReader();
  }
}
