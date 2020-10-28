package com.javaex.sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoExecutorUsage  {
	private static ExecutorService executor = null;
private static volatile Future taskOneResults = null;
private static volatile Future taskTwoResults = null;

public static void main(String[] args) {
	
	
	 String[] str1212 = new String[10];        
	 str1212[5] = "JAVA OPTIONAL CLASS EXAMPLE";// Setting value for 5th index  
     Optional<String> checkNull = Optional.ofNullable(str1212[5]);  
     if(checkNull.isPresent()){  // It Checks, value is present or not  
         String lowercaseString = str1212[5].toLowerCase();  
         System.out.println(lowercaseString);  
     }else  
         System.out.println("String value is not present");  
     
     
     Optional<String> checkNull1 = Optional.ofNullable(str1212[2]);
     
     System.out.println(checkNull1);
	
	
	
	
	
	
	
	
	
	
	
	 List<String> list = new ArrayList<>();
     list.add("1");
     list.add("2");
     list.add("3");
     list.add("4");
     list.add("5");
     
     // get the iterator
     Iterator<String> it = list.iterator();
     
     //manipulate list while iterating
     while(it.hasNext()){
         System.out.println("list is:"+list);
         String str = it.next();
         System.out.println(str);
         if(str.equals("2"))list.remove("5");
         if(str.equals("3"))list.add("3 found");
         //below code don't throw ConcurrentModificationException
         //because it doesn't change modCount variable of list
         if(str.equals("4")) list.set(1, "4");
     }
    executor = Executors.newFixedThreadPool(2);
    while (true)
    {
        try
        {
            checkTasks();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println("Caught exception: " + e.getMessage());
        }
    }
}

private static void checkTasks() throws Exception {
    if (taskOneResults == null
            || taskOneResults.isDone()
            || taskOneResults.isCancelled())
    {
        taskOneResults = executor.submit(new TestOne());
    }

    if (taskTwoResults == null
            || taskTwoResults.isDone()
            || taskTwoResults.isCancelled())
    {
        taskTwoResults = executor.submit(new TestTwo());
    }
}
}

class TestOne implements Runnable {
public void run() {
    while (true)
    {
        System.out.println("Executing task one");
        try
        {
            Thread.sleep(1000);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
}

class TestTwo implements Runnable {
public void run() {
    while (true)
    {
        System.out.println("Executing task two");
        try
        {
            Thread.sleep(1000);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
}
