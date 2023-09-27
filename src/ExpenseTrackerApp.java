import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {

    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");

    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks

    // controller
    view.getAddTransactionBtn().addActionListener(e -> {

      // Get transaction data from view
      try {
        double amount_test = view.getAmountField();
        Double.parseDouble(Double.toString(amount_test));
      } catch (Exception error) {
        JOptionPane.showMessageDialog(null, "Enter a valid number");
      }

      double amount = view.getAmountField();
      String category = view.getCategoryField();

      // validate amount and category

      InputValidation inputValidator = new InputValidation();

      String amountError = inputValidator.validateAmount(amount);
      String categoryError = inputValidator.validateCategory(category);

      if (!amountError.equals("") && !categoryError.equals("")) {
        JOptionPane.showMessageDialog(null, amountError.concat("\n").concat(categoryError));
      }

      else if (!amountError.equals("")) {
        JOptionPane.showMessageDialog(null, amountError);
      }

      else if (!categoryError.equals("")) {
        JOptionPane.showMessageDialog(null, categoryError);
        view.revalidate();
      }

      else if (amountError.equals("") && categoryError.equals("")) {
        // Create transaction object
        Transaction t = new Transaction(amount, category);
        // Call controller to add transaction
        view.addTransaction(t);
      }

    });
  }
}