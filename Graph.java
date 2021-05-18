import java.lang.String;
import java.util.*;

public class Graph {
	
	public Map<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();;

	public void addEdge(String actor1, String actor2) {
		//checks if actors present in map, if not add
		
		if (map.get(actor1) == null) //actor 1 not in map, add
		{
			map.put(actor1, new LinkedList<String>());
		}
		if (map.get(actor2) == null) 
		{
			map.put(actor2, new LinkedList<String>());
		}
		map.get(actor1).add(actor2);
		map.get(actor2).add(actor1);
	}

	//checked this section with cstutor center
	
	public String findPath(String actor1, String actor2) {
		//program crashes without "" for some reason..
		return findPath(actor1, actor2, "");
	}

	private String findPath(String actor1, String actor2, String path) {
		//recursive search to find shortest path
		LinkedList<String> temp = map.get(actor1); 

		if (temp.contains(actor2)) 
		{
			return actor1 + " --> " + actor2;
		}

		for (String actor: temp) {
			if (map.get(actor).contains(actor2)) 
			{
				return actor1 + " --> " +findPath(actor, actor2, path);
			}
		}

		for (String actor: temp) 
		{
			if (!path.contains(actor)) 
			{
				return actor1 + " --> " + findPath(actor, actor2, path);
			}
		}
		return "No connection found"; //no path present
	}
}