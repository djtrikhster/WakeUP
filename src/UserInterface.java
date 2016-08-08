import java.io.IOException;
import java.net.InetAddress;

public class UserInterface {
	private static String s;

	public static void main(String[] args) throws IOException, InterruptedException {
		Weather.Run();
		s = Weather.getFormatted();
		GenreSuggestion n1 = new GenreSuggestion();
		System.out.println(Location.ipAddress());
		Location l1 = new Location();
	}

}