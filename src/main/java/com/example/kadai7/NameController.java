package com.example.kadai7;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class NameController {
    @GetMapping("/names")
    public List<String> getNames() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello i :" + i);
        }
        return List.of("koyama", "tanaka", "suzuki");
    }

    @PostMapping("/names")
    public ResponseEntity<String> createName(@RequestBody NameCreateForm nameCreateForm) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id") // id部分は実際に登録された際に発⾏したidを設定する
                .build()
                .toUri();
        return ResponseEntity.created(url).body("POST通信成功");
    }

    @PostMapping("/pet")
    public ResponseEntity<String> createPet(@RequestBody PetCreateForm petCreateForm) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/pet/id") // id部分は実際に登録された際に発⾏したidを設定する
                .build()
                .toUri();
        System.out.println("petName :" + petCreateForm.getPetName());
        System.out.println("petType :" + petCreateForm.getPetType());
        return ResponseEntity.created(url).body("POST通信成功");
    }

}

