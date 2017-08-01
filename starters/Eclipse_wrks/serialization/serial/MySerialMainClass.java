package serial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MySerialMainClass {


	public static void main(String[] args) throws Exception {

//---		���� ��� ������
		File f = new File ("myfile.ser");
		if (!f. exists())
			f.createNewFile();
		
//---	����� ��� ������
		FileOutputStream fos = new FileOutputStream (f);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();		
//		ObjectOutputStream oos = new ObjectOutputStream (fos);
		ObjectOutputStream oos = new ObjectOutputStream (bos);
		
//		---	������ ��������		
		
		oos.writeInt(101);
		oos.writeObject ("� ������� ");
		
		MyEnumeration e = MyEnumeration.valueOf("TWO");
		oos.writeObject(e);
		
		ArrayList<Integer> inputList = new ArrayList<Integer>();
		for (int i = 1; i <= 5; i++)
			inputList.add(i);
		MySerializedClass inpMSC = new MySerializedClass(111, 222, 333, inputList);
		System.out.println ("�������� ������ MySerializedClass �� ������������:\n" + inpMSC);

		oos.writeObject(inpMSC);
		
		oos.flush();
		oos.close();
		
//---	������ ��� ������	
		FileInputStream fis = new FileInputStream (f);
		ByteArrayInputStream bis = new ByteArrayInputStream (bos.toByteArray());
//		ObjectInputStream ois = new ObjectInputStream (fis);
		ObjectInputStream ois = new ObjectInputStream (bis);

//	---	������ ��������		

		int i = ois.readInt();
		String str = (String)ois.readObject();
		System.out.println ("������: " + str + i);
		
		MyEnumeration e_ser = (MyEnumeration)ois.readObject();
		System.out.println ("������������ : " + e_ser + ", ��� ��������: " + e.setDescription());
				
		MySerializedClass outMSC = (MySerializedClass)ois.readObject();
		System.out.println ("�������� ������ MySerializedClass ����� ������������:\n" + inpMSC);
		System.out.println ("��������������� ������ MySerializedClass:\n" + outMSC);
		
		ois.close();
		
		System.out.println("\n\n������� �������� ����� ��������� �������.\n��������� �������� ������: ");
		inpMSC.setUsualInt(-111);
		inpMSC.setTransientStaticInt(-222);
		List<Integer> lst = inpMSC.getList();
		for (int j = 0; j < lst.size(); j++)
			lst.set(j, lst.get(j)+1000);
		lst.add(1006);
		System.out.println (inpMSC);
		System.out.println ("��������������� ������:\n" + outMSC);
		
	}
}
