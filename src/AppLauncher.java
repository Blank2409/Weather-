
import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               
                // System.out.println(Weatherapp.getLocationData("Tokyo"));

                new WeatherAppGui().setVisible(true);
            }
        });
    }
}
            
    //javac -cp "lib/json-simple-1.1.1.jar" -d bin src/AppLauncher.java src/Weatherapp.java src/WeatherAppGui.java
    //java -cp "bin;lib/json-simple-1.1.1.jar" AppLauncher
    



