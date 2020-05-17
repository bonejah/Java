package vanhack.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PredictAnswer {

	/*
	 * Complete the 'predictAnswer' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY stockData 2. INTEGER_ARRAY queries
	 */

	public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {

		List<Stock> stocks = new ArrayList<Stock>();
		List<Integer> lsMenoresDias = new ArrayList<Integer>();

		for (int i = 0; i < stockData.size(); i++) {
			stocks.add(new Stock(i, i + 1, stockData.get(i)));
		}

		for (Stock stock : stocks) {
			System.out.println(stock);
		}

		System.out.println("======================================");

		for (int i = 0; i < queries.size(); i++) {
			Integer querie = queries.get(i);

			Stock stockAtual = getStockByQuerieDay(stocks, querie);
			Stock stockAnterior = getStockByQuerieDay(stocks, querie - 1);
			Stock stockPosterior = getStockByQuerieDay(stocks, querie + 1);

			int diaComMenorValor = getDiaComMenorValor(stocks, stockAtual);

			if (diaComMenorValor == -1) {
				lsMenoresDias.add(getDiaComMenorValor(stocks, stockAtual));
				continue;
			} else if (stockAtual.getIndex() == 0) {
				lsMenoresDias.add(getDiaComMenorValor(stocks, stockAtual));
				continue;
			} else if (checkDiaAnteriorEPosteriorSaoMenoresQueDiaAtual(stockAtual, stockAnterior, stockPosterior)) {
				lsMenoresDias.add(stockAnterior.getDay());
				continue;
			} else if (checkDiaAnteriorEPosteriorSaoMaioresQueDiaAtual(stockAtual, stockAnterior, stockPosterior)) {
				for (Stock stockMenoValor : stocks) {
					if (stockMenoValor.getValue() < stockAtual.getValue()) {
						diaComMenorValor = stockMenoValor.getDay();
						break;
					}
				}
				lsMenoresDias.add(diaComMenorValor);
				continue;
			}
		}

		return lsMenoresDias;
	}

	private static boolean checkDiaAnteriorEPosteriorSaoMaioresQueDiaAtual(Stock stockAtual, Stock stockAnterior,
			Stock stockPosterior) {
		return (stockAnterior.getValue() > stockAtual.getValue())
				&& (stockPosterior.getValue() > stockAtual.getValue());
	}

	private static boolean checkDiaAnteriorEPosteriorSaoMenoresQueDiaAtual(Stock stockAtual, Stock stockAnterior,
			Stock stockPosterior) {
		return (stockAnterior.getValue() < stockAtual.getValue())
				|| (stockPosterior.getValue() < stockAtual.getValue());
	}

	private static int getDiaComMenorValor(List<Stock> stocks, Stock stockAtual) {
		int diaComMenorValor = -1;

		for (Stock stockMenoValor : stocks) {
			if (stockMenoValor.getValue() < stockAtual.getValue()) {
				diaComMenorValor = stockMenoValor.getDay();
				break;
			}
		}

		return diaComMenorValor;
	}

	private static Stock getStockByQuerieDay(List<Stock> stocks, Integer querie) {
		for (Stock stock : stocks) {
			if (stock.getDay() == querie) {
				return stock;
			}
		}

		return null;
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

public class StockMarketPrediction2 {
	public static void main(String[] args) throws IOException {

//		List<Integer> result = PredictAnswer.predictAnswer(Arrays.asList(5, 6, 8, 4, 9, 10, 8, 3, 6, 4),
//				Arrays.asList(3, 1, 8));
//		System.out.println(result);

		List<Integer> result = PredictAnswer.predictAnswer(Arrays.asList(5, 6, 8, 4, 9, 10, 8, 3, 6, 4),
				Arrays.asList(6, 5, 4));
		System.out.println(result);

	}
}
