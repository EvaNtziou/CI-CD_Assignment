package com.CICD.assignment;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class SResourceController {

    private final ResourceDAO resourceDAO;

    public SResourceController(ResourceDAO resourceDAO) {
        this.resourceDAO = resourceDAO;
    }

    // Get all resources
    @GetMapping
    public List<Resource_Stock> getAllResources() {
        return resourceDAO.getAllResources();
    }

    // Get resource by ID
    @GetMapping("/{id}")
    public Resource_Stock getResourceById(@PathVariable Long id) {
        return resourceDAO.getResourceById(id);
    }

    // Create a new resource
    @PostMapping
    public int createResource(@RequestBody Resource_Stock resource) {
        return resourceDAO.createResource(resource);
    }

    // Update an existing resource
    @PutMapping("/{id}")
    public int updateResource(@PathVariable Long id, @RequestBody Resource_Stock resourceDetails) {
        return resourceDAO.updateResource(id, resourceDetails);
    }

    // Delete a resource
    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Long id) {
        resourceDAO.deleteResource(id);
    }
}
