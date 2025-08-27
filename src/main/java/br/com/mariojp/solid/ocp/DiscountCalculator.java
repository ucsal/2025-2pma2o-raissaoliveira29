package br.com.mariojp.solid.ocp;

import java.util.Map;

public class DiscountCalculator {

    private final Map<CustomerType, DiscountPolicy> policies;

    public DiscountCalculator() {
        this.policies = Map.of(
            CustomerType.REGULAR, new RegularPolicy(),
            CustomerType.PREMIUM, new PremiumPolicy(),
            CustomerType.PARTNER, new PartnerPolicy()
        );
    }
    public DiscountCalculator(Map<CustomerType, DiscountPolicy> policies) {
        this.policies = policies;
    }
    public double apply(double amount, CustomerType type) {
        return policies.getOrDefault(type, a -> a).apply(amount);
    }
}
