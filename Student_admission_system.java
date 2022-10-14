
import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.ObjectInputStream;
        import java.io.ObjectOutputStream;
        import java.util.Scanner;

        public class Student_admission_system {
            static String fileName;
            static School school = new School();
            static Scanner in = new Scanner(System.in);
            static boolean running = true;


            public static void main(String[] args) {
        while (running) {
            System.out.println();
            System.out.println("                  -----------STUDENT ADMISSION SYSTEM-----------");
            System.out.println("\n 1). enter 1 for load a file containing student data" + "\n " +
                    "2). enter 2 for save and quite" + "\n " +
                    "3). enter 3 for list all students in school" + "\n" +
                    " 4). enter 4 for admitting Student in School");
            waiting l = new waiting();
            l.start();

            int answer = in.nextInt();

            switch (answer) {
                case 1:
                    System.out.println("enter the class in which student study/file name to load");
                    fileName = in.next();
                    loadScript(fileName);

                    break;
                case 2:
                    saveAndQuit(); //methods
                    break;
                case 3:
                    System.out.println(school.toString());
                    break;
                case 4:
                    addstudent();
                    break;
            }
        }
        System.exit(0);
    }

    private static void addstudent() {
        String name;     //international standard book number
        String Father_name;
        String Student_ID;
        double contact_no;

        System.out.println("\n Enter name: ");
        name = in.next();

        System.out.println("\n Enter father name: ");
        Father_name = in.next();

        System.out.println("\n Enter student id: ");
        Student_ID = in.next();

        System.out.println("\n Enter contact number: ");
        contact_no = in.nextDouble();

        student b = new student(name, Father_name, Student_ID, contact_no);
        school.addStudent(b);
    }

    private static void saveAndQuit() {
        System.out.println("Enter the file name. Make sure give the name of the file in which student is studying: ");
        fileName = in.next() + ".ser";
        running = false;
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(school);
            fos.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadScript(String name) {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        File file = new File(fileName + ".ser");
        if (file.exists()) {
            try {
                fis = new FileInputStream(file);
                in = new ObjectInputStream(fis);
                school = (School) in.readObject();
                fis.close();
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("\n The file does not exist! ");
        }
    }
}