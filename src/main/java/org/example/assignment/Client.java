package org.example.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ajaz", 25000, 25, "Backend", Gender.MALE, "IT"),
                new Employee(2, "Ahmed", 35000, 47, "Hiring", Gender.FEMALE, "HR"),
                new Employee(3, "Khan", 55000, 32, "Frontend", Gender.MALE, "IT"),
                new Employee(4, "Yusuf", 15000, 20, "Acquisition", Gender.MALE, "Talent"),
                new Employee(5, "Bhai", 75000, 19, "Backend", Gender.FEMALE, "IT"),
                new Employee(6, "Rakesh", 78000, 34, "Onboarding", Gender.FEMALE, "HR"),
                new Employee(7, "Raj", 98000, 29, "Backend", Gender.MALE, "Admin"),
                new Employee(8, "Prajwal", 63000, 50, "Acquisition", Gender.FEMALE, "Talent")
        );

        //* Display the Employee with highest salary

        Employee emp1 = employees.stream()
                .sorted((a, b) -> (b.getSalary() - a.getSalary()))
                .limit(1)
                .findFirst()
                .get();

        System.out.println("Employee with max salary: " + emp1);

        //* Display the youngest employee

        Employee emp2 = employees.stream()
                .sorted((a, b) -> a.getAge() - b.getAge())
                .findFirst()
                .get();

        System.out.println("Employee with min age: " + emp2);

        //* Display the 3rd most eldest employee

        Employee emp3 = employees.stream()
                .sorted((a, b) -> b.getAge() - a.getAge())
                .limit(3)
                .skip(2)
                .findFirst()
                .get();

        System.out.println("3rd eldest Employee: " + emp3);


//* Expenses every month incurred department wise

        Map<String, Integer> expenseMap = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.summingInt(e -> e.getSalary())));
        System.out.println(expenseMap);
//* Average age of employees designation wise

       Map<String, Double> map = employees.stream()
                .collect(Collectors.groupingBy(e->e.getDesignation(), Collectors.averagingInt(e->e.getAge())));
       System.out.println(map);
//* Total number of males & females working in company

        Map<Boolean, List<Employee>> partitionMap = employees.stream()
                .collect(Collectors.partitioningBy(e->e.getGender().equals(Gender.MALE)));

        partitionMap.forEach((k, list) -> {
            System.out.print(k + " : ");
            list.forEach(e -> System.out.print(e.getName() + ", "));
            System.out.println();
        });

        employees.stream()
                .filter(emp -> {
                    System.out.println("Inside filter..........");
                    return emp.getAge() > 30;
                });


    }
}
