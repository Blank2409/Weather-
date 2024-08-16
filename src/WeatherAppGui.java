import javax.swing.*;
import org.json.simple.JSONObject;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class WeatherAppGui extends JFrame {
    private JSONObject weatherData;
    private BackgroundPanel backgroundPanel;

    public WeatherAppGui() {
        super("Weather app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Initialize BackgroundPanel
        backgroundPanel = new BackgroundPanel("D:\\project\\Weather\\go\\src\\assets\\bgg_resized.jpg");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        addGuiComponents();
    }

    private void addGuiComponents() {
        JTextField searchText = new JTextField();
        searchText.setBounds(15, 15, 351, 45);
        searchText.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(searchText);
        
        JLabel weatherConditionImage = new JLabel(loadImage("D:\\project\\Weather\\go\\src\\assets\\cloudy.png"));
        weatherConditionImage.setBounds(0, 125, 450, 217);
        add(weatherConditionImage);
        
        JLabel temperatureText = new JLabel("10°C");
        temperatureText.setFont(new Font("Dialog", Font.BOLD, 48));
        temperatureText.setBounds(0, 350, 450, 54);
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(0, 405, 450, 36);
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

        JLabel humidityImage = new JLabel(loadImage("D:\\project\\Weather\\go\\src\\assets\\humidity.png"));
        humidityImage.setBounds(15, 500, 74, 66);
        add(humidityImage);

        JLabel humidityText = new JLabel("<html><b>Humidity</b><br>100%</html>");
        humidityText.setBounds(90, 500, 85, 55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);

        JLabel windspeedImage = new JLabel(loadImage("D:\\project\\Weather\\go\\src\\assets\\windspeed.png"));
        windspeedImage.setBounds(220, 500, 74, 66);
        add(windspeedImage);

        JLabel windspeedText = new JLabel("<html><b>Windspeed</b><br>15 km/h</html>");
        windspeedText.setBounds(310, 500, 85, 55);
        windspeedText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(windspeedText);

        JButton searchButton = new JButton(loadImage("D:\\project\\Weather\\go\\src\\assets\\search.png"));
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 13, 47, 45);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = searchText.getText().trim();
                if (userInput.isEmpty()) {
                    return;
                }

                weatherData = Weatherapp.getWeatherData(userInput);
                if (weatherData == null) {
                    JOptionPane.showMessageDialog(null, "Weather data not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String weatherCondition = (String) weatherData.get("weather_condition");
                if (weatherCondition != null) {
                    switch (weatherCondition) {
                        case "Clear":
                            weatherConditionImage.setIcon(loadImage("D:\\project\\Weather\\go\\src\\assets\\clear.png"));
                            backgroundPanel.setBackgroundImage("D:\\project\\Weather\\go\\src\\assets\\bgg_resized.jpg");
                            break;
                        case "Cloudy":
                            weatherConditionImage.setIcon(loadImage("D:\\project\\Weather\\go\\src\\assets\\cloudy.png"));
                            backgroundPanel.setBackgroundImage("D:\\project\\Weather\\go\\src\\assets\\cloudy_resized.jpg");
                            break;
                        case "Rain":
                            weatherConditionImage.setIcon(loadImage("D:\\project\\Weather\\go\\src\\assets\\rain.png"));
                            backgroundPanel.setBackgroundImage("D:\\project\\Weather\\go\\src\\assets\\rainy_resized.jpg");
                            break;
                        case "Snow":
                            weatherConditionImage.setIcon(loadImage("D:\\project\\Weather\\go\\src\\assets\\snow.png"));
                            backgroundPanel.setBackgroundImage("D:\\project\\Weather\\go\\src\\assets\\snow_resized.jpg");
                            break;
                    }
                    weatherConditionDesc.setText(weatherCondition);
                    backgroundPanel.repaint(); // Repaint to reflect the background change
                }

                Double temperature = getDoubleValue(weatherData.get("temperature"));
                if (temperature != null) {
                    temperatureText.setText(temperature + "°C");
                }

                Long humidity = getLongValue(weatherData.get("humidity"));
                if (humidity != null) {
                    humidityText.setText("<html><b>Humidity</b><br>" + humidity + "%</html>");
                }

                Double windspeed = getDoubleValue(weatherData.get("windspeed"));
                if (windspeed != null) {
                    windspeedText.setText("<html><b>Windspeed</b><br>" + windspeed + " km/h</html>");
                }
            }
        });

        add(searchButton);
    }

    // Custom JPanel class to draw the background image
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String filePath) {
            setBackgroundImage(filePath);
        }

        public void setBackgroundImage(String filePath) {
            try {
                backgroundImage = ImageIO.read(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, this);
            }
        }
    }

    private ImageIcon loadImage(String resourcePath) {
        File imgFile = new File(resourcePath);
        if (!imgFile.exists()) {
            System.out.println("File does not exist: " + resourcePath);
            return null;
        }
        
        try {
            BufferedImage image = ImageIO.read(imgFile);
            return new ImageIcon(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Double getDoubleValue(Object value) {
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        return null;
    }

    private Long getLongValue(Object value) {
        if (value instanceof Number) {
            return ((Number) value).longValue();
        }
        return null;
    }
}
