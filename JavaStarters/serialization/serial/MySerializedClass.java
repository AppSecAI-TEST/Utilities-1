package serial;

import java.io.*;

import java.io.Serializable;
import java.util.ArrayList;

public class MySerializedClass implements Serializable {
	
	private static final long serialVersionUID = 123L;
	
	private static int staticIntTrans;
	private transient int transValue;
	private int usualValue;
	private ArrayList<Integer> list;
	
//  Значения сериализуемости полей по умолчанию:	
	
	private static final ObjectStreamField[] serialPersistentFields = { 
		new ObjectStreamField("usualValue", int.class),
		new ObjectStreamField("list", ArrayList.class)
	};

	public MySerializedClass (int uValue, int transSI, int tValue, ArrayList<Integer> list)
	{
		staticIntTrans = transSI;
		usualValue = uValue;
		transValue = tValue;
		this.list = list;
	}

	
	public int getTransientStaticInt () { return staticIntTrans; }
	public void setTransientStaticInt (int new_v) { staticIntTrans = new_v; }
	
	public int getUsualInt () { return usualValue; }
	public void setUsualInt (int v) { usualValue = v; }
	
	public int getTransientValue () { return transValue; }
	
	public ArrayList<Integer> getList () { return list; }

	public String toString()
	{
		String res = "-----------Данные для объекта MySerializedClass---------\n";
		res += ("usualValue = " + usualValue) + ";\n"; 
		res += ("staticIntTrans = " + staticIntTrans) + ";\n"; 
		res += ("Значение transient-поля = " + transValue) + ";\n";
		res += "Список:" + list.toString();
		res += "\n---------------------------------------------------------";
		return res;
	}
	
	private void writeObject (ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		System.out.println("Кастомизация сериализации объекта (запись)");
	}

	private void readObject (ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject();
		System.out.println("Кастомизация сериализации объекта (чтение)");
	}
}
