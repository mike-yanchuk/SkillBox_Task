package airport;


import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;

import java.lang.reflect.Type;
import java.sql.SQLOutput;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.skillbox.airport.Flight.Type.DEPARTURE;

public class Main {
    public static int i = 0;
    public static void main(String[] args) {

    }

    public static long findCountAircraftWithModelAirbus(Airport airport, String model) {
        return airport.getAllAircrafts().stream().filter(s -> s.getModel().contains(model)).count();
    }

    public static Map<String, Integer> findMapCountParkedAircraftByTerminalName(Airport airport) {
        ArrayList<Terminal> terminals = (ArrayList<Terminal>) airport.getTerminals();
        Map<String, Integer> parkedPlanes = terminals
                .stream()
                .collect(Collectors.toMap(Terminal::getName, terminal -> terminal.getParkedAircrafts().size()));
        return parkedPlanes;
    }

    public static List<Flight> findFlightsLeavingInTheNextHours(Airport airport, int hours) {
        List<Flight> flights = airport.getTerminals()
                .stream()
                .map(Terminal::getFlights)
                .flatMap(Collection::stream)
                .filter(type -> type.getType().equals(DEPARTURE))
                .filter(flight -> flight.getDate().isBefore(Instant.now().plusSeconds(hours * 60 * 60 + 1)))
                .filter(flight -> flight.getDate().isAfter(Instant.now().minusSeconds(0)))
                .collect(Collectors.toList());
        return flights;
    }

    public static Optional<Flight> findFirstFlightArriveToTerminal(Airport airport, String terminalName) {
        Optional<Flight> getFlight = airport
                .getTerminals()
                .stream()
                .filter(terminal -> terminal.getName().equals(terminalName))
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType().equals(Flight.Type.ARRIVAL))
                .min(Comparator.comparing(flight -> flight.getDate()));
        return getFlight;
    }
}

//airport.getTerminals()
//                .stream()
//                .filter(terminal -> terminal.getName().equals(terminalName))
//                .findFirst()
//                .flatMap(terminal -> terminal.getFlights().stream().min((f1,f2) -> f1.getDate().isAfter(f2.getDate()) ? 0 : 1));

//    List<Terminal> terminals = airport.getTerminals();
//    List<Terminal> allFlightAircraft = airport.getTerminals();
//        allFlightAircraft.stream().forEach(System.out::println);
//                System.out.println();
//
//                List<Terminal> terminal = airport.getTerminals()
//        .stream()
//        .filter(terminal12 -> terminal12.toString().equals(terminalName))
//        .toList();
//
//        List<Flight> flights = terminal.get(0).getFlights();
//        Set<Flight> flightTerminal = flights.stream().filter(date -> date.getDate().isAfter(Instant.now())).collect(Collectors.toSet());
//        return flightTerminal.stream().min((o1, o2) -> o1.getDate().isBefore(o2.getDate()) ? 0 : 1);



//List<Terminal> terminals = airport.getTerminals();
//    List<Terminal> allFlightAircraft = airport.getTerminals();
//        allFlightAircraft.stream().forEach(System.out::println);
//                System.out.println();
//
//                List<Terminal> terminal = airport.getTerminals()
//        .stream()
//        .filter(terminal12 -> terminal12.toString().equals(terminalName))
//        .toList();
//        List<Optional<Flight>> flights = terminal.stream().map(new Function<Terminal, Optional<Flight>>() {
//@Override
//public Optional<Flight> apply(Terminal terminal) {
//        return terminal.getFlights().stream().filter(date -> date.getDate().isAfter(Instant.now())).min((o1, o2) -> o1.getDate().isBefore(o2.getDate()) ? 0 : 1);
//        }
//        }).toList();
//        System.out.println(flights);
//        flights.stream().forEach(System.out::println);
//        Optional<Flight> flight = flights.get(flights.size());
//        return flight;
