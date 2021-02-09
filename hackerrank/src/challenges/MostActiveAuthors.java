package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

/**
 *
 * brunolima on Feb 9, 2021
 * 
 */

public class MostActiveAuthors {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int threshold = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> result = Result.getUsernames(threshold);
		System.out.println(result);

//		bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

		bufferedReader.close();
//		bufferedWriter.close();
	}

}

class Result {

	/*
	 * Complete the 'getUsernames' function below.
	 *
	 * The function is expected to return a STRING_ARRAY. The function accepts
	 * INTEGER threshold as parameter.
	 *
	 * URL for cut and paste
	 * https://jsonmock.hackerrank.com/api/article_users?page=<pageNumber>
	 */

	private String page;
	private Integer per_page;
	private Integer total;
	private Integer total_pages;
	private List<User> data;

	private final static String URL = "https://jsonmock.hackerrank.com/api/article_users?page=";

	public static List<String> getUsernames(int threshold) {
		URL url = null;
		URLConnection connection = null;
		BufferedReader reader = null;
		String inputLine = "";
		StringBuilder sb = new StringBuilder();
		List<String> userNames = new ArrayList<String>();

		try {
			Gson gson = new Gson();

			Result result = gson.fromJson(getDataInitial(url, connection, reader, 1, inputLine, sb).toString(), Result.class);

			if (result.getData() == null && result.getData().isEmpty()) {
				return userNames;
			} else {
				getUsersWithThreshold(getUsersFromGson(result), threshold, userNames);

				Integer pageActual = Integer.parseInt(result.getPage());
				Integer total_pages = result.getTotal_pages();

				if (pageActual < total_pages) {
					getDataPaginate(url, connection, reader, inputLine, sb, result, gson,
							pageActual, total_pages, threshold, userNames);
				}				
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

		return userNames;
	}
	
	private static List<String> getUsersWithThreshold(List<User> users, int threshold, List<String> userNames) {
		for (User user : users) {
			if (user.getSubmission_count() > threshold) {
				userNames.add(user.getUsername());
			}
		}
		
		return userNames;
	}

	private static List<User> getUsersFromGson(Result result) {
		List<User> users = new ArrayList<User>();
		
		for (User user : result.getData()) {
				users.add(user);
		}
		
		return users;
	}

	private static StringBuilder getDataInitial(URL url, URLConnection connection, BufferedReader reader, int page,
			String inputLine, StringBuilder sb) {
		try {
			url = new URL(URL + 1);
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
	
	private static void getDataPaginate(
			URL url, 
			URLConnection connection, 
			BufferedReader reader, 
			String inputLine,
			StringBuilder sb, 
			Result result,
			Gson gson, 
			Integer pageActual, 
			Integer total_pages, int threshold, List<String> userNames) throws IOException {
		
		for (int page = pageActual + 1; page <= total_pages; page++) {
			sb = new StringBuilder();
			
			try {
				url = new URL(URL + page);
				connection = url.openConnection();
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				while ((inputLine = reader.readLine()) != null) {
					sb.append(inputLine);
				}

				result = gson.fromJson(sb.toString(), Result.class);
				
				getUsersWithThreshold(getUsersFromGson(result), threshold, userNames);

				reader.close();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
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

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}

}

class User {

	private Integer id;
	private String username;
	private Integer submission_count;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getSubmission_count() {
		return submission_count;
	}

	public void setSubmission_count(Integer submission_count) {
		this.submission_count = submission_count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
