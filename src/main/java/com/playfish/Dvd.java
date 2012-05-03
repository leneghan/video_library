package com.playfish;


import java.util.ArrayList;

public class Dvd {

    private final ArrayList<Copy> copies = new ArrayList<Copy>();

    public Dvd(String title, String year, String director) {
        Copy copy = new Copy();
        copies.add(copy);
    }

    public boolean isAvailable() {
        return copies.get(copies.size() - 1).isAvailable();
    }


}
