package com.kalanso2manu.IdeeFinancementProjet.payload.Autres;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.kalanso2manu.IdeeFinancementProjet.Modeles.Projets;
import org.springframework.web.multipart.MultipartFile;

public class SaveImage {

    public static String localhost = "http://127.0.0.1/";
    public static String serveruser = localhost + "IdeeFinancementProjet/images/utilisateur/";
    public static String serverprojets = localhost + "IdeeFinancementProjet/images/projets/";


    public static String Projetslocation = "C:/xampp/htdocs/IdeeFinancementProjet/images/projets/";
    public static String Userlocation = "C:/xampp/htdocs/IdeeFinancementProjet/images/utilisateur/";


    public static String save(String typeImage, MultipartFile file, String fileName) {
        String src = "";
        String server = "";
        String location = "";
        if (typeImage == "user") {
            location = Userlocation;
            server = serveruser;
        } else {
            location = Projetslocation;
            server = serverprojets;

        }

        try {
            Path filePath = Paths.get(location + fileName);

            if (!Files.exists(filePath)) {
                Files.createDirectories(filePath.getParent());
                Files.copy(file.getInputStream(), filePath);
                src = server + fileName ;
            } else {
                Files.delete(filePath);
                Files.copy(file.getInputStream(), filePath);
                src = server + fileName ;
            }
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
            src = null;
        }

        return src;
    }



}