public class Testes {

    public static void main(String[] args) {

        SensorAmazonia sensor1 = new SensorAmazonia("Sensor AM-1");
        SensorAmazonia sensor2 = new SensorAmazonia("Sensor AM-2");

        Cidade bsb = new Cidade("BSB");
        Cidade rj = new Cidade("RJ");
        Cidade sjc = new Cidade("SJC");
        Cidade sp = new Cidade("SP");
        Cidade poa = new Cidade("POA");

        System.out.println("TESTE 1: cadastro de observadores no sensor 1 ");
        sensor1.adicionarObservador(bsb);
        sensor1.adicionarObservador(rj);
        sensor1.adicionarObservador(sp);
        sensor1.setDados(32.5, 6.8, 85.0);

        System.out.println("\nTESTE 2: cadastro de observadores no sensor 2");
        sensor2.adicionarObservador(sjc);
        sensor2.adicionarObservador(poa);
        sensor2.adicionarObservador(sp);
        sensor2.setDados(28.3, 7.1, 90.0);

        System.out.println("\nTESTE 3: remoção de observador");
        sensor1.removerObservador(rj);
        sensor1.setDados(30.0, 6.5, 80.0);

        System.out.println("Verificação esperada: a cidade RJ não deve aparecer nesse último teste.");

        System.out.println("\nTESTE 4: novo valor no sensor 2");
        sensor2.setDados(26.7, 7.4, 93.0);

        System.out.println("Verificação esperada: SJC, POA e SP devem receber os novos dados.");
    }
}