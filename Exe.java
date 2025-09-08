package exc1;

public class A {
 void a() {
	 //ArrayIndexOutOfBoundsException
	 int[] arr =new int[3];
	 System.out.println(arr [-1]);
 }
 void a2 (Object o) {
	 //ClassCastException
	 B b=(B)o;
 }
 //널 포인트
 //NullPointerException
 void a3 (B b) {
	 b.b();
 }
}
======================
package exc1;

public class B extends Exception{
	void b() {}	
}

=====================================
  
package exc1;

public class Exc2 {
public static void main(String[] args) {
//new A().a();
//new A().a2(new A());
new A().a3(null);
}
}




==========================
package exc1;

public class A {
	void a() {
		try {
			// ArrayIndexOutOfBoundsException
			int[] arr = new int[3];
			System.out.println(arr[-1]);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	void a2(Object o) {
		// ClassCastException
		try {
			B b = (B) o;

		} catch (ClassCastException e) {
		}
	}
	// NullPointerException
	void a3(B b) {
		try {
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		b.b();
	}
}


