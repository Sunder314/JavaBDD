package Class.Course;

import java.sql.Time;

public class Course {
    private int id_u;
    private int idD;
    private Time tempsTC;
    private float distanceC;

    public Course() {}
    public Course(int id_u, int idD, Time tempsTC, float distanceC) {
        this.id_u = id_u;
        this.idD = idD;
        this.tempsTC = tempsTC;
        this.distanceC = distanceC;
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public int getIdD() {
        return idD;
    }

    public void setIdD(int idD) {
        this.idD = idD;
    }

    public Time getTempsTC() {
        return tempsTC;
    }

    public void setTempsTC(Time tempsTC) {
        this.tempsTC = tempsTC;
    }

    public float getDistanceC() {
        return distanceC;
    }

    public void setDistanceC(float distanceC) {
        this.distanceC = distanceC;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id_u=" + id_u +
                ", idD=" + idD +
                ", tempsTC=" + tempsTC +
                ", distanceC=" + distanceC +
                '}';
    }
}
