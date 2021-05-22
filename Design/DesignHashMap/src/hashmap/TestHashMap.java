package hashmap;

public class TestHashMap {

	public static void main(String[] args) {
		HashMap hashMap = new HashMap();
		hashMap.put(1,  2);
		hashMap.put(3,  4);
		hashMap.put(5,  6);
		hashMap.put(2, 1);
		System.out.println(hashMap.get(1));
		System.out.println(hashMap.get(3));
		System.out.println(hashMap.get(5));
		System.out.println(hashMap.get(2));
		System.out.println(hashMap.get(10));
		hashMap.remove(3);
		System.out.println(hashMap.get(3));
		hashMap.put(1,  100);
		System.out.println(hashMap.get(1));
	}

}
