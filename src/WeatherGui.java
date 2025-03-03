import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherGui extends JFrame {
    private JSONObject weatherData;
    private JLabel weatherConditionImage, temperatureText, weatherConditionDesc, humidityText, windspeedText;
    private JTextField searchTextField;

    public WeatherGui() {
        super("Weather App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 650);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        addGuiComponents();
        setVisible(true);
    }

    private void addGuiComponents() {
        searchTextField = new JTextField();
        searchTextField.setBounds(15, 15, 351, 45);
        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(searchTextField);

        weatherConditionImage = new JLabel(loadImage("src/asset/cloudy.png"));
        weatherConditionImage.setBounds(0, 125, 450, 217);
        add(weatherConditionImage);

        temperatureText = new JLabel("10°C");
        temperatureText.setBounds(0, 350, 450, 54);
        temperatureText.setFont(new Font("Dialog", Font.BOLD, 48));
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(0, 405, 450, 36);
        weatherConditionDesc.setFont(new Font("Dialog", Font.PLAIN, 32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

        JLabel humidityImage = new JLabel(loadImage("src/asset/humidity.png"));
        humidityImage.setBounds(15, 500, 74, 66);
        add(humidityImage);

        humidityText = new JLabel("<html><b>Humidity:</b> 100%</html>");
        humidityText.setBounds(90, 500, 120, 55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);

        JLabel windspeedImage = new JLabel(loadImage("src/asset/windspeed.png"));
        windspeedImage.setBounds(220, 500, 74, 66);
        add(windspeedImage);

        windspeedText = new JLabel("<html><b>Wind Speed:</b> 15 km/h</html>");
        windspeedText.setBounds(310, 500, 120, 55);
        windspeedText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(windspeedText);

        JButton searchButton = new JButton(loadImage("src/asset/search.png"));
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 13, 47, 45);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = searchTextField.getText().trim();
                if (userInput.isEmpty()) return;

                weatherData = WeatherApp.getWeatherData(userInput);

                if (weatherData == null) {
                    JOptionPane.showMessageDialog(null, "Failed to fetch weather data!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                updateWeatherUI(weatherData);
            }
        });
        add(searchButton);
    }

    private void updateWeatherUI(JSONObject weatherData) {
        SwingUtilities.invokeLater(() -> {
            String weatherCondition = (String) weatherData.getOrDefault("weather_condition", "Unknown");

            switch (weatherCondition) {
                case "Clear":
                    weatherConditionImage.setIcon(loadImage("src/asset/clear.png"));
                    break;
                case "Cloudy":
                    weatherConditionImage.setIcon(loadImage("src/asset/cloudy.png"));
                    break;
                case "Rain":
                    weatherConditionImage.setIcon(loadImage("src/asset/rain.png"));
                    break;
                case "Snow":
                    weatherConditionImage.setIcon(loadImage("src/asset/snow.png"));
                    break;
                default:
                    weatherConditionImage.setIcon(loadImage("src/asset/cloudy.png"));
                    break;
            }

            double temperature = (double) weatherData.getOrDefault("temperature", 0.0);
            temperatureText.setText(temperature + "°C");

            weatherConditionDesc.setText(weatherCondition);

            long humidity = (long) weatherData.getOrDefault("humidity", 0L);
            humidityText.setText("<html><b>Humidity:</b> " + humidity + "%</html>");

            double windspeed = (double) weatherData.getOrDefault("windspeed", 0.0);
            windspeedText.setText("<html><b>Wind Speed:</b> " + windspeed + " km/h</html>");
        });
    }

    private ImageIcon loadImage(String resourcePath) {
        try {
            File file = new File(resourcePath);
            if (!file.exists()) {
                System.out.println("Resource not found: " + resourcePath);
                return null;
            }
            BufferedImage image = ImageIO.read(file);
            return new ImageIcon(image);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not load image: " + resourcePath);
            return null;
        }
    }
}
