public class MostBookedHotelRoom {
	public static String mostBookedRoom(String[] bookRooms) {
        Map<String, Integer> map = new HashMap<>();
        String maxRoom = "";
        int maxBooked = 0;
        
        for (String bookRoom: bookRooms) {
            if (bookRoom.charAt(0) == '+') {
                String room = bookRoom.substring(1);
                map.put(room, map.getOrDefault(room, 0) + 1);
                
                if (map.get(room) > maxBooked) {
                    maxBooked = map.get(room);
                    maxRoom = room;
                } else if (map.get(room) == maxBooked) {
                    maxRoom = maxRoom.compareTo(room) == 1 ? room : maxRoom;
                }
            }
        }
        
        return maxRoom;
	}

	public static void main(String[] args) {
		String[] A = { "+1A", "+3E", "-1A", "+4F", "+1A", "+1A", "-3E", "+3E", "+3E" };
        System.out.println(mostBookedRoom(A));
	}
}
