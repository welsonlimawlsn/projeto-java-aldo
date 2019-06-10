
package br.edu.unieuro.projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

            private long id;
            private String nome;
            private String sobrenome;
            private String email;
            private String senha;
            static Scanner ler = new Scanner(System.in);
            static ArrayList <Usuario> usuarios = new ArrayList<>();
    public static void cadastroUsuario(){
      
       Usuario usuario = new Usuario();
       
          System.out.println("**CADASTRO DE USUÁRIO**");
          System.out.println("Isira o nome do usuário: ");
          usuario.setNome(ler.nextLine());
          System.out.println("Isira o sobrenome do usuário: ");
          usuario.setSobrenome(ler.nextLine());
          System.out.println("insira o email do usuário: ");
          usuario.setEmail(ler.nextLine());
          System.out.println("Crie uma senha: ");
          usuario.setSenha(ler.nextLine());
          usuarios.add(usuario);
          
      }
    
    public static void imprimirUsuarios(){
        for(int i = 0; i< usuarios.size();i++){
            System.out.println (usuarios.get(i));
        }
    }
    
         public long getId(){
            return id;
        }
         public void setId(long id){
             this.id = id;
         }
         
         //Cadastro nome
        public String getNome(){
            return nome;
        }
        public void setNome(String nome){
            this.nome = nome;
        }
        //Cadastro sobrenome
        public String getSobrenome(){
            return sobrenome;
        }
        public void setSobrenome(String sobrenome){
            this.sobrenome = sobrenome;
        }
        public String getEmail(){
            return email;
        }
        public void setEmail (String email){
            this.email = email;
        }
        public String getSenha(){
            return senha;
        }
        public void setSenha (String senha){
            this.senha = senha;
        }   

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", senha=" + senha + '}';
    }
        
}

