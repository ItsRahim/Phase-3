package com.rahim.eccomerce.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Stock {
    NO_STOCK("NO_STOCK"),
    AVAILABLE_STOCK("AVAILABLE_STOCK");

    @Getter
    private final String stock;
}
