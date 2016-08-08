import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
public class Weather {
	private static String formatted;
	public static void Run() throws IOException {
		String key = "1607df63abe833234512ddc3e168d99e";
		String website = "https://api.forecast.io/forecast/";
		Location gps = new Location();
		double latitude = gps.Latitude();
		double longitude = gps.Longitude();
		String result = null;
		String link = "https://api.forecast.io/forecast/1607df63abe833234512ddc3e168d99e/40.739675,-73.994042";
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

			result = buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
		//String formatted = new String();
		for (int i = 0; i < result.length(); i++) {
			formatted += result.subSequence(i, i + 1);
			if (result.substring(i, i + 1).equals("(")) {

				formatted += "\t";
			}
			if (result.substring(i, i + 1).equals("}")) {

				formatted += "\n";
			}
			
			
		}
		int location = formatted.indexOf("summary") + 10;
		formatted = formatted.substring(location);
		location = formatted.indexOf("\"");
		formatted = formatted.substring(0, location);
		makeFile(formatted);
		
		
		System.out.println(formatted);

	}

	public static void makeFile(String s) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("C:\\Users\\tesht\\Desktop\\Data.txt"));
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
	public static String getFormatted() {
		// TODO Auto-generated method stub
		return formatted;
	}
}
