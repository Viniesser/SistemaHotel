package hotel;

import java.util.Date;

public class Reserva {
    private Hospede hospede;
    private Date checkIn;
    private Date checkOut;
    private int numeroQuartos;
    private String tipoQuarto;

    public Reserva(Hospede hospede, Date checkIn, Date checkOut, int numeroQuartos, String tipoQuarto) {
        this.hospede = hospede;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numeroQuartos = numeroQuartos;
        this.tipoQuarto = tipoQuarto;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public String toString() {
        return "Reserva de " + hospede.getNome() + " de " + checkIn + " a " + checkOut + " (" + numeroQuartos + " quarto(s) tipo " + tipoQuarto + ")";
    }
}