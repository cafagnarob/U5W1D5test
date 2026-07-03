package roberto.cafagna.U5W1D5test.entities;


import jakarta.persistence.*;

@Entity

public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String indirizzo;

    @Column(nullable = false)
    private String città;
}
