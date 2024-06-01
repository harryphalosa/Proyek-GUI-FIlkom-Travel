package core.promotion;

import java.time.LocalDate;

public class Discount extends Promotion {
    public Discount(String promoCode, LocalDate startDate, LocalDate endDate, int percentOff, int maxDiscount,
            int minPurchase) {
        super(promoCode, startDate, endDate, percentOff, maxDiscount, minPurchase);
    }
}