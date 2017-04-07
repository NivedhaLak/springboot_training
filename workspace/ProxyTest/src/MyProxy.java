
public class MyProxy extends Target {
	@Override
	public void greet() {
		System.out.println("Pre process :");
		System.out.print("Good Morning, ");
		super.greet();
		System.out.print(" !!");
	}
}
