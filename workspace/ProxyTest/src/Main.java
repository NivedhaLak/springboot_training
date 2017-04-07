
public class Main {

	public static void main(String[] args) {
		Target t1 = new Target();
		t1.greet();
		Target t = new MyProxy();
		t.greet();

	}

}
