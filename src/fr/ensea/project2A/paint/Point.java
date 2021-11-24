package fr.ensea.project2A.paint;

import java.io.Serializable;

public class Point implements Serializable {
    int X;
    int Y;

    public Integer getX() {
        return X;
    }

    public Integer getY() {
        return Y;
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public Point(){
        X=0;
        Y=0;
    }
    public Point(int a, int b){
        X=a;
        Y=b;
    }

    @Override
    public String toString() {
        return "Point{ X=" + X +", Y=" + Y +'}';
    }
}
