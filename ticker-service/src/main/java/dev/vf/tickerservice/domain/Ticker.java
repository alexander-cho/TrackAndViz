package dev.vf.tickerservice.domain;

import jakarta.validation.constraints.NotBlank;

public record Ticker(
        @NotBlank(message = "The symbol must be defined.")
        String symbol,

        @NotBlank(message = "The company name must be defined.")
        String companyName
) {
}
