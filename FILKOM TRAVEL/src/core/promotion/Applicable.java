package core.promotion;

import core.customer.Customer;

public interface Applicable {
    boolean isCustomerEligible(Customer customer);
}