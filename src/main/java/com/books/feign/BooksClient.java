package com.books.feign;

import com.books.model.AuthenticationRequest;
import com.books.model.AuthenticationToken;
import com.books.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "BOOKS-SERVICE")
public interface BooksClient {

    @PostMapping("/auth/token")
    ResponseEntity<AuthenticationToken> getAuthToken(@RequestBody AuthenticationRequest authenticationRequest);

    @GetMapping("/books")
    ResponseEntity<List<Book>> getBooks(@RequestHeader HttpHeaders headers);
}
