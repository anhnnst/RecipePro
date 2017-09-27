package com.loabten.recipe.repositories;

import com.loabten.recipe.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
//integration testing
public class UnitOfMeasureRepositoryIT {
    @Autowired
    private UnitOfMeasureRepository repository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @DirtiesContext
    public void findByDescription() throws Exception {
        Optional<UnitOfMeasure> uomOptional = repository.findByDescription("Teaspoon");
        assertEquals("Teaspoon", uomOptional.get().getDescription());
    }
    @Test
    public void findByDescriptionCup() throws Exception {
        Optional<UnitOfMeasure> uomOptional = repository.findByDescription("Cup");
        assertEquals("Cup1", uomOptional.get().getDescription());
    }

    @Test
    public void testText() throws Exception {
    }
}