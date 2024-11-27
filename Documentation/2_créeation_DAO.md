# Crée un DAO
un dao permet d'etablir une connextion entre les requettes SQl faites sur java et la BDD.\
aller voir le code dans le package connection\
la methode exectueQuery attent une repose du serveur (ex Select * from [User])\
et la methode exectueUptade n'attend pas de reponse (ex insert ou delete).
## Explication des attributs
le premier sert a mettre en relation votre projet Java et la base de donnée.\
le deuxieme et votre id et le troisieme votre mot de passe.
## Ajout du fichier jar
Pour que le DAO marche il vous telecherger un dirver un fichier .jar ici on telecharger le jre8.jar\
Une fois telecharger sur Intellij (je code sur cette IDE) vous faite click droit sur votre proget\
puis open Module Setting \
puis librairie\
+\
java\
et la vous metter le fichier .jar telechargé.
## Test du DAO
        `Dao dao = new Dao();
        ResultSet rs;
        String rq;
        rq = "SELECT TOP (1000) [id_u]\n" +
                "      ,[nom_u]\n" +
                "      ,[prenom_u]\n" +
                "      ,[date_naissance_u]\n" +
                "      ,[date_inscription_u]\n" +
                "      ,[type_u]\n" +
                "  FROM [TaxiSimulation].[dbo].[User]";
        rs = dao.executeQuery(rq);
        while (rs.next()) {
            System.out.println(rs.getString(2));
        }`
Cela doit vousq revoyer la colone du nom
