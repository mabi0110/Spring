package com.example.validation;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientDtoMapper clientDtoMapper;


    public ClientService(ClientRepository clientRepository, ClientDtoMapper clientDtoMapper) {
        this.clientRepository = clientRepository;
        this.clientDtoMapper = clientDtoMapper;
    }

    public void register(ClientDto clientDto){
        Client client = clientDtoMapper.map(clientDto);
        String uniqueUserName = generateUserName(client);
        client.setUserName(uniqueUserName);
        clientRepository.save(client);

    }

    private String generateUserName(Client client) {
        String firstNameLetters = client.getFirstName().substring(0, 2).toUpperCase();
        String lastNameLetters = client.getLastName().substring(0, 2).toUpperCase();
        String userNameBeginning = firstNameLetters + lastNameLetters;
        String userName;
        do {
            userName = userNameBeginning + randomCode(3);
        } while (clientRepository.existsByUserName(userName));
        return userName;
    }

    private String randomCode(int length) {
        List<String> digitsAsString = Arrays.asList("0123456789".split(""));
        Collections.shuffle(digitsAsString);
        return digitsAsString
                .subList(0, length)
                .stream().
                reduce(String::concat)
                .get();
    }
}
