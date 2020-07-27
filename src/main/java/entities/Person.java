package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic(optional = false, fetch = FetchType.EAGER) //optional false запретит добавлять в поле firstName базы данных null значение
    @Column(name = "first_name")
    private String firstName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Temporal(TemporalType.TIME)
    private Date time;

    private Date timestamp;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Person() {
    }

    public Person(String firstName, Gender gender, Date date, Address address) {
        this.firstName = firstName;
        this.gender = gender;
        this.date = date;
        this.time = date;
        this.timestamp = date;
        this.address = address;
    }

    public Person(int id, String firstName, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.gender = gender;
    }

    //@Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //@Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", gender=" + gender +
                ", adress=" + address.toString() +
                ", date=" + date +
                ", time=" + time +
                ", timestamp=" + timestamp +
                '}';
    }
}
