/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import entity.Sneaker;
import entity.Buyer;
import entity.History;
import entity.Income;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author krasa
 */
public class App {
    Scanner scan = new Scanner(System.in);
    private final List<Sneaker> sneakers= new ArrayList<>();
    private final List<Buyer> buyers= new ArrayList<>();
    private final List<History> histories= new ArrayList<>();
    Income income = new Income();
    public void run(){
        int exit=0;
        do{
            System.out.println("---------МЕНЮ---------");
            System.out.println("1. Выход из программы");
            System.out.println("2. Добавить кроссовок");
            System.out.println("3. Список продаваемых кроссовок");
            System.out.println("4. Добавить покупателя");
            System.out.println("5. Список покупателей");
            System.out.println("6. Покупка обуви");
            System.out.println("7. Доход магазина за все время");
            System.out.print("Выберите задачу: ");
            int task= scan.nextInt(); scan.nextLine();
            switch(task){
                case 1:
                    exit++;
                    break;
                case 2:
                    addSneaker();
                    break;
                case 3:
                    sneakerList();
                    break;
                case 4:
                    addBuyer();
                    break;
                case 5:
                    buyerList();
                    break;
                case 6:
                    purchase();
                    break;
                case 7:
                    income();
                    break;
                default:
                    System.out.println("Выберите номер из списка!");
            }

        }while(exit==0);
        System.out.println("*ВЫХОД*");
    }
//------------------------------------------------------------------------------
private void sneakerList(){
    System.out.println("*СПИСОК КРОССОВОК*");
    int n=0;
    for (int i = 0; i < sneakers.size(); i++) {
        if(sneakers.get(i)!=null){
            System.out.printf("%d. %s %s, размер: %.1f, цена: %.2f евро%n",
            i+1,
            sneakers.get(i).getSneakerFirm(),
            sneakers.get(i).getSneakerModel(),
            sneakers.get(i).getSneakerSize(),
            sneakers.get(i).getSneakerPrice()
            );
            n++;
        }
    }  
    if(n<1){
        System.out.println("Кроссовок нет!");
    }
}
//------------------------------------------------------------------------------
private void buyerList(){
    System.out.println("*СПИСОК ПОКУПАТЕЛЕЙ*");
    int n=0;
    for (int i = 0; i < buyers.size(); i++) {
        if(buyers.get(i)!=null){
            System.out.printf("%d. %s %s, номер телефона: %s, доступные деньги: %.2f евро%n",
            i+1,
            buyers.get(i).getBuyerFirstName(),
            buyers.get(i).getBuyerLastName(),
            buyers.get(i).getBuyerPhone(),
            buyers.get(i).getBuyerMoney()
            );
            n++;
        }
    } 
    if(n<1){
        System.out.println("Покупателей нет!");
    }
}
//------------------------------------------------------------------------------
private void addSneaker(){
    System.out.println("*ДОБАВЛЕНИЕ КРОССОВКА*");
    Sneaker sneaker= new Sneaker();
    System.out.print("Введите фирму кроссовка: ");
    sneaker.setSneakerFirm(scan.nextLine()); 
    System.out.print("Введите модель кроссовка: ");
    sneaker.setSneakerModel(scan.nextLine());
    System.out.print("Введите размер кроссовка: ");
    sneaker.setSneakerSize(scan.nextDouble()); scan.nextLine();
    System.out.print("Введите цену кроссовка: ");
    sneaker.setSneakerPrice(scan.nextDouble()); scan.nextLine();
    System.out.println("Вы добавили"+sneaker.toString());
    sneakers.add(sneaker);
}  
//------------------------------------------------------------------------------
private void addBuyer(){
    System.out.println("*ДОБАВЛЕНИЕ ПОКУПАТЕЛЯ*");
    Buyer buyer= new Buyer();
    System.out.print("Введите имя покупателя: ");
    buyer.setBuyerFirstName(scan.nextLine());
    System.out.print("Введите фамилию покупателя: ");
    buyer.setBuyerLastName(scan.nextLine());
    System.out.print("Введите номер телефона покупателя: ");
    buyer.setBuyerPhone(scan.nextLine());
    System.out.print("Введите количество денег у покупателя: ");
    buyer.setBuyerMoney(scan.nextDouble()); scan.nextLine();
    System.out.println("Вы добавили "+buyer.toString());
    buyers.add(buyer);
}
//------------------------------------------------------------------------------
private void purchase(){
    System.out.println("*ПОКУПКА ОБУВИ*"); 
    System.out.println("-----------------------------");
    sneakerList();
    System.out.print("Выберите нужную модель обуви:");
    int sneakerNum= scan.nextInt(); scan.nextLine();
    System.out.println("-----------------------------");
    buyerList();
    System.out.print("Выберите нужного покупателя: ");
    int buyerNum= scan.nextInt(); scan.nextLine();
    History history= new History();
    history.setSneaker(sneakers.get(sneakerNum-1));
    history.setBuyer(buyers.get(buyerNum-1));
    Calendar c = new GregorianCalendar();
    history.setGivenSneaker(c.getTime());
    if(history.getBuyer().getBuyerMoney()>=history.getSneaker().getSneakerPrice()){
        System.out.println("-----------------------------");
        System.out.printf("Кроссовки %s %s купил %s %s за %.2f евро %s%n",
        history.getSneaker().getSneakerFirm(),
        history.getSneaker().getSneakerModel(),
        history.getBuyer().getBuyerFirstName(),
        history.getBuyer().getBuyerLastName(),
        history.getSneaker().getSneakerPrice(),
        history.getGivenSneaker()
        );
        history.getBuyer().setBuyerMoney(history.getBuyer().getBuyerMoney()-history.getSneaker().getSneakerPrice());
        income.setGeneralMoney(income.getGeneralMoney()+history.getSneaker().getSneakerPrice());
        histories.add(history);
    }else{
        System.out.println("Этот пользователь не может совершить покупку, так как у него не хватает денег!");
}
}   
//------------------------------------------------------------------------------
private void income(){
    System.out.println("*ДОХОД МАГАЗИНА*");
    System.out.printf("Выручка магазина составляет: %.2f%n",income.getGeneralMoney());
}
}


