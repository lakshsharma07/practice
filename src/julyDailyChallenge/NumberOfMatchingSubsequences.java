package julyDailyChallenge;

import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "kwyvpqbthzyvlspalhwnxnxuqnoquukfqrqrzezaxqxxylvperctdwahwfqstrxeksumnvsjvdcrazymzspqchnccihqfbgotmqgetvxeieyptbzjhnlbvxbjwckscujkzmodrazglthaadzlhdcatkxfxqkxxinvsfdmavdmhwdwknhbahvaiugfwppvzhvusvanxlacelycxxetbreykgygskvtikzvtuswnuwiiolylmmqzeolzsauhxrjxndyvwpzxkfrcywzkpxeifkatsxnobsdhrkfzouokybywkdccsxmietrqwcwqmwpxoeuriolrvkuxsxbllquactpqmrtzdugbbuhmuwbvwkbtthubtsaqxumwviwcblfwkplbvameldbkndhbzougsldayvvimodwhcrotxrqisnjxoegxgkafdsrgfmblkpmiqydtyxejusciilthovsebdjsxlnnfghkdkvmpoiulblsqdxgimnwccvbrheeupcwcoqomzigaesrugvlaqqsoghsbafjudazeqbbqwvmcudbsbaklariyqvnuvezqdfjdhnfudktsarsanomhxqxggjzbslelxwfixgzkxcdsaafixcnuhbixzeskmaqucdhgesiqzvpetuehawaevisviybrtevkgpxlgdvygubzahzqhtscwuzgcabhqphgfgvgaaocahzulumcfnugafcfrflwzpijmqdcdmrksvwuluzehmgvvjfzctdtwmdppzfbiciizrguhvsfieawiuiyuvxyniwwlxjmqejlwycornxkhzhcbnvzlkovjnfhnsasscugrduwjhfloeyhjpgcpgobrftesppkdtflqodcpncpetxudohpibgajpfwaxpncapaktncxpgikwomzcshupklkkdidadlvoyqgeckxfuwmoqtqijzcxvlriuupwamfibspyrzsxvscegcixedhycryxgylmjvvcmhgojw";
		String[] words = { "hnlbvxbjwckscujkzmodrazglthaadzlhdcatkxfxqkx", "nobsdhrkfzouokybywkdccsxmietrqwcwqmwpxo",
				"yqgeckxfuwmoqtqijzcxvlriuupw", "rflwzpijmqdcdmrksvwuluz", "gafcfrflwzpijmqdc", "hvsfieawiuiyuvxy",
				"ybywkdccsxmietrqwcwqmwpxoeurio", "mzspqchnccihqfbgotmqgetvxeieyptbzjhn", "sbaklariyqvnuve",
				"zkpxeifkatsxnobsdhrkfzouokybywkdccsxmi", "srgfmblkpmiqydtyxejusciilthovsebdjsxl", "sauhxrjxndyvwp",
				"lbvxbjwckscujkzmodrazglthaadzlhdcatkxfxqkx", "ifkatsxnobsdhrkfzouokybywkdccsxmietrqwcwqmwpxoeur",
				"ctdtwmdppzfbiciizrguhvsfieawiuiyuvxyniwwlxj", "zctdtw", "xlacelycxxetbreykgy",
				"wuzgcabhqphgfgvgaaocahzulumcfnugafcfrf", "ksvwuluzehmgvvjfzct", "hrkfzouokybywkdccsxmietrq",
				"ibgajpfwaxpncapaktncxpg", "aadzlhdcatkxfxqkxxinvsfdmavdmhwdwknh",
				"olrvkuxsxbllquactpqmrtzdugbbuhmuwbvwkbtthubtsaqxu",
				"xgkafdsrgfmblkpmiqydtyxejusciilthovsebdjsxlnnfghk", "wmoqtqijzcxvlriuupwamfibspyrzsxvscegcixedhycry",
				"ibgajpfwaxpncapaktncxpgikwomzcshupklkkdidadlvoyqge", "aocahzulumcfnugafcfr",
				"qxggjzbslelxwfixgzkxcdsaafixcnuhbixzeskmaqucdhges", "tyxejus", "kdtflqodcpncpetxudo",
				"fudktsarsanomhxqxggjzbs", "umnvsjvdcrazymzspqchnccihqfbgotm", "snjxoegxgkafdsrgfmblkpmiqydt",
				"ygskvtikzvtuswnuwiio", "dcrazymzspqchnc", "rotxrqisnjxoegxgkafdsrgfmblkpmiqydtyxejusciil",
				"xeieyptbzjhnlbvxbj", "xfxqkxxinvsfdmavdmhwdwknhb", "kgygskvtikzvtuswnuwiiolylmmqzeolzsauhxrjxn",
				"afcfrflwzpijmqdcdmrksvwuluzehmgv", "vanx", "xvlriuupwamfibspyrzsxvsce",
				"tflqodcpncpetxudohpibgajpfwaxpncapaktncxpgikwo", "bafjudazeqbbqwvmcudbsbaklariyqvnuvezqdfjd",
				"wfqstrxeksumnv", "lnnfghkdkvmpoiulblsqdxgimnwccvbrhe", "blfwkplbvameldbkn",
				"ccsxmietrqwcwqmwpxoeuriolrvkuxsxbllquactpqmrt", "eieyptbzjhnlbvxbjwckscujkzmodrazglthaa",
				"slelxwfixgzkxcdsaafixcnuhb", "ppdsxfksvwdnttzkzdqzjogutzbuogkstwymhuzakwkazcilmz",
				"luhiqkykzquprdllauiitlfwecarknxjricrkesqljtzfxpvha",
				"xlzdrgsxvrldekcomxmnmynphlybzsshboaxfkhctvpoolafky",
				"eerbaqtvdtsqyhyjxoufrelfrgowepgikgcykakxdwxtextfua",
				"ndgcexlhukgixscvutdjhjyozkosepknkayvrzevpofqwueffo",
				"nmitkligmkajsaoavgvtrwbdwmhijqeuyncyqposqwjkezhyhm",
				"wmoitvyatxqgxzpzjjhuukzzqmokuxsscadyaxefkkrodkcvdn",
				"tifpbntrlhxwsiaahnwsfplbpxvnoiivcwbdzsiiykrgorhjxu",
				"dkyqwflsukawqnyxqlxkrchnuowivmlitdezzclifrphkbxwvi",
				"txrzkklatrjorjjdfgvzobuvenxczebjoudpejvdcugfytragc",
				"tnrwwddicpcklfmwzqhckjcfqivxlppfjepvowpgynausilqpl",
				"bwdeamxprpyvsertgjlrbgilceisfwkgiaafdgvpslkxosdnkr",
				"zncujiobyzawcppsfqqrafidumncqyihrndzdueqkpcakrlwrb",
				"bfyfashxaawekugtuwzknyipasdmumspzvvoffykrjemlayyad",
				"hyktxabywjtbswhrtbtztkupmcvbupqzjqfjytvjfrmxtukhsx",
				"kvkzyjfuwautppbokrkwxrmchlmyrjldlwflgtqbgxxdwbuhrl",
				"qpycpwyxlewpkwvwjplqrgscfeuclujlwzmjvligsqohchqybd",
				"mwitwkjxofucxajsvgzakczncylxcgizkgnoosuhjkydjwzgcb",
				"sdbeijqzrdyjzvkuzipewikajuvsprneexgbiaaqndhbosieit",
				"xpriojcvdifltjopawldcjaaqzehibauefaxjedqbhgfmomkmr",
				"xeqpuoxzwiizvwgcomlsdvfsdpljidqouhnzixnisevlrpvsxl",
				"uwgnfdveznatiepykwdcegqxcqslimstwdsthcbchomfkxxzls",
				"nneddikiqwajapjhzxjhlendoolhnjowbstgubodewvbsgphec",
				"lslugamfvbvsnnaifvogecyspbigxmffbblyzmkikiknrxsudg",
				"qqczwdzstgzoayzlqfhrarodiqymwgjxrdiywbsxubyqucwhby",
				"esipgarzvbpxqtuukdvlluzmmjlbilfdnvaxmdxxxnaehscwlo",
				"brckptyfbcflospnayjlkpxydzfrcyqxsipqymxixyemzmsqcr",
				"hcmbjdxujfumgmxzlynelolkagrfygpxlkjyhrizboymqsitkb",
				"pphycufmpraiammjeghzqrduogimgadcpdsdosjixbbajnfpho",
				"qrmbcfvdbtlqaqgikddrfyrysqocxxkinhjynqwtijktckoijv",
				"ltzqoshzwmrhtioywgeptotikuvkxklbamrcvcepcbakmzvhcr",
				"wjwdhrenmbyeevrkpykghfvwdadvgofhuqxsvrikkgirkkifeo",
				"byypwnvxyeqzvqrbxutdxvtlwnmauhxwpblkgcpmouljhqzslh",
				"wvwsysetrmvjvydtoenjzwfrkryzwuhzefstwizqftciqsqqsb",
				"taoswubadzxjfurmpqrglcddkfavvgrproacbzepelcorsroxl",
				"dvltxfensrbpfcspdngkxttkqbparpveogyhomdgpaifagxwyf",
				"rzwjmehakpwqrlhtgucywrwdrdoketvdcbaqiibvvwswwrhmse",
				"ewcpmpimmchipndbjnucfyefjwboqvforkjizlxtixitdpybxk",
				"zttjfvwuzsolnqurqreqzusbbxwrlznzgopmdfasdtpeoieteq",
				"ikywqwtsxbatqcsyktczhhmgiuuzlqxplvganhrsiarphrralf",
				"uxuoagmqumwrwekystfqogpggdgftbxflgzximbgodwsdvbohw",
				"vvzujczaqzihjjsdvnigtgclrofkqomphiqchidzouizheeirg",
				"ccwkisxtcyzhpssvcxsckehnemtthgleotkdbhnwsxlxklfufb",
				"spgezsugjjkjgaeaiksqdzbczvtvlbqhrlkfpmzwhhscmfctwe",
				"wryssvzguwnsglsffxjfjotiybwaicwdbhjtjequrtwkbrrgqk",
				"ngyhgnxufiqbpgoorjypevmmvnyhcvhsmfihrzkzqxbpvcumxa",
				"yczvkfjpnaltdnacmlecmllfrdskbdtmqiramxxiviueolksgd",
				"zoxqikgwgkuycvlcicuplaruqxfuxoqflgrkwfpgcffrqogupi",
				"plabhvozomdpzahdfzapjlcaghtyedpimtrwgpbmxkrcjzawjd",
				"pgejjbhtqmwaarbotgnjcpvvskgnunptvhijubrwcpfsvtkqli" };

		System.out.println(numMatchingSubseq(s, words));
	}

	public static int numMatchingSubseq(String s, String[] words) {
		int count = 0;
		if (s == null || s.length() == 0)
			return 0;
		TrieNode root = buildTrie(s);

		HashMap<String, Integer> map = new HashMap<>();
		for (String str : words) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		for (String word : map.keySet()) {
			if (dfs(word, root))
				count += map.get(word);
		}
		return count;
	}

	private static boolean dfs(String word, TrieNode root) {
		int i = 0;
		while (i < word.length()) {
			int index = word.charAt(i) - 'a';
			if (root.children[index] == null) {
				if (root.isEndOfWord) {
					return false;
				}
				root = root.children[root.index];
			} else {

				root = root.children[index];

				if (root.isEndOfWord) {
					if (i == word.length() - 1)
						return true;
					else
						return false;
				}

				i += 1;
			}

		}
		return true;
	}

	private static TrieNode buildTrie(String s) {
		TrieNode root = new TrieNode();
		TrieNode current = root;
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if (current.children[index] == null)
				current.children[index] = new TrieNode();
			current.index = index;
			current = current.children[index];
		}
		current.isEndOfWord = true;
		return root;
	}

	static class TrieNode {
		boolean isEndOfWord;
		TrieNode[] children;
		int index;

		public TrieNode() {
			children = new TrieNode[26];
			isEndOfWord = false;
		}
	}
	
	
	
	 public int numMatchingSubseq1(String s, String[] words) {
		    
	        
	        Map<String,Integer> map = new HashMap<>();
	        for(String str:words){
	            map.put(str,map.getOrDefault(str,0)+1);
	        }
	        
	        int ans = 0;
	        char ch[] = s.toCharArray();
	        
	        for(String str:map.keySet()){
	            
	            char temp[] = str.toCharArray();
	            int i = 0;
	            int j = 0;
	            
	            while(i<ch.length && j<temp.length){
	                if(ch[i]==temp[j]){
	                    i++;
	                    j++;
	                }else{
	                    i++;
	                }
	            }
	            
	            if(j==temp.length){
	                ans+=map.get(str);
	            }
	            
	        }
	        
	      return ans;  
	    }
}
