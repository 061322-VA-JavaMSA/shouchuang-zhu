public class test {
	public static void main(String[] args) {
		if(args.length == 1) {
			One();
		} else {
			Two(args);
		}
	}
	public static void One() {
		double rand = Math.random();
		System.out.println(rand);
	}
	public static void Two(String[] args) {
		int x = Integer.parseInt(args[0]);
		for(int i = 0; i < x; i++) {
			System.out.println(args[1]);
		}
	}
}	
