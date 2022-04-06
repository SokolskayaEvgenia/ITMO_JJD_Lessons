package ru.itmo.lessons.lesson14;

import java.util.*;

public class CollectionsLesson {
    public static void main(String[] args) {

        Student student1 = new Student(1, "Maxim", 17);
        Student student2 = new Student(1, "Anna", 21);
        Student student3 = new Student(1, "Paul", 23);
        Student student4 = new Student(1, "Helen", 19);
        // коллекции различаются:
        // 1. многопоточная и однопоточная среда
        // 2. возможность хранить дублирующиеся элементы
        // 3. возможность хранить элементы в порядке добавления
        // 4. возможность хранить элементы в отсортированном виде

        System.out.println("ArrayList");
        // реализован на основе массива - внутри ArrayList физически массив
        // можно хранить null
        // можно хранить дублирующиеся элементы
        // порядок хранения элементов соответствует порядку добавления
        // примитивы хранить нельзя, только обертки

        ArrayList<Student> studentArrayList = new ArrayList<>(); // по умолчанию создается массив на 10 эл-ов (мы этого  не видим)
        studentArrayList = new ArrayList<>(30); // можно указать первоначальную емкость, которая может быть изменена
        System.out.println(studentArrayList.size()); // 0 - возвращает кол-во элементов в коллекции
        studentArrayList.add(student1); // добавляется ссылка на объект
        studentArrayList.add(student2);
        // обращение к несуществующему индексу IndexOutOfBoundsException
        // studentArrayList.add(10, student3);
        studentArrayList.add(1, student3); // не замена
        System.out.println(studentArrayList.size()); // 3 студента
        studentArrayList.add(null); // 4 элемента: 3 студента и null

        // урезает размер внутреннего массива до кол-ва добавленных элементов: выполняем, только когда уверены, что расширять больше не будем, хотя можем
        studentArrayList.trimToSize();

        // получение по индексу
        System.out.println(studentArrayList.get(1)); // возвращает ссылку на объект

        // удаление

        // удаляет ссылку по индексу из коллекции, возвращает ссылку на удаленный объект
        studentArrayList.remove(3);

        // возвращает true - false, для удаления использует метод equals
        studentArrayList.remove(student1); // удаляет первый найденный, если есть одинаковые
        System.out.println(studentArrayList);

        Student[] students = {student1, student2};
        List<Student> studentList = Arrays.asList(students);
        studentArrayList.removeAll(Arrays.asList(students));

        studentArrayList.clear(); // удаляет все элементы из коллекции
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);
        for (Student student : studentArrayList) {
            // к имени каждого студента добавить строку "Student: "
            student.setName("Student: " + student.getName());
            // удаление элемента в цикле приведет к ConcurrentModificationException
        }

        // удалить всех старше 20 лет
        Iterator<Student> iterator = studentArrayList.listIterator();
        while (iterator.hasNext()){
            if(iterator.next().getAge()>20){
                iterator.remove();
            }
        }

        System.out.println("LinkedList");
        // внутри не массив, нельзя задать начальную емкость
        LinkedList<Student> studentLinkedList = new LinkedList<>(studentArrayList);
        // можно хранить null
        // можно хранить дублирующиеся элементы
        // порядок хранения элементов соответствует порядку добавления

        studentLinkedList.add(student1);
        studentLinkedList.add(student2);
        studentLinkedList.add(student2);
        // при добавлении создается объект Node, который хранит ссылку на добавляемый объект
        // Node(student1) <-> Node(student2) <-> Node(student3) -> null
        // сам LinkedList хранит ссылку на первый и последний узел,
        // каждый узел хранит ссылку на следующий узел и предыдущий,
        // последний элемент хранит ссылку на null

        System.out.println("Set");
        // множества используются длля хранения уникальных элементов
        // обязательно должен быть переопределен метод equals

        Student student11 = new Student(1, "Maxim", 17);
        Student student12 = new Student(2, "Anna", 21);
        Student student13 = new Student(3, "Paul", 23);
        Student student14 = new Student(4, "Paul", 26);

        // Hashset
        //  позволяет хранить null (всегда будет на первом месте)
        // порядок хранения может отличаться от порядка добавления
        // основан на hash таблице
        // самый быстрый из всех множеств
        // если без разницы, как будут храниться элементы, то лучше HashSet

        HashSet<Student> studentHashSet = new HashSet<>();
        List<Student> list = Arrays.asList(student11, student12, student13, student14);
        studentHashSet = new HashSet<>(list);
        studentHashSet.add(student1);
        studentHashSet.remove(student13);

        // найти средний возраст студентов
        double avAge = 0;
        for (Student student : studentHashSet) {
            avAge += (double) student.getAge()/studentHashSet.size();
        }
        System.out.println(avAge);

        // LinkedHashSet
        // несколько медленнее, чем Hashset
        // порядок хранения не отличается от порядка добавления

        // TreeSet
        // 1. хранит элементы в отсортированном виде
        // 2. нельзя добавить null
        // 3. основан на алгоритме красно-черного дерева

        // Для добавления элементов в TreeSet необходимо:
        // 1. чтобы класс, элементы которого будут храниться в TreeSet (или сортироваться)
        // реализовывал интерфейс Comparable и его метод CompareTo

        TreeSet<Student> studentTreeSet = new TreeSet<>();
        studentTreeSet.add(student1);
        studentTreeSet.add(student2);
        studentTreeSet.add(student4);
        studentTreeSet.add(student11);


        // 2. создать экземпляры класса Comparator
                                                // если имена одинаковые -> сравниваем возраст
        Comparator<Student> studentComparator = new NameComparator().thenComparing(new AgeComparator());
        TreeSet<Student> studentTreeSet2 = new TreeSet<>(studentComparator);
        studentTreeSet2.add(student13);
        studentTreeSet2.add(student14);
    }
}
