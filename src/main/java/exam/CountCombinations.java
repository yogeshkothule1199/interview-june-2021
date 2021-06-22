
import java.util.*;

class GFG{

static List<String> arr = new ArrayList<String>();


static List<List<Integer>> graph = new ArrayList<List<Integer>>();


static List<String> path = new ArrayList<String>();


static boolean print_euler(int i, int []visited,
						int count)
{
	
	
	visited[i] = 1;
	count++;

		if (count == graph.size())
	{
		path.add(arr.get(i));
		return true;
	}

	
	boolean b = false;

		for(int j = 0; j < graph.get(i).size(); j++)
		if (visited[graph.get(i).get(j)] == 0)
		{
			b |= print_euler(graph.get(i).get(j),
							visited, count);
		}

	if (b)
	{
		path.add(arr.get(i));
		return true;
	}

	
	else
	{
		visited[i] = 0;
		count--;
		return false;
	}
}

static void connect()
{
	int n = arr.size();
	graph = new ArrayList<List<Integer>>(n);

	for(int i = 0; i < n; i++)
	{
		graph.add(new ArrayList<Integer>());
	}
	
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < n; j++)
		{
			if (i == j)
				continue;

			if (arr.get(i).charAt((arr.get(i).length()) - 1) ==
				arr.get(j).charAt(0))
			{
				graph.get(i).add(j);
			}
		}
	}

	for(int i = 0; i < n; i++)
	{
		int []visited = new int[n];
		int count = 0;

		if (print_euler(i, visited, count))
			break;
	}

	for(int i = path.size() - 1; i >= 0; i--)
	{
		System.out.print(path.get(i));
		
		if (i != 0)
			System.out.print(" ");
	}
}

public static void main(String []args)
{
	arr.add("451");
	arr.add("378");
	arr.add("123");
	arr.add("1254");

	connect();
}
}


