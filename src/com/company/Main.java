package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
	Repository repository=new Repository();
    Service service=new Service();
    List<Unternehmen> unternehmenList;
    unternehmenList=repository.readFromFile("kundendaten.txt",",");
        System.out.println(unternehmenList);
    unternehmenList=service.sortNachMitarbeiter(unternehmenList);
    repository.writeToFile(unternehmenList,"kundensortiert.txt",",");
        System.out.println(service.topOrte(unternehmenList));
        List<Unternehmen> finalUnternehmenList = unternehmenList;
        String map=service.topOrte(unternehmenList).keySet()
                        .stream()
                                .map(key->key+"="+service.topOrte(finalUnternehmenList))
                                        .collect(Collectors.joining(","));

        Files.write(Path.of("src/com/company/statistik.txt"), Collections.singleton(map));
    }
}
