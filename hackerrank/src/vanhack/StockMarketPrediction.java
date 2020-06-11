package vanhack;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class PredictAnswer {

	/*
	 * Complete the 'predictAnswer' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY stockData 2. INTEGER_ARRAY queries
	 */

	public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
		List<Integer> predictions = new ArrayList<>();

        /* to show -1 if there is no such stock price */
        for (int i = 0; i < queries.size(); i++) {
            predictions.add(-1);
        }

        for (int i = 0; i < queries.size(); i++) {
            /* the query index starts from 1 or supposes the first index is 1 */
            int index = (int) (queries.get(i) - 1);
            int value = stockData.get(index).intValue();
            
            for (int j = index + 1, k = index -1;  j < stockData.size() -1 || k > 1; j++, k--) {
            	if (k < 1) {
                    if (stockData.get(j).intValue() < value) {
                        predictions.set(i, j + 1);
                        break;
                    }
                } 

                else if (j > stockData.size() - 1) {
                    if (stockData.get(k).intValue() < value) {
                        predictions.set(i, k + 1);
                        break;
                    }
                } 

                else if (stockData.get(k).intValue() < value) {
                    predictions.set(i, k + 1);
                    break;
                } 

                else if (stockData.get(j).intValue() < value) {
                    predictions.set(i, j + 1);
                    break;
                }
			}

//            int j = index + 1;
//            int k = index - 1;
//
//            while (j < stockData.size() - 1 || k > 1) {
//
//                if (k < 1) {
//                    if (stockData.get(j).intValue() < value) {
//                        predictions.set(i, j + 1);
//                        break;
//                    }
//                } 
//
//                else if (j > stockData.size() - 1) {
//                    if (stockData.get(k).intValue() < value) {
//                        predictions.set(i, k + 1);
//                        break;
//                    }
//                } 
//
//                else if (stockData.get(k).intValue() < value) {
//                    predictions.set(i, k + 1);
//                    break;
//                } 
//
//                else if (stockData.get(j).intValue() < value) {
//                    predictions.set(i, j + 1);
//                    break;
//                }
//
//                j++;
//                k--;
//            }
        
        }

        return predictions;

		
	}
}

class Stock {

	private int index;
	private int day;
	private int value;

	public Stock(int index, int day, int value) {
		this.index = index;
		this.day = day;
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public int getDay() {
		return day;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Stock [index=" + index + ", day=" + day + ", value=" + value + "]";
	}

}

public class StockMarketPrediction {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int stockDataCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> stockData = IntStream.range(0, stockDataCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		List<Integer> result = PredictAnswer.predictAnswer(stockData, queries);

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
