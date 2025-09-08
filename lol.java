// 자바 12일 자바 시험
// 0908 예외
package exc;

public class A {
	void a3() throws Exception {
		throw new Exception();
	}
	// 예외가 날아갈수있다 ex)야구공 날린다
	void a(Object o) throws GloException {
		try {
			Apple c = (Apple) o;
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			throw new GloException();
		}
		// 예외 처리가 됐다 오브젝트로 하면 전부 예외로 출력 불가
		System.out.println("A a method end");
	}

	void a2() {
		int[] iArr = new int[5];
		int a = iArr[5];
		System.out.println("A a method end");
	}
}

======================

  package exc;

public class GloException extends Exception {
	GloException(){
		super("글로벌 예외 발생 일어나라 용사여 ");
	} 

}



================

  package exc;

public class Test {
	public static void main(String[] args) {
		try {
			new A().a(new Orange());
		} catch (GloException e) {
			e.printStackTrace();
		}

	}
}


========================
  java.lang.ClassCastException: exc.Orange cannot be cast to exc.Apple
	at exc.A.a(A.java:11)
	at exc.Test.main(Test.java:6)
exc.GloException: 글로벌 예외 발생 일어나라 용사여 
	at exc.A.a(A.java:16)
	at exc.Test.main(Test.java:6)
========================================================

  package exc;

public class A {

    // a3() 메서드는 호출되면 무조건 예외를 던짐
    // 예외를 직접 발생시키는 예제 (야구공을 던지는 것처럼 예외를 밖으로 날림)
    void a3() throws Exception {  
        throw new Exception(); // 강제로 예외 발생
    }

    // a(Object o) 메서드는 Object 타입을 받아서 Apple 타입으로 형변환 시도
    // 형변환 중 발생할 수 있는 예외들을 처리함
    void a(Object o) throws Exception {
        try {
            // Object를 Apple로 형변환 시도
            // Apple 클래스가 없으면 컴파일 에러가 날 수 있음 (가정상 존재한다고 봄)
            Apple c = (Apple)o;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            // 배열 인덱스 오류나 널 포인터 오류가 발생하면 여기서 처리
            e.printStackTrace(); // 오류 내용을 콘솔에 출력
        } catch (Exception e) {
            // 그 외 모든 예외는 여기서 처리
            e.printStackTrace(); // 오류 출력
            throw new Exception(); // 다시 예외를 던짐 (예외를 위로 전달)
        }

        // 예외가 발생하지 않거나 처리된 경우 실행됨
        System.out.println("A a method end");
    }

    // a2() 메서드는 배열 접근 오류를 발생시키는 예제
    void a2() {
        int[] iArr = new int[5]; // 크기가 5인 배열 생성 (인덱스 0~4)
        int a = iArr[5]; // 존재하지 않는 인덱스 5에 접근 → ArrayIndexOutOfBoundsException 발생
        System.out.println("A a method end"); // 이 줄은 실행되지 않음 (예외 발생으로 인해)
    }
}

======================
1. throws Exception vs throws GloException
- 첫 번째 코드는 throws Exception을 사용해서 자바 기본 예외 클래스를 던짐.
- 두 번째 코드는 throws GloException을 사용해서 사용자 정의 예외 클래스를 던짐.
👉 즉, 두 번째 코드는 개발자가 만든 GloException이라는 커스텀 예외 클래스를 활용하고 있어.
이건 실무에서 특정 상황을 구분하거나, 예외를 더 명확하게 표현할 때 자주 쓰이는 방식이야.

  ========================

package exc; // 이 클래스가 속한 패키지 이름

// 클래스 A 정의
public class A {

    // 메서드 a3: 강제로 일반 예외(Exception)를 발생시키는 메서드
    void a3() throws Exception {
        throw new Exception(); // 예외를 던짐 → 호출한 쪽에서 반드시 처리해야 함
    }

    // 메서드 a: Object 타입을 받아서 Apple로 형변환 시도
    // 예외 발생 시 사용자 정의 예외(GloException)를 던짐
    void a(Object o) throws GloException {
        try {
            Apple c = (Apple) o; // Object를 Apple로 강제 형변환
            // 만약 o가 Apple이 아니면 ClassCastException 발생
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            // 배열 범위 초과나 널 참조 예외가 발생하면 여기서 처리
            e.printStackTrace(); // 예외 내용을 콘솔에 출력
        } catch (Exception e) {
            // 그 외 모든 예외는 여기서 처리
            e.printStackTrace(); // 예외 출력 후
            throw new GloException(); // 사용자 정의 예외로 다시 던짐
        }
        // 예외가 없으면 정상적으로 이 메시지 출력됨
        System.out.println("A a method end");
    }
    // 메서드 a2: 배열 접근 예제
    void a2() {
        int[] iArr = new int[5]; // 길이가 5인 정수 배열 생성 (인덱스 0~4)
        int a = iArr[5]; // 존재하지 않는 인덱스 5에 접근 → 예외 발생
        System.out.println("A a method end"); // 위에서 예외 발생하므로 실행되지 않음
    }
}
