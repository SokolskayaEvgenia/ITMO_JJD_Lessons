package ru.itmo.lessons.patterns.decorator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileLogging implements ILog {
    @Override
    public void log(String data) {
        try {
            Files.writeString(Path.of("log.txt"), data + "\r\n", StandardOpenOption.APPEND);
        } catch (IOException ignored) { }
    }
}