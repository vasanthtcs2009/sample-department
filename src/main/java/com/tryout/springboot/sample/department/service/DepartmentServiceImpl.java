package com.tryout.springboot.sample.department.service;

import com.tryout.springboot.sample.department.entity.Department;
import com.tryout.springboot.sample.department.exception.DepartmentNotFoundException;
import com.tryout.springboot.sample.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {

        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);

        if(!departmentOptional.isPresent()){
            throw new DepartmentNotFoundException("Department Not Found!!");
        }

        return departmentOptional.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department temp = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equals(department.getDepartmentAddress())) {
            temp.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equals(department.getDepartmentCode())) {
            temp.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentCode())) {
            temp.setDepartmentName(department.getDepartmentName());
        }

        return departmentRepository.save(temp);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
