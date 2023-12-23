package ma.fstt.map.controller;

import ma.fstt.map.model.Catastrophe;
import ma.fstt.map.service.CatastropheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/catastrophe")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from your Angular app's origin
public class CatastropheController {
    @Autowired
    private CatastropheService catastropheService;

    @PostMapping
    public ResponseEntity<Catastrophe> createDisaster(@RequestBody Catastrophe catastrophe) {
        Catastrophe savedDisaster = catastropheService.saveDisaster(catastrophe);
        return new ResponseEntity<>(savedDisaster, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Catastrophe>> getAllDisasters() {
        List<Catastrophe> disasters = catastropheService.getAllDisasters();
        return new ResponseEntity<>(disasters, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catastrophe> getDisasterById(@PathVariable Long id) {
        Optional<Catastrophe> disaster = catastropheService.getDisasterById(id);
        return disaster.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Catastrophe> updateDisaster(@PathVariable Long id, @RequestBody Catastrophe updatedDisaster) {
        Catastrophe updated = catastropheService.updateDisaster(id, updatedDisaster);
        return updated != null
                ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisaster(@PathVariable Long id) {
        catastropheService.deleteDisaster(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}


