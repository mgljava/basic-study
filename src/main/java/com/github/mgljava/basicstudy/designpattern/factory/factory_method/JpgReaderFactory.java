package com.github.mgljava.basicstudy.designpattern.factory.factory_method;

public class JpgReaderFactory implements ReaderFactory {

  @Override
  public Reader getReader() {
    return new JpgReader();
  }
}
