package br.com.cronopedia.paginasapi.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pagina {
    private static int idCounter = 0;
    private int id;
    private String titulo;
    private String autor;
    private Date date = new Date();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    private String data;
    private String resumo;
    private String conteudo;
    // private String assuntos; // -> "titulo, algum termo, outro termo"
    private ArrayList<String> assuntos;

    public Pagina() {
        this.id = ++Pagina.idCounter;
        this.data = formatter.format(date);
    }

    public Pagina(String titulo, String autor, String resumo, String conteudo, String assuntos) {

        this.id = ++Pagina.idCounter;
        this.data = formatter.format(date);
        this.titulo = titulo;
        this.autor = autor;
        this.resumo = resumo;
        this.conteudo = conteudo;
        this.assuntos = new ArrayList<>();
        this.assuntos.add(titulo);
        this.assuntos.add(assuntos);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSeguidores() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    // Usando String (Simulando regex)
    // public void setAssunto(String assuntos) {
    // this.assuntos = assuntos;
    // }

    // public void addAssunto(String termo) {
    // this.assuntos += ", " + termo;
    // }

    // public void removeAssunto(String termoToRemove, String termoToAdd) {
    // this.assuntos.replaceAll(termoToRemove, termoToAdd);
    // }

    // public String getAssuntos() {
    // return assuntos;
    // }

    // Usando Array
    public void addAssunto(String termo) {
        this.assuntos.add(termo);
    }

    public void removeAssunto(String termoToRemove) {
        this.assuntos.remove(termoToRemove);
    }

    public ArrayList<String> getAssuntos() {
        return assuntos;
    }

    // Termos identicos
    public Boolean relecionada(String assunto) {
        if (this.getAssuntos().contains(assunto)) {
            return true;
        }

        return false;
    }

    public Boolean relacionadaRX(String assunto) {
        // Criando um regex de busca
        Pattern pattern = Pattern.compile(assunto, Pattern.CASE_INSENSITIVE);

        for (int i = 0; i < this.assuntos.size(); i++) {
            Matcher matcher = pattern.matcher(this.assuntos.get(i));

            // percorrendo os matches
            while (matcher.find()) {
                // return
                return true;
            }
        }

        return false;
    }

}
