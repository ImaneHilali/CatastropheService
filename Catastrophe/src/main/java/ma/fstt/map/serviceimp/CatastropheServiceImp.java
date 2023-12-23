package ma.fstt.map.serviceimp;

import ma.fstt.map.model.Catastrophe;
import ma.fstt.map.repo.CatastropheRepo;
import ma.fstt.map.service.CatastropheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatastropheServiceImp implements CatastropheService {

    @Autowired
    private CatastropheRepo catastropheRepo;

    public Catastrophe saveDisaster(Catastrophe catastrophe) {
         return catastropheRepo.save(catastrophe);
    }

    public List<Catastrophe> getAllDisasters() {
        return catastropheRepo.findAll();
    }

    public Optional<Catastrophe> getDisasterById(Long id) {
        return catastropheRepo.findById(id);
    }

    public Catastrophe updateDisaster(Long id, Catastrophe updatedDisaster) {
        return catastropheRepo.findById(id)
                .map(existingDisaster -> {
                    existingDisaster.setName(updatedDisaster.getName());
                    existingDisaster.setLocation(updatedDisaster.getLocation());
                    return catastropheRepo.save(existingDisaster);
                })
                .orElse(null); 
    }

    public void deleteDisaster(Long id) {
        catastropheRepo.deleteById(id);
    }
 
}

