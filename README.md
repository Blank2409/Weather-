
# Weather App

A simple Java Swing-based Weather App that displays real-time weather information based on user input. The app fetches weather data using the [OpenWeather API](https://openweathermap.org/api) and displays it with a user-friendly graphical interface.

## Features

- **Real-Time Weather Data:** Get the current weather information for any city.
- **Dynamic Backgrounds:** The background image changes based on the weather conditions (e.g., sunny, cloudy, rainy, snowy).
- **Weather Details:** Displays temperature, humidity, wind speed, and weather conditions.
- **Interactive UI:** Search for any city using the search bar and get instant weather updates.

## Technologies Used

- **Java Swing:** For creating the graphical user interface.
- **JSON-Simple:** For parsing the JSON data received from the OpenWeather API.
- **OpenWeather API:** For fetching the real-time weather data.
- **Java AWT:** For handling graphical operations and event-driven programming.

  

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/WeatherApp.git

2.**Compile the Java files:**
   ```bash
   javac -cp json-simple-1.1.1.jar WeatherAppGui.java
```
3.**Run the Application:**
  ```bash
  java -cp .json-simple-1.1.1.jar WeatherAppGui
```

## Usage
1.Enter the name of the city you want to check the weather for in the search bar.                                                                   
2.Press the search button or hit enter.                                                                                                                          
3.The app will fetch and display the current weather, temperature, humidity, and wind speed for the entered city.                                                               
4.The background image will change according to the weather condition (e.g., cloudy, rainy, snowy).                                                

## API Key Configuration
To use the OpenWeather API, you need an API key. Follow these steps to configure the API key:          
 
1.Go to OpenWeather API and sign up to get your API key.                      
2.Replace the YOUR_API_KEY placeholder in your Java code where the API key is used with your actual API key:                   
```bash
String apiKey = "YOUR_API_KEY";
```

## Customization
-**Background Images:** You can customize the background images for different weather conditions by replacing the images in the assets folder with your own.                
-**Fonts and Colors:** Modify the fonts and colors used in the UI to match your design preferences.                                                                 


## Screenshots
Here are some screenshots of the application in action:           
![bengaluru cloudy](https://github.com/user-attachments/assets/40745822-f882-465f-99e1-dea081ea1ed8)              
![clear delhi](https://github.com/user-attachments/assets/aaa11112-15fc-4d88-9241-e823da280ff5)             


## Acknowledgments
-Thanks to OpenWeather for providing the weather data API.                              
-Inspiration from various open-source weather apps.                                  


