package com.example.credit.demo.service;

import com.example.credit.demo.model.entity.OnetimeToken;
import com.example.credit.demo.repository.OnetimeTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class OnetimeService {

    private final OnetimeTokenRepository repository;


    public Long create() {

        Random r = new Random();

        int random = 1000 + r.nextInt(9000);
        var token = new OnetimeToken();
        token.setCode(random);
        repository.save(token);
        return token.getId();
    }

    public ResponseEntity auth(OnetimeToken sentToken) {

        Optional<OnetimeToken> byId = repository.findById(sentToken.getId());

        if (!byId.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if (byId.get().getCode().equals(sentToken.getCode())){
            return ResponseEntity.status((HttpStatus.ACCEPTED)).build();
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
