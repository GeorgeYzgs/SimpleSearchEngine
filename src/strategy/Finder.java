/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import api.GenerateData;
import entities.Person;
import java.util.*;

/**
 *
 * @author George.Giazitzis
 */
public abstract class Finder {

    private Scanner sc = new Scanner(System.in);
    protected List<Person> list = GenerateData.getList();
    protected Map<String, Set<Integer>> index = GenerateData.getIndex();
    protected String[] query = getInput();

    public abstract void find();

    private String[] getInput() {
        System.out.println("Enter a name or email to search all suitable people.");
        String input = sc.nextLine().trim();
        return input.split("\\s+");
    }

    protected Set<Integer> copySet() {
        Set<Integer> masterSet = new HashSet();
        for (Set<Integer> set : index.values()) {
            masterSet.addAll(set);
        }
        return masterSet;
    }

    protected boolean print(Set<Integer> masterSet) {
        if (!masterSet.isEmpty()) {
            System.out.println(masterSet.size() + " persons found:");
            for (Integer i : masterSet) {
                System.out.println(list.get(i));
            }
            return true;
        }
        System.out.println("No matching people found.");
        return false;
    }
}
