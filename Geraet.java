

/**
 * Ein zu verladendes Geraet
 */
public class Geraet implements Comparable {

    /**
     * Der Name des Geraetes
     */
    private String name;

    /**
     * Die Anzahl, welche benoetigt wird
     */
    private int numberRequested;

    /**
     * Die Anzahl der verladenen Geraete.
     * Im Transporter Objekt die dort verladenen Geraete, 
     *  in der Solution-Class die insgesamt verladenen Geraete.
     */
    private int numberLoaded = 0;

    /**
     * Gewicht eines Geraetes in Gramm
     */
    private int weight;

    /**
     * Prioritaet des Geraetes. (Hoeher = Besser)
     */
    private int priority;


    /**
     * Erstellt ein Geraet Objekt.
     * 
     * @param name Der Name des Geraetes
     * @param numberRequested Die Anzahl, welche in Bonn benoetigt wird
     * @param weight Das Gewicht des Geraetes in Gramm
     * @param priority Die Prioritaet des Geraetes (hoeher = besser)
     */
    public Geraet(String name, int numberRequested, int weight, int priority) {
        this.name = name;
        this.numberRequested = numberRequested;
        this.weight = weight;
        this.priority = priority;
    }

    /**
     * Gibt die Prioritaet pro Gramm zurueck
     */
    public double priorityPerGramm() {
        return (double) priority / (double) weight;
    }

    /**
     * Gibt den Namen des Geraetes zurueck
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setzt den Namen des Geraetes neu.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt die angeforderte Anzahl zurueck.
     */
    public int getNumberRequested() {
        return this.numberRequested;
    }

    /**
     * Setzt die angeforderte Anzahl neu.
     */
    public void setNumberRequested(int numberRequested) {
        this.numberRequested = numberRequested;
    }

    /**
     * Gibt die geladene Anzahl zurueck.
     */
    public int getNumberLoaded() {
        return this.numberLoaded;
    }

    /**
     * Setzt die geladene Anzahl neu.
     */
    public void setNumberLoaded(int numberLoaded) {
        this.numberLoaded = numberLoaded;
    }

    /**
     * Setzt die geladene Anzahl. Gibt zudem das Geraet zurueck.
     */
    public Geraet numberLoaded(int numberLoaded) {
        this.numberLoaded = numberLoaded;
        return this;
    }

    /**
     * Gibt das Gewicht eines Geraetes zurueck
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * Setzt das Gewicht eines Geraetes neu.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Gibt die Prioritaet des Geraetes zurueck.
     */
    public int getPriority() {
        return this.priority;
    }

    /**
     * Setzt die Prioritaet eines Geraetes neu.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }


    /**
     * Zu Debug-Zwecken: Ausgabe eines Geraetes in der Konsole
     */
    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", numberRequested='" + getNumberRequested() + "'" +
            ", weight='" + getWeight() + "'" +
            ", priority='" + getPriority() + "'" +
            "}";
    }

    /**
     * Vergleicht zwei Geraete mittels der Prioritaet pro Gramm.
     * Die Geraete werden in Absteigender Reihenfolge stehen.
     */
    @Override
    public int compareTo(Object o) {
        if(o instanceof Geraet) {
            Geraet other = (Geraet) o;

            double p2 = other.priorityPerGramm();
            double p1 = this.priorityPerGramm();
            return (p2 > p1) ? 1 : ((p1 == p2) ? 0 : -1);
        }

        return 0;
    }

    /**
     * Erstellt eine Kopie eines Geraetes, 
     *  sodass ein separates Objekt und kein Pointer uebergeben wird.
     */
	public Geraet copy() {
		return new Geraet(this.getName(), this.getNumberRequested(), this.getWeight(), this.getPriority()).numberLoaded(this.numberLoaded);
	}
}