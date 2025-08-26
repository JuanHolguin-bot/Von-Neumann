public class MAIN {
    public static void main(String[] args) {

        Memory memoria = new Memory();

        //Memoria con instrucciones a ejecutar

        memoria.ingresarMemoria("0000","00000100");
        memoria.ingresarMemoria("0001","00000101");
        memoria.ingresarMemoria("0010","01100111");
        memoria.ingresarMemoria("0011","01110000");
        memoria.ingresarMemoria("0100","00000101");
        memoria.ingresarMemoria("0101","00001011");
        memoria.ingresarMemoria("0110","00000000");
        memoria.ingresarMemoria("0111","00000000");



        CPU cpu = new CPU(memoria);
        cpu.ejecutar();



    }
}
