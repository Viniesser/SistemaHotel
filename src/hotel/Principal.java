package hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean running = true;

        while (running) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Fazer Reserva");
            System.out.println("3. Check-in");
            System.out.println("4. Check-out");
            System.out.println("5. Relatório de Ocupação");
            System.out.println("6. Histórico de Reservas");
            System.out.println("0. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    System.out.print("Número do quarto: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo de quarto (solteiro, casal, suite): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Preço diário: ");
                    double preco = scanner.nextDouble();
                    hotel.cadastrarQuarto(new Quarto(numero, tipo, preco));
                    break;

                case 2:
                    System.out.print("Nome do hóspede: ");
                    String nomeHospede = scanner.nextLine();
                    System.out.print("Data de check-in (formato: dd/MM/yyyy): ");
                    String checkInStr = scanner.nextLine();
                    System.out.print("Data de check-out (formato: dd/MM/yyyy): ");
                    String checkOutStr = scanner.nextLine();

                    Date checkIn = null;
                    Date checkOut = null;
                    try {
                        checkIn = sdf.parse(checkInStr);
                        checkOut = sdf.parse(checkOutStr);
                    } catch (ParseException e) {
                        System.out.println("Formato de data inválido. Tente novamente.");
                        continue;
                    }

                    System.out.print("Número de quartos: ");
                    int numeroQuartos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo de quarto reservado: ");
                    String tipoQuarto = scanner.nextLine();
                    hotel.fazerReserva(new Hospede(nomeHospede), checkIn, checkOut, numeroQuartos, tipoQuarto);
                    break;

                case 3:
                    System.out.print("Nome do hóspede: ");
                    String nomeCheckIn = scanner.nextLine();
                    System.out.print("Tipo de quarto: ");
                    String tipoCheckIn = scanner.nextLine();
                    hotel.realizarCheckIn(new Hospede(nomeCheckIn), tipoCheckIn);
                    break;

                case 4:
                    System.out.print("Nome do hóspede: ");
                    String nomeCheckOut = scanner.nextLine();
                    hotel.realizarCheckOut(new Hospede(nomeCheckOut));
                    break;

                case 5:
                    hotel.relatorioOcupacao();
                    break;

                case 6:
                    hotel.relatorioHistoricoReservas();
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}