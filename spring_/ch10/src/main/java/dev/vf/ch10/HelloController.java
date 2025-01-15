package dev.vf.ch10;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @GetMapping("/unitedstates")
    public ResponseEntity<Country> unitedStates() {
        Country c = Country.of("USA", 340);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "NA")
                .header("capital", "Washington")
                .header("favoritefood", "burgers")
                .body(c);
    }

    @GetMapping("/all")
    public List<Country> getAll() {
        Country c1 = Country.of("USA", 340);
        Country c2 = Country.of("Canada", 40);

        return List.of(c1, c2);
    }
}
