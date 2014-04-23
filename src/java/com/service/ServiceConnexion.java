package com.service;
import com.dao.DaoPostgre;
import com.domaine.Compte;
import com.domaine.OperationCompte;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class ServiceConnexion {
    
    public String[] getUser(String prmUser, String prmPasswd) throws SQLException {
        
        String[] retour = new String[10];
        
        try {
            ResultSet result = DaoPostgre.getUser(prmUser, encode(prmPasswd));
        
            while(result.next()) {
                retour[1] = result.getString("name");
                retour[2] = result.getString("nummembre");
                retour[3] = result.getString("role");
            }
            
        } catch (SQLException se) {
               //retour.add(1,"TEST !!");
               //retour.add(2,"PASS !!");
        }
        
        DaoPostgre.close();
        
        return retour ;
    }
        
    private String encode(String password)
    {
        byte[] uniqueKey = password.getBytes();
        byte[] hash      = null;

        try {
            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
        } catch (NoSuchAlgorithmException e) {
            throw new Error("No MD5 support in this VM.");
        }

        StringBuilder hashString = new StringBuilder();
        for (int i = 0; i < hash.length; i++)
        {
            String hex = Integer.toHexString(hash[i]);
            if (hex.length() == 1)
            {
                hashString.append('0');
                hashString.append(hex.charAt(hex.length() - 1));
            }
            else
                hashString.append(hex.substring(hex.length() - 2));
        }
        return hashString.toString();
    }
  
    
}