package com.popov.action;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class FileAction {

    public static void main(String[] args) {
        fileStreamExample();
    }

    @SneakyThrows
    private static void fileStreamExample() {
        final File file = new File("test.txt");
        final Path path = Path.of("test.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        try (FileInputStream inputStream = new FileInputStream("test.txt")) {
            int read;
            List<Byte> list = new LinkedList<>();
            while ((read = inputStream.read()) != -1) {
                list.add((byte) read);
            }
            byte[] bytes = new byte[list.size()];
            for (int i = 0; i < list.size(); i++) {
                bytes[i] = list.get(i);
            }

            final String s = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(s);
        }

        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            for (int i = 0; i < 10; i++) {
                outputStream.write("тест".getBytes(StandardCharsets.UTF_8));
            }
        }
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        final InputStream resourceAsStream = contextClassLoader.getResourceAsStream("xml/car.xml");
        // car.json
        // xml/car.xml

        final int i = "".indexOf("<");
        "".substring(i, i + 10);
    }
}
