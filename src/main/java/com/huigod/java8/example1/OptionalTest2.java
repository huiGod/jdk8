package com.huigod.java8.example1;

import java.util.*;


public class OptionalTest2 {

    public static class Company {

        private String name;

        private List<Employee> employees;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }
    }

    public static class Employee {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("zhangsan");

        Employee employee2 = new Employee();
        employee2.setName("lisi");

        Company company = new Company();
        company.setName("company1");

        List<Employee> employees = Arrays.asList(employee, employee2);
        company.setEmployees(employees);

//        List<Employee> list = company.getEmployees();
//        if (list != null) {
//            return list;
//        } else {
//            return new ArrayList<>(employees);
//        }

        Optional<Company> optional = Optional.ofNullable(company);

        System.out.println(optional.map(theCompany -> theCompany.getEmployees()).
                orElse(Collections.emptyList()));

    }
}
