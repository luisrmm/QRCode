package com.example.myapplication.models;

public class planilla {
    String Cuidad, ID, Nombre, Pais, Salario;

    public planilla(String cuidad, String ID, String nombre, String pais, String salario) {
        Cuidad = cuidad;
        this.ID = ID;
        Nombre = nombre;
        Pais = pais;
        Salario = salario;
    }

    public planilla() {

    }


    public String getCuidad() {
        return Cuidad;
    }

    public void setCuidad(String cuidad) {
        Cuidad = cuidad;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public String getSalario() {
        return Salario;
    }

    public void setSalario(String salario) {
        Salario = salario;
    }
}
