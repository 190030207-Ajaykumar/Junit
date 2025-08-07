package com.aemcnx.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AemContextExtension.class)
class ProductModelTest {

    private final AemContext context = new AemContext();

    @BeforeEach
    void setup() {
        // Register model
        context.addModelsForClasses(com.aemcnx.core.models.ProductModel.class);

        // Create mock content
        context.create().resource("/content/product1",
                "name", "Test Product",
                "price", 100.0,
                "discount", 10.0
        );
    }

    @Test
    void testProductModel() {
        // Get resource and adapt to model
        ProductModel model = context.resourceResolver()
                .getResource("/content/product1")
                .adaptTo(ProductModel.class);

        assertNotNull(model);
        assertEquals("Test Product", model.getName());
        assertEquals(100.0, model.getPrice());
        assertEquals(10.0, model.getDiscount());
        assertEquals(90.0, model.getFinalPrice(), 0.001); // Tolerance for double comparison
    }
}
