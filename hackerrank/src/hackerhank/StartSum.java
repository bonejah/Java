package hackerhank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StartSum {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("test.txt")));

		String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int gNodes = Integer.parseInt(gNodesEdges[0]);
		int gEdges = Integer.parseInt(gNodesEdges[1]);

		List<Integer> gFrom = new ArrayList<>();
		List<Integer> gTo = new ArrayList<>();

		IntStream.range(0, gEdges).forEach(i -> {
			try {
				String[] gFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
				gFrom.add(Integer.parseInt(gFromTo[0]));
				gTo.add(Integer.parseInt(gFromTo[1]));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int valuesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> values = IntStream.range(0, valuesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int k = Integer.parseInt(bufferedReader.readLine().trim());

		int result = bestSumKStar(gNodes, gFrom, gTo, values, k);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

	/*
	 * Complete the 'bestSumKStar' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. UNWEIGHTED_INTEGER_GRAPH g 2. INTEGER_ARRAY values 3. INTEGER
	 * k
	 */

	/*
	 * For the unweighted graph, <name>:
	 *
	 * 1. The number of nodes is <name>Nodes. 2. The number of edges is <name>Edges.
	 * 3. An edge exists between <name>From[i] and <name>To[i].
	 *
	 */

	public static int bestSumKStar(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> values, int k) {
		if (gNodes >= 2 && gNodes >= Math.pow(10, 5)) {
			return 0;
		}

		return 0;
	}
}
