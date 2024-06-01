package core.promotion;

import core.Order;
import core.customer.Customer;

public interface Applicable {
    boolean isCustomerEligible(Customer customer);
}