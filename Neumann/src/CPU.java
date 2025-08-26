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
            if (instruccion == null || instruccion.isEmpty()) {
                System.out.println("Fin del programa: no hay más instrucciones.");
                break;
            }
            System.out.println("instruccion = " + instruccion);

            String operacion  = instruccion.substring(0, 4);  // primeros 4 bits
            String operando = instruccion.substring(4, 8); // últimos 4 bits

            String valorOperando = memoria.leer(operando);   // buscar en memoria dato a operar
            int dato = valorOperando != null && !valorOperando.isEmpty() ? Integer.parseInt(valorOperando, 2) : 0;

            switch (operacion) {
                case "0000":  // ADD
                    acumulador = alu.add(acumulador, dato);
                    System.out.println( "ADD  " + dato);
                    break;
                case "0001":  // SUB
                    acumulador = alu.sub(acumulador, dato);
                    System.out.println( "SUB " + dato);
                    break;
                case "0010":  // MUL
                    acumulador = alu.mul(acumulador, dato);
                    System.out.println( "MUL " + dato);
                    break;
                case "0011": // EXP
                    acumulador =  alu.exp(acumulador,dato);
                    System.out.println("EXP = " + dato);
                    break;
                case "0110":  // MOVER A MEMORIA
                    memoria.ingresarMemoria(operando, String.format("%8s", Integer.toBinaryString(acumulador)).replace(' ', '0'));
                    System.out.println("Valor movido a memoria en dirección " + operando + ": " + String.format("%8s", Integer.toBinaryString(acumulador)).replace(' ', '0'));
                    break;
                case "0111":  // FINALIZAR PROGRAMA
                    System.out.println("Programa finalizado por instrucción 0111.");
                    running = false;
                    break;
            }
            System.out.println("Acumulador (entero): " + acumulador);
            String resultadoBinario = String.format("%8s", Integer.toBinaryString(acumulador)).replace(' ', '0');
            System.out.println("Acumulador (binario): " + resultadoBinario);


            contadorPrograma++;
            if (contadorPrograma >= 16) running = false; //  overflow

        }
        // System.out.println(("Se modificó en memoria" + memoria.leer("0111")));  Verificar que se haya guardado en memoria
    }
}