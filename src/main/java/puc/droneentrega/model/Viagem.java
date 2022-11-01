package puc.droneentrega.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VIAGEM")
@Getter
@Setter
public class Viagem {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DRONE", referencedColumnName = "ID")
    private Drone drone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_OPERADOR", referencedColumnName = "ID")
    private Operador operador;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_VOLUME", referencedColumnName = "ID")
    private Volume volume;

    @Column(name = "ORIGEM_VIAGEM")
    private String origemViagem;

    @Column(name = "DATA_CHEGADA_VIAGEM")
    private Date dataChegadaViagem;

    @Column(name = "DATA_SAIDA_VIAGEM")
    private Date dataSaidaViagem;

    @Column(name = "DESTINO_VIAGEM")
    private String destinoViagem;

    @Column(name = "INSTRUCOES_VIAGEM")
    private String instrucoesViagem;
}
