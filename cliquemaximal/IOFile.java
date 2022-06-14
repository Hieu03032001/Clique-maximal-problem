package cliquemaximal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOFile {
	// ghi du lieu
	void OutputFile() {
		try {
			FileOutputStream fos = new FileOutputStream("D:\\HAUI-subject\\Java programing\\BTL\\log.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			// ghi du lieu vao file
			dos.writeInt(100);
			dos.writeChars("hieu");
			//dong file
			fos.close();
			dos.close();
			System.out.println("Ghi thanh cong!");
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	// doc du lieu
	void InputFile() {
		try {
			FileInputStream fis = new FileInputStream("D:\\HAUI-subject\\Java programing\\BTL\\input.txt");
			DataInputStream dis = new DataInputStream(fis);
			// doc du lieu'
			int n = dis.readInt();
			//double m = dis.readDouble();
			// dong  file
			fis.close();
			dis.close();
			System.out.print(n);
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
