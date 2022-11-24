/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Jogo;


public class JDBCJogo {
    
    Connection conexao;

    public JDBCJogo(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void inserirJogo(Jogo b){
        String sql = "insert into jogo(nome, genero, empresa) values(?, ?, ?)";
        PreparedStatement ps; 
        
        try{
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1, b.getNome());
            ps.setString(2, b.getGenero());
            ps.setString(3, b.getEmpresa());
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Jogo> listarJogos(){
        ArrayList<Jogo> jogos = new ArrayList<Jogo>();
        String sql = "select * from jogo";
        
        try{
            Statement declaracao = conexao.createStatement();
            ResultSet resposta = declaracao.executeQuery(sql);
            
            while(resposta.next()){             
                int id = resposta.getInt("id");
                String nome = resposta.getString("nome");
                String genero = resposta.getString("genero");
                String empresa = resposta.getString("empresa");
               
                
                Jogo b = new Jogo(id, nome, genero, empresa);
                jogos.add(b);
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        return jogos;
    }
    
    public void apagarTudo(){
       String sql = "delete from jogo" ;
       PreparedStatement ps;
       
       try{
           ps = this.conexao.prepareStatement(sql);
           ps.execute();
       }catch (SQLException e){
            e.printStackTrace();
       }
    }
    
    
    
    public void editar(Jogo b){
        String sql = "UPDATE jogo SET nome = ?, genero = ?, empresa = ? WHERE id = ?";
        PreparedStatement ps;
        
        try{
           ps = this.conexao.prepareStatement(sql);
           ps.setString(1, b.getNome());
           ps.setString(2, b.getGenero());
           ps.setString(3, b.getEmpresa());
           ps.setInt(4, b.getId());
           ps.execute();
       }catch (SQLException e){
            e.printStackTrace();
       }      
    }
    public void editarNome(Jogo b){
        String sql = "UPDATE jogo SET nome = ? WHERE id = ?";
        PreparedStatement ps;
        
        try{
           ps = this.conexao.prepareStatement(sql);
           ps.setString(1, b.getNome());
           ps.setInt(2, b.getId());
           ps.execute();
       }catch (SQLException e){
            e.printStackTrace();
       }     
    }
    
    public void editarGenero(Jogo b){
        String sql = "UPDATE jogo SET genero = ? WHERE id = ?";
        PreparedStatement ps;
        
        try{
           ps = this.conexao.prepareStatement(sql);
           ps.setString(1, b.getGenero());
           ps.setInt(2, b.getId());
           ps.execute();
       }catch (SQLException e){
            e.printStackTrace();
       }     
    }
    
    public void editarEmpresa(Jogo b){
        String sql = "UPDATE jogo SET empresa = ? WHERE id = ?";
        PreparedStatement ps;
        
        try{
           ps = this.conexao.prepareStatement(sql);
           ps.setString(1, b.getEmpresa());
           ps.setInt(2, b.getId());
           ps.execute();
       }catch (SQLException e){
            e.printStackTrace();
       }     
    }

}
