# Créeation des services des Class
Code dispo dans le package Class\
Les Services permettent d'excuter les fonctions.\
Pour avoir plus de presion et aucun oublie de fonction ou va aussi crée des Interfaces.\
Une Interfaces permet d'obliger une Class a possedé les methode rentrer dans l'interfaces (code dispo dans Interfaces).
## Créeation Services pour UserServices et DriverServices
Une fois les interfaces implementer : `public class UserService implements UserInterface`\
on doit ecrire tout les methodes dans la class.\
**Explication des methodes**\
on implemente un dao qui va permettre d'executer des requettes sql\
puis un variable ResultSet qui permet de recupére les valeur retourner dans requette SQl\
`if (rs.next())` permet de passer a la ligne des resultat si ils existent\
`while (rs.next())` permet de parcourir chaque ligne du resultat retourné 1 par 1\
**Requette Sql**\
`Top (n)` requpére les n premiere ligne de la requette \
`Group by parmas` groupe les resultat avec le parms rentrer \
`order by` desc ou asc ordonne les donnée croissante ou decroissante \
`SUM(colo)` fait la somme des valeurs de la colone.


