package bankwith;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Dashboard extends JFrame {
    private int userId;
    private String username;
    private JLabel lblWelcome;
    private JButton btnAddBalance, btnTransfer, btnPayBills, btnTransactions, btnLogout;

    public Dashboard(int userId, String username) {
        this.userId = userId;
        this.username = username;

        setTitle("Banking System - Dashboard");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        lblWelcome = new JLabel("Welcome, " + username, JLabel.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblWelcome, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));

        btnAddBalance = new JButton("Add Balance");
        btnTransfer = new JButton("Transfer Money");
        btnPayBills = new JButton("Pay Bills");
        btnTransactions = new JButton("View Transactions");
        btnLogout = new JButton("Logout");

        panel.add(btnAddBalance);
        panel.add(btnTransfer);
        panel.add(btnPayBills);
        panel.add(btnTransactions);
        panel.add(btnLogout);

        add(panel, BorderLayout.CENTER);

        // Button actions
        btnAddBalance.addActionListener(e -> JOptionPane.showMessageDialog(this, "Add Balance clicked"));
        btnTransfer.addActionListener(e -> JOptionPane.showMessageDialog(this, "Transfer Money clicked"));
        btnPayBills.addActionListener(e -> JOptionPane.showMessageDialog(this, "Pay Bills clicked"));
        btnTransactions.addActionListener(e -> showTransactions());
        btnLogout.addActionListener(e -> {
            dispose();
            new Login();
        });

        setVisible(true);
    }

    private void showTransactions() {
        List<Transaction> list = Transaction.getTransactions(userId);
        StringBuilder sb = new StringBuilder();
        for (Transaction t : list) {
            sb.append(t.getType()).append(" - ")
              .append(t.getCategory()).append(" - $")
              .append(t.getAmount()).append("\n");
        }
        if (sb.length() == 0) sb.append("No transactions yet.");
        JOptionPane.showMessageDialog(this, sb.toString(), "Transactions", JOptionPane.INFORMATION_MESSAGE);
    }
}
