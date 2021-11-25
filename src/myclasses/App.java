/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;


import entity.Brand;
import entity.Sneaker;
import entity.Buyer;
import entity.History;
import interfaces.Keeping;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import tools.SaverToBase;
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
    private List<Brand> brands = new ArrayList<>();
    private final Keeping saver = new SaverToBase();
    
    public App(){
    this.sneakers = saver.loadSneaker();
    this.buyers = saver.loadBuyers();
    this.histories = saver.loadHistory();
    this.brands = saver.loadBrand();
    }   

    public void run(){
        int exit=0;
        do{
            System.out.println("---------МЕНЮ---------");
            System.out.println("1. Выход из программы");
            System.out.println("2. Добавить кроссовок");
            System.out.println("3. Вывести список кроссовок");
            System.out.println("4. Добавить покупателя");
            System.out.println("5. Список покупателей");
            System.out.println("6. Покупка обуви");
            System.out.println("7. Доход магазина за все время");
            System.out.println("8. Добавить деньги пользователю");
            System.out.println("9. Поступление кроссовок");
            System.out.println("10. Вывести базу фирм кроссовок");
            System.out.println("11. Редактировать кроссовки");
            System.out.println("12. Редактировать покупателя");
            System.out.println("13. Вывести доход за определенный месяц");
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
                case 9:
                    addQuantitySneaker();
                    break;
                case 10:
                    listBrands();
                    break;
                case 11:
                    changeSneaker();
                    break;
                case 12:
                    changeBuyer();
                    break;
                case 13:
                    IncomePerMonth();
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
            System.out.printf("%d. %s %s, размер: %.0f, цена: %.2f евро, в наличии: %d%n",
            i+1,
            sneakers.get(i).getSneakerFirm().getBrand(),
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
    Brand brand = new Brand();
    System.out.print("Введите количество кроссовок для добавления: ");
    sneaker.setSneakerQuantity(getNumber()); 
    listBrands();
    int i = 0;
    while(i==0){
    System.out.print("Если в списке есть желаемая фирма, нажмите 0, если нет и вы хотите добавить фирму, нажмите 1: ");
    int choice=getNumber();
    switch (choice) {
        case 1:
            System.out.print("Введите фирму кроссовка: ");
            brand.setBrand(scan.nextLine());
            sneaker.setSneakerFirm(brand);
            brands.add(brand);
            i++;
            break;
        case 0:
            System.out.print("Введите номер нужной фирмы: ");
            int choice2=getNumber();
            sneaker.setSneakerFirm(brands.get(choice2-1));
            i++;
            break;
        default:
            System.out.println("Ошибка, наберите 0 или 1!");
            break;
    }
    }
    System.out.print("Введите модель кроссовка: ");
    sneaker.setSneakerModel(scan.nextLine());
    System.out.print("Введите размер кроссовка: ");
    sneaker.setSneakerSize(getNumber());
    System.out.print("Введите цену кроссовка: ");
    sneaker.setSneakerPrice(scan.nextDouble()); scan.nextLine();
    System.out.println("Вы добавили"+sneaker.toString());
    sneakers.add(sneaker);
    saver.saveSneaker(sneakers);
    saver.saveBrand(brands);
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
    saver.saveBuyers(buyers);
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
            history.getSneaker().getSneakerFirm().getBrand(),
            history.getSneaker().getSneakerModel(),
            history.getBuyer().getBuyerFirstName(),
            history.getBuyer().getBuyerLastName(),
            history.getSneaker().getSneakerPrice(),
            history.getGivenSneaker()
            );
            history.getBuyer().setBuyerMoney(history.getBuyer().getBuyerMoney()-history.getSneaker().getSneakerPrice());
            history.getSneaker().setSneakerQuantity(history.getSneaker().getSneakerQuantity()-1);
            histories.add(history);
            saver.saveHistory(histories);
            saver.saveSneaker(sneakers);
            saver.saveBuyers(buyers);
            
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
    double income = 0;
    System.out.println("*ОБЩИЙ ДОХОД*");
    for (int i = 0; i < histories.size(); i++) {
        Date date = histories.get(i).getGivenSneaker();
        if (histories.get(i)!=null) {
           income+=histories.get(i).getSneaker().getSneakerPrice();
        }
        
    }
    System.out.printf("Доход за все время: %s евро%n", income);
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
    saver.saveBuyers(buyers);
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
//------------------------------------------------------------------------------
private void addQuantitySneaker(){
    sneakerList();
    System.out.print("Введите номер кроссовка для добавления количества: ");
    int num=getNumber();
    System.out.print("Введите сколько пар кроссовок поступило: ");
    int add=getNumber();
    sneakers.get(num-1).setSneakerQuantity(sneakers.get(num-1).getSneakerQuantity()+add);
    saver.saveSneaker(sneakers);}
//------------------------------------------------------------------------------
private void listBrands(){
    int n =0;
    for (int i = 0; i < brands.size(); i++) {
        if(brands.get(i)!=null){
            n++;
            System.out.printf("%d. %s%n",
            i+1,
            brands.get(i).getBrand()
            );
        n++;
        }
}
    if(n==0){
        System.out.println("Фирм нет!");
    }
}
//------------------------------------------------------------------------------
private void changeSneaker(){
    System.out.println("*РЕДАКТИРОВАТЬ КРОССОВОК*");
    sneakerList();
    System.out.print("Выберите кроссовок для редактирования: ");
    int numsneaker= getNumber();
    int n = 0;
    while(n==0){
    System.out.println("-------------------------");
    System.out.println("1. Редактировать фирму кроссовка");
    System.out.println("2. Редактировать модель кроссовка");
    System.out.println("3. Редактировать размер кроссовка");
    System.out.println("4. Редактировать цену кроссовка");
    System.out.println("5. Редактировать количество кроссовк");
    System.out.println("6. Выход");
    System.out.print("Выберите номер того, что хотите конкретно изменить или выйдите: ");
    int numchange= getNumber();
    switch(numchange){
        case 1:
            listBrands();
            int i = 0;
            while(i==0){
            System.out.print("Если в списке есть желаемая фирма, нажмите 0, если нет и вы хотите добавить фирму, нажмите 1: ");
            int choice=getNumber();
            switch (choice) {
                case 1:
                    System.out.print("Введите новую фирму кроссовок: ");
                    Brand newnewBrand= new Brand();
                    String newBrand=(scan.nextLine());
                    sneakers.get(numsneaker-1).getSneakerFirm().setBrand(newBrand);
                    newnewBrand.setBrand(newBrand);
                    brands.add(newnewBrand);
                    saver.saveSneaker(sneakers);
                    saver.saveBrand(brands);
                    i++;
                    break;
                case 0:
                    System.out.print("Введите номер нужной фирмы: ");
                    int choice2=getNumber();
                    sneakers.get(numsneaker-1).setSneakerFirm(brands.get(choice2-1));
                    saver.saveSneaker(sneakers);
                    i++;
                    break;
                default:
                    System.out.println("Ошибка, наберите 0 или 1!");
                    break;
            }
            }  
            break;
        case 2:
            System.out.print("Введите новую модель кроссовок: ");
            String newaspect=(scan.nextLine());
            sneakers.get(numsneaker-1).setSneakerModel(newaspect);
            saver.saveSneaker(sneakers);
            break;
        case 3:
            System.out.print("Введите новый размер кроссовок: ");
            int newaspect2=getNumber();
            sneakers.get(numsneaker-1).setSneakerSize(newaspect2);
            saver.saveSneaker(sneakers);
            break;
        case 4:
            System.out.print("Введите новую цену кроссовок: ");
            double newaspect3=scan.nextDouble();scan.nextLine();
            sneakers.get(numsneaker-1).setSneakerPrice(newaspect3);
            saver.saveSneaker(sneakers);
            break;
        case 5:
           System.out.print("Введите новое количество кроссовок: ");
            int newaspect4=getNumber();
            sneakers.get(numsneaker-1).setSneakerQuantity(newaspect4);
            saver.saveSneaker(sneakers);
            break;
        case 6:
            System.out.println("*ВЫХОД*");
            n++;
            break;
        default:
            System.out.println("Ошибка, выберите номер из списка!");
            break;
    }
    }
}
//------------------------------------------------------------------------------
private void changeBuyer(){
    System.out.println("*РЕДАКТИРОВАТЬ ПОКУПАТЕЛЯ*");
    buyerList();
    System.out.print("Выберите покупателя для редактирования: ");
    int numbuyer= getNumber();
    int n = 0;
    while(n==0){
    System.out.println("-------------------------");
    System.out.println("1. Изменить имя покупателя");
    System.out.println("2. Изменить фамилию покупателя");
    System.out.println("3. Изменить номер телефона покупателя");
    System.out.println("4. Изменить количество денег покупателя");
    System.out.println("5. Выход");
    System.out.print("Выберите номер того, что хотите конкретно изменить или выйдите: ");
    int numchange= getNumber();
    switch(numchange){
        case 1:
            System.out.print("Введите новое имя покупателя: ");
            String newName=(scan.nextLine());
            buyers.get(numbuyer-1).setBuyerFirstName(newName);
            saver.saveBuyers(buyers);
            break;
        case 2:
            System.out.print("Введите новую фамилию покупателя: ");
            String newName2=(scan.nextLine());
            buyers.get(numbuyer-1).setBuyerLastName(newName2);
            saver.saveBuyers(buyers);
            break;
        case 3:
            System.out.print("Введите новый телефон покупателя: ");
            String newTel=(scan.nextLine());
            buyers.get(numbuyer-1).setBuyerPhone(newTel);
            saver.saveBuyers(buyers);
            break;
        case 4:
            System.out.print("Введите новое количество денег у покупателя: ");
            double newMoney=scan.nextDouble();scan.nextLine();
            buyers.get(numbuyer-1).setBuyerMoney(newMoney);
            saver.saveBuyers(buyers);
            break;
        case 5:
            System.out.println("*ВЫХОД*");
            n++;
            break;    
        default:
            System.out.println("Ошибка, выберите номер из списка!");
            break;
    }
    
}
}
//------------------------------------------------------------------------------
private void IncomePerMonth(){
    double income = 0;
    System.out.println("*ДОХОД ЗА ОПРЕДЕЛЕННЫЙ МЕСЯЦ*");
    System.out.println("1 - Январь");
    System.out.println("2 - Февраль");
    System.out.println("3 - Март");
    System.out.println("4 - Апрель");
    System.out.println("5 - Май");
    System.out.println("6 - Июнь");
    System.out.println("7 - Июль");
    System.out.println("8 - Август");
    System.out.println("9 - Сентябрь");
    System.out.println("10 - Октябрь");
    System.out.println("11 - Ноябрь");
    System.out.println("12 - Декабрь");
    System.out.print("Введите нужный месяц: ");
    int choicemonth=getNumber()-1;
    System.out.print("Введите год: ");
    int years=getNumber();
    for (int i = 0; i < histories.size(); i++) {
        Date date = histories.get(i).getGivenSneaker();
        boolean toSum = summator(date, choicemonth, years);
        if (histories.get(i)!=null & toSum) {
           income+=histories.get(i).getSneaker().getSneakerPrice();
        }
        
    }
    System.out.printf("Доход за выбранный месяц: %s евро%n", income);
}
    private boolean summator(Date date, int choicemonth, int years) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        if(month==choicemonth && year==years){
            return true;
    }
        return false;
    }
}



