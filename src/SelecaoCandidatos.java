import java.util.Scanner;

public class SelecaoCandidatos {
    public static class Candidato {
        private String nome;
        private double propostaSalario;

        public Candidato(String nome, double propostaSalario) {
            this.nome = nome;
            this.propostaSalario = propostaSalario;
        }

        public String getNome() {
            return nome;
        }

        public double getPropostaSalario() {
            return propostaSalario;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setPropostaSalario(double propostaSalario) {
            this.propostaSalario = propostaSalario;
        }
    }

    public static class SelecaoException extends Exception {
        public SelecaoException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Digite o número de candidatos:");
        int numCandidatos = terminal.nextInt();

        Candidato[] candidatos = new Candidato[numCandidatos];

        for (int i = 0; i < numCandidatos; i++) {
            System.out.println("Digite o nome do candidato " + (i + 1) + ":");
            String nome = terminal.next();
            System.out.println("Digite a proposta de salário do candidato " + (i + 1) + ":");
            double propostaSalario = terminal.nextDouble();

            candidatos[i] = new Candidato(nome, propostaSalario);
        }

        try {
            Candidato melhorCandidato = selecionarMelhorCandidato(candidatos);
            System.out.println("O melhor candidato é " + melhorCandidato.getNome() + " com uma proposta de salário de R$ " + melhorCandidato.getPropostaSalario());
        } catch (SelecaoException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static Candidato selecionarMelhorCandidato(Candidato[] candidatos) throws SelecaoException {
        if (candidatos.length == 0) {
            throw new SelecaoException("Não há candidatos para selecionar");
        }

        Candidato melhorCandidato = candidatos[0];

        for (Candidato candidato : candidatos) {
            if (candidato.getPropostaSalario() > melhorCandidato.getPropostaSalario()) {
                melhorCandidato = candidato;
            }
        }

        return melhorCandidato;
    }
}