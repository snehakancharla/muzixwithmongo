package com.stackroute.muzixapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Id;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album {
    @Id
    private int trackid;
    private String trackname;
    private String trackartist;
    private String genre;

   /* public int getTrackid() {
        return trackid;
    }

    public void setTrackid(int trackid) {
        this.trackid = trackid;
    }

    public String getTrackname() {

        return trackname;
    }

    public void setTrackname(String trackname) {

        this.trackname = trackname;
    }

    public String getTrackartist() {

        return trackartist;
    }

    public void setTrackartist(String trackartist) {

        this.trackartist = trackartist;
    }

    public String getGenre() {

        return genre;
    }

    public void setGenre(String genre) {

        this.genre = genre;
    }

    public Album(int id, String trackname, String trackartist, String genre) {
        this.trackid = id;
        this.trackname = trackname;
        this.trackartist = trackartist;
        this.genre = genre;
    }

    public Album() {
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + trackid +
                ", trackname='" + trackname + '\'' +
                ", trackartist='" + trackartist + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }*/
}
