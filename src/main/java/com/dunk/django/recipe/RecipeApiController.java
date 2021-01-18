package com.dunk.django.recipe;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RecipeApiController {
    private final RecipeService recipeService;

    @PostMapping("/register")
    public ResponseEntity<Long> savePost(@RequestBody RecipeSaveForm recipeSaveForm) {
        log.info("recipeSaveForm : {}", recipeSaveForm);
        Long id = recipeService.save(recipeSaveForm);

        return ResponseEntity.ok(id);
    }

    @PostMapping("/recipe")
    public ResponseEntity<String> savePost(@RequestBody File thumbnail) {

        log.info(thumbnail.getName());
        log.info(thumbnail.getPath());
        log.info(thumbnail.toString());

        return ResponseEntity.ok().build();
    }
}