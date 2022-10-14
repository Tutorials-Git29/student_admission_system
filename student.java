
import java.io.*;
        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;

class student implements Serializable{
    public String name;     //international standard book number
    public String Father_name;
    public String Student_ID;
    public double contact_no;

    public student(){

    }
    // costr
    public student(String name, String Father_name, String Student_ID, double contact_no){
        this.name=name;
        this.Father_name=Father_name;
        this.Student_ID=Student_ID;
        this.contact_no=contact_no;}
    public String toString(){
        return "\n Name: "+name+"\n Father name: "+Father_name+"\n student ID: "+Student_ID+"\n contact no: "+contact_no+"\n ";
    }
}


class School extends Object implements Serializable{
    public List<student> collection;

    public School() {

        collection = new ArrayList<student>();
    }

    public void addStudent(student S) {

        collection.add(S);
    }

    public String toString() {

        String total = "\n";
        Iterator<student> i = collection.iterator();
        while (i.hasNext()) {
            student S = (student) i.next();
            total = total + S.toString();
        }
        return total;
    }
}


