package one.digitalinnovation.model;

public abstract class ObjArvore<Obj> {

    public abstract boolean equals(Object o);
    public abstract int hashCode();
    public abstract int compareTo(Obj outro);
    public abstract String toString();

}
