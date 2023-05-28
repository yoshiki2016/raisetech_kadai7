package com.example.kadai7;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@Validated
public class PetController {
    @PostMapping("/pet")
    public ResponseEntity<String> createPet(@RequestBody @Valid PetCreateForm petCreateForm) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/pet/id") // id部分は実際に登録された際に発⾏したidを設定する
                .build()
                .toUri();
        return ResponseEntity.created(url).body("POST通信成功");
    }
}