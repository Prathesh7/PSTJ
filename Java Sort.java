import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();

        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Collections.sort(studentList, new Comparator<Student>() {
            public int compare(Student a, Student b) {

                // CGPA: decreasing order
                if (Double.compare(b.getCgpa(), a.getCgpa()) != 0) {
                    return Double.compare(b.getCgpa(), a.getCgpa());
                }

                // First name: alphabetical order
                if (!a.getFname().equals(b.getFname())) {
                    return a.getFname().compareTo(b.getFname());
                }

                // ID: ascending order
                return Integer.compare(a.getId(), b.getId());
            }
        });

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }

        in.close();
    }
}

OUTPUT:
Input (stdin)

5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76


Your Output (stdout)

Ashis
Fahim
Samara
Samiha
Rumpa


Expected Output

Ashis
Fahim
Samara
Samiha
Rumpa
