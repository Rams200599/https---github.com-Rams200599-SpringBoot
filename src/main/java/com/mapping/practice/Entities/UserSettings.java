package com.mapping.practice.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//Entity\Bean class for UserSettings
@Entity
@Table(name = "usersettings")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hobby")
    private String hobby;

    public UserSettings(String hobby) {
        this.hobby = hobby;
    }

    // public void setUserName(String string) {
    // }
}
