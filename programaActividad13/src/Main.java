import java.util.*;
//Clase anonima
interface classOrder{
    public void Alphabeth();
    public void Length();
}
//Clase Lambda
interface classLambda{
    ArrayList<String> useList(ArrayList<String> Lista);
}
//Referencia
interface classReferencia{
    ArrayList<String> useList(ArrayList<String> Lista);
}

class useReferencia{
    static ArrayList<String> ordenAlfabetico(ArrayList<String> Lista){
        Lista.sort(Comparator.naturalOrder());
        return Lista;
    }
    static ArrayList<String> ordenLongitud(ArrayList<String> Lista){
        Lista.sort(Comparator.comparing(String::length).reversed());
        return Lista;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<String> List = new ArrayList<String>();
        //NOTA, el contenido en List.add es modificable
        List.add("Hola");
        List.add("Abecedario");
        List.add("Normal");
        List.add("Mudo");
        List.add("Sorteo");
        List.add("Heroismo");
        List.add("Locura");
        List.add("Blanco");
        List.add("Guapo");
        List.add("Jalando");
        //Clases anonimas
        classOrder anonimo = new classOrder(){
            public void Alphabeth() {
                List.sort(Comparator.naturalOrder());
            }
            public void Length() {
                List.sort(Comparator.comparing(String::length).reversed());
            }
        };
        //Lista original
        System.out.println("- Lista original:");
        System.out.println(List);
        System.out.println();
        //Ordenado por clase anonima
        //Orden alfabetico con anonimo
        System.out.println("- Ordenamiendo Alfabetico con clase anonima:");
        anonimo.Alphabeth();
        System.out.println(List);
        //Largo de la palabra con anonimo
        System.out.println("- Ordenamiendo de longitud con clase anonima:");
        anonimo.Length();
        System.out.println(List);
        System.out.println();
        //Ordenado por lambda
        //Orden alfabetico con lambda
        System.out.println("- Ordenamiento Alfabetico con Lambda:");
        classLambda Alphabeth = (a) -> {
            a.sort(Comparator.naturalOrder());
            return a;
        };
        System.out.println(Alphabeth.useList(List));
        //Largo de la palabra con Lambda
        System.out.println("- Ordenamiento de longitud con Lambda:");
        classLambda Lenght = (a) -> {
            a.sort(Comparator.comparing(String::length).reversed());
            return a;
        };
        System.out.println(Lenght.useList(List));
        System.out.println();
        //Metodo de referencia
        //Orden alfabetico
        System.out.println("- Ordenamiento Alfabetico con referencia:");
        classReferencia ordenAlfabetico = useReferencia::ordenAlfabetico;
        System.out.println(ordenAlfabetico.useList(List));
        //Orden de longitud
        System.out.println("- Ordenamiento de longitud con referencia:");
        classReferencia ordenLongitud = useReferencia::ordenLongitud;
        System.out.println(ordenLongitud.useList(List));
    }
}