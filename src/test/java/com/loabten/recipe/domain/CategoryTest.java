package com.loabten.recipe.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {
    Category category;

    @Before
    public void setUp() throws Exception {
        category = new Category();
    }

    @Test
    public void getId() throws Exception {
        Long idValue = 10L;
        category.setId(idValue);
        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() throws Exception {
    }

    @Test
    public void getRecipes() throws Exception {
        //assertEquals(0L, category.getId());
        //assertEquals(1, 2);
    }

    @Test
    public void getName() throws Exception {
        assertEquals(null, category.getId());
    }
}