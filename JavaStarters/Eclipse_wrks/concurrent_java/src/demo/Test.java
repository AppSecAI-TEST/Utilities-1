package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
	
	public void f() throws Exception
	{
		List<Future<String>> list = 
			new ArrayList<Future<String>>();
		
		ExecutorService es = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++)
			list.add(es.submit(new MyCallable<String>()));
		
		es.shutdown();
		
		for (Future<String> f : list)
			System.out.println(f.get());	
	}

	public static void main (String[] args) throws Exception
	{
		new Test().f();
	}
	
}

class MyCallable<T> implements Callable {

	@Override
	public T call() throws Exception {
		
		String res = Thread.currentThread().getName();
		return (T)res;
	}
}
