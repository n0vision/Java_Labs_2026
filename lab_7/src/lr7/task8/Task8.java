package lr7.task8;

import lr7.FileDemoConfig;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.nio.file.Files;

public class Task8 {

    public static class Student implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        private final String fullName;
        private final String group;
        private final double averageGrade;

        public Student(String fullName, String group, double averageGrade) {
            this.fullName = fullName;
            this.group = group;
            this.averageGrade = averageGrade;
        }

        public String getFullName() {
            return fullName;
        }

        public String getGroup() {
            return group;
        }

        public double getAverageGrade() {
            return averageGrade;
        }

        @Override
        public String toString() {
            return "Student{fullName='" + fullName + "', group='" + group + "', averageGrade=" + averageGrade + "}";
        }
    }

    public static void run() throws Exception {
        var file = FileDemoConfig.resolve("task8", "student.ser");
        Files.createDirectories(file.getParent());

        Student student = new Student("Владимиров Никита", "РИМ-150950", 4.75);
        System.out.println("Исходный объект: " + student);

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file.toFile()))) {
            output.writeObject(student);
        }
        System.out.println("Объект записан в файл.");

        Student restored;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file.toFile()))) {
            restored = (Student) input.readObject();
        }

        System.out.println("Восстановленный объект:");
        System.out.println("  ФИО: " + restored.getFullName());
        System.out.println("  Группа: " + restored.getGroup());
        System.out.println("  Средний балл: " + restored.getAverageGrade());

        Files.deleteIfExists(file);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Задание 8. Сериализация и десериализация объекта Student");
        run();
    }
}
