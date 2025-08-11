package com.aemcnx.core.servlets;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AemContextExtension.class)
class HelloServletTest {

    AemContext aemContext = new AemContext();
    HelloServlet unitTest = new HelloServlet();

    @BeforeEach
    void setUp() {
    }

    @Test
    void doGet() throws ServletException, IOException {

        unitTest.doGet(aemContext.request(), aemContext.response());

        assertEquals("Hello from AEM Servlet! 🚀", aemContext.response().getOutputAsString());
    }
}