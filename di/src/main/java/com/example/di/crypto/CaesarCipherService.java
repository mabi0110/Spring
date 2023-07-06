package com.example.di.crypto;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class CaesarCipherService implements CipherService {

    private final int SHIFT = 3;
    @Override
    public String encode(String text) {
        StringBuilder encodedText = new StringBuilder();
        char encodedChar;
        for (int i = 0; i < text.length(); i++) {
            encodedChar = (char) (text.charAt(i) + SHIFT);
            encodedText.append(encodedChar);
        }
        return encodedText.toString();
    }

    @Override
    public String decode(String text) {
        StringBuilder decodedText = new StringBuilder();
        char decodedChar;
        for (int i = 0; i < text.length(); i++) {
            decodedChar = (char) (text.charAt(i) - SHIFT);
            decodedText.append(decodedChar);
        }
        return decodedText.toString();
    }
}
