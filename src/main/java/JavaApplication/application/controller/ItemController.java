package JavaApplication.application.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import JavaApplication.application.model.Item;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/items")
@Validated
public class ItemController {

    private List<Item> itemList = new ArrayList<>();
    private Long idCounter = 1L;

    // Add new item
    @PostMapping
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item) {
        item.setId(idCounter++);
        itemList.add(item);
        return ResponseEntity.ok(item);
    }

    // Get item by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable Long id) {

        Optional<Item> foundItem = itemList.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();

        if (foundItem.isPresent()) {
            return ResponseEntity.ok(foundItem.get());
        } else {
            return ResponseEntity
                    .status(404)
                    .body("Item not found with id: " + id);
        }
    }
}
