package vanhack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

class Result {

	/*
	 * Complete the 'getExpenditure' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER userId 2. INTEGER locationId 3. INTEGER netStart 4.
	 * INTEGER netEnd
	 *
	 * https://jsonmock.hackerrank.com/api/transactions/search?userId=
	 */

	private String page;
	private Integer per_page;
	private Integer total;
	private Integer total_pages;
	private List<Transaction> data;
	private final static String URL_WITH_USER_ID = "https://jsonmock.hackerrank.com/api/transactions/search?userId=";

	public static int getExpenditure(int userId, int locationId, int netStart, int netEnd) {
		URL url = null;
		URLConnection connection = null;
		BufferedReader reader = null;
		String inputLine = "";
		StringBuilder sb = new StringBuilder();
		List<Transaction> transactions = new ArrayList<Transaction>();
		BigDecimal sum = new BigDecimal(BigInteger.ZERO);

		sb = getDataInitial(url, connection, reader, userId, inputLine, sb);

		try {
			Gson gson = createGson();

			Result result = gson.fromJson(sb.toString(), Result.class);

			if (result.getData() == null && result.getData().isEmpty()) {
				return 0;
			} else {
				getTransactionsFromGson(result, transactions);

				Integer pageActual = Integer.parseInt(result.getPage());
				Integer total_pages = result.getTotal_pages();

				if (pageActual < total_pages) {
					getDataPaginate(
							url, connection, reader, 
							inputLine, sb, result, 
							userId, transactions, gson,
							pageActual, total_pages);
				}

				sum = getSumtAllTransactionsOnRange(locationId, netStart, netEnd, transactions, sum);
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

		return sum.setScale(0, RoundingMode.HALF_EVEN).intValue();
	}

	private static Gson createGson() {
		Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
			@Override
			public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
					throws JsonParseException {
				return json == null ? null : new Date(json.getAsLong());
			}
		}).create();
		
		return gson;
	}

	private static BigDecimal getSumtAllTransactionsOnRange(
			int locationId, 
			int netStart, 
			int netEnd,
			List<Transaction> transactions, 
			BigDecimal sum) {

		for (Transaction transaction : transactions) {
			if (transaction.getLocation().getId() == locationId) {
				sum = getSumTransactionOnRange(netStart, netEnd, sum, transaction);
			}
		}

		return sum;
	}

	private static BigDecimal getSumTransactionOnRange(
			int netStart, 
			int netEnd, 
			BigDecimal sum, 
			Transaction transaction) {
		Integer firstByteIp = new Integer(transaction.getIp().substring(0, transaction.getIp().indexOf(".")));

		if (firstByteIp >= netStart && firstByteIp <= netEnd) {
			System.out.println("Amount value in string:" + transaction.getAmount());
			BigDecimal valueBd = new BigDecimal(transaction.getAmount().replace("$", "").replace(",", ""));
			System.out.println("Value BigDecimal: " + valueBd);
			sum = sum.add(valueBd);
			System.out.println("Value sum: " + sum);
			System.out.println("==================");
		}

		return sum;
	}

	private static void getDataPaginate(
			URL url, 
			URLConnection connection, 
			BufferedReader reader, 
			String inputLine,
			StringBuilder sb, 
			Result result, 
			int userId, 
			List<Transaction> transactions, 
			Gson gson, 
			Integer pageActual, 
			Integer total_pages) throws IOException {
		
		for (int page = pageActual + 1; page <= total_pages; page++) {
			sb = new StringBuilder();
			try {
				url = new URL(URL_WITH_USER_ID + userId + "&page=" + page);
				connection = url.openConnection();
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				while ((inputLine = reader.readLine()) != null) {
					sb.append(inputLine);
				}

				result = gson.fromJson(sb.toString(), Result.class);

				getTransactionsFromGson(result, transactions);

				reader.close();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void getTransactionsFromGson(Result result, List<Transaction> transactions) {
		for (Transaction transaction : result.getData()) {
			transactions.add(transaction);
		}
	}

	private static StringBuilder getDataInitial(
			URL url, 
			URLConnection connection, 
			BufferedReader reader,
			int userId, 
			String inputLine, 
			StringBuilder sb) {
		
		try {
			url = new URL(URL_WITH_USER_ID + userId);
			connection = url.openConnection();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			while ((inputLine = reader.readLine()) != null) {
				sb.append(inputLine);
			}

			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb;
	}

	public Result() { }

	public Result(String page, Integer per_page, Integer total, Integer total_pages, List<Transaction> data) {
		this.page = page;
		this.per_page = per_page;
		this.total = total;
		this.total_pages = total_pages;
		this.data = data;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Integer getPer_page() {
		return per_page;
	}

	public void setPer_page(Integer per_page) {
		this.per_page = per_page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}

	public List<Transaction> getData() {
		return data;
	}

	public void setData(List<Transaction> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages=" + total_pages
				+ ", data=" + data + "]";
	}

}

class Transaction {

	private Integer id;
	private Integer userId;
	private String userName;
	private String txnType;
	private Date timestamp;
	private String amount;
	private Location location;
	private String ip;

	public Transaction() { }

	public Transaction(Integer id, Integer userId, String userName, String txnType, Date timestamp, String amount,
			Location location, String ip) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.txnType = txnType;
		this.timestamp = timestamp;
		this.amount = amount;
		this.location = location;
		this.ip = ip;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {

		this.timestamp = timestamp;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", userId=" + userId + ", userName=" + userName + ", txnType=" + txnType
				+ ", timestamp=" + timestamp + ", amount=" + amount + ", location=" + location + ", ip=" + ip
				+ ", getId()=" + getId() + ", getUserId()=" + getUserId() + ", getUserName()=" + getUserName()
				+ ", getTxnType()=" + getTxnType() + ", getTimestamp()=" + getTimestamp() + ", getAmount()="
				+ getAmount() + ", getLocation()=" + getLocation() + ", getIp()=" + getIp() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}

class Location {

	private Integer id;
	private String address;
	private String city;
	private Integer zipCode;

	public Location() {	}

	public Location(Integer id, String address, String city, Integer zipCode) {
		this.id = id;
		this.address = address;
		this.city = city;
		this.zipCode = zipCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", address=" + address + ", city=" + city + ", zipCode=" + zipCode + "]";
	}

}

public class TransactionsByLocationAndIP {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int userId = Integer.parseInt(bufferedReader.readLine().trim());
		int locationId = Integer.parseInt(bufferedReader.readLine().trim());
		int netStart = Integer.parseInt(bufferedReader.readLine().trim());
		int netEnd = Integer.parseInt(bufferedReader.readLine().trim());

		int result = Result.getExpenditure(userId, locationId, netStart, netEnd);
		System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//        bufferedReader.close();
//        bufferedWriter.close();
	}

}
