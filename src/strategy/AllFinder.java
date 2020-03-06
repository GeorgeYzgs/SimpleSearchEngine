/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.util.Set;

/**
 *
 * @author George.Giazitzis
 */
public class AllFinder extends Finder {

    @Override
   public void find() {
        boolean isFound = false;
        Set<Integer> masterSet = copySet();
        for (String key : query) {
            if (index.containsKey(key)) {
                isFound = true;
                masterSet.retainAll(index.get(key));
            }
        }
        if (!isFound) masterSet.clear();
        print(masterSet);
    }
}
