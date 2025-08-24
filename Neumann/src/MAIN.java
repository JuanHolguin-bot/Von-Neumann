public class MAIN {
    public static void main(String[] args) {

        Memory memoria = new Memory();

        memoria.ingresarMemoria("0000","00000100");

        CPU cpu = new CPU(memoria);
        cpu.ejecutar();



    }
}
