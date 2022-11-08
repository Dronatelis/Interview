package sk.tuke.fei.kpi.dao;

import javax.persistence.*;

@Entity
public class DriverStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private int sizeOfStorage;
    private boolean state;

    public DriverStorage(Long id, int sizeOfStorage, boolean state) {
        this.id = id;
        this.sizeOfStorage = sizeOfStorage;
        this.state = state;
    }

    public DriverStorage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSizeOfStorage() {
        return sizeOfStorage;
    }

    public void setSizeOfStorage(int sizeOfStorage) {
        this.sizeOfStorage = sizeOfStorage;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DriverStorage{" +
                "id=" + id +
                ", sizeOfStorage=" + sizeOfStorage +
                ", state=" + state +
                '}';
    }
}
