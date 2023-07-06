package com.example.di.crypto;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class RawCipherService implements CipherService {
    @Override
    public String encode(String text) {
        return text;
    }

    @Override
    public String decode(String text) {
        return text;
    }
}
