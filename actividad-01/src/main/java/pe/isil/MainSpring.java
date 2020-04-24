package pe.isil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.isil.jugador.Messi;

public class MainSpring {

    public static void main(String[] args) {

        ApplicationContext app =
                new ClassPathXmlApplicationContext("beans.xml");

        Messi messi = app.getBean("messi", Messi.class);
        messi.juega();

    }


}
