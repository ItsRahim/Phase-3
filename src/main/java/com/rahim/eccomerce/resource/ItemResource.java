package com.rahim.eccomerce.resource;

import com.rahim.eccomerce.model.Item;
import com.rahim.eccomerce.model.Response;
import com.rahim.eccomerce.service.ItemService;
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

    @GetMapping("/list/{id}")
    public ResponseEntity<Response> getItems(@PathVariable("id") Long id) {
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

    @PostMapping("/save")
    public ResponseEntity<Response> saveServer(@RequestBody @Valid Item item) {
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
    public ResponseEntity<Response> deleteServer(@PathVariable("id") Long id) {
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
}
