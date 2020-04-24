package pe.isil.jugador;

import pe.isil.equipo.fultbol.Equipo;

public class Messi {

    Equipo equipo;

    public Messi(){
    }

    public Messi(Equipo equipo){
        this.equipo = equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void juega(){
        this.equipo.juega();
    }

}
