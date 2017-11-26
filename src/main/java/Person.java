import java.util.List;

public class Person {
    private int id;
    private String name;
    private Address address;
    private List<Integer> books;
    private int age;

    public Person(int id,String name,int age,Address address,List<Integer> books){
        setId(id);
        setName(name);
        setAge(age);
        setAddress(address);
        setBooks(books);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Integer> getBooks() {
        return books;
    }

    public void setBooks(List<Integer> books) {
        this.books = books;
    }

    public List<Integer> getBookIds() {
        return books;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
