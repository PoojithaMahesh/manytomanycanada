package manytomanycanada.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanycanada.dto.Course;
import manytomanycanada.dto.Student;

public class StudentDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	public void saveStudent(Student student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}
	
	public void updateStudent(int id,Student student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
			entityTransaction.begin();
			
			student.setId(id);
			student.setCourses(dbStudent.getCourses());			
			entityManager.merge(student);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	public void addCoursesStudent(int studentId,int courseId) {
		EntityManager entityManager=getEntityManager();
		Course dbCourse=entityManager.find(Course.class, courseId);
		if(dbCourse!=null) {
//			proceed the next 
			Student dbStudent=entityManager.find(Student.class, studentId);
			if(dbStudent!=null) {
//				then only i can update that student courses
//				take the courses she is taking
				EntityTransaction entityTransaction=entityManager.getTransaction();
				entityTransaction.begin();
				List<Course> list=dbStudent.getCourses();
				list.add(dbCourse);
				dbStudent.setCourses(list);
				entityTransaction.commit();
			}else {
				System.out.println("Student is not present");
			}	
		}else {
			System.out.println("Course is not present");
		}	
	}
	public void findStudent(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
			System.out.println(dbStudent);
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	public void deleteStudent(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
			entityTransaction.begin();
			entityManager.remove(dbStudent);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
}
