import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class PersonAdaptor {

    public static final DBObject toDBObject(Person person) {
        return new BasicDBObject("_id", person.getId())
                .append("name", person.getName())
                .append("age",person.getAge())
                .append("address", new BasicDBObject("street", person.getAddress().getStreet())
                        .append("city", person.getAddress().getTown())
                        .append("phone", person.getAddress().getPhone()))
                .append("books", person.getBookIds());
    }
}
