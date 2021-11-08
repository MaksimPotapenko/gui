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
import tools.SaverToFiles;


/**
 *
 * @author krasa
 */
public class App {
    Scanner scan = new Scanner(System.in);
    private List<Sneaker> sneakers= new ArrayList<>();
    private List<Buyer> buyers= new ArrayList<>();
    private List<History> histories= new ArrayList<>();
    private final SaverToFiles saverToFiles = new SaverToFiles();
    Income income = new Income();
    
    public App(){
    sneakers = saverToFiles.loadSneaker();
    buyers = saverToFiles.loadBuyers();
    histories = saverToFiles.loadHistory();
    }   

    public void run(){
        int exit=0;
        do{
            System.out.println("---------МЕНЮ---------");
            System.out.println("1. Выход из программы");
            System.out.println("2. Добавить кроссовок");
            System.out.println("3. Вывести список кроссовок");
            System.out.println("3. Список продаваемых кроссовок");
            System.out.println("4. Добавить покупателя");
            System.out.println("5. Список покупателей");
            System.out.println("6. Покупка обуви");
            System.out.println("7. Доход магазина за все время");
            System.out.println("8. Добавить деньги пользователю");
            System.out.print("Выберите задачу: ");
            int task= getNumber();
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
                case 8:
                    addMoney();
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
            System.out.printf("%d. %s %s, размер: %.1f, цена: %.2f евро, в наличии: %d%n",
            i+1,
            sneakers.get(i).getSneakerFirm(),
            sneakers.get(i).getSneakerModel(),
            sneakers.get(i).getSneakerSize(),
            sneakers.get(i).getSneakerPrice(),
            sneakers.get(i).getSneakerQuantity()
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
    System.out.print("Введите количество кроссовок для добавления: ");
    sneaker.setSneakerQuantity(getNumber()); 
    System.out.print("Введите фирму кроссовка: ");
    sneaker.setSneakerFirm(scan.nextLine()); 
    System.out.print("Введите модель кроссовка: ");
    sneaker.setSneakerModel(scan.nextLine());
    System.out.print("Введите размер кроссовка: ");
    sneaker.setSneakerSize(getNumber());
    System.out.print("Введите цену кроссовка: ");
    sneaker.setSneakerPrice(scan.nextDouble()); scan.nextLine();
    System.out.println("Вы добавили"+sneaker.toString());
    sneakers.add(sneaker);
    saverToFiles.saveSneaker(sneakers);
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
    saverToFiles.saveBuyers(buyers);
}
//------------------------------------------------------------------------------
private void purchase(){
    System.out.println("*ПОКУПКА ОБУВИ*"); 
    System.out.println("-----------------------------");
    buyerList();
    System.out.print("Выберите нужного покупателя: ");
    int buyerNum= getNumber();
    System.out.println("-----------------------------");
    int n=0;
    while(n==0){
        sneakerList();
        System.out.print("Выберите нужную модель обуви: ");
        int sneakerNum= getNumber();
        History history= new History();
        history.setSneaker(sneakers.get(sneakerNum-1));
        history.setBuyer(buyers.get(buyerNum-1));
        Calendar c = new GregorianCalendar();
        history.setGivenSneaker(c.getTime());
        if(history.getBuyer().getBuyerMoney()>=history.getSneaker().getSneakerPrice() && history.getSneaker().getSneakerQuantity()!=0){
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
            history.getSneaker().setSneakerQuantity(history.getSneaker().getSneakerQuantity()-1);
            histories.add(history);
            saverToFiles.saveHistory(histories);
            n++;
        }else if(history.getBuyer().getBuyerMoney()<history.getSneaker().getSneakerPrice()){
            System.out.println("Этот пользователь не может совершить покупку, так как у него не хватает денег на этот товар, выберите другой товар!");   
        }else if(history.getSneaker().getSneakerQuantity()==0){
            System.out.println("Этого товара нет в наличии, выберите другой!");
        }
    }   
}   
//------------------------------------------------------------------------------
private void income(){
    System.out.println("*ДОХОД МАГАЗИНА*");
    System.out.printf("Выручка магазина составляет: %.2f евро%n",income.getGeneralMoney());
}
//------------------------------------------------------------------------------
private void addMoney(){
    System.out.println("*ДОБАВИТЬ ДЕНЬГИ ПОКУПАТЕЛЮ*");
    buyerList();
    System.out.print("Выберите нужного покупателя: ");
    int choice= getNumber();
    System.out.print("Введите сколько денег вы хотите добавить этому покупателю: ");
    double add= scan.nextDouble(); scan.nextLine();
    buyers.get(choice-1).setBuyerMoney(buyers.get(choice-1).getBuyerMoney()+add);
    saverToFiles.saveBuyers(buyers);
    }
//------------------------------------------------------------------------------
private int getNumber(){
    int number;
    int number2;
    do{
        String strNumber= scan.nextLine();
        try{
            number= Integer.parseInt(strNumber);
            number2=0;
            return number;
        }catch(NumberFormatException e){
            System.out.print("Введено \""+strNumber+"\". Выбирайте номер: ");
        }catch(IllegalArgumentException e){
            System.out.println("0");
        }
    }while(true);
}
//------------------------------------------------------------------------------5
}



