/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Buyer;
import entity.History;
import entity.Income;
import entity.Sneaker;
import java.util.List;

/**
 *
 * @author Deniss
 */
public interface Keeping {
    public void saveSneaker(List<Sneaker> sneakers);
    public List<Sneaker> loadSneaker();
    public void saveBuyers(List<Buyer> buyers);
    public List<Buyer> loadBuyers();
    public void saveHistory(List<History> histories);
    public List<History> loadHistory();
    public void saveIncome(List<Income> incomes);
    public List<Income> loadIncome();
}
