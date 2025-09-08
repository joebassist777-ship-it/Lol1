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

=====================
package exc1;

public class Nike extends Exception {

}

==========================
package exc1;
//예외 정답
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






================================== 전체 예외 잡기
package exc1;

public class A {

    // 1. ArrayIndexOutOfBoundsException
    int a() {
        try {
            int[] arr = new int[3];
            System.out.println(arr[-1]); // 예외 발생
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught");
            e.printStackTrace();
        } finally {
            System.out.println("A a finally");
            return 2;
        }
    }

    // 2. ClassCastException
    void a2(Object o) {
        try {
            B b = (B) o; // 예외 발생
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught");
            e.printStackTrace();
        }
    }

    // 3. NullPointerException
    void a3(B b) {
        try {
            b.b(); // b가 null이면 예외 발생
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught");
            e.printStackTrace();
        }
    }

    // 4. 사용자 정의 예외 throw
    void a4() throws Nike {
        throw new Nike("no size");
    }

    // 5. 모든 예외를 한 번에 처리
    void a5() {
        try {
            int[] arr = new int[2];
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException

            Object o = new Object();
            B b = (B) o; // ClassCastException

            B nullB = null;
            nullB.b(); // NullPointerException
        } catch (ArrayIndexOutOfBoundsException | ClassCastException | NullPointerException e) {
            System.out.println("예외 발생: " + e.getClass().getSimpleName());
            e.printStackTrace();
        }
    }
}


=======
	public class Main {
    public static void main(String[] args) {
        A a = new A();

        a.a(); // ArrayIndexOutOfBoundsException
        a.a2(new Object()); // ClassCastException
        a.a3(null); // NullPointerException

        try {
            a.a4(); // 사용자 정의 예외
        } catch (Nike e) {
            System.out.println("Nike 예외 caught: " + e.getMessage());
        }

        a.a5(); // 모든 예외 한 번에 처리
    }
}
=======================
	package exc1;

public class B {
    void b() {
        System.out.println("B.b() 호출됨");
    }
}
========================
package exc1;

public class Nike extends Exception {
    public Nike(String message) {
        super(message);
    }
}

