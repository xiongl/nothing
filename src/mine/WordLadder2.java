package mine;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 12/27/13
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class WordLadder2 {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        list.add(start);
        Stack<List<String>> last = new Stack<List<String>>();
        Stack<List<String>> current = new Stack<List<String>>();
        Set<String> visited = new HashSet<String>();
        Set<String> thisVisited = new HashSet<String>();
        last.push(list);
        visited.add(start);
        boolean found = false;
        while(!last.empty() || !current.empty()) {
            if (last.empty()) {
                last = current;
                current = new Stack<List<String>>();
                visited.addAll(thisVisited);
                thisVisited = new HashSet<String>();
            }
            while (!last.empty()) {
                List<String> li = last.pop();
                String str = li.get(li.size()-1);
                if (str.equals(end)) {
                    result.add(li);
                    found = true;
                    continue;
                }
                char[] array = str.toCharArray();
                for (int i=0; i<array.length; i++) {
                    char curr = array[i];
                    for (char c='a'; c<='z'; c++) {
                        if (curr==c)
                            continue;
                        array[i] = c;
                        String newStr = new String(array);
                        if (dict.contains(newStr) && !visited.contains(newStr)) {
                            List<String> newList = new ArrayList<String>();
                            newList.addAll(li);
                            newList.add(newStr);
                            current.push(newList);
                            thisVisited.add(newStr);
                        }
                    }
                    array[i] = curr;
                }
            }
            if (found)
                return result;
        }
        return result;
    }
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<String>();
        String[] array = new String[]{"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
        for (String str : array) {
            dict.add(str);
        }
 //       int len = new WordLadder().ladderLength("nape", "mild", dict);
        new WordLadder2().findLadders("nape", "mild", dict);
    }
}
