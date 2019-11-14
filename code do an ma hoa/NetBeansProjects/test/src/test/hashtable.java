/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Hashtable;

/**
 *
 * @author admin
 */
public class hashtable {
    private static Hashtable listchat = new Hashtable();
    
    public static void main(String[] args) {
        
        String name="chieu";
        listchat.put("one", "");
        listchat.put("two", "");
        listchat.put("three","");
        listchat.put("four", "");
        
        System.out.println("Does hashtable contains chieu as key: " + listchat.containsKey("chieu"));
        System.out.println("Does hashtable contains one as key: " + listchat.containsKey("one"));
        listchat.remove("one");
        System.out.println("Does hashtable contains five as key: " + listchat.containsKey("five"));
        listchat.put(name, name);
        System.out.println("Does hashtable contains chieu as key: " + listchat.containsKey("chieu"));
        listchat.remove(name);
        System.out.println("Does hashtable contains chieu as key: " + listchat.containsKey(name));
    }
    
    
    
}
