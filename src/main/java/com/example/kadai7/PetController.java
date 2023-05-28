package com.example.kadai7;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

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

    @PatchMapping("/pet/{id}")
    public ResponseEntity<Map<String, String>> updatePet(@RequestBody @Valid PetUpdateForm petUpdateForm, @PathVariable(name = "id") int id) {
        // 更新処理は省略
        return ResponseEntity.ok(Map.of("message", "pet successfully updated"));
    }

    @DeleteMapping("/pet/{id}")
    public ResponseEntity<Map<String, String>> deletePet(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(Map.of("message", "pet successfully deleted"));
    }
}
