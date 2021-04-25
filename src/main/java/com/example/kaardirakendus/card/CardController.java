package com.example.kaardirakendus.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/card")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> getCards(){
        return cardService.getCards();
    }

    @GetMapping(path = "{cardNumber}")
    public Optional<Card> getCard(@PathVariable("cardNumber") String cardNumber){
        return cardService.getCard(cardNumber);
    }

    @PostMapping
    public void addCard(@RequestBody Card card) {
        cardService.addNewCard(card);
    }

    @DeleteMapping(path = "{cardId}")
    public void deleteCard(@PathVariable("cardId") Long cardId) {
        cardService.deleteCard(cardId);
    }

    @PutMapping(path = "{cardId}")
    public void updateCard(
            @PathVariable("cardId") Long cardId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String cardNumber,
            @RequestParam(required = false) Integer balance) {
        cardService.updateCard(cardId, name, cardNumber, balance);
    }
}
