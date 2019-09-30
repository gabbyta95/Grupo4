/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dealer.model;

/**
 *
 * @author diego
 */
public class Concessionaire {
    
    private String Name;
    private String Direcciont; 
    private String Telefono ;
    private String IdConcesionario;

    public Concessionaire(String Name, String Direcciont, String Telefono, String IdConcesionario) {
        this.Name = Name;
        this.Direcciont = Direcciont;
        this.Telefono = Telefono;
        this.IdConcesionario = IdConcesionario;
    }

    public Concessionaire() {
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDirecciont() {
        return Direcciont;
    }

    public void setDirecciont(String Direcciont) {
        this.Direcciont = Direcciont;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getIdConcesionario() {
        return IdConcesionario;
    }

    public void setIdConcesionario(String IdConcesionario) {
        this.IdConcesionario = IdConcesionario;
    }

    @Override
    public String toString() {
        return "Concecionario{" + "Name=" + Name + ", Direcciont=" + Direcciont + ", Telefono=" + Telefono + ", IdConcesionario=" + IdConcesionario + '}';
    }
}
