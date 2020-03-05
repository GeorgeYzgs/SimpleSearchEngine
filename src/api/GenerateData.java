/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import entities.Person;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author George.Giazitzis
 */
public abstract class GenerateData {

    private static List<Person> list = new ArrayList<>();
    private static Map<String, Set<Integer>> index = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public static List<Person> getList() {
        return list;
    }

    public static Map<String, Set<Integer>> getIndex() {
        return index;
    }

    public static void argumentHandler(String[] args) {
        if ("--data".equals(args[0]) && args.length > 1) {
            read(args[1]);
        }
    }

    private static void read(String file) {
        String dataRow;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((dataRow = br.readLine()) != null) {
                String[] dataRecord = dataRow.split("\\s+");
                createPersons(dataRecord);
            }
        } catch (IOException ex) {
            System.out.println("Could not Find File!");
        }
    }

    private static void createPersons(String[] personInfo) {
        if (personInfo.length == 3) {
            list.add(new Person(personInfo[0], personInfo[1], personInfo[2]));
        } else if (personInfo.length == 2) {
            list.add(new Person(personInfo[0], personInfo[1]));
        }
        invertedIndex(personInfo);
    }

    private static void invertedIndex(String[] words) {
        Set<Integer> positions;
        for (String word : words) {
            if (!index.containsKey(word)) {
                positions = new HashSet<>();
                positions.add(list.size() - 1);
                index.put(word, positions);
            } else {
                positions = index.get(word);
                positions.add(list.size() - 1);
            }
        }
    }
}
