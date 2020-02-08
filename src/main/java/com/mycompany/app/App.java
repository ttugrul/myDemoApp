package com.mycompany.app;
import java.util.*;
import java.lang.Exception;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App extends Exception
{
    public static void main( String[] args )
    {
      port(getHerokuAssignedPort());

      get("/", (req, res) -> "Hello, World");

      post("/compute", (req, res) -> {
        //System.out.println(req.queryParams("input1"));
        //System.out.println(req.queryParams("input2"));

        String input1 = req.queryParams("input1");
        java.util.Scanner sc1 = new java.util.Scanner(input1);
        sc1.useDelimiter("[;\r\n]+");
        java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
        while (sc1.hasNext())
        {
          int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
          inputList.add(value);
        }
        System.out.println(inputList);

        String input2 = req.queryParams("input2");
        java.util.Scanner sc2 = new java.util.Scanner(input2);
        sc2.useDelimiter("[;\r\n]+");
        java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
        while (sc2.hasNext())
        {
          int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
          inputList2.add(value);
        }
        System.out.println(inputList2);

        String input3 = req.queryParams("input3").replaceAll("\\s","");
        int input3AsInt = Integer.parseInt(input3);

        String input4 = req.queryParams("input4").replaceAll("\\s","");
        int input4AsInt = Integer.parseInt(input4);

        boolean result = App.equalityCheck(inputList, inputList2, input3AsInt, input4AsInt);

       Map map = new HashMap();
        map.put("result", result);
        return new ModelAndView(map, "compute.mustache");
      }, new MustacheTemplateEngine());


      get("/compute",
          (rq, rs) -> {
            Map map = new HashMap();
            map.put("result", "not computed yet!");
            return new ModelAndView(map, "compute.mustache");
          },
          new MustacheTemplateEngine());
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

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
