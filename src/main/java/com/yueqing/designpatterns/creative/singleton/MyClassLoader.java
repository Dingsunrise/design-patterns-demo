package com.yueqing.designpatterns.creative.singleton;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author dingliming
 * @date 2022/7/19
 */
public class MyClassLoader extends  ClassLoader{

    private final Path classDir;

    public MyClassLoader(String classDir){
        super();
        this.classDir = Paths.get(classDir);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] classBytes = this.readClassBytes(name);
        if(classBytes.length == 0){
            throw new ClassNotFoundException("class " + name + "not found.");
        }

        return this.defineClass(name, classBytes, 0, classBytes.length);

    }

    private byte[] readClassBytes(String name) throws ClassNotFoundException {

        String classPath = name.replace(".", "/");
        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));

        if(!classFullPath.toFile().exists()){
            throw new ClassNotFoundException("class " + name + "not found.");
        }

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            Files.copy(classFullPath, baos);
            return baos.toByteArray();

        } catch (IOException ex) {
            throw new ClassNotFoundException("class " + name + "not found.");
        }
    }

    @Override
    public String toString() {
        return "MyClassLoader";
    }
}
