# Rendu TP intégrateur

### Participants

 - Esteban BARNEAUD

 - Sylvain JOUBERT

 - Oliver MINEAU

 - Antoine SAUZEAU

 - Lucas SUBE


--------------------------------------------------------
 
### Organisation du code source

 - assets/ : contient tout les images à charger
 - Images/ : contient tout les affiches de film
 - src/ : Code source
 - src/Controler : exécute les actions 
 - src/listener : interface pour un listener
 - src/model/ : noyau fonctionnel
 - src/sql/ : gestion de la base de données
 - src/tests/ : Plusieurs tests utilisés pour vérifier l'implémentation de certains éléments
 - src/ui/ : interface

Le code sql création de table + triggers est src/sql/tables.sql

Le programme se lance en exécutant src/Main

--------------------------------------------------------

### Indication de compilation / installation

Afin de rendre la base de données opérationnelle, il faut ajouter en tant que modules suivants présent dans src:

- slf4j-api-1.7.36.jar
- sqlite-jdbc-3.44.0.0.jar

Sur IntelliJ :

- clic droit sur le .jar
- 'add as Library'
- Level : module library
- add to module : projet_integrateur_M1



