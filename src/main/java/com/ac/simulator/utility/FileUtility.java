package com.ac.simulator.utility;

import com.ac.simulator.exceptions.InvalidFileException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * File helper class which provides method to load file from resources
 */
public class FileUtility {
    public static List<String> loadFile(String filename) throws InvalidFileException {
        try {
            Path path = Paths.get(filename);
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch ( IOException e) {
            throw new InvalidFileException();
        }
    }
}
