package bankwith;


	import javax.swing.*;
	import java.awt.*;

	public class Main {
	    	    public static void main(String[] args) {
	    	        SwingUtilities.invokeLater(() -> {
	    	            new Login();
	    	        });
	        SwingUtilities.invokeLater(() -> {
	            JFrame frame = new JFrame("Banking System");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setSize(400, 300);
	            frame.setLocationRelativeTo(null);

	            // Simple placeholder panel
	            JPanel panel = new JPanel();
	            panel.add(new JLabel("Welcome to Banking System"));
	            frame.add(panel);

	            frame.setVisible(true);
	        });
	    }
	}


