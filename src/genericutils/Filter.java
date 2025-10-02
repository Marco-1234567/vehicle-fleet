package genericutils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Filter<T> {

    // TODO Uppgift 1 – Produktfilter (Predicate + T)
// TODO ● Skapa en generisk metod filterList(List<T> list, Predicate<T>
//            condition) som returnerar en ny lista med bara de element som matchar villkoret.
//            ● Testa metoden på en lista av Product (som tidigare) för att filtrera:
//    Produkter under 100 kr.
//    Produkter som finns i lager.
//    Kombination med .and().

    private final List<T> data;

    public Filter(List<T> data) {
        this.data = data;
    }

    public void foreach(Consumer<T> vehicle){
        data.forEach(vehicle);
    }

    public Filter<T> filterList(Predicate<T> condition){

        List<T> filteredList = data.stream().filter(condition).toList();

        return new Filter<>(filteredList);
    }
}
