package com.geekylikes.app.controllers;

import com.geekylikes.app.models.avatar.Avatar;
import com.geekylikes.app.models.developer.Developer;
import com.geekylikes.app.repositories.AvatarRepository;
import com.geekylikes.app.repositories.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/developers")
public class DeveloperController {
    @Autowired
    private DeveloperRepository repository;

    @Autowired
    private AvatarRepository avatarRepository;

    @GetMapping
    public @ResponseBody List<Developer> getDevelopers() {
        return repository.findAll();
    }

    @GetMapping("/cohort/{cohort}")
    public ResponseEntity<List<Developer>> getDeveloperByCohort (@PathVariable Integer cohort) {
        return new ResponseEntity<>(repository.findAllByCohort(cohort, Sort.by("name")), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public @ResponseBody Developer getOneDeveloper(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer newDeveloper) {
        return new ResponseEntity<>(repository.save(newDeveloper), HttpStatus.CREATED);
    }

    @PostMapping("/photo")
    public ResponseEntity<Developer> addPhoto (@RequestBody Developer dev) {
        return null;
    }

    @PutMapping("/language")
    public @ResponseBody Developer addLanguage (@RequestBody Developer updates) {
        Developer developer = repository.findById(updates.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        developer.languages.addAll(updates.getLanguages());

        return repository.save(developer);
    }

    @PutMapping("/{id}")
    public @ResponseBody Developer updateEmployee (@PathVariable Long id, @RequestBody Developer updates) {
        Developer developer = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

//        developer.setName(updates.getName());
//        return repository.save(updates);
        if (updates.getName() != null) developer.setName(updates.getName());
        if (updates.getEmail() != null) developer.setEmail(updates.getEmail());
        if (updates.getCohort() != null) developer.setCohort(updates.getCohort());
        if (updates.languages != null) developer.languages = updates.languages;

        return repository.save(developer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyDeveloper(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
