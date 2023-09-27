import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidation {

    /**
     * @author Tanay Joshi
     * @param amount is entered by the user in the amount input field
     * @return empty string if no exception
     * @throws IllegalArgumentException when amount is 0 or negative or greater than
     *                                  1000
     */
    public String validateAmount(double amount) {

        try {
            if (amount <= 0 || amount > 1000) {
                throw new IllegalArgumentException("Amount out of range");
            }
            return "";

        } catch (IllegalArgumentException e) {
            String error = e.getMessage();
            return error;
        }

    }

    /**
     * @author Tanay Joshi
     * @param category is entered by the user in the category input field
     * @return empty string if no exception
     * @throws IllegalArgumentException when category is an empty string or not
     *                                  equal to either food, travel, bills,
     *                                  entertainment or other
     */
    public String validateCategory(String category) {
        Set<String> categories = new HashSet<>(Arrays.asList("food", "travel", "bills", "entertainment", "other"));

        try {
            if (category.trim().equals("")) {
                throw new IllegalArgumentException("Category cannot be blank");
            }
            if (!categories.contains(category.toLowerCase())) {
                throw new IllegalArgumentException(
                        "Category must be in either Food, Travel, Bills, Entertainment or Other");
            }
            return "";

        } catch (IllegalArgumentException e) {
            String error = e.getMessage();
            return error;
        }

    }
}