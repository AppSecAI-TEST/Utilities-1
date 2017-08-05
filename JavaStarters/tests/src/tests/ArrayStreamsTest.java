package tests;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayStreamsTest {
	
	public static void main(String[] strIn){
		ArrayList<String> al = new ArrayList<>(
				Arrays.asList(new String[]{"test1","test2","test3"}));
		
		al.parallelStream().filter(element-> element.startsWith("test"))
			.map(s->s+s).forEach(System.out::println);;
		
	}
}
