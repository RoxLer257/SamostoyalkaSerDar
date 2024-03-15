package com.example.samostoyalkaserdar;

public class Fruits {

    private long ID;
    private String Name;
    private int Quan;

    Fruits(long ID, String Name, int Quan){ this.ID = ID;
        this.Name = Name; this.Quan = Quan;
    }
    public long getId() { return ID;
    }
    public String getName() { return Name;
    }

    public void setName(String Name) { this.Name = Name;
    }

    public int getQuan() { return Quan;
    }

    public void setQuan(int Quan) { this.Quan = Quan;
    }

    @Override
    public String toString() {
        return this.Name + " : " + this.Quan;
    }
}
