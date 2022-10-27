package com.dam2.javiervicedo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.lang.reflect.Field;
import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ColeccionJuegos {
    private ArrayList<juego> coleccion;
    public ColeccionJuegos()
    {
        coleccion= new ArrayList<>();
    }

    public void addjuego(juego juego)
    {
        coleccion.add(juego);
    }

    public void muestrajuego()
    {
        for(juego juego:coleccion)
            System.out.println(juego);
    }

}
