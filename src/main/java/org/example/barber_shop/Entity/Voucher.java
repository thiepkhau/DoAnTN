package org.example.barber_shop.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vouchers")
@ToString
public class Voucher extends DistributedEntity{
    private String code;
    private int maxUses;
    private int discount;
    private int maxDiscount;
    private LocalDate startDate;
    private LocalDate endDate;
    private long minPrice;
    private int uses;
    private boolean disabled;
    private boolean deleted = false;

    public boolean isValid() {
        LocalDate today = LocalDate.now();
        return !disabled && (startDate == null || !today.isBefore(startDate))
                && (endDate == null || !today.isAfter(endDate));
    }

    public boolean canUse() {
        return (maxUses == 0 || uses < maxUses);
    }
    public long calculateDiscount(long price) {
        long applicableDiscount = (price * discount) / 100;
        return Math.min(applicableDiscount, maxDiscount);
    }
}
