package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById =====");
		Department department = departmentDao.findById(3);		
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: department findAll =====");
		List<Department> deps = departmentDao.findAll();
		for(Department dep : deps) {
			System.out.println(dep);
		}
		
		System.out.println("\nPause! Type any key and press Enter to continue...");
		sc.next();
		
		System.out.println("\n=== TEST 3: department insert =====");
		Department newDep = new Department(null, "Office");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());
		
		System.out.println("\nPause! Type any key and press Enter to continue...");
		sc.next();
		
		System.out.println("\n=== TEST 4: department update =====");
		Department updatedDep = departmentDao.findById(newDep.getId());
		updatedDep.setName("Pharmacy");
		departmentDao.update(updatedDep);
		System.out.println("Update completed!");
		
		System.out.println("\nPause! Type any key and press Enter to continue...");
		sc.next();
		
		System.out.println("\n=== TEST 5: department delete =====");
		departmentDao.deleteById(updatedDep.getId());
		System.out.println("Delete completed!");
		
		System.out.println("\nPause! Type any key and press Enter to continue...");
		sc.next();
		
		System.out.println("\n=== TEST 6: department findAll again =====");
		deps = departmentDao.findAll();
		for(Department dep : deps) {
			System.out.println(dep);
		}
		
		sc.close();

	}

}
