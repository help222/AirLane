package mod2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Flights flights = new Flights();
        List<String> townList = Towns.TownList();
        List<Ticket> tickets = flights.getTickets();
        List<Ticket> myTickets = new ArrayList<Ticket>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int money = 0;
        int option = 0;
        System.out.println("Скільки у вас є грошей?");
        money = Integer.parseInt(scanner.nextLine());
        while (true) {
            System.out.println("Вітаємо у компанії Airlines");
            System.out.println("Ви можете скористатися нашим меню");
            System.out.println("1.Замовити квиток на літак");
            System.out.println("2.Подивитися ваші квитки");
            System.out.println("3.Вернути квиток у кассу");
            option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                System.out.println("Звідки вам потрібен літак?");
                for (int i = 0; i < townList.size(); i++) {
                    System.out.println((i + 1) + "." + townList.get(i));
                }
                option = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < townList.size(); i++) {
                    if (option - 1 == i) {
                        System.out.println("З вашого міста є такі рейси");
                        int randomSize = random.nextInt(10);
                        List<String> times = new ArrayList<String>();
                        List<String> placeOfArrival = new ArrayList<String>();
                        List<Integer> prices = new ArrayList<Integer>();
                        String randomTime;

                        for (int j = 0; j < randomSize; j++) {
                            int randomHour = random.nextInt(24);
                            int randomMinute = random.nextInt(60);
                            int randomPriceMax = random.nextInt(1000);
                            int randomPriceMin = random.nextInt(1000);
                            int randomPrice = (int) (randomPriceMax + randomPriceMin) / 2;
                            if (randomMinute < 10) {
                                randomTime = randomHour + ":" + "0" + randomMinute;
                            } else randomTime = randomHour + ":" + randomMinute;
                            int randomDay = random.nextInt(14);
                            int randomTown = random.nextInt(townList.size());
                            System.out.println("----");
                            System.out.println((j + 1) + "." + "Звідки: " + townList.get(option - 1) + "\n" +
                                    "Куди: " + townList.get(randomTown) + "\n" +
                                    "Час: " + " Через " + randomDay + " Днів" + " в " + randomTime + "\n" +
                                    "Ціна: " + randomPrice);
                            System.out.println("----");
                            placeOfArrival.add(townList.get(randomTown));
                            times.add("Через " + randomDay + " Днів" + " в " + randomTime);
                            prices.add(randomPrice);
                        }
                        System.out.println("На який рейс вам треба");
                        option = Integer.parseInt(scanner.nextLine());
                        for (int j = 0; j < randomSize; j++) {
                            if (option - 1 == j) {
                                if (money >= prices.get(j)) {
                                    tickets.add(
                                            new Ticket().setCode(random.nextInt(999999)).addNameYourTown(townList.get(i)).addPlaceOfArrival(placeOfArrival.get(j)).addTime(times.get(j)).setPrice(prices.get(j))
                                    );
                                    System.out.println("Ваш квиток");
                                    for (int k = 0; k < tickets.size(); k++) {
                                        System.out.println("---");
                                        System.out.println(tickets.get(k));
                                        System.out.println("---");
                                        myTickets.add(tickets.get(k));
                                        tickets.clear();
                                    }
                                } else {
                                    System.out.println("Не хватає грошей");
                                }
                            }
                        }
                    }
                }
            } else if (option == 2) {
                System.out.println("Гроші " + money);
                for (int j = 0; j < myTickets.size(); j++) {
                    System.out.println("---");
                    System.out.println(myTickets.get(j));
                    System.out.println("----");
                }
            }else if (option== 3){
                List<Integer> prices = new ArrayList<Integer>();
                for (Ticket entry : myTickets){
                    prices.add(entry.getPrice());
                }
                for (int i = 0; i <myTickets.size() ; i++) {
                    System.out.println("---");
                    System.out.println((i+1) + "." + myTickets.get(i));
                    System.out.println("---");
                }
                System.out.println("Який білет хочете здати?");
                int choice = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i <prices.size() ; i++) {
                    if (choice-1 == i) {
                        int moneyBack = (int) prices.get(i)/2;
                        money = money + moneyBack;
                        System.out.println("Ви продали квиток за " + moneyBack);
                    }
                }
            }
        }
    }
}
