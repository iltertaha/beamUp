package com.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class RandomCodeGenerator {

    @Value("${codeSize}")
    private int codeSize;

    public String generateRandomCode(){
        SecureRandom random = new SecureRandom();

        StringBuilder created = new StringBuilder();

        var codeAlphabet = "abcdefghijklmnprsttuvyzqw123456789"
                .toUpperCase()
                .chars()
                .mapToObj( x -> (char)x)
                .collect(Collectors.toList());

        Collections.shuffle(codeAlphabet);

        for (int i = 0; i < codeSize; i++) {
            created.append(codeAlphabet.get(random.nextInt(codeAlphabet.size())));
        }
        return created.toString();
    }
}
