package com.example.kaardirakendus.card;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CardConfig {

    @Bean
    CommandLineRunner commandLineRunner(CardRepository cardRepository) {
        return args -> {
            Card testkaart1 = new Card(
                    "Mari Maasikas",
                    "1111222233334444",
                    400
            );
            Card testkaart2 = new Card(
                    "Juku Juhan",
                    "5555666677778888",
                    999
            );

            cardRepository.saveAll(List.of(testkaart1, testkaart2));
        };
    }
}
