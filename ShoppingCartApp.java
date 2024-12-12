package com.mycompany.freshfoods;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

// Cart Item Class
class CartItem {
    int productId;
    String productName;
    int quantity;
    double price;

    public CartItem(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}

public class ShoppingCartApp extends JFrame {
    private JTable productTable;
    private JButton addToCartButton, viewInvoiceButton, backButton;
    private DefaultTableModel tableModel;
    private ArrayList<CartItem> cart = new ArrayList<>();
    private static int currentUserId;
    
    public ShoppingCartApp(int customer_id) {
        
        ShoppingCartApp.currentUserId=customer_id;
        
        // Frame setup
        setTitle("Product Inventory");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(247, 249, 247)); // Background color
        setLayout(new BorderLayout());

        
            JPanel headerPanel = new JPanel();
            headerPanel.setBackground(new Color(46, 40, 42)); // Header background color
            JLabel titleLabel = new JLabel("Fresh Foods");
            titleLabel.setForeground(new Color(118,176,65)); // Text color
            titleLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 48)); // Font
            headerPanel.add(titleLabel);
            add(headerPanel, BorderLayout.NORTH);

      
            tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Quantity", "Price", "Category", "Quality"}, 0);
            productTable = new JTable(tableModel);
            productTable.setBackground(new Color(118,176,65)); // Set table background color
            productTable.setForeground(Color.BLACK); // Set text color for better visibility
            productTable.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Optional: Set font for table
            productTable.setRowHeight(25); // Optional: Set row height for better appearance

            JScrollPane scrollPane = new JScrollPane(productTable);
            scrollPane.getViewport().setBackground(new Color(247, 249, 247)); // Set background of the scroll pane
            add(scrollPane, BorderLayout.CENTER);

            
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(new Color(247, 249, 247)); // Set background color of the button panel

            addToCartButton = new JButton("Add to Cart");
            viewInvoiceButton = new JButton("View Invoice");
            backButton = new JButton("Back");

            addToCartButton.setBackground(new Color(118,176,65)); // Set button background
            addToCartButton.setForeground(Color.BLACK); // Set button text color

            viewInvoiceButton.setBackground(new Color(118,176,65)); // Set button background
            viewInvoiceButton.setForeground(Color.BLACK); // Set button text color

            backButton.setBackground(new Color(118,176,65)); // Set button background
            backButton.setForeground(Color.BLACK);
            
            buttonPanel.add(addToCartButton);
            buttonPanel.add(backButton);
            buttonPanel.add(viewInvoiceButton);
            add(buttonPanel, BorderLayout.SOUTH);


        loadProducts();

         backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Userlogin().setVisible(true);
                setVisible(false);
            }
        });
        // Add Event Listeners
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToCart();
            }
        });

        viewInvoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInvoice();
            }
        });
    }

    private void loadProducts() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Products";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            tableModel.setRowCount(0); // Clear table before loading
            while (resultSet.next()) {
                tableModel.addRow(new Object[]{
                        resultSet.getInt("product_id"),
                        resultSet.getString("product_name"),
                        resultSet.getInt("product_quantity"),
                        resultSet.getDouble("product_price"),
                        resultSet.getString("product_category"),
                        resultSet.getString("product_quality")
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading products: " + ex.getMessage());
        }
    }

    private void addToCart() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product to add to the cart.");
            return;
        }

        int productId = (int) tableModel.getValueAt(selectedRow, 0);
        String productName = (String) tableModel.getValueAt(selectedRow, 1);
        int availableQuantity = (int) tableModel.getValueAt(selectedRow, 2);
        double price = (double) tableModel.getValueAt(selectedRow, 3);

        if (availableQuantity <= 0) {
            JOptionPane.showMessageDialog(this, "Product is out of stock.");
            return;
        }

      
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Products SET product_quantity = product_quantity - 1 WHERE product_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, productId);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
              
                cart.add(new CartItem(productId, productName, 1, price));
                JOptionPane.showMessageDialog(this, "Product added to cart!");
                loadProducts();
            } else {
                JOptionPane.showMessageDialog(this, "Error adding product to cart.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void displayInvoice() {
    if (cart.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Your cart is empty.");
        return;
    }

  
    double total = 0;
    StringBuilder invoice = new StringBuilder("Invoice:\n\n");
    invoice.append(String.format("%-10s %-20s %-10s %-10s\n", "ID", "Name", "Qty", "Price"));
    invoice.append("----------------------------------------------------\n");

    for (CartItem item : cart) {
        invoice.append(String.format("%-10d %-20s %-10d %-10.2f\n",
                item.productId, item.productName, item.quantity, item.price));
        total += item.price * item.quantity;
    }

    // Apply discount (e.g., 10% discount for orders above $100)
    double discount = (total > 100) ? total * 0.1 : 0;
    double finalTotal = total - discount;

    invoice.append("----------------------------------------------------\n");
    invoice.append(String.format("Total: $%.2f\n", total));
    invoice.append(String.format("Discount: $%.2f\n", discount));
    invoice.append(String.format("Final Total: $%.2f\n", finalTotal));

    // Display invoice
    JOptionPane.showMessageDialog(this, invoice.toString());

    // Insert orders into Orders table
    try (Connection connection = DatabaseConnection.getConnection()) {
        String insertQuery = "INSERT INTO Orders (order_name, order_number, order_price, customer_id) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertQuery);

        for (CartItem item : cart) {
            statement.setString(1, item.productName);
            statement.setString(2, generateOrderNumber()); // Generate a unique order number
            statement.setDouble(3, item.price);
            
            statement.setInt(4, currentUserId); 
            statement.executeUpdate();
        }

        JOptionPane.showMessageDialog(this, "Order placed successfully!");

        // Clear cart after placing order
        cart.clear();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error placing order: " + ex.getMessage());
    }
}

// Helper method to generate unique order numbers
private String generateOrderNumber() {
    return "ORD-" + System.currentTimeMillis(); // Generates a unique number based on the current time
}

  public static void main(String[] args) {
    // Example customer ID for testing. Replace with actual logic as needed.
    int customerId = 1; // Replace with dynamic input if required.

    // Run the application on the Event Dispatch Thread (EDT) to ensure thread safety for Swing components
    SwingUtilities.invokeLater(() -> {
        ShoppingCartApp app = new ShoppingCartApp(customerId);
        app.setVisible(true);
    });
}
}