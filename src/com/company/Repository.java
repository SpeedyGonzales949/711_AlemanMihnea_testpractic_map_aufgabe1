package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Repository {
    public List<Unternehmen> readFromFile(String filename, String character) throws IOException {
        return Files
                .lines(Path.of("src/com/company/"+filename))
                .map(line->
                        new Unternehmen(Integer.parseInt(line.split(character)[0]),line.split(character)[1],Unternehmensgrosse.valueOf(line.split(character)[2]),Integer.parseInt(line.split(character)[3]),Integer.parseInt(line.split(character)[4]),line.split(character)[5]))
                .collect(Collectors.toList());
    }
    public void writeToFile(List<Unternehmen> unternehmen,String filename,String character) throws IOException {
        Files.write(Paths.get("src/com/company/"+filename),
                unternehmen
                        .stream()
                        .map(unternehmen1 -> Stream.of(
                                String.valueOf(unternehmen1.getId()),unternehmen1.getName(),unternehmen1.getUnternehmensgrosse().toString(),String.valueOf(unternehmen1.getMitareiter()),String.valueOf(unternehmen1.getEinkommen()),unternehmen1.getOrt()
                        )
                                .collect(Collectors.joining(character)))
                        .collect(Collectors.toList())
        );
    }
}
