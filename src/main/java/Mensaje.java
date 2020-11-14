
import java.io.Serializable;
import java.util.Date;
import javax.swing.JList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cathy
 */
public class Mensaje implements Serializable{

    /**
     * @return the no_registro
     */
    public int getNo_registro() {
        return no_registro;
    }

    /**
     * @param no_registro the no_registro to set
     */
    public void setNo_registro(int no_registro) {
        this.no_registro = no_registro;
    }

    /**
     * @return the izq
     */
    public int getIzq() {
        return izq;
    }

    /**
     * @param izq the izq to set
     */
    public void setIzq(int izq) {
        this.izq = izq;
    }

    /**
     * @return the der
     */
    public int getDer() {
        return der;
    }

    /**
     * @param der the der to set
     */
    public void setDer(int der) {
        this.der = der;
    }

    /**
     * @return the emisor
     */
    public String getEmisor() {
        return emisor;
    }

    /**
     * @param emisor the emisor to set
     */
    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    /**
     * @return the receptor
     */
    public String getReceptor() {
        return receptor;
    }

    /**
     * @param receptor the receptor to set
     */
    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the Mensaje
     */
    public String getMensaje() {
        return Mensaje;
    }

    /**
     * @param Mensaje the Mensaje to set
     */
    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    /**
     * @return the adjunto
     */
    public String getAdjunto() {
        return adjunto;
    }

    /**
     * @param adjunto the adjunto to set
     */
    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

    /**
     * @return the estatus
     */
    public int getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    //izq y der son el numero de registro del usuario
    private int no_registro;
    private int izq;
    private int der;
    private String emisor;
    private String receptor;
    private Date fecha;
    private String asunto;
    private String Mensaje;
    private String adjunto;
    private int estatus;
    
    public String toString(){
    return "Registro: "+no_registro+"|"+"Izq: "+izq+"|"+"Der: "+der+"|"+"Emisor: "+emisor+"|"+"Receptor: "+receptor+"|"+
            "Fech_transac: "+fecha+"|"+"Asunto:"+asunto+"|"+"Mensaje: "+Mensaje+"|"+"Adjunto: "+adjunto+"|"+"Estatus: "+estatus+"|";
    }

   
}
