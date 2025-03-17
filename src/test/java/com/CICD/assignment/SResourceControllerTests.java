package com.CICD.assignment;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(SResourceController.class)  //load the controller for testing
public class SResourceControllerTests {

    @Autowired
    private MockMvc mockMvc;  //To simulate API requests

    @SuppressWarnings("removal")
    @MockBean
    private ResourceDAO resourceDAO;  // Mocking the DAO layer

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Resource_Stock testResource;

    @BeforeEach
    void setUp() {
        testResource = new Resource_Stock(1L, "Test Resource", 10);
    }

    @Test
    public void testGetAllResources() throws Exception {
        List<Resource_Stock> resources = Arrays.asList(testResource);
        when(resourceDAO.getAllResources()).thenReturn(resources);

        mockMvc.perform(get("/api/resources")) 
                .andExpect(status().isOk()) 
                .andExpect(jsonPath("$.size()").value(1)) 
                .andExpect(jsonPath("$[0].name").value("Test Resource"));  //check JSON response
    }

    @Test
    public void testGetResourceById() throws Exception {
        when(resourceDAO.getResourceById(1L)).thenReturn(testResource);

        mockMvc.perform(get("/api/resources/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Resource"));
    }

    @Test
    public void testCreateResource() throws Exception {
        when(resourceDAO.createResource(any(Resource_Stock.class))).thenReturn(1);

        mockMvc.perform(post("/api/resources")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testResource))) //convert object to JSON
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateResource() throws Exception {
        when(resourceDAO.updateResource(eq(1L), any(Resource_Stock.class))).thenReturn(1);

        mockMvc.perform(put("/api/resources/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testResource)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteResource() throws Exception {
        doNothing().when(resourceDAO).deleteResource(1L);

        mockMvc.perform(delete("/api/resources/1"))
                .andExpect(status().isOk());
    }
}
