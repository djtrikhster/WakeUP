
public class GenreSuggestion {
	private String weather;

	public GenreSuggestion() throws InterruptedException {

		System.out.println("The weather where you are is " + Weather.getFormatted() + "");
		Music outside = new Music("-", Weather.getFormatted(), "");
		Thread.sleep(30000);
		for (int i = 0; i < 7; i++) {

			System.out.println("1. Sunny\n2. Cloudy\n3. Partly Cloudy\n4. Thunderstorms\n5. Rain\n6. Drizzle");
			switch (Keyboard.readInt()) {
			case (1): {

				weather = "Sunny";
				Music sunny = new Music("The Girl from Ipanem - Astrud Gilberto", "Sunny", "");

				break;
			}
			case (2): {
				weather = "Cloudy";
				Music cloudy = new Music("Clouds - Imagined Herbal Flows", "Cloudy", "");

				break;
			}
			case (3): {
				weather = "Partly Cloudy";
				Music partlycloudy = new Music("Sunshine Through the Rain Clouds - NERVO", "Partly Cloudy", "");

				break;
			}
			case (4): {
				weather = "Thunderstorm";
				Music thunderstorm = new Music("Lights and the Thunder - Krewella", "Thunderstorm", "");

				break;
			}
			case (5): {
				weather = "Rain";
				Music rain = new Music("Set Fire to the Rain - Zedd Edit", "Rain", "");

				break;
			}
			case (6): {
				weather = "Drizzle";
				Music drizzle = new Music("Set Fire to the Rain - Zedd Edit", "Drizzle", "");

				break;
			}
			}
			Thread.sleep(30000);
		}

	}
}