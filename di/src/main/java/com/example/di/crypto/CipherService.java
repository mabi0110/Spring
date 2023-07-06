package com.example.di.crypto;

public interface CipherService {

    String encode(String text);
    String decode(String text);
}
