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

// 클래스 A: 예외 처리 실습용 클래스
public class A {
    // 1. 배열 인덱스 오류 예외 발생시키기
    int a() {
        try {
            int[] arr = new int[3]; // 크기가 3인 배열 생성 (인덱스 0~2)
            System.out.println(arr[-1]); // 잘못된 인덱스 접근 → 예외 발생
        } catch (ArrayIndexOutOfBoundsException e) {
            // 배열 인덱스가 범위를 벗어났을 때 실행됨
            System.out.println("ArrayIndexOutOfBoundsException caught");
            e.printStackTrace(); // 예외 정보 출력
        } finally {
            // 예외가 발생하든 안 하든 무조건 실행됨
            System.out.println("A a finally");
            return 2; // 메서드 결과로 2 반환
        }
    }

    // 2. 잘못된 형변환 예외 발생시키기
    void a2(Object o) {
        try {
            B b = (B) o; // Object를 B로 강제 형변환 → 실패 시 예외 발생
        } catch (ClassCastException e) {
            // 형변환이 잘못됐을 때 실행됨
            System.out.println("ClassCastException caught");
            e.printStackTrace(); // 예외 정보 출력
        }
    }

    // 3. 널 객체 접근 예외 발생시키기
    void a3(B b) {
        try {
            b.b(); // b가 null이면 예외 발생 (null.b() 호출 불가)
        } catch (NullPointerException e) {
            // null 객체를 사용하려고 할 때 실행됨
            System.out.println("NullPointerException caught");
            e.printStackTrace(); // 예외 정보 출력
        }
    }

    // 4. 사용자 정의 예외 던지기
    void a4() throws Nike {
        // 직접 만든 예외 Nike를 강제로 발생시킴
        throw new Nike("no size"); // 예외 메시지 포함
    }

    // 5. 여러 예외를 한 번에 처리하기
    void a5() {
        try {
            int[] arr = new int[2];
            System.out.println(arr[5]); // 배열 범위 초과 → ArrayIndexOutOfBoundsException

            Object o = new Object();
            B b = (B) o; // 잘못된 형변환 → ClassCastException

            B nullB = null;
            nullB.b(); // null 객체 접근 → NullPointerException
        } catch (ArrayIndexOutOfBoundsException | ClassCastException | NullPointerException e) {
            // 위 세 가지 예외를 한 번에 처리
            System.out.println("예외 발생: " + e.getClass().getSimpleName());
            e.printStackTrace(); // 예외 정보 출력
        }
    }
}

===============================================
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

