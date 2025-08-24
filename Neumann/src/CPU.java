public class CPU {

    private int contadorPrograma;      //Indica en que instrucción estoy
    private Memory memoria;
    private int acumulador;
    private ALU alu;

    public CPU(Memory memoria) {
        this.memoria = memoria;
        this.acumulador = 0;
        this.contadorPrograma = 0;
        this.alu =  new ALU();
    }

    public void ejecutar(){
        boolean running = true;

        while(running){

            String direccion = String.format("%4s", Integer.toBinaryString(contadorPrograma)).replace(' ', '0');
            System.out.println("direccion = " + direccion);

            String instruccion = memoria.leer(direccion);
            String operacion  = instruccion.substring(0, 4);  // primeros 4 bits
            String operando = instruccion.substring(4, 8); // últimos 4 bits

            switch (operacion) {
                case "0000":  // ADD

                case "0001":  // SUB

                case "0010":  //  MUL

            }

            contadorPrograma++;
            if (contadorPrograma >= 16) running = false; //  overflow

        }
    }
}