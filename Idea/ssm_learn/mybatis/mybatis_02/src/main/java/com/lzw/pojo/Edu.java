package com.lzw.pojo;

/**
 * @author: a5071
 * @version: 2021/6/13 20:01
 */
public class Edu{
    private Integer id;
    private String name;
    private String gender;
    private String school;
    private String grade;

    public Edu(){
        super();
    }

    public Edu(Integer id, String name, String gender, String school, String grade){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.school = school;
        this.grade = grade;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getSchool(){
        return school;
    }

    public void setSchool(String school){
        this.school = school;
    }

    public String getGrade(){
        return grade;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

    @Override
    public String toString(){
        return "Edu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", school='" + school + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

}
