package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   private String lastName;

   private String email;

   @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
   @JoinColumn(name = "car_id")
   private Car car;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   @Override
   public boolean equals(Object usr) {
      if (usr == null) return false;
      if (this == usr) return true;
      if (usr.getClass() == this.getClass()) {
         User u = (User) usr;
         if (firstName.equals(u.getFirstName())
                 && lastName.equals(u.getLastName())
                 && email.equals(u.getEmail())) {
            return true;
         }
      }
      return false;
   }

   public String toString() {
      StringBuilder sb = new StringBuilder();

      sb.append("User{id=").append(id).append(", firstName=").append(firstName).append(", lastName=")
              .append(lastName).append(", email=").append(email).append(" ").append(car).append("}");

      return sb.toString();
   }
}
