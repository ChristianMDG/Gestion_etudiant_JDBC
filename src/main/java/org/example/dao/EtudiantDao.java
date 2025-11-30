package org.example.dao;

import org.example.model.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDao {
   DbConnection dbConnection = new DbConnection();
    public void addEtudiant(Etudiant etudiant)
    {
        String sql = "insert into etudiant (id, nom, email, age) values (?,?,?,?)";

        try(Connection con = dbConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql)){
            preparedStatement.setInt(1,etudiant.getId());
            preparedStatement.setString(2,etudiant.getNom());
            preparedStatement.setString(3,etudiant.getEmail());
            preparedStatement.setInt(4,etudiant.getAge());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("erreur etudiant");
        }
    }

    public List<Etudiant> getEtudiants(){
        List<Etudiant> listeEtudiants = new ArrayList<>();
        String sql = "select * from etudiant order by nom";

        try(Connection con = dbConnection.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                listeEtudiants.add(new Etudiant(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("email"),
                        resultSet.getInt("age")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("erreur etudiant");
        }
        return listeEtudiants;
    }

    public void updateEtudiant(Etudiant etudiant)
    {
        String updateSql = "update etudiant set nom=?, email=?, age=? where id=?";

        try (Connection connection= dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            preparedStatement.setString(1,etudiant.getNom());
            preparedStatement.setString(2,etudiant.getEmail());
            preparedStatement.setInt(3,etudiant.getAge());
            preparedStatement.setInt(4,etudiant.getId());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("erreur etudiant");
        }
    }

    public void deleteEtudiant(int id)
    {
        String deleteSql = "delete from etudiant where id=?";

        try (Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("erreur etudiant");
        }
    }
}
