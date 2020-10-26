package com.github.mgljava.basicstudy.asm;

import java.io.File;
import java.io.FileOutputStream;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

public class ClassGenerator {

  public static void main(String[] args) throws Exception {
    // 读取
    ClassReader classReader = new ClassReader("com/github/mgljava/basicstudy/asm/Base");
    ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);

    // 处理
    ClassVisitor classVisitor = new MyClassVisitor(classWriter);
    classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
    byte[] data = classWriter.toByteArray();

    // 输出
    File file = new File("/Users/monk/Code/IdeaProjects/github/basic-study/build/classes/java/main/com/github/mgljava/basicstudy/asm/Base.class");
    FileOutputStream fileOutputStream = new FileOutputStream(file);
    fileOutputStream.write(data);
    fileOutputStream.close();
    System.out.println("generate success");
  }
}
