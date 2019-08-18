package models;
public class Perfil implements java.io.Serializable {
private String nome;
private String sobrenome;
private String email;
private String pais;

public void setNome(String nome){
this.nome=nome;
}

public void setSobrenome(String sobrenome){
this.sobrenome=sobrenome;
}

public void setEmail(String email){
this.email=email;
}

public void setPais(String pais){
this.pais=pais;
}


public String getNome(){
return this.nome;
}

public String getSobrenome(){
return this.sobrenome;
}

public String getEmail(){
return this.email;
}

public String getPais(){
return this.pais;
}

@Override
    public String toString() {
        return ""
+ " - " + nome+ " - " + sobrenome+ " - " + email+ " - " + pais;
}
}
