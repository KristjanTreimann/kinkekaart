package com.example.kaardirakendus.card;

import javax.persistence.*;

@Entity
@Table
public class Card {
    @Id
    @SequenceGenerator(
            name = "card_sequence",
            sequenceName = "card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "card_sequence"
    )
    private Long id;
    private String name;
    private String cardNumber;
    private Integer balance;

    public Card() {
    }

    public Card(Long id, String name, String cardNumber, Integer balance) {
        this.id = id;
        this.name = name;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public Card(String name, String cardNumber, Integer balance) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
