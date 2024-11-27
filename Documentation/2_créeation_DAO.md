# Crée un DAO
un dao permet d'etablir une connextion entre les requettes SQl faites sur java et la BDD.\
aller voir le code dans le package connection\
la methode exectueQuery attent une repose du serveur (ex Select * from [User])\
et la methode exectueUptade n'attend pas de reponse (ex insert ou delete).
## Explication des attributs
le premier sert a mettre en relation votre projet Java et la base de donnée.\
le deuxieme et votre id et le troisieme votre mot de passe.
