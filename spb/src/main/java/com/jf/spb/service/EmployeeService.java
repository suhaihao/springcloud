package com.jf.spb.service;

import com.jf.spb.bean.Employee;
import com.jf.spb.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    /**
     * 查出员工信息并且缓存到redis
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "empl", key = "#id")
    public Employee getByID(int id) {
        return employeeDao.getEMP(id);
    }

}
