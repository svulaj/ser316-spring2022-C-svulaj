package main.java;

import java.util.UUID;

/**
 * This a class for Customer in the Bear Workshop.
 */
public class Customer {
    int age;

    // customer has a name and a customer id
    private Customer parent;
    //Never read, removing from class
//    String customer_id;

    // Customer lives in a state
    public String state;

    public Customer getParent() {
        return parent;
    }

    public void setParent(Customer parent) {
        this.parent = parent;
    }

    /**
     * Default ctor with state
     */
    public Customer(String state) {
        this.state = state;
        this.age = 18;
    }

    /**
     * Parameterized ctor for Customers
     * 
     * @param age      int age of customer
     * @param custumer reference to guardian or null
     */
    public Customer(int age, String state, Customer custumer) {
        this.setParent(custumer);
        this.age = age;
//        this.customer_id = UUID.randomUUID().toString();

        this.state = state;
    }

    public int getCustomerAge() {
        return age;

    }

    public void setAge(int ageOfCusto) {
        age = ageOfCusto;
    }

}