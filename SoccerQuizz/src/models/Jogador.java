package models;
public class Jogador implements java.io.Serializable {
private String username;
private String senha;
private int pontuacaoIndividual;
private Perfil perfil;

    public Jogador() {
        perfil = new Perfil();
    }
    
    

public void setUsername(String username){
this.username=username;
}

public void setSenha(String senha){
this.senha=senha;
}

public void setPontuacaoIndividual(int pontuacaoIndividual){
this.pontuacaoIndividual=pontuacaoIndividual;
}

public void setPerfil(Perfil perfil){
this.perfil=perfil;
}


public String getUsername(){
return this.username;
}

public String getSenha(){
return this.senha;
}

public int getPontuacaoIndividual(){
return this.pontuacaoIndividual;
}

public Perfil getPerfil(){
return this.perfil;
}

@Override
    public String toString() {
        return ""
+ " - " + username+ " - " + senha+ " - " + pontuacaoIndividual+ " - " + perfil;
}
}
