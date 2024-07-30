/*
 * You can use the following import statements
 *
 * import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 * 
 * import javax.persistence.*;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.wordlyweek.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;
import com.example.wordlyweek.model.Magazine;

@Entity
@Table(name = "writer")
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int writerId;

    @Column(name = "name")
    private String writerName;

    @Column(name = "bio")
    private String bio;

    @ManyToMany
    @JoinTable(name = "writer_magazine", joinColumns = @JoinColumn(name = "writerid"), inverseJoinColumns = @JoinColumn(name = "magazineid"))
    @JsonIgnoreProperties("writers")
    private List<Magazine> magazines;

    public Writer() {
    }

    public int getWriterId() {
        return writerId;
    }

    public String getWriterName() {
        return writerName;
    }

    public String getBio() {
        return bio;
    }

    public List<Magazine> getMagazines() {
        return magazines;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setMagazines(List<Magazine> magazines) {
        this.magazines = magazines;
    }
}