import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Location {
	private double x, y;
	private String formatted, unformatted, latitude, longitude, city, zip;

	public Location() throws IOException {
		//latitude = "";
		
		unformatted = null;

		String link = "https://www.freegeoip.net/json/" + ipAddress();
		HttpURLConnection connection = null;
		BufferedReader reader = null;
		try {
			URL url = new URL(link);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			unformatted = buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
		// String formatted = new String();

		Latitude();
		Longitude();
		formatted = latitude + ", " + longitude;

		makeFile(formatted);
		city = zipCity();
		zip = zipCode();
		System.out.println(formatted);
		System.out.println(city + ", " + zip);
	}

	public static void makeFile(String s) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("C:\\Users\\tesht\\Desktop\\Location.txt"));
			writer.write(s);

		} catch (IOException e) {
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}

	}

	public String zipCity() throws IOException {
		String apiReturn = "";

		String link = "http://nominatim.openstreetmap.org/reverse?format=json&lat=" + Latitude() + "&lon=" + Longitude();
		HttpURLConnection connection = null;
		BufferedReader reader = null;
		try {
			URL url = new URL(link);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			apiReturn = buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
		int pos = apiReturn.indexOf("city") + 7;
		apiReturn = apiReturn.substring(pos);
		pos = apiReturn.indexOf("\"");
		apiReturn = apiReturn.substring(0, pos);
		city = apiReturn;

		return city;
	}
	public String zipCode() throws IOException {
		String apiReturn = "";

		String link = "http://nominatim.openstreetmap.org/reverse?format=json&lat=" + Latitude() + "&lon=" + Longitude();
		HttpURLConnection connection = null;
		BufferedReader reader = null;
		try {
			URL url = new URL(link);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			apiReturn = buffer.toString();
			makeFile(apiReturn);
		} finally {
			if (reader != null)
				reader.close();
		}
		int pos = apiReturn.indexOf("postcode") + 11;
		apiReturn = apiReturn.substring(pos);
		pos = apiReturn.indexOf("\"");
		apiReturn = apiReturn.substring(0, pos);
		zip = apiReturn;		
		return zip;
	}

	public double Latitude() {
		latitude = unformatted;
		int pos = latitude.indexOf("latitude") + 10;
		latitude = latitude.substring(pos);
		pos = latitude.indexOf(",");
		latitude = latitude.substring(0, pos);
		x = Double.parseDouble(latitude);
		return x;
	}

	public double Longitude() {
		longitude = unformatted;
		int pos = longitude.indexOf("longitude") + 11;
		longitude = longitude.substring(pos);
		pos = longitude.indexOf(",");
		longitude = longitude.substring(0, pos);
		y = Double.parseDouble(longitude);
		return y;
	}

	public static String ipAddress() throws IOException {
		URL whatismyip = new URL("http://checkip.amazonaws.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));

		String ip = in.readLine(); // you get the IP as a String
		// System.out.println(ip);
		return ip;
	}

}
