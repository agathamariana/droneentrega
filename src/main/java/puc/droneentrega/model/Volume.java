package puc.droneentrega.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "VOLUME")
@Getter
@Setter
public class Volume {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME_VOLUME")
    private String nomeVolume;

    @Column(name = "METRAGEM_VOLUME")
    private Double metragemVolume;

    @Column(name = "PESO_VOLUME")
    private Double pesoVolume;

    @Column(name = "VALOR_VOLUME")
    private Double valorVolume;
}
