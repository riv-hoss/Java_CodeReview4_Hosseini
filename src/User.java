public class User {

    private static int counter = 0;
    private int id;
    private String fname;
    private String lname;
    private String eMail;
    private String address;
    private int zip;
    private String phone;

    public User(String fname, String lname, String eMail, String address, int zip, String phone) {
        this.id = ++counter;
        this.fname = fname;
        this.lname = lname;
        this.eMail = eMail;
        this.address = address;
        this.zip = zip;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String geteMail() {
        return eMail;
    }

    public String getAddress() {
        return address;
    }

    public int getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + fname + " " +  lname + '\'' +
                ", eMail='" + eMail + "\'\n" +
                ", address='" + address + ", " +  zip + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
