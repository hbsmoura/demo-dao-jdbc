package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById =====");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(department);		
		for(Seller sel : sellers) {
			System.out.println(sel);
		}
		
		System.out.println("\n=== TEST 3: seller findAll =====");
		List<Seller> allSellers = sellerDao.findAll();		
		for(Seller sel : allSellers) {
			System.out.println(sel);
		}
		
		System.out.println("\n=== TEST 4: seller insert =====");
		Seller newSeller = new Seller(null, "Greg Silver", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inseted! New id = " + newSeller.getId());
		System.out.println(sellerDao.findById(newSeller.getId()));
		
		System.out.println("\n=== TEST 5: seller update =====");
		Seller updatedSeller = sellerDao.findById(8);
		updatedSeller.setName("Martha Black");
		updatedSeller.setEmail("martha@gmail.com");
		sellerDao.update(updatedSeller);
		System.out.println("Update completed!");
		
		sc.next();
		
		System.out.println("\n=== TEST 6: seller delete =====");
		sellerDao.deleteById(9);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
