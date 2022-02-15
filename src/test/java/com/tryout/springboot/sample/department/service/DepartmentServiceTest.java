package com.tryout.springboot.sample.department.service;

import com.tryout.springboot.sample.department.entity.Department;
import com.tryout.springboot.sample.department.exception.DepartmentNotFoundException;
import com.tryout.springboot.sample.department.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("2334 quinah dr phoenix")
                .departmentCode("3b3g")
                .departmentId(1L)
                .build();


        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);

        Mockito.when(departmentRepository.findById(1L))
                .thenReturn(java.util.Optional.ofNullable(department));
    }

    @Test
    @DisplayName("get data based on departmentName")
    public void whenValiddepartmentName_thendepartmentNameisFound() throws DepartmentNotFoundException {
        String departmentName = "IT";
        Department departmentName_found = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName, departmentName_found.getDepartmentName());

    }

    @Test
    @DisplayName("get data based on departmentId")
    public void whenValiddepartmentId_thendepartmentIdisFound() throws DepartmentNotFoundException {
        Long departmentId = 1L;
        Department departmentId_found = departmentService.getDepartmentById(departmentId);
        assertEquals(departmentId, departmentId_found.getDepartmentId());
    }
}