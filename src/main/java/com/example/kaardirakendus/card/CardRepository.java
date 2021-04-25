package com.example.kaardirakendus.card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("SELECT c from Card c WHERE c.cardNumber =?1")
    Optional<Card> findCardByCardNumber(String cardNumber);
}
