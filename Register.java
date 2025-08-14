package bankwith;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.sql.*;

	public class Register extends JFrame {
	    private JTextField txtUsername, txtEmail, txtPhone;
	    private JPasswordField txtPassword;
	    private JButton btnRegister, btnBack;

	    public Register() {
	        setTitle("Banking System - Register");
	        setSize(400, 350);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setLayout(new BorderLayout());

	        JLabel header = new JLabel("Create a New Account", JLabel.CENTER);
	        header.setFont(new Font("Arial", Font.BOLD, 18));
	        add(header, BorderLayout.NORTH);

	        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
	        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

	        panel.add(new JLabel("Username:"));
	        txtUsername = new JTextField();
	        panel.add(txtUsername);

	        panel.add(new JLabel("Password:"));
	        txtPassword = new JPasswordField();
	        panel.add(txtPassword);

	        panel.add(new JLabel("Email:"));
	        txtEmail = new JTextField();
	        panel.add(txtEmail);

	        panel.add(new JLabel("Phone:"));
	        txtPhone = new JTextField();
	        panel.add(txtPhone);

	        btnRegister = new JButton("Register");
	        btnBack = new JButton("Back");
	        panel.add(btnRegister);
	        panel.add(btnBack);

	        add(panel, BorderLayout.CENTER);

	        btnRegister.addActionListener(e -> registerUser());
	        btnBack.addActionListener(e -> {
	            dispose();
	            new Login();
	        });

	        setVisible(true);
	    }

	    private void registerUser() {
	        String username = txtUsername.getText();
	        String password = String.valueOf(txtPassword.getPassword());
	        String email = txtEmail.getText();
	        String phone = txtPhone.getText();

	        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Please fill all fields.");
	            return;
	        }

	        try (Connection conn = DBConnection.getConnection()) {
	            String sql = "INSERT INTO users(username, password, email, phone) VALUES (?, ?, ?, ?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, username);
	            ps.setString(2, password);
	            ps.setString(3, email);
	            ps.setString(4, phone);
	            ps.executeUpdate();
	            JOptionPane.showMessageDialog(this, "Registration successful!");
	            dispose();
	            new Login();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Username may already exist.");
	        }
	    }
	}



