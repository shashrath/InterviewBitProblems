package shasha.company.practice;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> sortedTransactions = transactions.stream().filter(x -> x.getYear() == 2011).sorted(Comparator.comparingInt(Transaction::getYear)).collect(Collectors.toList());
        Set<String> uniqueCities = transactions.stream().map(x -> x.getTrader().getCity()).collect(Collectors.toSet());
        List<Trader> tradersFromCambridge = transactions.stream().map(Transaction::getTrader).distinct().filter(x -> x.getCity().equalsIgnoreCase("Cambridge")).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        String sortedTradersNames =  transactions.stream().map(x -> x.getTrader().getName()).distinct().sorted().collect(Collectors.joining());
        //Boolean anyFromMilan = transactions.stream().map(Transaction::getTrader).distinct().anyMatch(x -> x.getCity().equalsIgnoreCase("Milan"));
        Boolean anyFromMilan = transactions.stream().anyMatch(x -> x.getTrader().getCity().equalsIgnoreCase("Milan"));
        List<Integer> transactionsFromCambridge = transactions.stream().filter( x -> x.getTrader().getCity().equalsIgnoreCase("Cambridge")).map(Transaction::getValue).collect(Collectors.toList());
        OptionalInt maxTransaction = transactions.stream().mapToInt(Transaction::getValue).max();
        Optional<Transaction> minTransaction = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        //Printing solutions
        System.out.println(sortedTransactions);
        System.out.println(uniqueCities);
        System.out.println(tradersFromCambridge);
        System.out.println(sortedTradersNames);
        System.out.println(anyFromMilan);
        System.out.println(transactionsFromCambridge);
        System.out.println(maxTransaction.orElse(-1));
        System.out.println(minTransaction.get());
    }
}
