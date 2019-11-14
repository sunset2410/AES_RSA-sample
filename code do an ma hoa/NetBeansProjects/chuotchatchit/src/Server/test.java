/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

/**
 *
 * @author admin
 */
public class test {
    public static Hashtable<String, String> listUser;// chua danh sach cac user;
    public static void main(String[] args) {
        listUser = new Hashtable<String, String>();
        listUser.put("1","chieu");
        listUser.put("a","hoang");
        listUser.put("c","hung");
        listUser.put("5","vuong");
        
        System.out.println(listUser.get("1"));//lay gia tri co key la 1;
        System.out.println(listUser.get("5"));//lay gia tri co key la 5
        System.out.println("hasttable co chua gia tri vuong ko? "+listUser.containsValue("vuon")); //kiem tra co chua hastable gia tri vuon khong?
        System.out.println("hasttable co chua trong ko? "+listUser.isEmpty());//kiem tra xem hastable co trong khong;
        
        // How to get all values form hashtable in Java
        // you can use keySet() method to get a Set of all the keys of hashtable
        // in Java
        //a.compareTo(b) == 0 should imply that a.equals(b)
        Set hashtableKeys = listUser.keySet();
 
        
        
        // you can also get enumeration(liet ke) of all keys by using method keys()
        Enumeration e = listUser.keys();
        String name="";
        String value=  " ";
		while(e. hasMoreElements()){
                    name+=(String) e.nextElement()+"\n";             
                    value+=listUser.get(name.toString());
		}
        System.out.print(name);
        System.out.print("\n"+value);
        
    }
    
    
    
    
}


