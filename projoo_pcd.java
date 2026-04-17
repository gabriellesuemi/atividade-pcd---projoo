import java.util.ArrayList;
import java.util.List;

// Interface do Observador
interface Observador {
    void atualizar(String nomeSensor, double temperatura, double ph, double umidade);
}

// Interface do Sujeito
interface Sujeito {
    void adicionarObservador(Observador o);
    void removerObservador(Observador o);
    void notificarObservadores();
}

// Classe Sensor = Sujeito
class SensorAmazonia implements Sujeito {
    private String nomeSensor;
    private double temperatura;
    private double ph;
    private double umidade;

    private List<Observador> observadores;

    public SensorAmazonia(String nomeSensor) {
        this.nomeSensor = nomeSensor;
        this.observadores = new ArrayList<>();
    }

    @Override
    public void adicionarObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void removerObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores() {
        for (Observador o : observadores) {
            o.atualizar(nomeSensor, temperatura, ph, umidade);
        }
    }

    public void setDados(double temperatura, double ph, double umidade) {
        this.temperatura = temperatura;
        this.ph = ph;
        this.umidade = umidade;
        notificarObservadores();
    }
}

// Classe Cidade = Observador
class Cidade implements Observador {
    private String nome;

    public Cidade(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String nomeSensor, double temperatura, double ph, double umidade) {
        System.out.println("Cidade: " + nome);
        System.out.println("Sensor: " + nomeSensor);
        System.out.println("Temperatura: " + temperatura + " °C");
        System.out.println("pH: " + ph);
        System.out.println("Umidade do ar: " + umidade + " %");
        System.out.println("----------------------------------");
    }
}
