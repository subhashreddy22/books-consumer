package com.books.service;

import com.books.feign.BooksClient;
import com.books.model.AuthenticationRequest;
import com.books.model.AuthenticationToken;
import com.books.model.Book;
import com.books.util.LoggingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookConsumerService.class);

    @Autowired
    private BooksClient booksClient;

    public List<Book> getBooks() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setUsername("user");
        authenticationRequest.setPassword("user");

        ResponseEntity<AuthenticationToken> authToken = booksClient.getAuthToken(authenticationRequest);

        LOGGER.info("AuthToken Response -> {} code -> {}", LoggingUtil.getString(authToken.getBody()), authToken.getStatusCodeValue());

        String token = authToken.getBody().getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);

        ResponseEntity<List<Book>> books = booksClient.getBooks(headers);

        LOGGER.info("Books Response -> {} code -> {}", LoggingUtil.getString(books.getBody()), books.getStatusCodeValue());

        return books.getBody();
    }
}
