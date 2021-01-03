package com.guitars.axe.guitars.service;

import com.guitars.axe.guitars.entity.Guitar;

import java.util.List;

public interface GuitarService {

    public Guitar addGuitar(Guitar phone);

    public List<Guitar> getAllGuitars();

    public Guitar getGuitar(String guitarId);
}
