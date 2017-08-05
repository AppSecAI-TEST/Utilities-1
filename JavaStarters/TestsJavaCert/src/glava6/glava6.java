package glava6;

import java.io.IOException;

public abstract class glava6 {
	public static void main(String [] a) throws IOException {
		"dsds".substring(0, 2);
	};
}

class Flip2 {
		public static void main(String[] args) {
		String o = "-";
		String[] sa = new String[4];
		int i;
		for(i = 0; i < args.length; i++)
		sa[i] = args[i];
		for(String n: sa) {
		switch(n.toLowerCase()) {
		case "yellow": o += "y";
		case "red": o += "r";
		case "green": o += "g";
		}
		}
		i=9;
		System.out.print(o);
	}
}

class Loopy {
public static void main(String[] args) {
int[] x = {7,6,5,4,3,2,1};
// x[3]++,x[2]++,x[1]++;
for(int y=0, z=0; z<x.length; z++) { y = x[z];
System.out.print(y + " ");
}
}
}