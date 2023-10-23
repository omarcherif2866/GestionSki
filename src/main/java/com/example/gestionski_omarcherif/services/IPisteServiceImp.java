package com.example.gestionski_omarcherif.services;

import com.example.gestionski_omarcherif.entities.Piste;
import com.example.gestionski_omarcherif.repositories.PisteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class IPisteServiceImp  implements IPisteService {
    private PisteRepository pisteRepository;
    @Override
    public Piste getPiste(Long pisteId) {
        return pisteRepository
                .findById(pisteId)
                .orElseThrow(() -> new IllegalArgumentException("piste not found"));
    }
}
