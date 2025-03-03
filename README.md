# Weather App using Java Swing and API

This is a simple Weather Application built using **Java Swing** for the GUI and **Open-Meteo API** to fetch real-time weather data.

## Features
- 🌍 Search weather by city name
- 🌡️ Displays temperature in Celsius
- ☁️ Shows weather conditions
- 💨 Displays wind speed
- 💧 Displays humidity
- 🖼️ Weather icons for different conditions

## Technologies Used
- **Java Swing** (GUI development)
- **Open-Meteo API** (Weather data)
- **JSON.simple** (JSON parsing)
- **GitHub** (Version control)

## Installation & Setup
### 1️⃣ Clone the repository
```sh
 git clone https://github.com/AzadAb/Weather_App.git
```

### 2️⃣ Open the project in IntelliJ IDEA
- Go to **File → Open** and select the project folder.
- Ensure **Java SDK** is installed and configured.

### 3️⃣ Install Dependencies
This project requires the **JSON.simple** library. Add it to your project:
- Download `json-simple-1.1.1.jar` from [here](https://code.google.com/archive/p/json-simple/)
- Add it to your project’s dependencies in IntelliJ IDEA.

### 4️⃣ Run the Application
- Navigate to `AppLauncher.java`
- Click **Run** or execute the following command in the terminal:
```sh
javac AppLauncher.java
java AppLauncher
```

## API Used
This application uses [Open-Meteo API](https://open-meteo.com/) for weather data.
- **Geocoding API**: Fetches latitude and longitude of a location.
- **Weather API**: Retrieves weather conditions based on coordinates.

## Project Structure
```
Weather_App/
│── src/
│   ├── WeatherGUI.java   # GUI design using Swing
│   ├── WeatherApp.java   # API request handling
│   ├── AppLauncher.java  # Main application launcher
│── assets/               # Icons & images
│── README.md             # Project documentation
```

## Future Enhancements 🚀
- ✅ Add support for more weather parameters (sunrise/sunset, UV index, etc.)
- ✅ Improve UI with better animations and themes
- ✅ Cache previous search results for faster access

## Contributing
Feel free to fork the repository and submit pull requests with improvements!


## License
This project is **open-source** and available under the [MIT License](LICENSE).

