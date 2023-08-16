//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.spring.spring_personal_pj.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(
    name = "user"
)
public class UserEntity {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "user_id"
    )
    private Long userId;
    @Column(
        name = "email"
    )
    private String email;
    @Column(
        name = "phone"
    )
    private String phone;
    @Column(
        name = "name"
    )
    private String name;
    @Column(
        name = "password"
    )
    private String password;
    @Column(
        name = "birth"
    )
    private Date birth;
    @Column(
        name = "create_date"
    )
    @CreatedDate
    private Date create_date;
    @Column(
        name = "update_date"
    )
    @LastModifiedDate
    private Date updated_date;

    public UserEntity(String email, String phone, String name, String password, Date birth) {
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.password = password;
        this.birth = birth;
    }

    public static UserEntityBuilder builder() {
        return new UserEntityBuilder();
    }

    public Long getUserId() {
        return this.userId;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public Date getBirth() {
        return this.birth;
    }

    public Date getCreate_date() {
        return this.create_date;
    }

    public Date getUpdated_date() {
        return this.updated_date;
    }

    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setBirth(final Date birth) {
        this.birth = birth;
    }

    public void setCreate_date(final Date create_date) {
        this.create_date = create_date;
    }

    public void setUpdated_date(final Date updated_date) {
        this.updated_date = updated_date;
    }

    public UserEntity() {
    }

    public static class UserEntityBuilder {
        private String email;
        private String phone;
        private String name;
        private String password;
        private Date birth;

        UserEntityBuilder() {
        }

        public UserEntityBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public UserEntityBuilder phone(final String phone) {
            this.phone = phone;
            return this;
        }

        public UserEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public UserEntityBuilder password(final String password) {
            this.password = password;
            return this;
        }

        public UserEntityBuilder birth(final Date birth) {
            this.birth = birth;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this.email, this.phone, this.name, this.password, this.birth);
        }

        public String toString() {
            return "UserEntity.UserEntityBuilder(email=" + this.email + ", phone=" + this.phone + ", name=" + this.name + ", password=" + this.password + ", birth=" + this.birth + ")";
        }
    }
}
