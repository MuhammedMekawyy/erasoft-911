package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@PrimaryKeyJoinColumn(name = "id") // FK to person.id (JOINED strategy)
public class Customer extends Person {

    @Column(name = "loyalty_points")
    private Integer loyaltyPoints;

    public Customer() {
    }

    public Customer(String name, Integer loyaltyPoints) {
        super(name);
        this.loyaltyPoints = loyaltyPoints;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer{id=" + getId() + ", name='" + getName() + "', loyaltyPoints=" + loyaltyPoints + "}";
    }
}