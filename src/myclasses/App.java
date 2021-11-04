/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import entity.Sneaker;
import entity.Buyer;
import java.util.Scanner;

/**
 *
 * @author krasa
 */
public class App {
    private final Sneaker[] sneakers= new Sneaker[10];
    private final Buyer[] buyers= new Buyer[10];
    public void run(){
        int exit=0;
        do{
            System.out.println("---------МЕНЮ---------");
            System.out.println("1. Выход из программы");
            System.out.println("2. Добавить кроссовок");
            System.out.println("3. Список продаваемых кроссовок");
            System.out.println("4. Добавить покупателя");
            System.out.print("Выберите задачу: ");
            Scanner scan = new Scanner(System.in);
            int task= scan.nextInt(); scan.nextLine();
            switch(task){
                case 1:
                    exit++;
                    break;
                case 2:
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
                    for (int i = 0; i < sneakers.length; i++) {
                        if(sneakers[i]==null){
                            sneakers[i]=sneaker;
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("*СПИСОК КРОССОВОК*");
                    for (int i = 0; i < sneakers.length; i++) {
                        if(sneakers[i]!=null){
                            System.out.printf("%d. %s %s, размер: %.1f, цена: %.2f евро%n",
                            i+1,
                            sneakers[i].getSneakerFirm(),
                            sneakers[i].getSneakerModel(),
                            sneakers[i].getSneakerSize(),
                            sneakers[i].getSneakerPrice()
                            );
                        }
                    }
                case 4:
                    System.out.println("*ДОБАВЛЕНИЕ ПОКУПАТЕЛЯ*");
                    Buyer buyer= new Buyer();
                    System.out.print("Введите имя покупателя:");
                    buyer.setBuyerFirstName(scan.nextLine());
                    System.out.print("Введите фамилию покупателя:");
                    buyer.setBuyerLastName(scan.nextLine());
                    System.out.print("Введите номер телефона покупателя:");
                    buyer.setBuyerPhone(scan.nextLine());
                    System.out.print("Введите количество денег у покупателя:");
                    buyer.setBuyerMoney(scan.nextDouble()); scan.nextLine();
                    System.out.println("Вы добавили "+buyer.toString());
                    for (int i = 0; i < buyers.length; i++) {
                        if(buyers[i]==null){
                            buyers[i]=buyer;
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("*СПИСОК ПОКУПАТЕЛЕЙ*");
                    for (int i = 0; i < buyers.length; i++) {
                        if(buyers[i]!=null){
                            System.out.printf("%d. %s %s, номер телефона: %s, доступные деньги: %f евро%n",
                            i+1,
                            buyers[i].getBuyerFirstName(),
                            buyers[i].getBuyerLastName(),
                            buyers[i].getBuyerPhone(),
                            buyers[i].getBuyerMoney()
                            );
                        }
                        
                    }
                default:
                    System.out.println("Выберите номер из списка!");
            }

        }while(exit==0);
        System.out.println("*ВЫХОД*");
    }
}

