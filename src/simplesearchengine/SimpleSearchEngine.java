/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplesearchengine;

import api.Menu;
import api.GenerateData;

/**
 *
 * @author George.Giazitzis
 */
public class SimpleSearchEngine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GenerateData.argumentHandler(args);
        Menu.menu();
    }
}
