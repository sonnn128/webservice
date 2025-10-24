package com.example.demo.controller;

import com.example.demo.exception.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @GetMapping
    public String index() {
        throw new CommonException("Common exception message", HttpStatus.NOT_FOUND);
//        return "Hello World";
    }

//    @GetMapping
//    public ResponseEntity<?> getAllUsers(PageRequestDtoIn pageRequestDtoIn) {
//        return ResponseEntity.ok(
//                ApiResponse.builder()
//                        .success(true)
//                        .message("Get all users successfully")
//                        .data(new PagedModel<>(userService.getAllBySearchString(pageRequestDtoIn)))
//                        .build()
//        );
//    }
//
}
