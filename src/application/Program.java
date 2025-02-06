package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entites.Department;
import model.entites.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		
		Department department = new Department();
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDeparment ===");
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller sl : list) {
			System.out.println(sl);
		}
		System.out.println("\n=== TEST 3: seller findall ===");
		list = sellerDao.findAll();
		
		for(Seller sl : list) {
			System.out.println(sl);
		}
		
		System.out.println("\n=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.isert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Matha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: seller delete ===");
		System.out.println("Enter id for delete ");
		int id = sc.nextInt();

		sellerDao.deleteById(id);
		
		System.out.println("Delete complete");
		
		
		System.out.println("\n ==== TEST 7: Department insert ====");
		Department newDepartment = new Department(null, "Engineer");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n ==== TEST 8: Department update ====");
		department = departmentDao.findById(10);
		department.setName("Finance");
		departmentDao.update(department);
		
		System.out.println("\n ==== TEST 9: Department delete ====");
		System.out.println("Enter id for delete ");
		int idDelete = sc.nextInt();
		
		departmentDao.deleteById(idDelete);
		System.out.println("Delete complete");
		
		
		System.out.println("\n ==== TEST 10: Department findById ====");
		department = departmentDao.findById(1);
		
		System.out.println(department);
		
		System.out.println("\n ==== TEST 11: Department findAll ====");
		List<Department> listD = departmentDao.findAll();
		for(Department dep : listD) {
			System.out.println(dep);
		}		
		sc.close();
	}

}
