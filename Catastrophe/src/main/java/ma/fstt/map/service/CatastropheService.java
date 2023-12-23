package ma.fstt.map.service;

import ma.fstt.map.model.Catastrophe;


import java.util.List;
import java.util.Optional;

public interface CatastropheService {

    public Catastrophe saveDisaster(Catastrophe catastrophe);

    public List<Catastrophe> getAllDisasters();

    public Optional<Catastrophe> getDisasterById(Long id);

    public Catastrophe updateDisaster(Long id, Catastrophe updatedDisaster);

    public void deleteDisaster(Long id);

    }
