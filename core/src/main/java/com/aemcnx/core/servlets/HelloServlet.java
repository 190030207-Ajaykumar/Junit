package com.aemcnx.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

@Component(
        service = { Servlet.class },
        property = {
                "sling.servlet.paths=/bin/hello", // URL path to trigger servlet
                "sling.servlet.methods=GET"       // Allowed method(s)
        }
)
public class HelloServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");
        response.getWriter().write("Hello from AEM Servlet! 🚀");
    }
}
