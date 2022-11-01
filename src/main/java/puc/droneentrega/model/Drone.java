package puc.droneentrega.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "DRONE")
@Getter
@Setter
public class Drone {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME_DRONE")
    private String nomeDrone;

    @Column(name = "MODELO_DRONE")
    private String modeloDrone;

    @Column(name = "COR_DRONE")
    private String corDrone;

    @Column(name = "ANO_DRONE")
    private String anoDrone;
}
