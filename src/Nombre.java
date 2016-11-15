import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

/**
 * Created by zamedjir on 08/11/2016.
 */
public class Nombre {
    int n;
    int carre;
    int indicateur;

    public Nombre() {
        super();
        this.n = 0;
        this.carre = 0;
        indicateur = 1;
    }

    public synchronized void afficher() throws InterruptedException {
        while (indicateur == 0) {
        wait();
        }
                indicateur = 0;
                System.out.println("le nombre" + n);
                System.out.println("son carre" + carre);
                notifyAll();

        }


    public synchronized void calculer() throws InterruptedException {
        while (indicateur == 1) {
            wait();
        }

        indicateur = 1;
        this.n++;
        this.carre = this.n * this.n;
        notifyAll();

    }
}