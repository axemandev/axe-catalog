package com.guitars.axe.guitars.controller;

import com.guitars.axe.guitars.entity.Guitar;
import com.guitars.axe.guitars.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("guitars")
public class GuitarController {

    @Autowired
    GuitarService guitarService;

    @PostMapping("/")
    public ResponseEntity<Guitar> addGuitar(@RequestBody Guitar guitar) {
        return  new ResponseEntity<>(guitarService.addGuitar(guitar), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Guitar>> getAllGuitars() {
        return new ResponseEntity<>(guitarService.getAllGuitars(), HttpStatus.OK);
    }

    @GetMapping("/{guitarId}")
    public ResponseEntity<Object> getPhone(@PathVariable("guitarId") String guitarId) {
        try {
            List<Guitar> guitars = guitarService.getAllGuitars();
            return new ResponseEntity<>(guitarService.getGuitar(guitarId), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
