package hiber.model;

import jakarta.persistence.*;
@Entity
@Table(name = "cars")
public class Car {
    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private User user;

    public Car() {}

    public Car(String model, int series) {
        this.series = series;
        this.model = model;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }
    public User setUser(User user) {
        this.user = user;
        return user;
    }
    @Override
    public String toString() {
        return "Сar - " + model + ":" + series;
    }
}
