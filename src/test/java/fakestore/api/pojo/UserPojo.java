package fakestore.api.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UserPojo {
    int id;
    String email;
    String username;
    String password;
    Name name;
    String phone;
    int __v;
    Address address;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserPojo userPojo = (UserPojo) o;
        return id == userPojo.id && __v == userPojo.__v && Objects.equals(email, userPojo.email) && Objects.equals(username, userPojo.username) && Objects.equals(password, userPojo.password) && Objects.equals(name, userPojo.name) && Objects.equals(phone, userPojo.phone) && Objects.equals(address, userPojo.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username, password, name, phone, __v, address);
    }

    public UserPojo() {
    }

    public UserPojo(int id, String email, String username, String password, Name name, String phone, int __v, Address address) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.__v = __v;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static class Name{
        String firstname;
        String lastname;

        public Name() {
        }

        public Name(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Name name = (Name) o;
            return Objects.equals(firstname, name.firstname) && Objects.equals(lastname, name.lastname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstname, lastname);
        }
    }

    public static class Address{
        String city;
        String street;
        int number;
        String zipcode;
        Geolocation geolocation;

        public Address() {
        }

        public Address(String city, String street, int number, String zipcode, Geolocation geolocation) {
            this.city = city;
            this.street = street;
            this.number = number;
            this.zipcode = zipcode;
            this.geolocation = geolocation;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public Geolocation getGeolocation() {
            return geolocation;
        }

        public void setGeolocation(Geolocation geolocation) {
            this.geolocation = geolocation;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return number == address.number && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(zipcode, address.zipcode) && Objects.equals(geolocation, address.geolocation);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, street, number, zipcode, geolocation);
        }

        public static class Geolocation{
            String lat;
            @JsonProperty("long")
            String longitude;

            public Geolocation() {
            }

            public Geolocation(String lat, String longitude) {
                this.lat = lat;
                this.longitude = longitude;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            @Override
            public boolean equals(Object o) {
                if (o == null || getClass() != o.getClass()) return false;
                Geolocation that = (Geolocation) o;
                return Objects.equals(lat, that.lat) && Objects.equals(longitude, that.longitude);
            }

            @Override
            public int hashCode() {
                return Objects.hash(lat, longitude);
            }
        }
    }
}
