package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.lang.Exception;
/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( AppTest.class );
    }

    public void testEquality(){
      ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
      ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(9,8,7,6,5,4,3,2,1));
      assertTrue(App.equalityCheck(list1,list2,0,8));
      assertTrue(App.equalityCheck(list1,list2,2,6));
    }

    public void testNotEquality(){
      ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
      ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(9,8,7,6,5,4,3,2,1));
      assertFalse(App.equalityCheck(list1,list2,1,1));
      assertFalse(App.equalityCheck(list1,list2,2,3));
    }

    public void testNegativeIndex(){
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(9,8,7,6,5,4,3,2,1));
        try{
          App.equalityCheck(list1,list2,-5,2);
          fail("Missing Exception");
        }catch(IllegalArgumentException e){
            //success
        }

        try{
          App.equalityCheck(list1,list2,5,-2);
          fail("Missing Exception");
        }catch(IllegalArgumentException e){
            //success
        }
    }

    public void testWrongIndex(){
      ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
      ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(9,8,7,6,5,4,3,2,1));
      try{
        App.equalityCheck(list1,list2,20,30);
        fail("Missing Exception");
      }catch(IllegalArgumentException e){
         //success
      }
    }
    public void testNull(){
      try{
        App.equalityCheck(null,null,1,1);
        fail("Missing Exception");
      }catch(NullPointerException e){
         //success
      }
    }





}
