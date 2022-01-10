package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Service {
    public List<Unternehmen> sortNachMitarbeiter(List<Unternehmen> unternehmen){
        List<Unternehmen> unternehmenList=unternehmen
                .stream()
                .sorted(Comparator.comparing(Unternehmen::getMitareiter))

                .collect(Collectors.toList());
        Collections.reverse(unternehmenList);
        return unternehmenList;
    }

    public Map<String,Integer> topOrte(List<Unternehmen> unternehmen){
        return  unternehmen
                .stream()
                .collect(Collectors.groupingBy(Unternehmen::getOrt,Collectors.summingInt(Unternehmen::getEinkommen)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }
}
