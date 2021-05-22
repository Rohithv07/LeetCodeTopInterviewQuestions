package hashSet;

public class TestHashSet {
	public static void main(String[] args) {
		DesignHashSet designHashset = new DesignHashSet();
//		designHashset.add(5);
//		designHashset.add(11);
		designHashset.add(10);
		designHashset.add(10);
		designHashset.delete(10);
		designHashset.add(5);
		designHashset.add(11);
		designHashset.add(12);
		designHashset.add(13);
		designHashset.add(14);
		designHashset.add(15);
		designHashset.add(116);
		
		System.err.println(designHashset.contain(5));
		System.err.println(designHashset.contain(11));
		System.err.println(designHashset.contain(10));
		System.err.println(designHashset.contain(12));
		System.err.println(designHashset.contain(13));
		System.err.println(designHashset.contain(14));
		System.err.println(designHashset.contain(15));
		System.err.println(designHashset.contain(16));
		System.err.println(designHashset.contain(116));
	}
}
