
package dailyChalange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class FoodRatings {
	public static void main(String[] args) {
		String[] order = { "FoodRatings","changeRating","highestRated","changeRating","changeRating","changeRating","highestRated","highestRated"};
		String[] foods = { "emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"};
		String[] cuisines = {"snaxol","snaxol","snaxol","fajbervsj","fajbervsj"};
		int[] ratings = { 2,6,18,6,5};

		ArrayList<List<Object>> input = new ArrayList<>();
		input.add(null);
		input.add(List.of("qnvseohnoe",11));
		input.add(List.of("fajbervsj"));
		input.add(List.of("emgqdbo",3));
		input.add(List.of("jmvfxjohq",9));
		input.add(List.of("emgqdbo",14));
		input.add(List.of("fajbervsj"));
		input.add(List.of("snaxol"));
		FoodRatings obj = null;
		for (int i = 0; i < order.length; i++) {
			if (order[i].equalsIgnoreCase("FoodRatings")) {
				obj = new FoodRatings(foods, cuisines, ratings);
			} else if (order[i].equalsIgnoreCase("highestRated")) {
				String param_2 = obj.highestRated((String) input.get(i).get(0));
			} else if (order[i].equalsIgnoreCase("changeRating")) {
				obj.changeRating((String) input.get(i).get(0), (int) input.get(i).get(1));
			}
		}

	}

	HashMap<String, TreeMap<Integer,String>> map = new HashMap<>();

	public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
		for (int i = 0; i < cuisines.length; i++) {
			if (map.containsKey(cuisines[i])) {
				map.get(cuisines[i]).put(ratings[i],foods[i]);
			} else {
				TreeMap<Integer,String > st = new TreeMap<>((a,b) -> b-a);
				st.put(ratings[i],foods[i]);
				map.put(cuisines[i], st);
			}
		}
		System.out.println("null");
		System.out.println(map);
	}

	public void changeRating(String food, int newRating) {

		for (String itr : map.keySet()) {
			if (map.get(itr).containsValue(food)) {
				map.get(itr).put(newRating,food);
				break;
			}
		}
		System.out.println(map);
		System.out.println("null");
	}

	public String highestRated(String cuisine) {
		int maxRating = 0;
		String food = null;
		food = map.get(cuisine).firstEntry().getValue();
		System.out.println(food);
		return food;
	}
}

// Your FoodRatings object will be instantiated and called as such:
