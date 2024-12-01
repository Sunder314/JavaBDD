# Class Course 
on va mtn creer un Class course comme fait précedemment pour les User Driver.\
je vous laisser allez voir le code pour miuex comprendre, mais la aussi j'ai incrementer auto le id et le datetime de la commande.\
## Class CourService 
J'ai tout d'abord fait le crud sans le Update comme pour les classes precedente mais j'ai rajouté d'autre fonction.\

### 1. `distanceClient(int id)`

Calcule la distance totale parcourue par un client spécifique en fonction de son identifiant (`id`).

- **Paramètres** :
  - `id` (*int*) : Identifiant unique du client.
  
- **Retourne** :
  - `float` : La somme des distances parcourues par le client.
  - `-2` : Si aucune donnée n'est trouvée pour le client.

- **Exceptions** :
  - `SQLException` : Si une erreur survient lors de l'exécution de la requête SQL.

#### Exemple d'utilisation :
```java
float distance = distanceClient(101);
System.out.println("Distance totale parcourue : " + distance + " km");
