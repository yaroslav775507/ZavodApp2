package com.example.zavodapp.Inzener;
//Составление списка деталей для сборки
public class Roster {
    public String id,ComplDetalls,prod1,prod2,prod3,prod4,prod5;
    public Roster(){
    }
    public Roster(
            String id, String complDetalls, String prod1, String prod2, String prod3, String prod4, String prod5) {
        this.id = id;
        this.ComplDetalls = complDetalls;
        this.prod1 = prod1;
        this.prod2 = prod2;
        this.prod3 = prod3;
        this.prod4 = prod4;
        this.prod5 = prod5;
    }
}
