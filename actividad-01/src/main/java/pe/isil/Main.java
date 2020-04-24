package pe.isil;

import pe.isil.equipo.fultbol.Barcelona;
import pe.isil.equipo.fultbol.Madrid;
import pe.isil.jugador.Messi;

public class Main {

    public static void main(String[] args) {

        //inyeccion de dependencia por constructor
        Messi messi = new Messi(new Barcelona());
        messi.juega();

        //inyeccion de dependencia por setter
        messi.setEquipo(new Madrid());
        messi.juega();

    }

}
