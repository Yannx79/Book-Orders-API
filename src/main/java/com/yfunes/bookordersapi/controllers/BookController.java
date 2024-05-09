package com.yfunes.bookordersapi.controllers;

import com.yfunes.bookordersapi.dto.BookDTO;
import com.yfunes.bookordersapi.entities.BookEntity;
import com.yfunes.bookordersapi.services.IBookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final IBookService service;

    @Qualifier("bookModelMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<BookDTO>> readAll() throws Exception {
        List<BookDTO> list = service.readAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<BookDTO>> readByPage(Pageable pageable) {
        /* Page<BookDTO> page = service.findByPage(pageable)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.()); */
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> readById(@PathVariable("id") Integer id) throws Exception {
        BookDTO dto = convertToDTO(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDTO> create(@Valid @RequestBody BookDTO dto) throws Exception {
        BookEntity entity = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(entity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody BookDTO dto) throws Exception {
        dto.setIdBook(id);
        BookEntity entity = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(entity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private BookDTO convertToDTO(BookEntity entity) {
        return modelMapper.map(entity, BookDTO.class);
    }

    private BookEntity convertToEntity(BookDTO dto) {
        return modelMapper.map(dto, BookEntity.class);
    }

}
