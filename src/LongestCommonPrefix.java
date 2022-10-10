public class LongestCommonPrefix {

	public static void main(String[] args) {

		String[] x = { "flower", "flow", "flight" };

		String result = longestCommonPrefix(x);
		System.out.println(result);

	}

	public static String longestCommonPrefix(String[] strs) {

		String prefix = strs[0];

		for (int j = 1; j < strs.length; j++) {
			/*
			 * while (strs[j].indexOf(prefix) != 0) { prefix = prefix.substring(0,
			 * prefix.length() - 1); if (prefix.isEmpty()) return ""; }
			 */

			if (strs[j].length() < prefix.length()) {
				prefix = prefix.substring(0, strs[j].length());
			}
			while (prefix.length() > 0) {
				if (prefix.regionMatches(0, strs[j], 0, prefix.length())) {
					break;
				} else {
					prefix = prefix.substring(0, prefix.length() - 1);
				}
			}
		}

		return prefix;

	}
}