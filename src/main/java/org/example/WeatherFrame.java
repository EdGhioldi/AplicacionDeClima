package org.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase que representa la ventana de la aplicación
public class WeatherFrame {

    private JFrame frame;

    public WeatherFrame() {
        frame = new JFrame("Weather App");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
    }

    public void showFrame() {
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel cityLabel = new JLabel("Ingrese la ciudad:");
        cityLabel.setBounds(10, 20, 80, 25);
        panel.add(cityLabel);

        JTextField cityText = new JTextField(20);
        cityText.setBounds(100, 20, 165, 25);
        panel.add(cityText);

        JButton getWeatherButton = new JButton("Obtener Clima");
        getWeatherButton.setBounds(10, 50, 150, 25);
        panel.add(getWeatherButton);

        JLabel weatherLabel = new JLabel();
        weatherLabel.setBounds(10, 80, 300, 25);
        panel.add(weatherLabel);

        getWeatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cityName = cityText.getText();
                String weatherInfo = WeatherService.getWeatherInfo(cityName);
                weatherLabel.setText(weatherInfo);
            }
        });
    }
}
