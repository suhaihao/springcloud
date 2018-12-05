package com.jf.spb.dao;



import com.jf.spb.bean.Employee;

public interface EmployeeDao {
    /**
     * 根据ID查找用户
     * @param id
     * @return
     */
    public Employee getEMP(int id);

    /**
     * 插入一个用户
     * @param employee
     */
    public void insertEmp(Employee employee);
}
