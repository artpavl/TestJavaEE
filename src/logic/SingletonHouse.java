package logic;

import logic.Observer.Observed;
import logic.Observer.Observer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingletonHouse implements Observed {
    private int name;
    private static SingletonHouse instance;

    private List<Integer> list = new ArrayList<>(3);// Колличество комнат по умолчанию 3
    Set<Observer> subscribers = new HashSet<>();

    public static synchronized SingletonHouse getInstance() {
        if (instance == null) {
            instance = new SingletonHouse();
            instance.setList();
        }
        return instance;
    }

    public int getName() {
        return name;
    }
    public void setName(int name) {
        this.name = name;
    }


    // по умолчанию свет во всех комнатах выключен
    void setList() {
        list.add(0, 0);
        list.add(1, 0);
        list.add(2, 0);

    }

    //Состояние света в комноте
    public synchronized String getState(int i) {
        return list.get(i).toString();
    }

    public synchronized int[] getArray() {
        int[] b = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    public synchronized void change(int i) {
        if (list.get(i) == 1) {
            list.set(i, 0);
        } else {
            list.set(i, 1);
        }
        notifyObservers();
    }


    @Override
    public void addObserver(Observer observer) {
        this.subscribers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        this.subscribers.remove(observer);

    }

    @Override
    public void notifyObservers() {
        for (Observer observer : subscribers) {
            observer.handleEvent(list);
        }
    }


}




