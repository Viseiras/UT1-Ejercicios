package com.dam2.javiervicedo;

public class juego {

    private String nombre;
    private  int anyo;

    private String estudio;

    public juego()
    {

    }

    public juego(String nombre, int anyo, String estudio)
    {
        this.nombre=nombre;
        this.anyo=anyo;
        this.estudio=estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString() {
        return "juego{" +
                "nombre='" + nombre + '\'' +
                ", anyo=" + anyo +
                ", estudio='" + estudio + '\'' +
                '}';
    }
}
















