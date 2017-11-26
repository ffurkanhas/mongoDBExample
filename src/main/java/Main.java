import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static DBCollection personCollection;
    public static void main(String args[]){
        MongoDBHelper mongoDBHelper = new MongoDBHelper("Company");
        personCollection = mongoDBHelper.getDbCollection("Person");
        //createAndInsertPersons();
        //removeAllRows();
        //printByAge(20,22);
        //averageBookCount();
        //Person person = getPerson(1);
        //System.out.println(person.getName());
        averageBookCount("Ankara");
    }

    public static void averageBookCount(String city){
        int bookSum = 0,personCount = 0;
        BasicDBObject fields = new BasicDBObject();
        fields.put("address.city", city);
        DBCursor cursor = personCollection.find(fields);
        while(cursor.hasNext()) {
            personCount++;
            Person tmp = getPerson((int)cursor.next().get("_id"));
            bookSum += tmp.getBooks().size();
        }
        System.out.println((double)bookSum/personCount);
    }

    public static Person getPerson(int id){
        BasicDBObject gtQuery = new BasicDBObject();
        gtQuery.put("_id", id);
        DBCursor cursor = personCollection.find(gtQuery);
        int personId = (int)cursor.one().get("_id");
        String name = (String) cursor.one().get("name");
        int age = (int)cursor.one().get("age");
        BasicDBObject address = (BasicDBObject) cursor.one().get("address");
        String street = (String)address.get("street");
        String city = (String)address.get("city");
        String phone = (String)address.get("phone");
        Address addressTemp = new Address(street,city,phone);
        List<Integer> books = (List<Integer>)cursor.one().get("books");
        return new Person(personId,name,age,addressTemp,books);
    }

    public static void printByAge(int min,int max){
        BasicDBObject gtQuery = new BasicDBObject();
        gtQuery.put("age", new BasicDBObject("$gte", min).append("$lte", max));
        DBCursor cursor = personCollection.find(gtQuery);
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    public static void removeAllRows(){
        BasicDBObject document = new BasicDBObject();

        personCollection.remove(document);

        DBCursor cursor = personCollection.find();
        while (cursor.hasNext()) {
            personCollection.remove(cursor.next());
        }
    }

    public static List<Integer> randomBooksNumber(){
        Random rnd = new Random();
        ArrayList<Integer> bookList = new ArrayList<Integer>();
        int randomBookCount = rnd.nextInt(8)+1;
        for(int i=0;i<randomBookCount;i++){
            bookList.add(rnd.nextInt(9999)+1000);
        }
        return bookList;
    }

    public static void createAndInsertPersons(){
        Address address1 = new Address("X","Ankara","5062719191");
        Address address2 = new Address("X1","Istanbul","5062719192");
        Address address3 = new Address("X2","Izmir","5062719193");
        Address address4 = new Address("X3","Ankara","5062719194");
        Address address5 = new Address("X4","Istanbul","5062719195");
        Address address6 = new Address("X5","Izmir","5062719196");
        Address address7 = new Address("X6","Ankara","5062719197");
        Address address8 = new Address("X7","Istanbul","5062719198");
        Address address9 = new Address("X8","Izmir","5062719199");
        Address address10 = new Address("X9","Ankara","5072719191");
        Address address11 = new Address("X10","Istanbul","5072719192");
        Address address12 = new Address("X11","Izmir","5072719193");
        Address address13 = new Address("X12","Ankara","5072719194");
        Address address14 = new Address("X13","Istanbul","5072719195");
        Address address15 = new Address("X14","Izmir","5072719196");
        Address address16 = new Address("X15","Ankara","5072719197");
        Address address17 = new Address("X16","Istanbul","5072719198");
        Address address18 = new Address("X17","Ankara","5072719199");
        Address address19 = new Address("X18","Izmir","5062719190");
        Address address20 = new Address("X19","Istanbul","5072719190");
        Person person1 = new Person(1,"Fatih Has",22,address1,randomBooksNumber());
        Person person2 = new Person(2,"Furkan Has",22,address2,randomBooksNumber());
        Person person3 = new Person(3,"Fatih Furkan",22,address3,randomBooksNumber());
        Person person4 = new Person(4,"Zeki Mazan",27,address4,randomBooksNumber());
        Person person5 = new Person(5,"Ugur Sahin",28,address5,randomBooksNumber());
        Person person6 = new Person(6,"Tansel Ozyer",42,address6,randomBooksNumber());
        Person person7 = new Person(7,"Benan Bardak",21,address7,randomBooksNumber());
        Person person8 = new Person(8,"Atakan Angun",35,address8,randomBooksNumber());
        Person person9 = new Person(9,"Ozan Yuksel",60,address9,randomBooksNumber());
        Person person10 = new Person(10,"Irem Ugurlu",18,address10,randomBooksNumber());
        Person person11 = new Person(11,"Firat Alyurt",21,address11,randomBooksNumber());
        Person person12 = new Person(12,"Sena Seyhoglu",22,address12,randomBooksNumber());
        Person person13 = new Person(13,"Julide Hancer",20,address13,randomBooksNumber());
        Person person14 = new Person(14,"Ecem Memis",19,address14,randomBooksNumber());
        Person person15 = new Person(15,"Furkan Sert",1,address15,randomBooksNumber());
        Person person16 = new Person(16,"Mehmet Coskun",5,address16,randomBooksNumber());
        Person person17 = new Person(17,"Ataberk Hancer",28,address17,randomBooksNumber());
        Person person18 = new Person(18,"Damla Ozsu",15,address18,randomBooksNumber());
        Person person19 = new Person(19,"Simge Taskiran",21,address19,randomBooksNumber());
        Person person20 = new Person(20,"Busra Akinci",22,address20,randomBooksNumber());
        personCollection.insert(PersonAdaptor.toDBObject(person1));
        personCollection.insert(PersonAdaptor.toDBObject(person2));
        personCollection.insert(PersonAdaptor.toDBObject(person3));
        personCollection.insert(PersonAdaptor.toDBObject(person4));
        personCollection.insert(PersonAdaptor.toDBObject(person5));
        personCollection.insert(PersonAdaptor.toDBObject(person6));
        personCollection.insert(PersonAdaptor.toDBObject(person7));
        personCollection.insert(PersonAdaptor.toDBObject(person8));
        personCollection.insert(PersonAdaptor.toDBObject(person9));
        personCollection.insert(PersonAdaptor.toDBObject(person10));
        personCollection.insert(PersonAdaptor.toDBObject(person11));
        personCollection.insert(PersonAdaptor.toDBObject(person12));
        personCollection.insert(PersonAdaptor.toDBObject(person13));
        personCollection.insert(PersonAdaptor.toDBObject(person14));
        personCollection.insert(PersonAdaptor.toDBObject(person15));
        personCollection.insert(PersonAdaptor.toDBObject(person16));
        personCollection.insert(PersonAdaptor.toDBObject(person17));
        personCollection.insert(PersonAdaptor.toDBObject(person18));
        personCollection.insert(PersonAdaptor.toDBObject(person19));
        personCollection.insert(PersonAdaptor.toDBObject(person20));
    }
}
