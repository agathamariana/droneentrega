package puc.droneentrega.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OPERADOR")
@Getter
@Setter
public class Operador {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME_OPERADOR")
    private String nomeOperador;

    @Column(name = "USERNAME_OPERADOR")
    private String usernameOperador;

    @Column(name = "DATA_NASCIMENTO_OPERADOR")
    private Date dataNascimentoOperador;

    @Column(name = "CPF_OPERADOR")
    private Long cpfOperador;

    @Column(name = "RG_OPERADOR")
    private Long rgOperador;

    @Column(name = "UF_RG_OPERADOR")
    private String ufRgOperador;

    @Column(name = "DATA_EMISSAO_RG_OPERADOR")
    private Date dataEmissaoRgOperador;
}
