import javax.swing.*;


public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WeatherGui().setVisible(true));
    }
}
