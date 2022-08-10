package com.rahim.eccomerce.resource;

import com.rahim.eccomerce.enumeration.Stock;
import com.rahim.eccomerce.model.Item;
import com.rahim.eccomerce.model.Response;
import com.rahim.eccomerce.service.implementation.ItemServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemResource {

    private final ItemServiceImplementation itemService;

    @GetMapping("/list")
    public ResponseEntity<Response> getItems() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("Items", itemService.list(20)))
                        .message("Items Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getItem(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("Items", itemService.get(id)))
                        .message("Item Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<Response> getItem(@PathVariable("category") String category) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("Items", itemService.getByCategory(category)))
                        .message("Item Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveItem(@RequestBody @Valid Item item) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("Items", itemService.create(item)))
                        .message("Item Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteItem(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("Deleted", itemService.delete(id)))
                        .message("Item Deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update-price/{id}/{price}")
    public ResponseEntity<Response> updateItemPrice(@PathVariable Long id, @PathVariable double price) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("Updated Price", itemService.updatePrice(id, price)))
                        .message("Item Price Updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update-stock/{id}/{stock}")
    public ResponseEntity<Response> updateItemStock(@PathVariable Long id, @PathVariable Stock stock) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("Updated Stock", itemService.updateStock(id, stock)))
                        .message("Item Stock Updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
