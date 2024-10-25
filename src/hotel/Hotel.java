package hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void cadastrarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public void fazerReserva(Hospede hospede, Date checkIn, Date checkOut, int numeroQuartos, String tipoQuarto) {
        int quartosDisponiveis = 0;

        for (Quarto quarto : quartos) {
            if (quarto.getTipo().equals(tipoQuarto) && quarto.isDisponivel()) {
                quartosDisponiveis++;
            }
        }

        if (quartosDisponiveis >= numeroQuartos) {
            for (Quarto quarto : quartos) {
                if (quarto.getTipo().equals(tipoQuarto) && quarto.isDisponivel()) {
                    Reserva reserva = new Reserva(hospede, checkIn, checkOut, numeroQuartos, tipoQuarto);
                    reservas.add(reserva);
                    quarto.setDisponivel(false); 
                    System.out.println("Reserva realizada com sucesso: " + reserva);
                    break;
                }
            }
        } else {
            System.out.println("Não foi possível fazer a reserva. Quartos insuficientes disponíveis.");
        }
    }

    public void realizarCheckIn(Hospede hospede, String tipoQuarto) {
        for (Reserva reserva : reservas) {
            if (reserva.getHospede().getNome().equals(hospede.getNome()) && reserva.getTipoQuarto().equals(tipoQuarto)) {
                System.out.println("Check-in realizado para: " + hospede.getNome());
                return;
            }
        }
        System.out.println("Reserva não encontrada para check-in.");
    }

    public void realizarCheckOut(Hospede hospede) {
        for (Reserva reserva : reservas) {
            if (reserva.getHospede().getNome().equals(hospede.getNome())) {
                reservas.remove(reserva);
                for (Quarto quarto : quartos) {
                    if (!quarto.isDisponivel() && quarto.getTipo().equals(reserva.getTipoQuarto())) {
                        quarto.setDisponivel(true);
                        break;
                    }
                }
                System.out.println("Check-out realizado para: " + hospede.getNome());
                return;
            }
        }
        System.out.println("Reserva não encontrada para check-out.");
    }

    public void relatorioOcupacao() {
        int quartosOcupados = 0;
        for (Quarto quarto : quartos) {
            if (!quarto.isDisponivel()) {
                quartosOcupados++;
            }
        }
        System.out.println("Número de quartos ocupados: " + quartosOcupados);
    }

    public void relatorioHistoricoReservas() {
        System.out.println("Histórico de Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }
}