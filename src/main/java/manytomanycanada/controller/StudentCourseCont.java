package manytomanycanada.controller;

import java.util.ArrayList;
import java.util.List;

import manytomanycanada.dao.CoursesDao;
import manytomanycanada.dao.StudentDao;
import manytomanycanada.dto.Course;
import manytomanycanada.dto.Student;

public class StudentCourseCont {
public static void main(String[] args) {
	Course course1=new  Course();
	course1.setId(100);
	course1.setName("Java");
	course1.setFees(5000);
	Course course2=new  Course();
	course2.setId(200);
	course2.setName("AdvJava");
	course2.setFees(6000);
	Course course3=new  Course();
	course3.setId(300);
	course3.setName("Sql");
	course3.setFees(7000);
	
	
	
	Student student1=new Student();
	
	student1.setId(1);
	student1.setName("Poojitha");
	student1.setAddress("India");
	List<Course> coursesOfPoojitha=new ArrayList<Course>();
	coursesOfPoojitha.add(course1);
	coursesOfPoojitha.add(course2);
	student1.setCourses(coursesOfPoojitha);
	
	Student student2=new Student();
	student2.setId(2);
    student2.setName("Aryan");
    student2.setAddress("USA");
    
   
    student2.setCourses(coursesOfPoojitha);
    
    Student student3=new Student();
    student3.setId(3);
    student3.setName("Sandhya");
    student3.setAddress("dubai");
    
    List<Course> coursesofsandhya=new ArrayList<Course>();
    coursesofsandhya.add(course1);
    coursesofsandhya.add(course2);
    coursesofsandhya.add(course3);
    
    student3.setCourses(coursesofsandhya);
	
	
    CoursesDao coursesDao=new CoursesDao();
     List<Course> courses=new ArrayList<Course>();
     courses.add(course3);
     courses.add(course2);
     courses.add(course1);
	
	
//	coursesDao.saveMultipleCourses(courses);
	
	
	StudentDao studentDao=new StudentDao();
//	studentDao.saveStudent(student1);
//	studentDao.saveStudent(student2);
//	studentDao.saveStudent(student3);
	
	
	studentDao.addCoursesStudent(1, 300);
	
	
	
	
}
}
