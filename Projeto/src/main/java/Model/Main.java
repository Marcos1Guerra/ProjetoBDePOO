package Model;

import controller.HospitalDB;
import controller.MedicoDB;
import controller.PacienteDB;
import controller.QuartoDB;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        HospitalDB hospitalDB = new HospitalDB();
        MedicoDB medicoDB = new MedicoDB();
        PacienteDB pacienteDB = new PacienteDB();
        QuartoDB quartoDB = new QuartoDB();

        Quarto q01 = new Quarto(1, "alta");
        Quarto q02 = new Quarto(2, "media");
        Quarto q03 = new Quarto(3, "baixa");

        quartoDB.insertQuarto(q01);
        quartoDB.insertQuarto(q02);
        quartoDB.insertQuarto(q03);

        //numero = 0 -> parar
        //numero = 1 -> adicionar

        System.out.println("Entre com 1 para adicionar e para sair 0");
        System.out.println("Digite o numero:");
        int numero1 = entrada.nextInt();

        do {
            switch (numero1) {
                case 0:
                    System.out.println("Parou de adicionar medicos");
                case 1:
                    entrada.nextLine();
                    Medico m = new Medico();
                    System.out.println("Entre com o CRM:");
                    m.setCRM(entrada.nextInt());
                    entrada.nextLine();
                    System.out.println("Entre com o Nome:");
                    m.setNome(entrada.nextLine());
                    System.out.println("Entre com a Funcao:");
                    m.setFuncao(entrada.nextLine());
                    medicoDB.insertMedico(m);
                    System.out.println("Digite o numero:");
                    numero1 = entrada.nextInt();
            }
        } while (numero1 != 0);

        Hospital hospital = new Hospital("Albert Einstein", " Av. Albert Einstein, Sao Paulo");
        hospitalDB.insertHospital(hospital);

        System.out.println("------------------------");
        System.out.println("Voce esta no Model.Hospital " + hospital.getNome());

        //numero = 0 -> parar
        //numero = 1 -> adicionar
        //numero = 2 -> atualziar
        //numero = 3 -> excluir
        //numero = 4 -> visualizar

        System.out.println("Entre com 0 para sair");
        System.out.println("Entre com 1 para adicionar");
        System.out.println("Entre com 2 para atualizar");
        System.out.println("Entre com 3 para excluir");
        System.out.println("Entre com 4 para visualizar");
        System.out.println("Digite o numero:");
        int numero2 = entrada.nextInt();

        do {
            switch (numero2) {
                case 0:
                    System.out.println("Parou!");
                case 1:
                    entrada.nextLine();
                    Paciente p = new Paciente();
                    System.out.println("Entre com seu nome:");
                    p.setNome(entrada.nextLine());
                    System.out.println("Entre com seu CPF:");
                    p.setCPF(entrada.nextLine());
                    System.out.println("Entre com sua idade:");
                    p.setIdade(entrada.nextInt());
                    entrada.nextLine();
                    pacienteDB.insertPaciente(p);
                    System.out.println("Digite o numero:");
                    break;

                case 2:
                    entrada.nextLine();
                    System.out.println("Entre com o nome e CPF");
                    pacienteDB.updatePaciente(entrada.nextLine(), entrada.nextLine());
                    System.out.println("Digite o numero:");
                    break;

                case 3:
                    entrada.nextLine();
                    System.out.println("Entre com o CPF");
                    pacienteDB.deletePaciente(entrada.nextLine());
                    System.out.println("Digite o numero:");
                    break;

                case 4:
                    entrada.nextLine();
                    System.out.println("Entre com o CPF");
                    pacienteDB.selectPaciente(entrada.nextLine());
                    System.out.println("Digite o numero:");
                    break;
            }

            numero2 = entrada.nextInt();
        } while (numero2 != 0);
    }
}
