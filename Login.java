package bankwith;
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.sql.*;

	public class Login extends JFrame {
	    private JTextField txtUsername;
	    private JPasswordField txtPassword;
	    private JButton btnLogin, btnRegister;

	    public Login() {
	        setTitle("Banking System - Login");
	        setSize(400, 300);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setLayout(new BorderLayout());

	        // Header
	        JLabel header = new JLabel("Welcome to Banking System", JLabel.CENTER);
	        header.setFont(new Font("Arial", Font.BOLD, 18));
	        add(header, BorderLayout.NORTH);

	        // Form Panel
	        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
	        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
	        panel.add(new JLabel("Username:"));
	        txtUsername = new JTextField();
	        panel.add(txtUsername);

	        panel.add(new JLabel("Password:"));
	        txtPassword = new JPasswordField();
	        panel.add(txtPassword);

	        btnLogin = new JButton("Login");
	        btnRegister = new JButton("Register");
	        panel.add(btnLogin);
	        panel.add(btnRegister);

	        add(panel, BorderLayout.CENTER);

	        // Button actions
	        btnLogin.addActionListener(e -> loginUser());
	        btnRegister.addActionListener(e -> {
	            dispose();
	            new Register();
	        });

	        setVisible(true);
	    }

	    private void loginUser() {
	        String username = txtUsername.getText();
	        String password = String.valueOf(txtPassword.getPassword());

	        if (username.isEmpty() || password.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Please enter username and password.");
	            return;
	        }

	        try (Connection conn = DBConnection.getConnection()) {
	            String sql = "SELECT * FROM users WHERE username=? AND password=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, username);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                JOptionPane.showMessageDialog(this, "Login successful!");
	                dispose();
	                new Dashboard(rs.getInt("id"), username);
	            } else {
	                JOptionPane.showMessageDialog(this, "Invalid username or password.");
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Database error.");
	        }
	    }
	}



