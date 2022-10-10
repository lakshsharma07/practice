package augDailyChallenge;

import java.util.TreeMap;

public class MyCalendarI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cmd = {"MyCalendar", "book", "book", "book"};
		int[][] input = {{}, {10, 20}, {15, 25}, {20, 30}} ;
		for (int i =0;i<cmd.length;i++) {
			
			if (cmd[i].equalsIgnoreCase("MyCalendar")) {
				MyCalendar();
			}
			else if (cmd[i].equalsIgnoreCase("book")) {
				System.out.println(book(input[i][0],input[i][1]));
				System.out.println(map);
			}
			
		}
	}
	
	static TreeMap<Integer, Integer> map;
	public static void MyCalendar() {
		map = new TreeMap<>((a,b) -> b-a);
    }
    
    public static boolean book(int start, int end) {

    	for (Integer itr : map.keySet()) {
    		if (itr < end && start < map.get(itr)) return false;
		}
    	map.put(start, end);
    	
		return true;
        
    }

}
