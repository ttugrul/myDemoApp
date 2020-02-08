package com.mycompany.app;
import java.util.*;
import java.lang.Exception;

public class App extends Exception
{
    public static void main( String[] args )
    {
        ArrayList<Integer> list1 = new ArrayList<>();
      	ArrayList<Integer> list2 = new ArrayList<>();
      	list1.add(1);
      	list1.add(2);
      	list1.add(3);
      	list2.add(3);
      	list2.add(2);
      	System.out.println(equalityCheck(list1,list2,2,2));
    }
    public static boolean equalityCheck(ArrayList<Integer> array,ArrayList<Integer> array2, int a, int b) throws IllegalArgumentException {
        if (array == null || array2 == null)
            throw new NullPointerException("array can not be empty");
        if(a < 0 || b < 0)
      	    throw new IllegalArgumentException("negative index is not allowed");
      	if(array.size() <= a || array2.size() <= b)
      	    throw new IllegalArgumentException("wrong index");
      	if(array.get(a) == array2.get(b))
      	    return true;
      	return false;
    }
}
