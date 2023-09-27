
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseTrackerView extends JFrame {

  private JTable transactionsTable;
  private JButton addTransactionBtn;
  private JTextField amountField;
  private JTextField categoryField;
  private DefaultTableModel model;
  
  // list of transactions
  private List<Transaction> transactions = new ArrayList<>();

  public JTable getTransactionsTable() {
    return transactionsTable;
  }

  public double getAmountField() {
    if (amountField.getText().isEmpty()) {
      return 0;
    } else {
      double amount = Double.parseDouble(amountField.getText());
      return amount;
    }
  }

  public void setAmountField(JTextField amountField) {
    this.amountField = amountField;
  }

  public String getCategoryField() {
    return categoryField.getText();
  }

  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }

  public DefaultTableModel getTableModel() {
    return model;
  }

  public ExpenseTrackerView(DefaultTableModel model) {
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger
    this.model = model;

    addTransactionBtn = new JButton("Add Transaction");

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");

    amountField = new JTextField(10);

    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);
    transactionsTable = new JTable(model);

    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel);
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);

    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    // Set frame properties
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  /**
   * this method accepts transactions list as argument and adds a new
   * transaction to the list and updates the total
   * transactions cost. Finally it updates the transations table to display all
   * transactions
   * 
   * 
   * @param transactions
   */
  public void refreshTable(List<Transaction> transactions) {
    // model.setRowCount(0);
    model.setRowCount(0);
    int rowNum = model.getRowCount();
    double totalCost = 0;
    for (Transaction t : transactions) {
      totalCost += t.getAmount();
    }

    // Add rows from transactions list
    for (Transaction t : transactions) {
      model.addRow(new Object[] { rowNum += 1, t.getAmount(), t.getCategory(), t.getTimestamp() });

    }
    Object[] totalRow = { "Total", null, null, totalCost };
    model.addRow(totalRow);

    // Fire table update
    transactionsTable.updateUI();

  }

  /**
   * this method fetches all transactions and passes them as argument to the
   * refreshTable method to update the transactions list
   */
  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = getTransactions();

    // Pass to view
    refreshTable(transactions);

  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  /**
   * this method adds a new transaction to existing transactions and refreshes the
   * transactions table
   * 
   * @param t is an instance of Transaction class
   */

  public void addTransaction(Transaction t) {
    transactions.add(t);
    getTableModel().addRow(new Object[] { t.getAmount(), t.getCategory(), t.getTimestamp() });
    refresh();
  }

  // Other view methods
}
