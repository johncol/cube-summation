package com.hackerrank.challenges.cubesummation.input.reader;

import com.hackerrank.challenges.cubesummation.input.data.InputData;
import com.hackerrank.challenges.cubesummation.input.parser.InputParseException;
import com.hackerrank.challenges.cubesummation.input.parser.InputParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader implements InputReader {

    private final InputParser parser;
    private final String file;

    public FileReader(InputParser parser, String file) {
        this.parser = parser;
        this.file = file;
    }

    @Override
    public InputData read() throws InputReaderException {
        List<String> lines = getLinesList();
        try {
            return parser.parse(lines);
        } catch (InputParseException e) {
            e.printStackTrace();
            throw new InputReaderException(e);
        }
    }

    private List<String> getLinesList() throws InputReaderException {
        try {
            Path path = Paths.get(file);
            if (!Files.exists(path)) {
                throw new IOException("File doesn't exist: " + file);
            }
            return Files.lines(path).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            throw new InputReaderException(e);
        }
    }
}
