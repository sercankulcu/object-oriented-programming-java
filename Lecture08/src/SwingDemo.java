
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingDemo {

    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("Swing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        // Create a new JPanel (container)
        JPanel panel = new JPanel();
        
        // Create a JLabel to display text
        JLabel label = new JLabel("Welcome to Swing!");
        
        // Create a JButton
        JButton button = new JButton("Click Me!");
        button.addActionListener(e -> {
            // Action to be performed when button is clicked
            label.setText("Button Clicked!");
        });
        
        // Add the components to the panel
        panel.add(label);
        panel.add(button);
        
        // Add the panel to the frame
        frame.add(panel);
        
        // Set the frame visibility to true
        frame.setVisible(true);
    }
}
