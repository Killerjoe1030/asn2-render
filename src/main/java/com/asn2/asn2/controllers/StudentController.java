package com.asn2.asn2.controllers;

import java.util.ArrayList;
// import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asn2.asn2.models.Student;
import com.asn2.asn2.models.StudentRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class StudentController {


    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/students/view")
    public String getAllStudents(Model model){
        System.out.println("Getting all students");
        List<Student> students = studentRepo.findAll();
        // end of database call 
        model.addAttribute("st", students);
        return "students/showAll";
    }

    @GetMapping("/students/select")
    public String deleteMenu(Model model){
        List<Student> students = studentRepo.findAll();
        model.addAttribute("st", students);
        return "students/deleteStudent";
    }

    @GetMapping("/students/delete/{uid}")
    public String deleteStudent(@PathVariable String uid,@RequestParam Map<String,String> editedStudent, HttpServletResponse response, Model model, Model model2, Model model3, Model model4){
        Student student = studentRepo.findByUid(Integer.parseInt(uid));
        studentRepo.delete(student);

        List<Student> students = studentRepo.findAll();
        List<Integer> additionalInfo = new ArrayList<Integer>();
        List<Float> additionalInfoGPA = new ArrayList<Float>();
        List<String> additionalInfoNames = new ArrayList<String>();
        int heightSum = 0;
        String minheightName = students.get(0).getName(); //occupys index 0 of the add info list
        String maxheightName = students.get(0).getName(); //occupays index 1 of the add info list
        int minheight = students.get(0).getHeight();
        int maxheight = students.get(0).getHeight();

        for(int i = 0; i < students.size(); i++){
            heightSum += students.get(i).getHeight();
            if(students.get(i).getHeight() < minheight){
                minheight = students.get(i).getHeight();
                minheightName = students.get(i).getName();
            }
            if(students.get(i).getHeight() > maxheight){
                maxheight = students.get(i).getHeight();
                maxheightName = students.get(i).getName();
            }
        }
        int avgheight = heightSum / students.size(); //occupys index 2 of the add info list
        additionalInfoNames.add(0,minheightName);
        additionalInfoNames.add(1,maxheightName);
        additionalInfo.add(0,avgheight);

        //now to collect information on the weights 
        int weightSum = 0; 
        int minWeight = students.get(0).getWeight(); //index 3
        int maxWeight = students.get(0).getWeight(); //index 4
        String minweightName = students.get(0).getName(); 
        String maxweightName = students.get(0).getName();                 

        for(int i = 0; i < students.size(); i++){
            weightSum += students.get(i).getWeight();
            if(students.get(i).getWeight() < minWeight){
                minWeight = students.get(i).getWeight();
                minweightName = students.get(i).getName();
            }
            if(students.get(i).getWeight() > maxWeight){
                maxWeight = students.get(i).getWeight();
                maxweightName = students.get(i).getName();
            }
        }
        int avgWeight = weightSum / students.size(); //index 5
        additionalInfoNames.add(2,minweightName);
        additionalInfoNames.add(3,maxweightName);
        additionalInfo.add(1,avgWeight);

        float gpaSum = 0;
        float mingpa = students.get(0).getGpa(); //index 0
        float maxgpa = students.get(0).getGpa(); // index 1

        for(int i = 0; i < students.size(); i++){
            gpaSum += students.get(i).getGpa();
            if(students.get(i).getGpa() < mingpa){
                mingpa = students.get(i).getGpa();
            }
            if(students.get(i).getGpa() > maxgpa){
                maxgpa = students.get(i).getGpa();
            }
        }
        float avgGpa = gpaSum / students.size();
        additionalInfoGPA.add(0,mingpa);
        additionalInfoGPA.add(1,maxgpa);
        additionalInfoGPA.add(2,avgGpa);

        model.addAttribute("st", students);        
        model2.addAttribute("addInfo1", additionalInfo);
        model3.addAttribute("addInfo2", additionalInfoGPA);
        model4.addAttribute("names", additionalInfoNames);

        return "students/display";
    }

    @GetMapping("/students/home")
    public String loadHomePage(Model model, Model model2, Model model3, Model model4){
        System.out.println("loading home page");
        List<Student> students = studentRepo.findAll();
        List<Integer> additionalInfo = new ArrayList<Integer>();
        List<Float> additionalInfoGPA = new ArrayList<Float>();
        List<String> additionalInfoNames = new ArrayList<String>();
        int heightSum = 0;
        String minheightName = students.get(0).getName(); //occupys index 0 of the add info list
        String maxheightName = students.get(0).getName(); //occupays index 1 of the add info list
        int minheight = students.get(0).getHeight();
        int maxheight = students.get(0).getHeight();

        for(int i = 0; i < students.size(); i++){
            heightSum += students.get(i).getHeight();
            if(students.get(i).getHeight() < minheight){
                minheight = students.get(i).getHeight();
                minheightName = students.get(i).getName();
            }
            if(students.get(i).getHeight() > maxheight){
                maxheight = students.get(i).getHeight();
                maxheightName = students.get(i).getName();
            }
        }
        int avgheight = heightSum / students.size(); //occupys index 2 of the add info list
        additionalInfoNames.add(0,minheightName);
        additionalInfoNames.add(1,maxheightName);
        additionalInfo.add(0,avgheight);

        //now to collect information on the weights 
        int weightSum = 0; 
        int minWeight = students.get(0).getWeight(); //index 3
        int maxWeight = students.get(0).getWeight(); //index 4
        String minweightName = students.get(0).getName(); 
        String maxweightName = students.get(0).getName();                 

        for(int i = 0; i < students.size(); i++){
            weightSum += students.get(i).getWeight();
            if(students.get(i).getWeight() < minWeight){
                minWeight = students.get(i).getWeight();
                minweightName = students.get(i).getName();
            }
            if(students.get(i).getWeight() > maxWeight){
                maxWeight = students.get(i).getWeight();
                maxweightName = students.get(i).getName();
            }
        }
        int avgWeight = weightSum / students.size(); //index 5
        additionalInfoNames.add(2,minweightName);
        additionalInfoNames.add(3,maxweightName);
        additionalInfo.add(1,avgWeight);

        float gpaSum = 0;
        float mingpa = students.get(0).getGpa(); //index 0
        float maxgpa = students.get(0).getGpa(); // index 1

        for(int i = 0; i < students.size(); i++){
            gpaSum += students.get(i).getGpa();
            if(students.get(i).getGpa() < mingpa){
                mingpa = students.get(i).getGpa();
            }
            if(students.get(i).getGpa() > maxgpa){
                maxgpa = students.get(i).getGpa();
            }
        }
        float avgGpa = gpaSum / students.size(); //index 2
        additionalInfoGPA.add(0,mingpa);
        additionalInfoGPA.add(1,maxgpa);
        additionalInfoGPA.add(2,avgGpa);

        model.addAttribute("st", students);        
        model2.addAttribute("addInfo1", additionalInfo);
        model3.addAttribute("addInfo2", additionalInfoGPA);
        model4.addAttribute("names", additionalInfoNames);
        return "students/display";
    }

    @PostMapping("/students/select")
    public String showAllStudents(Model model){
        System.out.println("Getting all students");

        List<Student> students = studentRepo.findAll();
        // end of database call 
        model.addAttribute("st", students);
        return "editUser";
    }



    @GetMapping("/students/edit/{uid}")
    public String editStudent(Model model, @PathVariable String uid){
        System.out.println("GET Student " + uid);
        Student student = studentRepo.findByUid(Integer.parseInt(uid));
        model.addAttribute("student",student);

        return "students/editStudent";
    }

    @PostMapping("/students/add")
    public String addStudent(@RequestParam Map<String,String> newstudent, HttpServletResponse response, Model model, Model model2, Model model3, Model model4){
        System.out.println("ADD Student");
        String newName = newstudent.get("name");
        String newHairColor = newstudent.get("hair_color");
        int newHeight = Integer.parseInt(newstudent.get("height"));
        int newWeight = Integer.parseInt(newstudent.get("weight"));
        float newGPA = Float.parseFloat(newstudent.get("gpa"));
        studentRepo.save(new Student(newName,newWeight,newHeight,newHairColor,newGPA));
        response.setStatus(201);

        List<Student> students = studentRepo.findAll();
        List<Integer> additionalInfo = new ArrayList<Integer>();
        List<Float> additionalInfoGPA = new ArrayList<Float>();
        List<String> additionalInfoNames = new ArrayList<String>();
        int heightSum = 0;
        String minheightName = students.get(0).getName(); //occupys index 0 of the add info list
        String maxheightName = students.get(0).getName(); //occupays index 1 of the add info list
        int minheight = students.get(0).getHeight();
        int maxheight = students.get(0).getHeight();

        for(int i = 0; i < students.size(); i++){
            heightSum += students.get(i).getHeight();
            if(students.get(i).getHeight() < minheight){
                minheight = students.get(i).getHeight();
                minheightName = students.get(i).getName();
            }
            if(students.get(i).getHeight() > maxheight){
                maxheight = students.get(i).getHeight();
                maxheightName = students.get(i).getName();
            }
        }
        int avgheight = heightSum / students.size(); //occupys index 2 of the add info list
        additionalInfoNames.add(0,minheightName);
        additionalInfoNames.add(1,maxheightName);
        additionalInfo.add(0,avgheight);

        //now to collect information on the weights 
        int weightSum = 0; 
        int minWeight = students.get(0).getWeight(); //index 3
        int maxWeight = students.get(0).getWeight(); //index 4
        String minweightName = students.get(0).getName(); 
        String maxweightName = students.get(0).getName();                 

        for(int i = 0; i < students.size(); i++){
            weightSum += students.get(i).getWeight();
            if(students.get(i).getWeight() < minWeight){
                minWeight = students.get(i).getWeight();
                minweightName = students.get(i).getName();
            }
            if(students.get(i).getWeight() > maxWeight){
                maxWeight = students.get(i).getWeight();
                maxweightName = students.get(i).getName();
            }
        }
        int avgWeight = weightSum / students.size(); //index 5
        additionalInfoNames.add(2,minweightName);
        additionalInfoNames.add(3,maxweightName);
        additionalInfo.add(1,avgWeight);

        float gpaSum = 0;
        float mingpa = students.get(0).getGpa(); //index 0
        float maxgpa = students.get(0).getGpa(); // index 1

        for(int i = 0; i < students.size(); i++){
            gpaSum += students.get(i).getGpa();
            if(students.get(i).getGpa() < mingpa){
                mingpa = students.get(i).getGpa();
            }
            if(students.get(i).getGpa() > maxgpa){
                maxgpa = students.get(i).getGpa();
            }
        }
        float avgGpa = gpaSum / students.size(); //index 2      
        additionalInfoGPA.add(0,mingpa);
        additionalInfoGPA.add(1,maxgpa);
        additionalInfoGPA.add(2,avgGpa);

        model.addAttribute("st", students);        
        model2.addAttribute("addInfo1", additionalInfo);
        model3.addAttribute("addInfo2", additionalInfoGPA);
        model4.addAttribute("names", additionalInfoNames);

        return "students/display";
    }




    @GetMapping("/students/edited/{uid}")
    public String editedStudent2(@PathVariable String uid ,@RequestParam Map<String,String> editedStudent, HttpServletResponse response, Model model, Model model2, Model model3, Model model4){
        System.out.println("Editing Student");
        Student student = studentRepo.findByUid(Integer.parseInt(uid));
        student.setName(editedStudent.get("name"));
        student.setHairColor(editedStudent.get("hair_color"));
        student.setHeight(Integer.parseInt(editedStudent.get("height")));
        student.setWeight(Integer.parseInt(editedStudent.get("weight")));   
        student.setGpa(Float.parseFloat(editedStudent.get("gpa")));         
        studentRepo.save(student);         

        List<Student> students = studentRepo.findAll();
        List<Integer> additionalInfo = new ArrayList<Integer>();
        List<Float> additionalInfoGPA = new ArrayList<Float>();
        List<String> additionalInfoNames = new ArrayList<String>();
        int heightSum = 0;
        String minheightName = students.get(0).getName(); //occupys index 0 of the add info list
        String maxheightName = students.get(0).getName(); //occupays index 1 of the add info list
        int minheight = students.get(0).getHeight();
        int maxheight = students.get(0).getHeight();

        for(int i = 0; i < students.size(); i++){
            heightSum += students.get(i).getHeight();
            if(students.get(i).getHeight() < minheight){
                minheight = students.get(i).getHeight();
                minheightName = students.get(i).getName();
            }
            if(students.get(i).getHeight() > maxheight){
                maxheight = students.get(i).getHeight();
                maxheightName = students.get(i).getName();
            }
        }
        int avgheight = heightSum / students.size(); //occupys index 2 of the add info list
        additionalInfoNames.add(0,minheightName);
        additionalInfoNames.add(1,maxheightName);
        additionalInfo.add(0,avgheight);

        //now to collect information on the weights 
        int weightSum = 0; 
        int minWeight = students.get(0).getWeight(); //index 3
        int maxWeight = students.get(0).getWeight(); //index 4
        String minweightName = students.get(0).getName(); 
        String maxweightName = students.get(0).getName();                 

        for(int i = 0; i < students.size(); i++){
            weightSum += students.get(i).getWeight();
            if(students.get(i).getWeight() < minWeight){
                minWeight = students.get(i).getWeight();
                minweightName = students.get(i).getName();
            }
            if(students.get(i).getWeight() > maxWeight){
                maxWeight = students.get(i).getWeight();
                maxweightName = students.get(i).getName();
            }
        }
        int avgWeight = weightSum / students.size(); //index 5
        additionalInfoNames.add(2,minweightName);
        additionalInfoNames.add(3,maxweightName);
        additionalInfo.add(1,avgWeight);

        float gpaSum = 0;
        float mingpa = students.get(0).getGpa(); //index 0
        float maxgpa = students.get(0).getGpa(); // index 1

        for(int i = 0; i < students.size(); i++){
            gpaSum += students.get(i).getGpa();
            if(students.get(i).getGpa() < mingpa){
                mingpa = students.get(i).getGpa();
            }
            if(students.get(i).getGpa() > maxgpa){
                maxgpa = students.get(i).getGpa();
            }
        }
        float avgGpa = gpaSum / students.size(); //index 2    
        additionalInfoGPA.add(0,mingpa);
        additionalInfoGPA.add(1,maxgpa);
        additionalInfoGPA.add(2,avgGpa);

        model.addAttribute("st", students);        
        model2.addAttribute("addInfo1", additionalInfo);
        model3.addAttribute("addInfo2", additionalInfoGPA);
        model4.addAttribute("names", additionalInfoNames);
        return "students/display";
    }


}
