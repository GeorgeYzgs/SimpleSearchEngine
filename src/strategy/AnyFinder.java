/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author George.Giazitzis
 */
public class AnyFinder extends Finder {

    @Override
    public void find() {
        Set<Integer> masterSet = new HashSet<>();
        for (String key : query) {
            if (index.containsKey(key)) {
                masterSet.addAll(index.get(key));
            }
        }
        print(masterSet);
    }
}
