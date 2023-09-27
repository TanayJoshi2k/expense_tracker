
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class should be instantiated every time to create a transaction object
 * with amount, category and timestamp properties
 */
public class Transaction {

  private double amount;
  private String category;
  private String timestamp;

  /**
   * Creates a new instance of the `Transaction` class.
   * @param amount the transaction amount
   * @param category category of the transaction
   */
  public Transaction(double amount, String category) {
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  /**
   * this method returns the amount property of a transaction
   * @return amount entered by the user
   */
  public double getAmount() {
    return amount;
  }

  /**
   * this method sets the amount property of a transaction
   * @param amount store it in the amount property of a transaction object
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /**
   * this method returns the category property of a transaction
   * @return category entered by the user
   */
  public String getCategory() {
    return category;
  }

  /**
  * this method sets the category property of a transaction
   * @param category store it in the category property of a transaction object
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * this method returns the timestamp of a transaction
   * @return timestamp of the transaction at the time of saving
   */
  public String getTimestamp() {
    return timestamp;
  }

  /**
   * this method formats date object into string
   * @return datetime formatted into string
   */
  private String generateTimestamp() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    return sdf.format(new Date());
  }

}