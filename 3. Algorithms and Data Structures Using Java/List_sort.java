/*package whatever //do not write package name here */
import java.util.*;
import java.io.*;

class List_sort {
	public static void main (String[] args) {
	    List<Integer> l = new ArrayList<Integer>();
	    l.add(26);
	    l.add(9);
	    l.add(5);
	    l.add(3);
	    for(int i=0; i<l.size()-1; i++){
	        int temp;
	        for(int j=i+1; j<l.size(); j++){
	           if(l.get(i) > l.get(j)){
    	            temp = l.get(i);
    	            l.set(i, l.get(j));
    	            l.set(j, temp);
	            }
	        }
	    }
	    for(int i=0; i<l.size()/2; i++){
	        int temp = l.get(i);
	        l.set(i, l.get(l.size()-1-i));
	        l.set(l.size()-1-i, temp);
	    }
		System.out.println(l);
	}
}