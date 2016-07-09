package exerciseThree.model.obserwowany;


public class Student {
    private String name = "";
    private Integer mark;


    public Student(String name, Integer mark) {
        this.name = name;
        this.mark = mark;
    }

    //GETTERs and SETTERs:
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getMark() {
        return mark;
    }
    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
