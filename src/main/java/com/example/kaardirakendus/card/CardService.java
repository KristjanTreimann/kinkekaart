package com.example.kaardirakendus.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Objects;
import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    public void addNewCard(Card card) {
        Optional<Card> cardOptional = cardRepository.findCardByCardNumber(card.getCardNumber());
        if(cardOptional.isPresent()) {
            throw new IllegalStateException("Cannot add card");
        }

        cardRepository.save(card);
    }

    public void deleteCard(Long cardId) {
        boolean exists = cardRepository.existsById(cardId);
        if (!exists) {
            throw new IllegalStateException("Card with id " + cardId + " does not exist in database");
        }
        cardRepository.deleteById(cardId);
    }

    @Transactional
    public void updateCard(Long cardId, String name, String cardNumber, Integer balance) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new IllegalStateException("Card with id " + cardId + "does not exist in database"));

        if (name != null && name.length() > 0 && !Objects.equals(card.getName(), name)) {
            card.setName(name);
        }

        if (cardNumber != null && cardNumber.length() > 0 && !Objects.equals(cardNumber, card.getCardNumber())) {
            Optional<Card> cardOptional = cardRepository.findCardByCardNumber(cardNumber);
            if (cardOptional.isPresent()) {
                throw new IllegalStateException("Card number taken");
            }
            card.setCardNumber(cardNumber);
        }

        if (balance != null && balance < 1000) {
            Optional<Card> cardOptional = cardRepository.findCardByCardNumber(cardNumber);
            if (cardOptional.isEmpty()) {
                throw new MissingFormatArgumentException("Card not found");
            }
            card.setBalance(balance);
        }


    }

    public Optional<Card> getCard(String cardNumber) {
        return cardRepository.findCardByCardNumber(cardNumber);
    }
}
